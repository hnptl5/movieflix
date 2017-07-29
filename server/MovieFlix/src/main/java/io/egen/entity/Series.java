package io.egen.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Series.findAll",
                query = "SELECT series from Series series ORDER BY series.title ASC "),
        @NamedQuery(name = "Series.findUsingTitle",
                query = "SELECT series from Series series where series.title=:paramTitle order by series.title desc "),
        @NamedQuery(name = "Series.findByTypeSortByImdbRating",
                query = "SELECT series from Series series where series.type=:paramType order by series.imdbRating desc"),
        @NamedQuery(name = "Series.findByTypeSortByImdbVotes",
                query = "SELECT series from Series series where series.type=:paramType order by series.imdbVotes desc"),
        @NamedQuery(name = "Series.findByTypeSortByYear",
                query = "SELECT series from Series series where series.type=:paramType order by series.year desc"),
        @NamedQuery(name = "Series.findByType",
                query = "SELECT series from Series series where series.type=:paramType order by series.title ASC "),
        @NamedQuery(name = "Series.findByYearSortByimdbRating",
                query = "SELECT series from Series series where series.year=:paramYear order by series.imdbRating desc "),
        @NamedQuery(name = "Series.findByYearSortByimdbVotes",
                query = "SELECT series from Series series where series.year=:paramYear order by series.imdbVotes desc"),
        @NamedQuery(name = "Series.findByYearSortByYear",
                query = "SELECT series from Series series where series.year=:paramYear order by series.year desc "),
        @NamedQuery(name = "Series.findByYear",
                query = "SELECT series from Series series where series.year=:paramYear order by series.title ASC "),
        @NamedQuery(name = "Series.findByGenreSortByimdbRating",
                query = "SELECT series from Series series where series.genre=:paramGenre order by series.imdbRating desc "),
        @NamedQuery(name = "Series.findByGenreSortByimdbVotes",
                query = "SELECT series from Series series where series.genre=:paramGenre order by series.imdbVotes desc "),
        @NamedQuery(name = "Series.findByGenreSortByYear",
                query = "SELECT series from Series series where series.genre=:paramGenre order by series.year desc"),
        @NamedQuery(name = "Series.findByGenre",
                query = "SELECT series from Series series where series.genre=:paramGenre order by series.title asc "),
        @NamedQuery(name = "Series.findAllSortByimdbRating",
                query = "SELECT series from Series series order by series.imdbRating DESC "),
        @NamedQuery(name = "Series.findAllSortByimdbVotes",
                query = "SELECT series from Series series order by series.imdbVotes DESC"),
        @NamedQuery(name = "Series.findAllSortByYear",
                query = "SELECT series from Series series order by series.year desc")
})
public class Series {

    public Series(){
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
        return "Series{" +
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

