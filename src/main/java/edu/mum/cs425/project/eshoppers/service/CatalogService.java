package edu.mum.cs425.project.eshoppers.service;

import edu.mum.cs425.project.eshoppers.domain.Catalog;

import java.util.List;

import org.springframework.stereotype.Service;


public interface CatalogService {
    public Catalog findOne(Long id);
    public List<Catalog> findAll();
    public Catalog save(Catalog catalog);
    void delete(Long id);
}
