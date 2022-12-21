package com.model.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(MovieRepository movieRepository) {
        return args -> {
            Stream.of(
                    "The Shawshank Redemption",
                    "The Godfather",
                    "The Dark Knight",
                    "The Godfather Part II",
                    "12 Angry Men"
            ).forEach(title -> {
                String description = "";
                LocalDate releaseDate = LocalDate.parse("2022-10-10");
                Set<String> directors = Set.of("");
                Set<String> starCast = Set.of("");
                Set<String> genres = Set.of("");

                Movie movie = new Movie(title, description, releaseDate, directors, starCast, genres);
                movieRepository.save(movie);
            });
            movieRepository.findAll().forEach(System.out::println);
        };
    }

}
