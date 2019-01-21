package com.app;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        myPlaylist.addAlbumToLibrary(new Album(
                "Awesome Album",
                new Song("Awesome Track 1", 1.25),
                new Song("Awesome Track 2", 1.50),
                new Song("Awesome Track 3", 1.30),
                new Song("Awesome Track 4", 1.24)
        ));
        myPlaylist.addAlbumToLibrary(new Album(
                "Fantastic Album",
                new Song("Fantastic Track 1", 1.75),
                new Song("Fantastic Track 2", 1.80),
                new Song("Fantastic Track 3", 1.00)
        ));

        myPlaylist.addSongToPlaylist("Awesome Album", 1);
        myPlaylist.addSongToPlaylist("Awesome Album", 4);
        myPlaylist.addSongToPlaylist("Fantastic Album", 3);
        myPlaylist.addSongToPlaylist("Fantastic Album", 10);

        myPlaylist.play();
    }
}
