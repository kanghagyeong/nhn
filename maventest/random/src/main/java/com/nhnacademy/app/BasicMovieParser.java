package com.nhnacademy.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicMovieParser implements MovieParser {

    @Override
    public List<Movie> parse(String fileName) throws IOException {
        List<Movie> movie = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(getMovieFileAsStream()));
        br.readLine();
        String line = "";
        while ( (line = br.readLine()) != null ) {
            String[] a = line.split(",");
            long id = Long.parseLong(a[0]);
            String title = a[1];

            String[] genre = a[2].split("\\|");
            Set<String> set = new HashSet<>(Arrays.asList(genre));

            Movie movies = new Movie(id, title, set);
            movie.add(movies);
        
        }

        return movie;

    }
    
}
