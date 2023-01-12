package hust.soict.dsai.store.controller;


import hust.soict.dsai.cart.controller.CartController;

import java.util.Scanner;

public class StoreMenuController {
    // Định tuyến việc xử lý các tính nang liên quan đến store
    // Nếu hàm này trả về 0 thì tự động back lại menu phía trước
    public static int handleMenuStore() {
        int back = 0;
        while(true) {
            back = 0;
            storeMenu();
            System.out.print("Vui lòng chọn: ");
            Scanner sc= new Scanner(System.in);
            int chosen = sc.nextInt();
            switch (chosen) {
                case 0:
                    back = 1;
                    break;
                case 1:
                    handleDetailMenu();
                    break;
                case 2:
                    StoreController.addToCart();
                    break;
                case 3:
                    StoreController.playItem();
                    break;
                case 4:
                    CartController.printCart();
                    break;

            }

            if(back == 1)
                return back;
        }

    }

    public static void handleDetailMenu() {
        StoreController.printStore();
        while(true) {
            mediaDetailsMenu();
            System.out.print("Vui lòng chọn: ");
            Scanner sc= new Scanner(System.in);
            int chosen = sc.nextInt();
            switch (chosen) {
                case 0:
                    return;
                case 1:
                    StoreController.addToCart();
                    break;
                case 2:
                    StoreController.playItem();
                    break;

            }

        }
    }

    public static void storeMenu() {
        System.out.println("Lựa chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Xem chi tiết sản phẩm");
        System.out.println("2. Thêm sản phẩm vào giỏ hàng");
        System.out.println("3. Play media");
        System.out.println("4. Xem giỏ hàng hiện tại");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.println("Nhập lựa chọn của bạn: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Lựa chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Thêm vào giỏ hàng");
        System.out.println("2. Play");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.println("Nhập lựa chọn của bạn: 0-1-2");
    }

    /**
     * Chức năng dành cho menu update store
     */
    public static int handleUpdateStore() {
        int back = 0;
        while(true) {
            back = 0;
            printUpdateStoreMenu();
            System.out.print("Vui lòng chọn: ");
            Scanner sc= new Scanner(System.in);
            int chosen = sc.nextInt();
            switch (chosen) {
                case 0:
                    back = 1;
                    break;
                case 1:
                    StoreController.addToStore();
                    break;
                case 2:
                    StoreController.removeFromStore();
                    break;
            }

            if(back == 1)
                return back;
        }
    }

    public static void printUpdateStoreMenu() {
        System.out.println("Lựa chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Thêm mới sản phẩm vào cửa hàng");
        System.out.println("2. Xóa sản phẩm khỏi cửa hàng");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.println("Nhập lựa chọn của bạn: 0-1-2");
    }


}
