package io.egen.controller;


import io.egen.entity.Movie;
import io.egen.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> findAll(@RequestParam Map<String, String> params){
        return movieService.findByArgument(params);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}",
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie findUsingId(@PathVariable("id") String movieId){
        return movieService.findUsingId(movieId);
    }

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie create(@RequestBody Movie movie){
        return movieService.create(movie);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}",
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie update(@PathVariable("id") String movieId, @RequestBody Movie movie){
        return movieService.update(movieId, movie);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String movieId){
        movieService.delete(movieId);
    }
}