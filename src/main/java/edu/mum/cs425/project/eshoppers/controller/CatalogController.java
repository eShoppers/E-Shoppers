package edu.mum.cs425.project.eshoppers.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogService;
	
	//@GetMapping(value="/Catalog")
	@RequestMapping(value="/catalog", method = RequestMethod.GET)
	public ModelAndView cataloglist() {
		List<Catalog> catalog = catalogService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("catalogs", catalog);
		modelAndView.setViewName("webapps/catalog");

		List<String> catalogImages = CatalogController.recreateImages(catalog);
		modelAndView.addObject("catalogImages", catalogImages );

		return modelAndView;

	}

	static List<String> recreateImages(List<Catalog> catalogs){
		List<String> catalogImages = new ArrayList<>();
		try{
			for(Catalog c: catalogs){
				byte[] encodeBase64 = Base64.encode(c.getCatalogPic()).getBytes();
				String base64Encoded = new String(encodeBase64, "UTF-8");
				catalogImages.add(base64Encoded);
			}

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

		return catalogImages;
	}

	@RequestMapping(value = "/addcatalog", method = RequestMethod.GET)
	public String create(Model model){
		model.addAttribute("catalog", new Catalog());
		return "webapps/addCatalog";
	}

	@RequestMapping(value = "/addcatalog", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("catalog") Catalog catalog,
					   BindingResult result, @RequestParam("image_upload") MultipartFile image, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			System.out.println("error occured");
			System.out.println(result.toString());
			return "webapps/addCatalog";
		}
		if (!image.isEmpty()) {
			try {
				byte[] bytes = image.getBytes();
				catalog.setCatalogPic(bytes);
			} catch (Exception e) {
				System.out.println("You failed to upload  => " + e.getMessage());
			}
		}

			catalog = catalogService.save(catalog);
			System.out.println("successfull" + catalog);
			System.out.println("successfull" + catalog);
//        update with correct url
			return "redirect:/";
	}

	@RequestMapping(value="/catalog/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){
		System.out.println("catalog id " + id);
		Catalog cat = catalogService.findOne(id);
		System.out.println(cat);
		model.addAttribute("catalog", cat);
		return "webapps/addCatalog";
	}

	@RequestMapping(value="/catalog/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){
		catalogService.delete(id);
		return "redirect:/catalog";
	}
}
