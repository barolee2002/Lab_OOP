package hust.soict.dsai.aims;

import hust.soict.dsai.cart.controller.CartMenuController;
import hust.soict.dsai.data.InitData;
import hust.soict.dsai.store.controller.StoreMenuController;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        // Khởi tạo data dùng chung
        InitData.init();
        // In menu ra màn hình
        handleMainMenu();

    }

    /**
     * Menu chính
     */
    public static void handleMainMenu() {
        //Hiển thị menu
        showMenu();
        Scanner sc = new Scanner(System.in);
        // Lấy lựa chọn của người dùng
        int chosen = sc.nextInt();
        int back = 0;
        switch (chosen) {
            case 1:
                back = StoreMenuController.handleMenuStore();
                break;
            case 2:
                back = StoreMenuController.handleUpdateStore();
                break;
            case 3:
                back = CartMenuController.handleMenuCart();
                break;
            case 0:
                return ;
        }

        if(back == 1) {
            handleMainMenu();
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. Cửa hàng");
        System.out.println("2. Cập nhật cửa hàng");
        System.out.println("3. Giỏ hàng");
        System.out.println("0. Thoát");
        System.out.println("--------------------------------");
        System.out.println("Nhập lựa chọn của bạn: 0-1-2-3");
    }


}