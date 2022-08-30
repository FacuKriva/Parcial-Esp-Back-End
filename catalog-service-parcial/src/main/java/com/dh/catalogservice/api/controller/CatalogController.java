package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.ICatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping( "/catalogs" )
public class CatalogController {
	private final ICatalogService catalogService;

	@Autowired
	public CatalogController( ICatalogService catalogService ) {
		this.catalogService = catalogService;
	}

	@GetMapping( "/{genre}" )
	ResponseEntity< CatalogWS > getCatalogByGenre( @PathVariable String genre, HttpServletResponse response ) {
		CatalogWS catalog = this.catalogService.findCatalogByGenre( genre );
		return catalog == null
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok( catalog );
	}
}
