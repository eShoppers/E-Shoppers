package edu.mum.cs425.project.eshoppers.service;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.domain.Product;

import java.util.List;

public interface CatalogService {
    public Catalog findOne(Long id);
    public List<Product> findAll();
}
