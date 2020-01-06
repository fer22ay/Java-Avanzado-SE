package com.avanzadose.model;

import java.util.ArrayList;

/***
 * Hereda de {@link Movie}
 * @see Film
 * @author Fernando Ambrosio
 */
public class Chapter extends Movie{
 
    private int id;
    private int sessionNumber;
    private Serie serie;

    public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
        super(title, genre, creator, duration, year);
        this.setSessionNumber(sessionNumber);
        this.setSerie(serie);
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "\n :: SERIE ::"
                + "\n Title: " + getTitle() + 
                "\n :: CHAPTER ::"
                + "\n Title: " + getTitle() + 
                "\n Year: " + getYear() + 
                "\n Creator: " + getCreator() +
                "\n Duration:" + getDuration();
    }   
    
    public static ArrayList<Chapter> makeChaptersList(Serie serie){
        ArrayList<Chapter> chapters = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            chapters.add(new Chapter("Capitulo: "+i, "Genero"+i, "Creador: "+i, 45, (short)(2017+1), i, serie));
        }
        return chapters;
    }

    @Override
    public void view() {
        super.view();
        ArrayList<Chapter> chapters = getSerie().getChapters();
        int chapterViewedCounter = 0;
        for (Chapter chapter : chapters) {
            if (chapter.getIsViewed()) {
                chapterViewedCounter++;
            }
        }
        
        if (chapterViewedCounter == chapters.size()) {
            getSerie().view();
            
        }
    }
    
}
