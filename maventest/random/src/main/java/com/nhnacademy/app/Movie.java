package com.nhnacademy.app;

import java.util.Set;

public class Movie {
    private final long MovieId;
    private final String title;
    private final Set<String> genres;

    public Movie(long movieId, String title, Set<String> genres) {
        MovieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie [MovieId=" + MovieId + ", title=" + title + ", genres=" + genres + "]";
    }

    
}
