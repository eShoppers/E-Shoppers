package edu.mum.cs425.project.eshoppers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs425.project.eshoppers.service.CatalogService;

@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogService;

	@RequestMapping(value = "/catalog")
	public String catalog() {

		return null;

	}
}
