package com.dh.catalogservice.domain.model.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class CatalogWS {
	private String genre;
	private List< MovieWS > movies;

	public CatalogWS(){
		// No-args constructor
	}

	public CatalogWS( String genre, List< MovieWS > movies ){
		this.genre = genre;
		this.movies = movies;
	}

	public String getCatalogGenre() { return genre; }

	public void setCatalogGenre( String genre ) { this.genre = genre; }

	public List< MovieWS > getMovies() { return movies; }

	public void setMovies( List< MovieWS > movies ) { this.movies = movies; }

	@Override
	public String toString() {
		return " CatalogWS {"
				+ " genre = " + genre
				+ " , movies = " + movies
				+ " } " ;
	}
}
