package com.app;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private Songlist songs;

    public Album(String name, Song ... s) {
        this.name = name;
        this.songs = new Songlist();
        for (Song song : s) {
            this.songs.addSong(song);
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
            return songs.getSong(index);
        }
    }

    public void listSongs() {
        int trackNumber = 1;
        for (Song song: songs.getSongs()) {
            System.out.println("\tSong " + trackNumber + ": " + song.getTitle());
            trackNumber++;
        }
    }

    private class Songlist {
        private List<Song> songs;

        private Songlist() {
            this.songs = new ArrayList<Song>();
        }

        private boolean addSong(Song newSong) {
            if (songs.contains(newSong)) {
                return false;
            } else {
                this.songs.add(newSong);
                return true;
            }
        }

        private int size() {
            return songs.size();
        }

        private Song getSong(int index) {
            return songs.get(index);
        }

        private List<Song> getSongs() {
            return songs;
        }
    }
}
