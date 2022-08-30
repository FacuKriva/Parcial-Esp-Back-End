package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.ICatalogService;
import com.dh.catalogservice.api.service.MovieFeignClient;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class CatalogServiceImpl implements ICatalogService {

	public static Logger logger = LoggerFactory.getLogger( ICatalogService.class );

	private final MovieFeignClient movieFeignClient;

	@Autowired
	public CatalogServiceImpl( MovieFeignClient movieFeignClient ) {
		this.movieFeignClient = movieFeignClient;
	}

	public CatalogWS findCatalogByGenre ( String genre ) {
		ResponseEntity< List< MovieWS > > movieResponse = this.movieFeignClient.findMovieByGenre( genre );
		logger.info( "Puerto de la instancia Movie-Service: " + movieResponse.getHeaders().get( "port" ) );
		if (movieResponse.getStatusCode().is2xxSuccessful() && !Objects.isNull( movieResponse.getBody() ) ) {
			CatalogWS catalog = new CatalogWS();
			catalog.setCatalogGenre( genre );
			catalog.setMovies( movieResponse.getBody() );
			return catalog;
		}
		return null;
	}
}
