package hust.soict.dsai.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        if(o1.getTitle().equals(o2.getTitle())) {
            // Trường hợp 2 sản phầm cùng title thì sắp xếp theo giá
            return Float.compare(o2.getCost(), o1.getCost());
        } else {
            // Trường hợp không cùng tiêu đề
            return o1.getTitle().compareTo(o2.getTitle());
        }

    }
}
