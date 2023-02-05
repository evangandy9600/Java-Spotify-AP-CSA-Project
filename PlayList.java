import java.util.*;

public class PlayList {
    // Create instance variables for our PlayList
    private ArrayList<Song> songs;
    private String name;

    /**
     * Constructs a Playlist object that can store the songs in the play list
     */
    public PlayList(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public PlayList(String name) {
        this.songs = new ArrayList<Song>();
        this.name = name;
    }

    /**
     * @return The PlayList
     */
    public ArrayList<Song> getPlayList() {
        return this.songs;
    }

    /**
     * Adds a song to the PlayList
     * 
     * @param Song The song to add to the PlayList
     */
    public void addSong(Song s) {
        songs.add(s);
    }

    /**
     * Removes a song from the PlayList
     * 
     * @param Song The song to remove from the PlayList
     */
    public void removeSong(Song s) {
        songs.remove(search(s));
    }

    /**
     * This method will return the number of songs in the PlayList
     * 
     * @return The number of songs in the PlayList
     */
    public int numSongs() {
        return songs.size();
    }

    /**
     * This method will return the length of the PlayList in seconds. This method
     * must implement
     * an enhanced for loop
     * 
     * @return The length of the PlayList
     */
    public int getLength() {
        int sumTime = 0;

        for (int i = 0; i < songs.size(); i++) {
            sumTime += songs.get(i).getLength();
        }

        return sumTime;
    }

    /**
     * This will will search the PlayList for a given song.
     * 
     * @return the postion in the ArrayList. -1 if it isn't there
     */
    public int search(Song s) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).equals(s)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * This method will reverse the order of the playList
     */
    public void reverse() {
        for (int i = 0; i < songs.size() / 2; i++) {
            Song temp = songs.get(i);

            songs.set(i, songs.get(songs.size() - i - 1));
            songs.set(songs.size() - i - 1, temp);
        }
    }

    /**
     * Remove ALL songs on the playlist with a length greater than the
     * given length
     * 
     * @param length The maximium allowed length of songs on the playlist
     */
    public void removeLengths(int length) {
        for (int i = songs.size() - 1; i >= 0; i--) {
            if (songs.get(i).getLength() >= length) {
                songs.remove(i);
            }
        }
    }

    /**
     * A String representation of the PlayList
     * 
     * @return The PlayList as a String
     */
    public String toString() {
        String str = "";
        for (Song i : songs) {
            str += i + "\n";
        }

        return str;
    }

    /**
     * This method will copy the playList from a given PlayList onto this PlayList
     * 
     * @param PlayList The playlist being copied
     */
    public void copy(PlayList p) {
        int length = numSongs();
        for (int i = 0; i < length; i++) {
            songs.add(songs.get(i));
        }
    }

    /**
     * This method will determine if two PlayLists have the same
     * playlist in the same order
     * 
     * @param PlayList The playlist to compare with this one
     * @return if the play lists are identical
     */
    public boolean identical(PlayList p) {

        if (songs.size() != p.getPlayList().size()) {
            return false;
        }

        for (int i = 0; i < songs.size(); i++) {
            if (!songs.get(i).equals(p.getPlayList().get(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * This method will sort the PlayList in alphabetical order by song
     *
     * THIS METHOD IS A STRETCH
     */
    public void sort() {
        Collections.sort(songs, new Comparator<Song>() {
            public int compare(Song song1, Song song2) {
                return song1.getTitle().compareTo(song2.getTitle());
            }
        });
    }
    
    /**
     * THIS METHOD DOES NOT WORK AS INTENDED
     * This method will determine if two PlayLists are identical, regardless
     * of the order of the songs in the playlist
     *
     * THIS METHOD IS A STRETCH
     * 
     * @param PlayList The playlist to compare with this one
     */
    public boolean compare(PlayList other) {
        if (this.songs.size() != other.songs.size()) {
            return false;
        }
    
        for (Song song : this.songs) {
            if (!other.songs.contains(song)) {
                return false;
            }
        }
        
        return true;
    }    
}
