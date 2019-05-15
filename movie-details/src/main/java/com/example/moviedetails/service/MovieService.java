package com.example.moviedetails.service;

import com.example.moviedetails.dao.MovieDAO;
import com.example.moviedetails.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "movieService")
public class MovieService {

    @Autowired
    @Qualifier(value = "movieDAO")
    private MovieDAO movieDAO;

    public Movie findMovieByID(int id){
        return movieDAO.getMovieByID(id);
    }

    public String getMovieDescription(int id){
        return findMovieByID(id).getDescription();
    }
}
