package hust.soict.dsai.screen;


import hust.soict.dsai.data.InitData;
import hust.soict.dsai.media.DigitalVideoDisc;
import hust.soict.dsai.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
    private Store myStore = InitData.myStore;
    // Render UI
    public AddDigitalVideoDiscToStoreScreen() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(renderAddDVDScreen(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);

    }

    JPanel renderAddDVDScreen() {
        JPanel layout = new JPanel();
        layout.setLayout(new GridLayout(3, 3, 2, 2));
        // Input Title
        JPanel inputTitleGroup = this.inputGroup("Title", 20);
        layout.add(inputTitleGroup);
        // Input category
        JPanel inputCategoryGroup = this.inputGroup("Category", 20);
        layout.add(inputCategoryGroup);
        // Input director
        JPanel inputDirectorGroup = this.inputGroup("Director", 20);
        layout.add(inputDirectorGroup);
        // Input Length
        JPanel inputLengthGroup = this.inputGroup("Length", 20);
        layout.add(inputLengthGroup);
        // Input Cost
        JPanel inputCostGroup = this.inputGroup("Cost", 20);
        layout.add(inputCostGroup);

        // Submit button
        layout.add(submitButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo media mới
                DigitalVideoDisc dvd = new DigitalVideoDisc(getValueTextField(inputTitleGroup), getValueTextField(inputCategoryGroup), getValueTextField(inputDirectorGroup), Integer.valueOf(getValueTextField(inputLengthGroup)) ,Float.valueOf(getValueTextField(inputCostGroup)));
                System.out.println(dvd);
                //Thêm media
                myStore.addMedia(dvd);
                System.out.println(myStore.getItemsInStore());
            }
        }));
        return layout;
    }
}
