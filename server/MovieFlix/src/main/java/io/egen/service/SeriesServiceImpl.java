package io.egen.service;

import io.egen.entity.Series;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SeriesServiceImpl implements SeriesService {


    @Autowired
    SeriesRepository seriesRepository;

    @Transactional(readOnly = true)
    public List<Series> findAll() {
        return seriesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Series findUsingId(String id) {
        Series existing = seriesRepository.findUsingId(id);
        if (existing == null){
            throw new ResourceNotFoundException("");
        }
        return existing;
    }

    @Transactional
    public Series create(Series series) {
        Series existing = seriesRepository.findUsingTitle(series.getTitle());
        if (existing != null){
            throw new BadRequestException("Series with title" + series.getTitle() + "already exists");
        }
        return seriesRepository.create(series);
    }

    @Transactional
    public Series update(String id, Series series) {
        Series existing = seriesRepository.findUsingId(id);
        if (existing == null){
            throw new ResourceNotFoundException("Series with the Id " + id + "already exists");
        }
        return seriesRepository.update(series);
    }

    @Transactional
    public void delete(String id) {
        Series existing = seriesRepository.findUsingId(id);
        if (existing == null){
            throw new BadRequestException("Series with Id " + id + "already does not exist");
        }
        seriesRepository.delete(existing);
    }

    public List<Series> findByArgument(Map<String, String> params) {
        return seriesRepository.findByArgument(params);
    }
}
