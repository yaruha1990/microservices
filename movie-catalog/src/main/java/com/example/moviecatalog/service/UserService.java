package com.example.moviecatalog.service;

import com.example.moviecatalog.dao.UserDAO;
import com.example.moviecatalog.entity.Movie;
import com.example.moviecatalog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userService")
public class UserService {

    @Autowired
    @Qualifier(value = "userDAO")
    UserDAO userDAO;

    public User getUserDetails(int id){
        return userDAO.getUserByID(id);
    }

    public List<Movie> getUserMoviesList(int id){
        return getUserDetails(id).getMovies();
    }
}
