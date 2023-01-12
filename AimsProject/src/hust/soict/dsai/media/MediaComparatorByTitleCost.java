package hust.soict.dsai.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        int compare = Float.compare(o2.getCost(), o1.getCost());
        if(compare == 0) {
            // Trường hợp cùng giá thì sắp xếp theo title
            return  o1.getTitle().compareTo(o2.getTitle());
        } else {
            // Trường hợp giá khác nhau
            return compare;
        }

    }
}
