package edu.mum.cs425.project.eshoppers.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.service.CatalogService;

@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogService;

	@RequestMapping(value = "/addcatalog")
	public List<Catalog> catalog(@Valid @ModelAttribute("catalog") Catalog catalog,BindingResult result,Model model) {
		if(result.hasErrors())
			
			return null;
		return catalogService.findAll();

	}
	
	@GetMapping(value="/catalog")
	public String cataloglist() {
		
		return "webapps/Catalog";
	}
}
