package hust.soict.dsai.screen;

import hust.soict.dsai.data.InitData;
import hust.soict.dsai.exception.PlayerException;
import hust.soict.dsai.media.Disc;
import hust.soict.dsai.media.Media;
import hust.soict.dsai.media.Playable;
import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Frame parentFrame;
    // Render UI
    public MediaStore(Media media, Frame parentFrame) {
        this.media = media;
        this.parentFrame = parentFrame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();

        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Action
        JButton addToCartBtn = new JButton("Add to cart");
        container.add(addToCartBtn);
        addToCartBtn.putClientProperty("media", media);
        addToCartBtn.putClientProperty("type", "add_to_cart");
        addToCartBtn.addActionListener(new AddToCartButtonListener());

        if(media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            container.add(playBtn);
            playBtn.putClientProperty("media", media);
            playBtn.putClientProperty("type", "play_media");
            playBtn.addActionListener(new PlayMediaButtonListener());
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class PlayMediaButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String type = (String) button.getClientProperty("type");
            Disc selectedMedia = (Disc)button.getClientProperty("media");
            try {
                ((Playable) selectedMedia).play();
                JDialog dialog = new JDialog(parentFrame, "Play Demo Audio");
                JLabel label = new JLabel("Play audio " + selectedMedia.getTitle() + " length: " + String.valueOf(selectedMedia.getLength()), SwingConstants.CENTER);
                dialog.add(label);
                dialog.setLocationRelativeTo(parentFrame);
                dialog.setSize(300, 200);
                dialog.setVisible(true);
            } catch (PlayerException ex) {
                JDialog dialog = new JDialog(parentFrame, "Thông báo");
                JLabel label = new JLabel(ex.getLocalizedMessage(), SwingConstants.CENTER);
                dialog.add(label);
                dialog.setLocationRelativeTo(parentFrame);
                dialog.setSize(300, 200);
                dialog.setVisible(true);
            }
        }
    }

    // Class handle event Add to Cart
    private class AddToCartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String type = (String) button.getClientProperty("type");
            Media selectedMedia = (Media)button.getClientProperty("media");
            try {
                // Thêm sản phẩm vào cart
                InitData.myCart.addMedia(selectedMedia);
            } catch (LimitExceededException ex) {
                // Bắt lỗi cart ầy nếu có
                JDialog dialog = new JDialog(parentFrame, "Thông báo");
                JLabel label = new JLabel(ex.getLocalizedMessage(), SwingConstants.CENTER);
                dialog.add(label);
                dialog.setLocationRelativeTo(parentFrame);
                dialog.setSize(300, 200);
                dialog.setVisible(true);


            }
        }
    }
}