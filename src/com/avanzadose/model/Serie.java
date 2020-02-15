package com.avanzadose.model;

import java.util.ArrayList;

/**
 * *
 * Hereda de {@link Film}
 *
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 2020
 */
public class Serie extends Film {

    private int id;
    private int sesssionQuantity;
    private ArrayList<Chapter> chapters;

    public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
        super(title, genre, creator, duration);
        this.sesssionQuantity = sessionQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSesssionQuantity() {
        return sesssionQuantity;
    }

    public void setSesssionQuantity(int sesssionQuantity) {
        this.sesssionQuantity = sesssionQuantity;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "\n :: SERIE ::"
                + "\n Title: " + getTitle()
                + "\n Genero: " + getGenre()
                + "\n Year: " + getYear()
                + "\n Creator: " + getCreator()
                + "\n Duration: " + getDuration();
    }

    public static ArrayList<Serie> makeSeriesList() {
        ArrayList<Serie> series = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            Serie serie = new Serie("Serie: " + i, "Genero: " + i, "Creador: " + i, 1200, 5);
            serie.setChapters(Chapter.makeChaptersList(serie));
            series.add(serie);
        }

        return series;
    }

    /**
     * *
     * {@inheritDoc }
     */
    @Override
    public void view() {
        setViewed(true);
    }

}
