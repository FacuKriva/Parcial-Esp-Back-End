package com.dh.movieservice.domain.model;

import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "movies" )
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column( name = "movie_name" )
	private String name;

	@Column ( name = "genre" )
	private String genre;

	@Column ( name = "urlStream" )
	private String urlStream;

	public Movie(){
		// No-args constructor
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getMovieName() { return name; }

	public void setMovieName(String name) { this.name = name; }

	public String getMovieGenre() { return genre; }

	public void setMovieGenre(String genre) { this.genre = genre; }

	public String getUrlStream() { return urlStream; }

	public void setUrlStream(String urlStream) { this.urlStream = urlStream; }

	@Override
	public String toString() {
		return " Movie { "
				+ " id = " + id
				+ " , name = " + name + '\''
				+ " , genre = " + genre + '\''
				+ " , urlStream = " + urlStream + '\''
				+ " } " ;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Movie movie = (Movie) o;
		return id != null && Objects.equals(id, movie.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
