package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Get All Movies
    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> movies = movieService.getMovie();
        model.addAttribute("movies", movies);
        return "movies";
    }

    // Show Add Movie Form
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }

    // Save Movie
    @PostMapping
    public String saveMovie(@ModelAttribute Movie movie) {
        movieService.putMovie(movie);
        return "redirect:/movies";
    }

    // Update Movie
    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute Movie movie) {
        movieService.updateMovie(id, movie);
        return "redirect:/movies";
    }

    // Delete Movie
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}