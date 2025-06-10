package com.desafio.sf_movies.service;

import com.desafio.sf_movies.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final WebClient webClient;

    public MovieService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://data.sfgov.org/resource/yitu-d5am.json")
                .build();
    }

    public List<Movie> getAllMovies() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Movie.class)
                .collectList()
                .block();
    }

    public List<Movie> filterMoviesByTitle(String title) {
        return getAllMovies().stream()
                .filter(movie -> movie.getTitle() != null && movie.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> autocomplete(String prefix) {
        return getAllMovies().stream()
                .map(Movie::getTitle)
                .filter(Objects::nonNull)
                .filter(title -> title.toLowerCase().startsWith(prefix.toLowerCase()))
                .distinct()
                .sorted()
                .limit(10)
                .collect(Collectors.toList());
    }
}