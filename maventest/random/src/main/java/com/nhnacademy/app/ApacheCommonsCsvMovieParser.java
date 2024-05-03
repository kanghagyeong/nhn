package com.nhnacademy.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ApacheCommonsCsvMovieParser implements MovieParser {

    @Override
    public List<Movie> parse(String fileName) throws IOException {
        List<Movie> movie = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(getMovieFileAsStream()));

        CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(br);

        for (CSVRecord csvRecord : parser) {
            long id = Long.parseLong(csvRecord.get("movieId"));
            String title = csvRecord.get("title");
            String[] genre = (csvRecord.get("genres")).split("\\|");
            Set<String> set = new HashSet<>(Arrays.asList(genre));
            
    
            Movie movies = new Movie(id, title, set);
            movie.add(movies);
        }

        return movie;
    }

}
