package hust.soict.dsai.cart;


import hust.soict.dsai.media.DigitalVideoDisc;
import hust.soict.dsai.media.Media;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
    public static final int MAX_NUMBERS_ORDERD = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    /**
     * Thêm nhiều media vào giỏ hàng
     * @param medias
     * @return
     */
    public boolean addMedia(Media ... medias) {
        if(itemsOrdered.size() + medias.length >= MAX_NUMBERS_ORDERD) {
            System.out.println("Bạn chỉ được phép thêm tối đa: " + (MAX_NUMBERS_ORDERD - itemsOrdered.size()) + " vào giỏ hàng");
            return false;
        }
        for(Media media: medias) {
            if(!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
            } else {
                System.out.println("Sản phẩm " + media.getTitle() + " đã tồn tại trong giỏ hàng");
            }
        }

        return true;
    }

    /**
     * Tìm dvd bằng id
     * @param id
     */
    public int searchProduct(int id) {
        int index = -1;
        for(int i = 0; i < itemsOrdered.size(); i++) {
            Media item = itemsOrdered.get(i);
            if(item.getId() == id) {
                return i;
            }
        }

        return index;
    }

    /**
     * Tìm dvd bằng title
     * @param title
     */

    public int searchProduct(String title) {
        int index = -1;
        for(int i = 0; i < itemsOrdered.size(); i++) {
            Media item = itemsOrdered.get(i);
            if(item.isMatch(title)) {
                return i;
            }
        }
        return index;
    }

    /**
     * Xóa 1 media nào đó khỏi giỏ hàng nếu sản phẩm đó tồn tại
     * @param id
     * @return
     */
    public void removeMedia(int id) {
        itemsOrdered.remove(id);
    }
    /**
     * Tính tổng số tiền giỏ hàng
     * @return float
     */
    public float totalCost() {
        float cartTotal = 0f;
        for(int i = 0; i < itemsOrdered.size(); i++) {
            cartTotal += itemsOrdered.get(i).getCost();
        }
        return cartTotal;
    }


    /**
     * In các DVD có trong cart
     * @param
     * @return void
     */
    public void printCart() {
        System.out.println("***********************CART***********************");
        for(int i = 0; i < itemsOrdered.size(); i++) {
            Media item = itemsOrdered.get(i);
            System.out.println(item.toString());
        }
        System.out.printf("Total cost: %f\n", totalCost());
        System.out.println("***************************************************");

    }

    /**
     * Lấy danh sách sản phẩm trong cart
     * @return
     */
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    /**
     * Lấy số sản phẩm có trong giỏ hàng hiện tại
     * @return
     */
    public int getCountItem() {
        return itemsOrdered.size();
    }
}