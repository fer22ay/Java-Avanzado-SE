package com.avanzadose.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * *
 * Herada de {@link Film} Implementa de {@link IVisualizable}
 *
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 2020
 */
public class Movie extends Film implements IVisualizable {

    private int id;
    private int timeViewed;

    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        setYear(year);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        return "\n :: Movie ::"
                + "\n Title ::" + getTitle()
                + "\n Genero: " + getGenre()
                + "\n Year: " + getYear()
                + "\n Creator: " + getCreator()
                + "\n Duration: " + getDuration();
    }

    /**
     * *
     * {@inheritDoc }
     */
    public Date startToSee(Date dateI) {
        return dateI;
    }

    /**
     * *
     * {@inheritDoc }
     */
    public void stopToSee(Date dateI, Date dateF) {

        if (dateF.getTime() > dateI.getTime()) {
            setTimeViewed((int) (dateF.getTime() - dateI.getTime()));
        } else {
            setTimeViewed(0);
        }

    }

    public static ArrayList<Movie> makeMoviesList() {

        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            movies.add(new Movie("Movie: " + i, "Genero " + i, "Creador: " + i, 120 + i, (short) (2017 + i)));
        }
        return movies;
    }

    /**
     * *
     * {@inheritDoc }
     */
    @Override
    public void view() {
        setViewed(true);
        Date dateI = startToSee(new Date());

        for (int i = 0; i < 100000; i++) {
            System.out.println("..............");
        }

        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Viste: " + toString());
        System.out.println("Por: " + getTimeViewed() + " milisegundos");
    }

}
