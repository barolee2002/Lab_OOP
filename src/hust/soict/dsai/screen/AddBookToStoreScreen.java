package hust.soict.dsai.screen;

import hust.soict.dsai.data.InitData;
import hust.soict.dsai.media.Book;
import hust.soict.dsai.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddBookToStoreScreen extends AddItemToStoreScreen{
    private Store myStore = InitData.myStore;
    // Render UI
    public AddBookToStoreScreen() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(renderAddBookScreen(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);

    }

    /**
     * Render giao diện form điền thông tin
     * @return
     */
    JPanel renderAddBookScreen() {
        JPanel layout = new JPanel();
        layout.setLayout(new GridLayout(3, 3, 2, 2));
        // Input Title
        JPanel inputTitleGroup = this.inputGroup("Title", 20);
        layout.add(inputTitleGroup);
        // Input category
        JPanel inputCategoryGroup = this.inputGroup("Category", 20);
        layout.add(inputCategoryGroup);

        // Input author
        JPanel inputAuthorGroup = this.inputGroup("Author", 20);
        layout.add(inputAuthorGroup);

        // Input Cost
        JPanel inputCostGroup = this.inputGroup("Cost", 20);
        layout.add(inputCostGroup);

        // Submit button
        layout.add(submitButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo sách mới
                Book book = new Book(getValueTextField(inputTitleGroup), getValueTextField(inputCategoryGroup), Float.valueOf(getValueTextField(inputCostGroup)));
                // Thêm tác giả
                book.addAuthor(getValueTextField(inputAuthorGroup));
                // Thêm vào cửa hàng
                myStore.addMedia(book);
            }
        }));
        return layout;
    }
}
