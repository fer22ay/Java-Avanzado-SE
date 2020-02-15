package com.avanzadose.model;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Publication {

    private int id;

    public Magazine(String title, Date editionDate, String editorial) {
        super(title, editionDate, editorial);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String detailMagazine = "\n :: MAGAZINE ::"
                + "\n Title: " + getTitle()
                + "\n Editorial: " + getEditorial()
                + "\n Edition Date: " + getEditionDate()
                + "\n Authors: ";
        for (int i = 0; i < getAutores().length; i++) {
            detailMagazine += "\t" + getAutores()[i] + " ";
        }
        return detailMagazine;
    }

    public static ArrayList<Magazine> makeMagazineList() {

        ArrayList<Magazine> magazines = new ArrayList<>();
        String[] authors = new String[3];
        for (int i = 0; i < 3; i++) {

            authors[i] = "author " + i;

        }
        for (int i = 0; i <= 5; i++) {
            magazines.add(new Magazine("Magazine " + i, new Date(), "Editorial " + i));
        }
        return magazines;

    }

}
