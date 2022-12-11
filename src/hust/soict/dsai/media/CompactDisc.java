package hust.soict.dsai.media;

import hust.soict.dsai.media.model.Track;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }
    public CompactDisc(String artist) {
        super();
        this.artist = artist;
    }

    public CompactDisc(String artist, String title) {
        super();
        this.artist = artist;
        this.setTitle(title);
    }
    @Override
    public void play() {
        for(int i = 0; i < tracks.size(); i++) {
            tracks.get(i).play();
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