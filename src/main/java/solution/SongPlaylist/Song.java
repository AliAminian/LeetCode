package solution.SongPlaylist;

import java.util.HashMap;
import java.util.Map;

/**
 * The problem
 */
public class Song {
    private String name;
    private Song nextSong;

    private static final Map<String, Song> TMP_PLAYLIST = new HashMap<>();

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song next) {
        this.nextSong = next;
    }

    public static void isPlayListRepeatable() {
        //write your code here;
    }

    public static void main(String[] args) {
        //Song sol = new Song(); TODO: solve it
    }
}
