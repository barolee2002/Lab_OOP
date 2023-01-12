package hust.soict.dsai.media;


public class Disc extends Media{
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Disc() {
        super();
    }
    public Disc(int length, String director) {
        super();
        this.length = length;
        this.director = director;
    }
}
