package io.egen.repository;


import io.egen.entity.Series;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class SeriesRepositoryImpl implements SeriesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Series> findAll() {
        TypedQuery<Series> query = entityManager.createNamedQuery("Series.findAll", Series.class);
        return query.getResultList();
    }

    public Series findUsingTitle(String title) {
        TypedQuery<Series> query = entityManager.createNamedQuery("Series.findUsingTitle", Series.class);
        query.setParameter("paramTitle","title");
        List<Series> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1){
            return resultList.get(0);
        }
        return null;
    }

    public Series findUsingId(String id) {
        return entityManager.find(Series.class, id);
    }

    public List<Series> findByArgument(Map<String, String> params) {
        TypedQuery<Series> query = null;

        if (params.get("type") != null)
        {
            if (params.get("sort") == "imdbRating")
                query = entityManager.createNamedQuery("Series.findByTypeSortByImdbRating", Series.class);

            else if (params.get("sort") != "imdbVotes")
                query = entityManager.createNamedQuery("Series.findByTypeSortByImdbVotes", Series.class);

            else if (params.get("sort") == "year")
                query = entityManager.createNamedQuery("Series.findByTypeSortByYear", Series.class);

            else
                query = entityManager.createNamedQuery("Series.findByType", Series.class);
            query.setParameter("paramType", params.get("type"));
        }

        else if (params.get("year") != null)

        {
            if (params.get("sort") == "imdbRating")
                query = entityManager.createNamedQuery("Series.findByYearSortByimdbRating", Series.class);

            else if (params.get("sort") == "imdbVotes")
                query = entityManager.createNamedQuery("Series.findByYearSortByimdbVotes", Series.class);

            else if (params.get("sort") == "year")
                query = entityManager.createNamedQuery("Series.findByYearSortByYear", Series.class);

            else
                query = entityManager.createNamedQuery("Series.findByYear", Series.class);
            query.setParameter("paramYear",Integer.parseInt(params.get("Year")));
        }

        else if (params.get("genre") != null)
        {

            if (params.get("sort") == "imdbRating")
                query = entityManager.createNamedQuery("Series.findByGenreSortByimdbRating", Series.class);

            else if (params.get("sort") == "imdbVotes")
                query = entityManager.createNamedQuery("Series.findByGenreSortByimdbVotes", Series.class);

            else if (params.get("sort") == "year")
                query = entityManager.createNamedQuery("Series.findByGenreSortByYear", Series.class);
            else
                query = entityManager.createNamedQuery("Series.findByGenre", Series.class);
            query.setParameter("paramGenre", params.get("genre"));
        }

        else {

            if (params.get("sort") == "imdbRating")
                query = entityManager.createNamedQuery("Series.findAllSortByimdbRating", Series.class);

            else if (params.get("sort") == "imdbVotes")
                query = entityManager.createNamedQuery("Series.findAllSortByimdbVotes", Series.class);

            else if (params.get("sort") == "Year")
                query = entityManager.createNamedQuery("Series.findAllSortByYear", Series.class);

            else
                query = entityManager.createNamedQuery("Series.findAll", Series.class);
        }
        List<Series> resultList = query.getResultList();
        return resultList;

    }

    public Series create(Series series) {
        entityManager.persist(series);
        return series;
    }

    public Series update(Series series) {
       return entityManager.merge(series);
    }

    public void delete(Series series) {
        entityManager.remove(series);
    }
}
