package edu.mum.cs425.project.eshoppers.serviceImpl;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.repository.CatalogRepository;
import edu.mum.cs425.project.eshoppers.service.CatalogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	CatalogRepository catalogRepository;
	
    @Override
    public Catalog findOne(Long id) {
        return null;
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void delete(Long id) {
        catalogRepository.deleteById(id);
    }
}
