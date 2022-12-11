package hust.soict.dsai.store;


import hust.soict.dsai.media.DigitalVideoDisc;
import hust.soict.dsai.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    /**
     * Thêm 1 hay nhiều media vào cửa hàng
     * @param args
     */
    public void addMedia(Media ... args) {
        for(Media media : args) {
//            System.out.printf("Thêm thành công sản phẩm %s với id: %d\n", media.getTitle(), media.getId());
            itemsInStore.add(media);
        }
    }

    /**
     * Xóa Media bằng index
     * @param id
     */
    public void removeMedia(int id) {
        itemsInStore.remove(id);
    }

    /**
     * Xóa sản phẩm theo title
     * @param title
     */
    public void removeMedia(String title) {
        boolean isRemoved = false;
        for(int i = 0; i < itemsInStore.size(); i++) {
            // Nếu tìm thấy sản phẩm thì xóa
            Media item = itemsInStore.get(i);
            if(item.isMatch(title)) {
                itemsInStore.remove(i);
                isRemoved = true;
                System.out.printf("Đã xóa sản phẩm có title: %s\n", title);
                return ;
            }
        }

        if(isRemoved == false) {
            System.out.printf("Không sản phẩm nào có Title: %s\n", title);
        }
    }

    /**
     * Kiểm tra xem sản phẩm đã tồn tại hay chưa, trả về index của sản phẩm đó
     * @param title
     * @return
     */
    public int isExist(String title) {
        int result = -1;
        for(int i = 0; i < itemsInStore.size(); ++i) {
            if(itemsInStore.get(i).getTitle().equals(title)) {
                result = i;
                break;
            }
        }

        return result;
    }

    /**
     * In danh sách sản phẩm
     */
    public void printStore() {
        for(int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(itemsInStore.get(i).toString());
        }
    }

    /**
     * Lấy một sản phẩm nào đó trong cart
     */
    public Media getItemByIndex(int index) {
        return itemsInStore.get(index);
    }
}