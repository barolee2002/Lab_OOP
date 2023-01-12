package hust.soict.dsai.screen;


import hust.soict.dsai.aims.Aims;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    private JComponent currentScene;

    public Layout() {
        this.setLayout(new BorderLayout());
        this.add(createNorth(), BorderLayout.NORTH);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public void setCurrentScene(JComponent currentScene) {
        this.currentScene = currentScene;
        this.add(currentScene);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        Aims.MenuItemListener menuItemListener = new Aims.MenuItemListener();


        JMenuItem viewStoreMenu = new JMenuItem("View Store");
        viewStoreMenu.setActionCommand("view_store");
        viewStoreMenu.addActionListener(menuItemListener);
        menu.add(viewStoreMenu);

        JMenuItem viewCartMenu = new JMenuItem("View Cart");
        viewCartMenu.setActionCommand("view_cart");
        viewCartMenu.addActionListener(menuItemListener);
        menu.add(viewCartMenu);



        JMenuBar menuBar = new JMenuBar();

        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.RED);

        JButton cart = new JButton("View Cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));

        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }
}