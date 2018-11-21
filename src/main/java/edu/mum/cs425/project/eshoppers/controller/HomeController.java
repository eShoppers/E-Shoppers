package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs425.project.eshoppers.domain.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	CatalogService catalogService;

	@RequestMapping(value = {"/", "/common/masterlayout"}, method = RequestMethod.GET)
	public ModelAndView homepage() {
		List<Catalog> catalog = catalogService.findAll();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cata", catalog);
		modelAndView.setViewName("webapps/index");

		List<String> catalogImages = CatalogController.recreateImages(catalog);


		modelAndView.addObject("catalogImages", catalogImages );
		return modelAndView;
	}


}


