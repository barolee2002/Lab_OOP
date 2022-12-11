package hust.soict.dsai.media;


import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();
    public Book() {
        super();
    }

    public Book(String title, String category, float cost ) {
        super(title, category, cost);
    }
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * Thêm 1 tác giả mới
     * @param author
     * @return
     */
    public boolean addAuthor(String author) {
        // Nếu tác giả đã tồn tại thì không thể thêm
        if(authors.contains(author)) {
            System.out.println("Tác giả đã có trong danh sách");
            return false;
        }
        authors.add(author);
        return true;
    }

    /**
     * Xóa 1 tác giả khỏi danh sach
     * @param authorName
     * @return
     */
    public boolean removeAuthor(String authorName) {
        // Chỉ xóa khi tác giả đó có trong danh sách
        if(authors.contains(authorName)) {
            System.out.println("Đã xóa tác giả này khỏi danh sách");
            authors.remove(authorName);
            return true;
        }
        System.out.println("Tác giả này không tồn tại");
        return false;
    }

    @Override
    public String toString() {
        return getId() + ". Book - " + getTitle() + " - " + getCategory() + " giá: " + getCost() + "$";
    }
}