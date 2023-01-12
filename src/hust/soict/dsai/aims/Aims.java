package hust.soict.dsai.aims;


import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.data.InitData;
import hust.soict.dsai.screen.*;
import hust.soict.dsai.store.Store;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aims {
    private static JFrame currentView;
    private static Store myStore;
    private static Cart myCart;
    public static void main(String[] args) throws LimitExceededException {
        // Khởi tạo data dùng chung
        InitData.init();
        myStore = InitData.myStore;
        myCart = InitData.myCart;
        // In menu ra màn hình
        currentView = new StoreScreen(myStore);
    }

    // Khi click vào menu, cần hiển thị những chức năng tương ứng
    public static class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("view_store")) {
                currentView = new StoreScreen(myStore);
            } else if(command.equals("view_cart")) {
                currentView = new CartScreen(myCart);
            } else if(command.equals("add_dvd")) {
                new AddDigitalVideoDiscToStoreScreen();
            } else if(command.equals("add_cd")) {
                new AddCompactDiscToStoreScreen();
            }  else if(command.equals("add_book")) {
                new AddBookToStoreScreen();
            }
            System.out.println(e.getActionCommand() + " JMenuItem clicked.");
        }
    }



}