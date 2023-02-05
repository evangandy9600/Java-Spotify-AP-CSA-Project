public class Music
{
    public static void main(String[] args)
    {
        PlayList p = new PlayList("PreGame");

        p.addSong(new Song("The Power", "Snap", 240));
        p.addSong(new Song("Pump Up The Jam", "Technotronic", 200));
        p.addSong(new Song("Eye of the Tiger", "Survivor", 180));
        p.addSong(new Song("We Like to Party", "Vengaboys", 210));
        p.addSong(new Song("1, 2, 3, 4 (Sumpin' New)", "Coolio", 160));
        p.addSong(new Song("This Is How We Do It", "Montell Jordan", 190));

        System.out.println(p);

        System.out.println("\nNum songs on playList: " + p.numSongs());
        System.out.println("EXPECTED: 6");
        System.out.println("\nLength of playList: " + p.getLength());
        System.out.println("EXPECTED: 1180");

        System.out.println("\nRemove: This is How We Do It\n");
        p.removeSong(new Song("This Is How We Do It", "Montell Jordan", 190));
        
        System.out.println(p);
        System.out.println("\nNum songs on playList: " + p.numSongs());
        System.out.println("EXPECTED: 5");
        System.out.println("\nLength of playList: " + p.getLength());
        System.out.println("EXPECTED: 990\n");

        System.out.println("Search for We like to party: " + p.search(new Song("We Like to Party", "Vengaboys", 210)));
        System.out.println("EXPECTED: 3\n");

        System.out.println(p);

        // p.reverse();

        System.out.println("\nSongs should be reversed\n");
        System.out.println(p);

        p.removeLengths(200);
        System.out.println("\nSongs >= 200 should be removed\n");
        System.out.println(p);
        System.out.println("\nNum songs on playList: " + p.numSongs());
        System.out.println("EXPECTED: 2");
        System.out.println("\nLength of playList: " + p.getLength());
        System.out.println("EXPECTED: 340");

        System.out.println("\nTesting Identical");
        System.out.println("Identical? " +  p.identical(p));
        System.out.println("EXPECTED: true");

        PlayList p2 = new PlayList("List 2");
        for(Song s : p.getPlayList())
            p2.addSong(s);
        p.reverse();    
        System.out.println("Identical? " +  p.identical(p2));
        System.out.println("EXPECTED: false\n");

        System.out.println("\nTesting Copy. List should be doubled");
        p.copy(p2);
        System.out.println(p);
        System.out.println("\nNum songs on playList: " + p.numSongs());
        System.out.println("EXPECTED: 4");
        System.out.println("\nLength of playList: " + p.getLength());
        System.out.println("EXPECTED: 680");

    }
}
