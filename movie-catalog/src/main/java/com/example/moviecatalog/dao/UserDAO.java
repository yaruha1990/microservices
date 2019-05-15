package com.example.moviecatalog.dao;

import com.example.moviecatalog.entity.Movie;
import com.example.moviecatalog.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "userDAO")
public class UserDAO {

    private List<User> users = new ArrayList<>();

    public UserDAO() {
        users.add(new User(1,"Yarik", Arrays.asList(new Movie(1,"Movie1"),new Movie(2,"Movie2"))));
        users.add(new User(2,"Yana",Arrays.asList(new Movie(3,"Movie3"),new Movie(4,"Movie4"))));
    }

    public User getUserByID(int id){
        return users.stream().filter(u -> u.getId() == id).collect(Collectors.toList()).get(0);
    }

}
