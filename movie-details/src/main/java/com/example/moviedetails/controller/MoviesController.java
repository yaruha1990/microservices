package com.example.moviedetails.controller;

import com.example.moviedetails.entity.Movie;
import com.example.moviedetails.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    @Qualifier(value = "movieService")
    MovieService movieService;

    @RequestMapping(value = "/{movieID}")
    public Movie getMovie(@PathVariable("movieID") String movieID){
        return movieService.findMovieByID(Integer.valueOf(movieID));
    }
}
