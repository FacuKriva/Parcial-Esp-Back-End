package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.impl.MovieServiceImpl;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping( "/movies" )
public class MovieController {

	private final MovieServiceImpl movieServiceImpl;

	@Autowired
	public MovieController( MovieServiceImpl movieServiceImpl ) {
		this.movieServiceImpl = movieServiceImpl;
	}

	@GetMapping( "/{genre}" )
	public ResponseEntity< List< Movie > > getMovieByGenre( @PathVariable String genre ) {
		List< Movie > movieList = this.movieServiceImpl.getListByGenre( genre );
		return movieList.isEmpty() ? ResponseEntity.notFound().build(): ResponseEntity.ok().body( movieList );
	}

	@PostMapping
	public ResponseEntity<Movie> saveMovie( @RequestBody Movie movie ) {
		return ResponseEntity.ok().body( movieServiceImpl.save( movie ) );
	}
}
