package hust.soict.dsai.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    private static int autoIncrement = 1;
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        this.id = autoIncrement;
        incrementId();
    }

    public Media(String title, String category, float cost) {
        this.id = autoIncrement;
        this.title = title;
        this.category = category;
        this.cost = cost;
        incrementId();
    }

    public static final Comparator<Media> COMPARATOR_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public static final Comparator<Media> COMPARATOR_BY_TITLE_COST = new MediaComparatorByTitleCost();
    private void incrementId() {
        autoIncrement++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * So sánh 2 media.Bằng nhau nếu title giong nhau
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(title, media.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, cost);
    }

    /**
     * So khớp title với instance hiện tại
     * @param title
     * @return
     */
    public boolean isMatch(String title) {
        return getTitle().equals(title);
    }

    @Override
    public String toString() {
        return id + ". Media - " + title + " - " + category + " - " + cost;
    }
}