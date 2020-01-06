package com.avanzadose.dao;

import com.avanzadose.model.Movie;
import java.util.ArrayList;

/**
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 2020
 */
public interface MovieDAO {
    
    default Movie setMovieViewed(Movie movie){
        return movie;
    }
    
    default ArrayList<Movie> read(){
        ArrayList<Movie> movies = new ArrayList<>();
        return movies;
    }
    
//    private boolean getMovieViewed(){
//        return false;
//    }
//    
}
