public class Song
{
    private String title;
    private String artist;
    private int length;

    public Song(String title, String artist, int length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }    
    
    public String getArtist() {
        return artist;
    }

    public int getLength() {
        return length;
    }

    public boolean equals(Song other) {
        if(title.equals(other.getTitle()) && artist.equals(other.getArtist())) {
            return true;
        }

        return false;
    }

    public String toString() {
        return title + " by " + artist + " (" + length +")";
    }
}
