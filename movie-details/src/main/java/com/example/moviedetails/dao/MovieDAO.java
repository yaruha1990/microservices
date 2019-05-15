package com.example.moviedetails.dao;

import com.example.moviedetails.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "movieDAO")
public class MovieDAO {

    private List<Movie> movies = new ArrayList<>();

    public MovieDAO() {
        movies.add(new Movie(1,"Movie1","Movie1Description"));
        movies.add(new Movie(2,"Movie2","Movie2Description"));
        movies.add(new Movie(3,"Movie3","Movie3Description"));
        movies.add(new Movie(4,"Movie4","Movie4Description"));
    }

    public Movie getMovieByID(int id){
        return movies.stream().filter(m -> m.getId() == id).collect(Collectors.toList()).get(0);
    }
}
