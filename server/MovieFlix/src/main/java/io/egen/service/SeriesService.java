package io.egen.service;


import io.egen.entity.Series;
import java.util.List;
import java.util.Map;

public interface SeriesService {

    List<Series> findAll();

    Series findUsingId(String id);

    Series create(Series series);

    Series update(String id, Series series);

    List<Series> findByArgument(Map<String, String> params);

    void delete(String id);
}
