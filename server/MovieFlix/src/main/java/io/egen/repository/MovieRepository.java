package io.egen.repository;

import io.egen.entity.Movie;
import java.util.List;
import java.util.Map;


public interface MovieRepository  {

    List<Movie> findAll();

    Movie findUsingId(String id);

    Movie create(Movie movie);

    Movie findUsingTitle(String title);

    List<Movie> findByArgument(Map<String, String> params);

    Movie update(Movie movie);

    void delete(Movie movie);
}
