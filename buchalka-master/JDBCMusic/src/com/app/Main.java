package com.app;

import com.app.model.Artist;
import com.app.model.DataSource;
import com.app.model.DataSource.OrderBy;

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

        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Iron Maiden", OrderBy.ASC);

        albumsForArtist.forEach(System.out::println);

        dataSource.close();
    }
}
