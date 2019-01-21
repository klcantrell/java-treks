package com.app;

import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name, Song songOne, Song songTwo, Song songThree, Song ... s) {
        this.name = name;
        this.songs = new ArrayList<Song>();
        this.songs.add(songOne);
        this.songs.add(songTwo);
        this.songs.add(songThree);
        for (Song song : s) {
            this.songs.add(song);
        }
    }

    public String getName() {
        return name;
    }

    public Song getSong(int trackNumber) {
        if (trackNumber > songs.size() || trackNumber < 1) {
            return null;
        } else {
            int index = trackNumber - 1;
            return songs.get(index);
        }
    }

    public void listSongs() {
        int trackNumber = 1;
        for (Song song: songs) {
            System.out.println("\tSong " + trackNumber + ": " + song.getTitle());
            trackNumber++;
        }
    }
}
