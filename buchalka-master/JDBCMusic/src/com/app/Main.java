package com.app;

import com.app.model.Artist;
import com.app.model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        if (!dataSource.open()) {
            System.out.println("Can't open data source");
            return;
        }

        List<Artist> artists = dataSource.queryArtists();
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        artists.forEach(artist -> {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        });

        dataSource.close();
    }
}
