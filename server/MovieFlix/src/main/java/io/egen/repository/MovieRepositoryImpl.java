package io.egen.repository;

import io.egen.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Movie> findAll() {
        TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findAll", Movie.class);
        return query.getResultList();
    }

    public Movie findUsingId(String id) {
        return entityManager.find(Movie.class, id);
    }

    public Movie create(Movie movie) {
         entityManager.persist(movie);
         return movie;
    }

    public Movie findUsingTitle(String title) {
        TypedQuery<Movie> query = entityManager.createNamedQuery("Movie.findUsingTitle", Movie.class);
        query.setParameter("paramsTitle", title);
        List<Movie> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1 ){
            return resultList.get(0);
        }
        return null;
    }

    public List<Movie> findByArgument(Map<String, String> params) {

        TypedQuery<Movie> query = null;

        if (params.get("type") != null)
        {
            if (params.get("sort") == "imdbRating")
                query = entityManager.createNamedQuery("Movie.findByTypeSortByImdbRating", Movie.class);

            else if (params.get("sort") != "imdbVotes")
                query = entityManager.createNamedQuery("Movie.findByTypeSortByImdbVotes", Movie.class);

            else if (params.get("sort") == "year")
                query = entityManager.createNamedQuery("Movie.findByTypeSortByYear", Movie.class);

            else
                query = entityManager.createNamedQuery("Movie.findByType", Movie.class);
            query.setParameter("paramsType", params.get("type"));
        }

        else if (params.get("year") != null)

        {
            if (params.get("sort") == "imdbRating")
                query = entityManager.createNamedQuery("Movie.findByYearSortByimdbRating", Movie.class);

            else if (params.get("sort") == "imdbVotes")
                query = entityManager.createNamedQuery("Movie.findByYearSortByimdbVotes", Movie.class);

            else if (params.get("sort") == "year")
                query = entityManager.createNamedQuery("Movie.findByYearSortByYear", Movie.class);

            else
                query = entityManager.createNamedQuery("Movie.findByYear", Movie.class);
            query.setParameter("paramsYear",Integer.parseInt(params.get("Year")));
        }

        else if (params.get("genre") != null)
        {

            if (params.get("sort") == "imdbRating")
                query = entityManager.createNamedQuery("Movie.findByGenreSortByimdbRating", Movie.class);

            else if (params.get("sort") == "imdbVotes")
                query = entityManager.createNamedQuery("Movie.findByGenreSortByimdbVotes", Movie.class);

            else if (params.get("sort") == "year")
                query = entityManager.createNamedQuery("Movie.findByGenreSortByYear", Movie.class);
            else
                query = entityManager.createNamedQuery("Movie.findByGenre", Movie.class);
            query.setParameter("paramsGenre", params.get("genre"));
        }

        else {

            if (params.get("sort") == "imdbRating")
                query = entityManager.createNamedQuery("Movie.findAllSortByimdbRating", Movie.class);

            else if (params.get("sort") == "imdbVotes")
                query = entityManager.createNamedQuery("Movie.findAllSortByimdbVotes", Movie.class);

            else if (params.get("sort") == "Year")
                query = entityManager.createNamedQuery("Movie.findAllSortByYear", Movie.class);

            else
                query = entityManager.createNamedQuery("Movie.findAll", Movie.class);
        }
        List<Movie> resultList = query.getResultList();
        return resultList;

    }

    public Movie update(Movie movie) {
        entityManager.merge(movie);
        return movie;
    }

    public void delete(Movie movie) {
        entityManager.remove(movie);
    }


}
