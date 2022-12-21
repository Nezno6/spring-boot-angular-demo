package com.model.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @PostMapping("/movies")
    void addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }
}
