package com.dh.movieservice.domain.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String genre;
	private String urlStream;

	public Movie(){
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getGenre() { return genre; }

	public void setGenre(String genre) { this.genre = genre; }

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
