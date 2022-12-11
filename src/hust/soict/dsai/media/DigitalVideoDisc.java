package hust.soict.dsai.media;

import java.util.Objects;

public class DigitalVideoDisc extends Disc implements Playable {

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());

    }
    public DigitalVideoDisc(String title) {
        this.setTitle(title);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId()) + ". DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + String.valueOf(getLength()) + ": " + String.valueOf(getCost()) + "$";
    }

    /**
     * So sánh 2 DVD với nhau
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalVideoDisc that = (DigitalVideoDisc) o;
        return this.getLength() == that.getLength() && Float.compare(that.getCost(), this.getCost()) == 0 && Objects.equals(that.getTitle(), this.getTitle()) && Objects.equals(that.getCategory(), this.getCategory()) && Objects.equals(this.getDirector(), that.getDirector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
    }
}
