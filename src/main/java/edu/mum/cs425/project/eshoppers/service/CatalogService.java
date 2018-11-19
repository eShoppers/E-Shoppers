package edu.mum.cs425.project.eshoppers.service;

import edu.mum.cs425.project.eshoppers.domain.Catalog;

import java.util.List;

import org.springframework.stereotype.Service;


public interface CatalogService {
     Catalog findOne(Long id);
     List<Catalog> findAll();
     Catalog save(Catalog catalog);
    void delete(Long id);
     Catalog findCatalogByCatalogName(String name);
}
