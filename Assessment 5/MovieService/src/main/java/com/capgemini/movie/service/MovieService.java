package com.capgemini.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.movie.model.Movie;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>(List.of(
        new Movie(1, "Inception", "English", 250),
        new Movie(2, "RRR", "Telugu", 200),
        new Movie(3, "Dangal", "Hindi", 180)
    ));

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        return movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }
}