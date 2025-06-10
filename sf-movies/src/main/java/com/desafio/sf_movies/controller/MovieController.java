package com.desafio.sf_movies.controller;

import com.desafio.sf_movies.model.Movie;
import com.desafio.sf_movies.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> getAllMovies(@RequestParam Optional<String> title) {
        return title.map(service::filterMoviesByTitle)
                .orElseGet(service::getAllMovies);
    }

    @GetMapping("/autocomplete")
    public List<String> autocomplete(@RequestParam("prefix") String prefix) {
        return service.autocomplete(prefix);
    }
}