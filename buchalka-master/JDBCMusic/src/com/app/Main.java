package com.app;

import com.app.model.Artist;
import com.app.model.DataSource;
import com.app.model.DataSource.OrderBy;
import com.app.model.SongArtist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        if (!dataSource.open()) {
            System.out.println("Can't open data source");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(OrderBy.ASC);
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        artists.forEach(artist -> {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        });

        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Pink Floyd", OrderBy.DESC);

        albumsForArtist.forEach(System.out::println);

        List<SongArtist> songArtists = dataSource.queryArtistForSong("Go Your Own Way", OrderBy.ASC);

        songArtists.forEach(artist -> {
            System.out.println("Artist = " + artist.getArtistName() +
                    ", Album name = " + artist.getAlbumName() +
                    ", Track = " + artist.getTrack());
        });

        dataSource.querySongsMetaData();

        int count = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs is = " + count);

        dataSource.createViewForSongArtists();

        List<SongArtist> songArtistsFromView =dataSource.querySongInfoView("Go Your Own Way");

        if (songArtistsFromView.isEmpty()) {
            System.out.println("Could not find song");
        } else {
            songArtistsFromView.forEach(artist -> {
                System.out.println("Artist = " + artist.getArtistName() +
                        ", Album name = " + artist.getAlbumName() +
                        ", Track = " + artist.getTrack());
            });
        }


        dataSource.close();
    }
}
