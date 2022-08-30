package com.dh.catalogservice.domain.model.dto;

public class MovieWS {
    private Integer id;
    private String name;
    private String genre;
    private String urlStream;

    public MovieWS() {
        // No Args Constructor
    }

    public Integer getMovieId() {
        return id;
    }

    public void setMovieId( Integer id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) { this.name = name; }

    public String getMovieGenre() {
        return genre;
    }

    public void setMovieGenre( String genre ) {
        this.genre = genre;
    }

    public String getUrlStream() {
        return urlStream;
    }

    public void setUrlStream( String urlStream ) {
        this.urlStream = urlStream;
    }

    @Override
    public String toString() {
        return "MovieWS { "
                + "id = " + id
                + ", movieName = " + name + '\''
                + ", genre = " + genre + '\''
                + ", urlStream = " + urlStream + '\''
                + " }";
    }


}