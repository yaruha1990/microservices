package com.example.moviecatalog.controller;

import com.example.moviecatalog.entity.Movie;
import com.example.moviecatalog.entity.User;
import com.example.moviecatalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "userService")
    UserService userService;

    @RequestMapping("/{userId}")
    public User getUserInfo(@PathVariable("userId") String userId){
        User user = userService.getUserDetails(Integer.valueOf(userId));
        for (Movie movie : user.getMovies()) {
            Movie gottenMovie = restTemplate.getForObject("http://movie-details-service/movies/"+movie.getId(),Movie.class);
            movie.setDescription(gottenMovie.getDescription());
        }
        return user;
    }
}
