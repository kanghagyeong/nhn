package com.nhnacademy.app;

import java.util.List;

public class MovieMain {

    public static void main(String[] args) {
      MovieParser movieParser = new ApacheCommonsCsvMovieParser();
      //MovieParser movieParser = new BasicMovieParser();
  
      try {
        List<Movie> movieList = movieParser.parse("movies.csv");
        for(Movie movie : movieList){
          System.out.println(movie);
        }
      }catch (Exception e){
        System.out.println(e.getMessage());
      }
  
    }
  }
