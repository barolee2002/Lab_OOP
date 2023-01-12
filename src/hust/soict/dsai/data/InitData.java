package hust.soict.dsai.data;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.media.Book;
import hust.soict.dsai.media.CompactDisc;
import hust.soict.dsai.media.DigitalVideoDisc;
import hust.soict.dsai.media.model.Track;
import hust.soict.dsai.store.Store;

import javax.naming.LimitExceededException;
public class InitData {
    public static final Store myStore = new Store();
    public static final Cart myCart = new Cart();

    public static void init() throws LimitExceededException {
        // Tạo các DVD có trong cửa hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Doraemon", "Hoạt hình", "Fujiko Fujio", 34 ,52.55f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Titanic", "film", "James Cameron", 56 ,654.44f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Em và Trịnh", "film", "Phan Gia Nhật Linh", 23 ,879.55f);
        // Tạo các CD có trong cửa hàng
        CompactDisc cd1 = new CompactDisc("Nguyễn Thanh Tùng", "SKY","Sơn Tùng MTP", 9999.99f);
        cd1.addTrack(new Track("Em của ngày hôm qua", 4));
        cd1.addTrack(new Track("Hãy trao cho anh", 6));
        cd1.addTrack(new Track("Cơn mưa ngang qua", 7));

        CompactDisc cd2 = new CompactDisc("Bùi Thị Bích Phương", "Đi đu đưa đi", "Bích Phương", 49.99f);
        cd2.addTrack(new Track("Nếu em còn tồn tại", 2));
        cd2.addTrack(new Track("Gửi anh xa nhớ", 2));
        cd2.addTrack(new Track("Nằm ngủ emru", 3));

        // Tạo các Book có trong cửa hàng
        Book book1 = new Book("GIà thiên", "Tiểu thuyết tiên hiệp", 56f);
        Book book2 = new Book("Thế giới hoàn mỹ", "Tiểu thuyết tiên hiệp", 43f);
        Book book3 = new Book("Thánh khư", "Tiểu Thuyết tiên hiệp", 67f);
        // Add vào store
        myStore.addMedia(dvd1, dvd2, dvd3, cd1, cd2, book1, book2, book3);
        myCart.addMedia(dvd1, cd2);
    }
}