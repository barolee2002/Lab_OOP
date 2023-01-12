package hust.soict.dsai.media;


import hust.soict.dsai.exception.PlayerException;
import hust.soict.dsai.media.model.Track;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();


    public CompactDisc(String artist) {
        super();
        this.artist = artist;
    }

    public CompactDisc(String artist, String title, Float cost) {
        super();
        this.artist = artist;
        this.setTitle(title);
        this.setCost(cost);
    }

    public CompactDisc(String artist, String title, String director, Float cost) {
        super();
        this.artist = artist;
        this.setTitle(title);
        this.setCost(cost);
        this.setDirector(director);
    }

    @Override
    public void play() throws PlayerException {
        for(int i = 0; i < tracks.size(); i++) {
            Track currentTrack = tracks.get(i);
            if(currentTrack.getLength() > 0) {
                tracks.get(i).play();
            } else {
                throw new PlayerException("ERROR: CD length is non-positive!");
            }

        }
    }

    /**
     * Thêm một track mới vào danh sách nếu không tồn tại
     * @param track
     * @return
     */
    public boolean addTrack(Track track) {
        if(tracks.contains(track)) {
            return false;
        }

        tracks.add(new Track(this.getTitle(), this.getLength()));
        return true;
    }

    /**
     * Xóa 1 track khỏi danh sách tracks nếu nó tồn tại
     * @param track
     * @return
     */

    public boolean removeTrack(Track track) {
        if(tracks.contains(track)) {
            tracks.remove(track);
            return true;
        }

        return false;
    }

    /**
     * Tính tổng thời gian của tất cả các track trong CD
     * @return
     */
    public int getLength() {
        int result = 0;
        for(int i = 0; i < tracks.size(); i++) {
            result += tracks.get(i).getLength();
        }
        return result;
    }

    @Override
    public String toString() {
        return getId() + ". CD - " + getTitle() + " - tác giả: " + artist + " - độ dài: " + getLength();
    }
}
