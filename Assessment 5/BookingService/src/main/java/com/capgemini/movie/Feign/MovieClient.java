package com.capgemini.movie.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service")  // uses Eureka service name — no hardcoded URL
public interface MovieClient {

    @GetMapping("/movies/{id}")
    Movie getMovieById(@PathVariable int id);
}