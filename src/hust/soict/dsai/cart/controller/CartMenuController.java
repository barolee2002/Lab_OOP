package hust.soict.dsai.cart.controller;

import hust.soict.dsai.store.controller.StoreController;

import java.util.Scanner;

public class CartMenuController {
    public static int handleMenuCart() {
        int back = 0;
        while(true) {
            back = 0;
            cartMenu();
            System.out.print("Vui lòng chọn: ");
            Scanner sc= new Scanner(System.in);
            int chosen = sc.nextInt();
            switch (chosen) {
                case 0:
                    back = 1;
                    break;
                case 1:
                    CartController.filterItem();
                    break;
                case 2:
                    CartController.sortItem();
                    break;
                case 3:
                    CartController.removeItem();
                    break;
                case 4:
                    CartController.playItem();
                    break;
                case 5:
                    CartController.order();
                    break;

            }

            if(back == 1)
                return back;
        }

    }
    public static void cartMenu() {
        System.out.println("Lựa chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Lọc sản phẩm trong giỏ hàng");
        System.out.println("2. Sắp xếp danh sách sản phẩm trong giỏ hàng");
        System.out.println("3. Xóa media khỏi cart");
        System.out.println("4. Play media");
        System.out.println("5. Thanh toán");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.println("Vui lòng lựa chọn: 0-1-2-3-4-5");
    }
}
