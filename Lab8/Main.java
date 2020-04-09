package com.company;

import dbapp.dao.AlbumController;
import dbapp.dao.ArtistController;
import dbapp.dao.Database;

public class Main {

    public static void main(String[] args) {
        ArtistController test = new ArtistController();
        System.out.println( test.findByName("\'Caravan Palace\'"));
        test.create("\'Skillet\'","\'USA\'");
        AlbumController test2 = new AlbumController();
        test2.findByArtist(1);
        test2.create("\'Lion\'",3,2016);
        Database.closeConnection();

    }
}
