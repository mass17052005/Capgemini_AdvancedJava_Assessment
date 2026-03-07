package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepo;

@Service
public class MovieService {

    private MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<Movie> getMovie() {
        return movieRepo.findAll();
    }

    public Movie putMovie(Movie movie){
        return movieRepo.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie){
        Movie existing = movieRepo.findById(id).orElseThrow();

        // CHANGED: Removed setId()
        existing.setTitle(movie.getTitle());        // CHANGED
        existing.setGenre(movie.getGenre());        // CHANGED
        existing.setDirector(movie.getDirector());  // CHANGED
        existing.setRelease_year(movie.getRelease_year()); // CHANGED
        existing.setRating(movie.getRating());      // CHANGED

        return movieRepo.save(existing);
    }

    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
    }
}