package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.CatalogWS;

public interface ICatalogService {
    CatalogWS findCatalogByGenre( String genre);
}
