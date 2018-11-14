package edu.mum.cs425.project.eshoppers.service;

import edu.mum.cs425.project.eshoppers.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
    Product findOne(Long id);
    void delete(Long id);
}
