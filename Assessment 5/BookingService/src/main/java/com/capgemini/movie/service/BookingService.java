package com.capgemini.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.movie.Feign.Movie;
import com.capgemini.movie.Feign.MovieClient;
import com.capgemini.movie.model.Booking;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookingService {

    @Autowired
    private MovieClient movieClient;

    private final List<Booking> bookings = new ArrayList<>();
    private int idCounter = 101;

    @CircuitBreaker(name = "movieService", fallbackMethod = "bookingFallback")
    public Booking createBooking(int movieId, int tickets) {
        Movie movie = movieClient.getMovieById(movieId); // Feign call

        if (movie == null) throw new RuntimeException("Movie not found");

        Booking booking = new Booking(
            idCounter++,
            movieId,
            tickets,
            movie.getPrice() * tickets
        );
        bookings.add(booking);
        return booking;
    }

    // Fallback when Movie Service is down
    public Booking bookingFallback(int movieId, int tickets, Throwable t) {
        Booking fallback = new Booking();
        fallback.setBookingId(-1);
        fallback.setMovieId(movieId);
        fallback.setTickets(tickets);
        fallback.setTotalAmount(0);
        // You could also throw a custom exception or return a meaningful message
        return fallback;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}
