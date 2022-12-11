package hust.soict.dsai.data;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.media.Book;
import hust.soict.dsai.media.CompactDisc;
import hust.soict.dsai.media.DigitalVideoDisc;
import hust.soict.dsai.media.model.Track;
import hust.soict.dsai.store.Store;

public class InitData {
    public static final Store myStore = new Store();
    public static final Cart myCart = new Cart();

    public static void init() {
        // Tạo các DVD có trong cửa hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Doraemon", "Hoạt hình", "ZZZ", 21 ,24.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Conan", "Hoạt hình", "Change", 54 ,99.7f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("luffy", "Hoạt hình", "ABC", 65 ,90f);
        // Tạo các CD có trong cửa hàng
        CompactDisc cd1 = new CompactDisc("Nguyễn Hồng Sơn", "Nhạc của tôi");
        cd1.addTrack(new Track("Sơn 1", 13));
        cd1.addTrack(new Track("Sơn 2", 24));
        cd1.addTrack(new Track("Sơn 3", 24));

        CompactDisc cd2 = new CompactDisc("Soobin Hoàng Sơn", "Đi để chở về");
        cd2.addTrack(new Track("Đi để chở về 1", 2));
        cd2.addTrack(new Track("Đi để chở về 2", 2));
        cd2.addTrack(new Track("Đi để chở về 3", 3));

        // Tạo các Book có trong cửa hàng
        Book book1 = new Book("Nhật chuyên ngành 1", "Tiếng Nhật", 21f);
        Book book2 = new Book("Nhật chuyên ngành 2", "Tiếng Nhật", 25f);
        Book book3 = new Book("Giải tích IV", "Toán cao cấp", 9999f);
        // Add vào store
        myStore.addMedia(dvd1, dvd2, dvd3, cd1, cd2, book1, book2, book3);
    }
}