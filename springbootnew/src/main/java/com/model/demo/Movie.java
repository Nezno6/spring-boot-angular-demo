package com.model.demo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Table
@Entity
public class Movie {

    // FUN FACT:
    // The entity class must not be final.
    // No methods or persistent instance variables of the entity class may be final.
    // 2.1 The Entity Class (site 23)
    // ---> https://download.oracle.com/otn-pub/jcp/persistence-2_1-fr-eval-spec/JavaPersistence.pdf?AuthParam=1671380680_c52519b59dafaa11e24c3dfab7617c38
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String code;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Set<String> directors;
    private Set<String> starCast;
    private Set<String> genres;

    public Movie() {
    }

    public Movie(String title, String description, LocalDate releaseDate, Set<String> directors, Set<String> starCast, Set<String> genres) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.directors = directors;
        this.starCast = starCast;
        this.genres = genres;
        this.code = titleAndDateToCode(title,releaseDate);
    }

    private String titleAndDateToCode(String title, LocalDate releaseDate) {
        int year = Optional.of(releaseDate)
                .orElse(LocalDate.of(0, 1, 1))
                .getYear();
        String code = Arrays.stream(title.toUpperCase()
                        .split(" ")).limit(15)
                .map(word -> word.length() <= 3 ? word : word.substring(0, 3))
                .collect(Collectors.joining("")) + year;
        return code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<String> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<String> directors) {
        this.directors = directors;
    }

    public Set<String> getStarCast() {
        return starCast;
    }

    public void setStarCast(Set<String> starCast) {
        this.starCast = starCast;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                ", directors=" + directors +
                ", starCast=" + starCast +
                ", genres=" + genres +
                '}';
    }
}

