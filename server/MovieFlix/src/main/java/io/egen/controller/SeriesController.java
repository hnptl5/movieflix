package io.egen.controller;


import io.egen.entity.Series;
import io.egen.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "series")
public class SeriesController {

    @Autowired
    SeriesService seriesService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Series> findAll(Map<String, String> params){
        return seriesService.findByArgument(params);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Series findUsingId(@PathVariable("id") String seriesId){
        return seriesService.findUsingId(seriesId);
    }

    @RequestMapping(method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Series create(@RequestBody Series series){
        return seriesService.create(series);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}",
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Series update(@PathVariable("id") String seriesId, @RequestBody Series series){
        return seriesService.update(seriesId, series);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String seriesId){
        seriesService.delete(seriesId);
    }
}
