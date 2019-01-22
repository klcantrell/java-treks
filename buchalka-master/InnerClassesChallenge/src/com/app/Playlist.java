package com.app;

import java.util.*;

public class Playlist {
    private static Scanner scanner = new Scanner(System.in);

    private LinkedList<Song> playlist;
    private ArrayList<Album> albums;

    public Playlist() {
        this.playlist = new LinkedList<Song>();
        this.albums = new ArrayList<Album>();
    }

    public void play() {
        ListIterator<Song> playlistIterator = playlist.listIterator();
        boolean quit = false;
        boolean goingForward = true;
        printInstructions();

        if (playlist.isEmpty()) {
            System.out.println("No songs in your playlist");
            return;
        } else {
            System.out.println("Now listening to " + playlistIterator.next().getTitle());
        }

        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0) {
                System.out.println("\nEnter a number to control the playlist (3 for options)");
            }

            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Shutting down...");
                    break;
                case 1:
                    if (!goingForward && playlistIterator.hasNext()) {
                        goingForward = true;
                        playlistIterator.next();
                    }
                    if (playlistIterator.hasNext()) {
                        System.out.println("Now listening to " + playlistIterator.next().getTitle());
                    } else {
                        System.out.println("You're at the end of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward && playlistIterator.hasPrevious()) {
                        goingForward = false;
                        playlistIterator.previous();
                    }
                    if (playlistIterator.hasPrevious()) {
                        System.out.println("Now listening to " + playlistIterator.previous().getTitle());
                    } else {
                        System.out.println("You're at the beginning of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (playlist.size() > 0) {
                        playlistIterator.remove();
                    }
                    if (playlistIterator.hasNext()) {
                        System.out.println("Now playing " + playlistIterator.next().getTitle());
                    } else if (playlistIterator.hasPrevious()) {
                        System.out.println("Now playing " + playlistIterator.previous().getTitle());
                    } else {
                        System.out.println("No more songs left");
                        return;
                    }
                    break;
                case 4:
                default:
                    printInstructions();
                    break;
            }
        }
    }

    public boolean addSongToPlaylist(String albumName, int trackNumber) {
        Album album = findAlbum(albumName);
        if (album != null) {
            Song song = album.getSong(trackNumber);
            if (song == null) {
                System.out.println("Track " + trackNumber + " does not exist on that album");
            } else if (findSongOnPlaylist(song.getTitle()) != null) {
                System.out.println(song.getTitle() + " already exists on playlist");
            } else {
                playlist.add(song);
                System.out.println(song.getTitle() + " added to playlist");
                return true;
            }
        } else {
            System.out.println(albumName + " does not exist in your library");
        }
        return false;
    }


    public boolean addAlbumToLibrary(Album newAlbum) {
        if (findAlbum(newAlbum.getName()) == null) {
            albums.add(newAlbum);
            System.out.println(newAlbum.getName() + " added to library");
            return true;
        } else {
            System.out.println(newAlbum.getName() + " already in library");
            return false;
        }
    }

    public void showPlaylist() {
        int playlistItem = 1;
        System.out.println("===============");
        System.out.println("Your playlist: ");
        for (Song song : playlist) {
            System.out.println("\tPlaylist item " + playlistItem + ": " + song.getTitle());
            playlistItem++;
        }
    }

    public void showAlbums() {
        for (Album album : albums) {
            System.out.println(album.getName());
            album.listSongs();
        }
    }

    private Song findSongOnPlaylist(String songTitle) {
        for (Song song: playlist) {
            if (song.getTitle().equals(songTitle)) {
                return song;
            }
        }
        return null;
    }
    private Album findAlbum(String name) {
        for (Album album : albums) {
            if (album.getName().equals(name)) {
                return album;
            }
        }
        return null;
    }

    private void printInstructions() {
        System.out.println("------------");
        System.out.println("Playlist controls:\n" +
                "\t0 - shut down your playlist\n" +
                "\t1- listen to the next song\n" +
                "\t2 - listen to the previous song\n" +
                "\t3 - delete current song\n" +
                "\t4 - print these instructions again\n");
    }
}
