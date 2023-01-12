package hust.soict.dsai.cart.controller;


import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.data.InitData;
import hust.soict.dsai.media.DigitalVideoDisc;
import hust.soict.dsai.media.Media;

import java.util.Collections;
import java.util.Scanner;

public class CartController {
    private static Cart myCart = InitData.myCart;

    /**
     * In các sản phẩm có trong Cart
     */
    public static void printCart() {
        myCart.printCart();
    }

    /**
     * Lọc sản phẩm theo ID hoặc tiêu đề
     */
    public static void filterItem() {
        while(true) {
            System.out.println("Lọc theo: ");
            System.out.println("0. Thoát chế độ lọc");
            System.out.println("1. ID");
            System.out.println("2. Tiêu đề");
            System.out.println("Nhập lựa chọn của bạn: 1-2");
            Scanner sc = new Scanner(System.in);
            int type = sc.nextInt();
            int index = -1;
            // Lọc theo ID
            if(type == 1) {
                System.out.print("Nhập ID cần tìm: ");
                int id = sc.nextInt();
                // Tìm index của sản phẩm theo ID
                index = myCart.searchProduct(id);
                if(index == -1) {
                    System.out.println("Không tìm thấy sản phẩm này trong giỏ hàng của bạn");
                    return ;
                }
            } else if(type == 2) {
                // Lọc theo tiêu đề
                System.out.print("Nhập title cần tìm: ");
                sc.nextLine();
                String title = sc.nextLine();
                System.out.println(title);
                // Tìm index của sản phẩm theo tiêu đề
                index = myCart.searchProduct(title);
            } else if(type == 0) {
              break;
            } else {
                System.out.println("Lựa chọn của bạn không hợp lệ.Thử lại sau");
                return ;
            }

            if(index == -1) {
                System.out.println("Không tìm thấy sản phẩm này trong giỏ hàng của bạn");
                return;
            }
            System.out.println("Thông tin sản phẩm: ");
            // Nếu tìm thấy thì in ra
            System.out.println(myCart.getItemsOrdered().get(index).toString());
        }

    }

    /**
     * Sắp xếp sản phẩm theo tiêu đề hoặc ID
     */
    public static void sortItem() {
        System.out.println("Chọn phương án sắp xếp");
        System.out.println("1. Theo tiêu đề");
        System.out.println("2. Theo ID");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();

        if(type == 1) {
            Collections.sort(myCart.getItemsOrdered(), Media.COMPARATOR_BY_COST_TITLE);
        } else if(type == 2){
            Collections.sort(myCart.getItemsOrdered(), Media.COMPARATOR_BY_TITLE_COST);
        } else {
            System.out.println("Lựa chọn không hợp lệ");
            return;
        }

        System.out.println("Sắp xếp thành công");
    }

    /**
     * Xóa một sản phẩm khỏi giỏ hàng bởi tiêu đề
     */

    public static void removeItem() {
        System.out.println("Nhập tiêu đề sản phẩm cần xóa");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        // Tìm index của sản phẩm cần xóa theo tiêu đề
        int index = myCart.searchProduct(title);
        if(index == -1) {
            System.out.println("Sản phẩm này không tồn tại trong giỏ hàng của bạn");
            return;
        }
        myCart.removeMedia(index);
        System.out.println("Đã xóa sản phẩm " + title + " khỏi giỏ hàng của bạn");
    }

    /**
     * Play sản phẩm
     */
    public static void playItem() {
        System.out.println("Nhập tiêu đề sản phẩm cần play");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        int index = myCart.searchProduct(title);
        if(index == -1) {
            System.out.println("Sản phẩm này không tồn tại trong giỏ hàng của bạn");
            return;
        }

        if(myCart.getItemsOrdered().get(index) instanceof DigitalVideoDisc) {
            DigitalVideoDisc item = (DigitalVideoDisc) myCart.getItemsOrdered().get(index);
            item.play();
        } else {
            System.out.println("Sản phẩm này không phải là DVD, không hỗ trợ play");
        }
    }

    /**
     * Order, thanh toán
     */
    public static void order() {
        // Xóa giỏ hàng
        myCart.getItemsOrdered().removeAll(myCart.getItemsOrdered());
        System.out.println("Tạo đơn hàng thành công !");
    }
}