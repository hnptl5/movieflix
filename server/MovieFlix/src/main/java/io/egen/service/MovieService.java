package io.egen.service;


import io.egen.entity.Movie;
import java.util.List;
import java.util.Map;


public interface MovieService {

     List<Movie> findAll();

     Movie findUsingId(String id);

     Movie create(Movie movie);

     List<Movie> findByArgument(Map<String, String> params);

     Movie update(String id, Movie movie);

     void delete(String id);
}
