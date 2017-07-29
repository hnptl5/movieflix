package io.egen.repository;

import io.egen.entity.Series;
import io.egen.service.SeriesService;

import java.util.List;
import java.util.Map;

public interface SeriesRepository {


    List<Series> findAll();

    Series findUsingId(String id);

    Series create(Series series);

    Series findUsingTitle(String title);

    Series update(Series series);

    List<Series> findByArgument(Map<String, String> params);

    void delete(Series series);

}
