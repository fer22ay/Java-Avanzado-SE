package com.avanzadose.viewer;

import com.avanzadose.model.Book;
import com.avanzadose.model.Chapter;
import com.avanzadose.model.Magazine;
import com.avanzadose.model.Movie;
import com.avanzadose.model.Serie;
import com.avanzadose.util.AmazonUtil;
import com.fernando.makereport.Report;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * < h1>AmazonViewer</h1>
 * AmazonView es un programa que permite visualizar Movies, Series con sus
 * respectivos Chapters, Books y Magazines. Te permite generar reportes
 * generales y con fecha del dia.
 * <p>
 * Existen algunas reglas como que todos los elementos pueden ser visualizados o
 * leidos a excepcion de las Magazines, estas solo puede ser vistas a moodo de
 * exposicion sin ser leidas.
 *
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 2020
 */
public class Main {

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int exit = 0;
        do {
            System.out.println("WELCOME AMAZON VIEWER");
            System.out.println("");
            System.out.println("Selecciona el numero de la opcion deseada");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");

            //Leer la respuesta del usuario
            int response = AmazonUtil.validateUserResponseMenu(0, 6);

            switch (response) {
                case 0:
                    //Salir
                    exit = 0;
                    break;
                case 1:
                    showMovies();
                    break;
                case 2:
                    showSeries();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    showMagazines();
                    break;
                case 5:
                    makeReport();
                    exit = 1;
                    break;
                case 6:
                    makeReport(new Date());
                    exit = 1;
                    break;
                default:
                    System.out.println();
                    System.out.println("....!!Selecciona una opcion!!...");
                    System.out.println();
                    exit = 1;
                    break;
            }
        } while (exit != 0);
    }

    static ArrayList<Movie> movies = Movie.makeMoviesList();

    public static void showMovies() {
        int exit = 1;

        do {
            System.out.println();
            System.out.println(":: MOVIES ::");
            System.out.println();

            for (int i = 0; i < movies.size(); i++) {
                System.out.println(i + 1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            int response = AmazonUtil.validateUserResponseMenu(0, movies.size());

            if (response == 0) {
                exit = 0;
                showMenu();
                break;
            }
            if (response > 0) {
                Movie movieSelected = movies.get(response - 1);
                movieSelected.view();

            }
        } while (exit != 0);
    }

    static ArrayList<Serie> series = Serie.makeSeriesList();

    public static void showSeries() {
        int exit = 1;

        do {
            System.out.println();
            System.out.println(":: SERIES ::");
            System.out.println();

            for (int i = 0; i < series.size(); i++) {
                System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            int response = AmazonUtil.validateUserResponseMenu(0, series.size());

            if (response == 0) {
                exit = 0;
                showMenu();
            }
            if (response > 0) {
                showChapters(series.get(response - 1).getChapters());
            }
        } while (exit != 0);
    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
        int exit = 1;

        do {
            System.out.println();
            System.out.println(":: CHAPTERS ::");
            System.out.println();

            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
                System.out.println(i + 1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + "Visto: " + chaptersOfSerieSelected.get(i).isViewed());
            }
            System.out.println("0. Regresar al Menu");
            System.out.println();

            //Leer respuesta usuario
            int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());

            if (response == 0) {
                exit = 0;
            }

            if (response > 0) {
                Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
                chapterSelected.view();

            }

        } while (exit != 0);
    }

    static ArrayList<Book> books = Book.makeBookList();

    public static void showBooks() {
        int exit = 1;

        do {
            System.out.println();
            System.out.println(":: BOOKS ::");
            System.out.println();

            for (int i = 0; i < books.size(); i++) {
                System.out.println(i + 1 + ". " + books.get(i).getTitle() + " Leido: " + books.get(i).isReaded());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            int response = AmazonUtil.validateUserResponseMenu(0, books.size());

            if (response == 0) {
                exit = 0;
                showMenu();
            }

            if (response > 0) {
                Book bookSelected = books.get(response - 1);
                bookSelected.view();
            }
        } while (exit != 0);
    }

    public static void showMagazines() {

        ArrayList<Magazine> magazines = Magazine.makeMagazineList();
        int exit = 0;
        do {            
            System.out.println();
            System.out.println(":: MAGAZINES ::");
            System.out.println();
            
            for (int i = 0; i < magazines.size(); i++) {
                System.out.println(i + 1 + ". " + magazines.get(i).getTitle());
            }
            
            System.out.println("0. Regresar al Menu");
            System.out.println();
            
            int response = AmazonUtil.validateUserResponseMenu(0, 0);
            
            if (response == 0) {
                exit = 0;
                showMenu();
            }
        } while (exit !=0);
        
    }

    public static void makeReport() {

        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        
        String contentReport = "";
        
        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";
            }
        }
        
        for (Serie serie : series) {
            ArrayList<Chapter> chapters = serie.getChapters();
            for (Chapter chapter : chapters) {
                if (chapter.getIsViewed()) {
                    contentReport += chapter.toString() + "\n";
                }
            }
        }
        
        for (Book book : books) {
            if (book.getIsReaded()) {
                contentReport += book.toString() + "\n";
            }
        }
        
        report.setContent(contentReport);
        report.makeReport();
        System.out.println("Reporte generado");
        System.out.println();
        
    }

    public static void makeReport(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
        String dateString = df.format(date);
        Report report = new Report();
        
        report.setNameFile("reporte" + dateString);
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        
        SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W, MMM Y");
        dateString = dfNameDays.format(date);
        String contentReport = "Date: " + dateString + "\n\n\n";
        
        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";
            }
        }
        
        for (Book book : books) {
            if (book.getIsReaded()) {
                contentReport  += book.toString() + "\n";
            }
        }
        
        report.setContent(contentReport);
        report.makeReport();
        
        System.out.println("Reporte Generado");
        System.out.println();
        
    }

}
