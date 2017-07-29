package io.egen.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findAll",
                query = "SELECT movie from Movie movie ORDER BY movie.title ASC "),
        @NamedQuery(name = "Movie.findUsingTitle",
                query = "SELECT movie from Movie movie where movie.title=:paramsTitle order by movie.title desc "),
        @NamedQuery(name = "Movie.findByTypeSortByImdbRating",
                query = "SELECT movie from Movie movie where movie.type=:paramsType order by movie.imdbRating desc"),
        @NamedQuery(name = "Movie.findByTypeSortByImdbVotes",
                query = "SELECT movie from Movie movie where movie.type=:paramsType order by movie.imdbVotes desc"),
        @NamedQuery(name = "Movie.findByTypeSortByYear",
                query = "SELECT movie from Movie movie where movie.type=:paramsType order by movie.year desc"),
        @NamedQuery(name = "Movie.findByType",
                query = "SELECT movie from Movie movie where movie.type=:paramsType order by movie.title ASC "),
        @NamedQuery(name = "Movie.findByYearSortByimdbRating",
                query = "SELECT movie from Movie movie where movie.year=:paramsYear order by movie.imdbRating desc "),
        @NamedQuery(name = "Movie.findByYearSortByimdbVotes",
                query = "SELECT movie from Movie movie where movie.year=:paramsYear order by movie.imdbVotes desc"),
        @NamedQuery(name = "Movie.findByYearSortByYear",
                query = "SELECT movie from Movie movie where movie.year=:paramYear order by movie.year desc "),
        @NamedQuery(name = "Movie.findByYear",
                query = "SELECT movie from Movie movie where movie.year=:paramsYear order by movie.title ASC "),
        @NamedQuery(name = "Movie.findByGenreSortByimdbRating",
                query = "SELECT movie from Movie movie where movie.genre=:paramsGenre order by movie.imdbRating desc "),
        @NamedQuery(name = "Movie.findByGenreSortByimdbVotes",
                query = "SELECT movie from Movie movie where movie.genre=:paramsGenre order by movie.imdbVotes desc "),
        @NamedQuery(name = "Movie.findByGenreSortByYear",
                query = "SELECT movie from Movie movie where movie.genre=:paramsGenre order by movie.year desc"),
        @NamedQuery(name = "Movie.findByGenre",
                query = "SELECT movie from Movie movie where movie.genre=:paramsGenre order by movie.title asc "),
        @NamedQuery(name = "Movie.findAllSortByimdbRating",
                query = "SELECT movie from Movie movie order by movie.imdbRating DESC "),
        @NamedQuery(name = "Movie.findAllSortByimdbVotes",
                query = "SELECT movie from Movie movie order by movie.imdbVotes DESC"),
        @NamedQuery(name = "Movie.findAllSortByYear",
                query = "SELECT movie from Movie movie order by movie.year desc")
})
public class Movie {

    public Movie(){
        this.id = UUID.randomUUID().
                toString();
    }

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(unique = true)
    private String title;

    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private int metaScore;
    private double imdbRating;
    private int imdbVotes;
    private String imdbId;
    private String type;
    private int year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getMetaScore() {
        return metaScore;
    }

    public void setMetaScore(int metaScore) {
        this.metaScore = metaScore;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", rated='" + rated + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                ", metaScore=" + metaScore +
                ", imdbRating=" + imdbRating +
                ", imdbVotes=" + imdbVotes +
                ", imdbId='" + imdbId + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                '}';
    }
}


