package io.egen.service;

import io.egen.entity.Movie;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Movie findUsingId(String id) {
        Movie existing = movieRepository.findUsingId(id);
        if (existing == null){
            throw new ResourceNotFoundException("The movie with id" + id + "does not exists");
        }
        return existing;
    }

    @Transactional
    public Movie create(Movie movie) {
        Movie existed = movieRepository.findUsingTitle(movie.getTitle());
        if (existed != null){
            throw new BadRequestException("The movie with id" + movie.getId() + "already exists" );
        }
        return movieRepository.create(movie);
    }

    @Transactional(readOnly = true)
    public List<Movie> findByArgument(Map<String, String> params) {
        return movieRepository.findByArgument(params);
    }

    @Transactional
    public Movie update(String id, Movie movie) {
        Movie existing = movieRepository.findUsingId(id);
        if (existing == null){
                throw new ResourceNotFoundException("Movie with id " + id + "does not exist");
        }
        return movieRepository.update(movie);
    }

    @Transactional
    public void delete(String id) {
        Movie existing = movieRepository.findUsingId(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Movie with the Id " + id + "does not exists");
        }
            movieRepository.delete(existing);

    }
}
