package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import edu.mum.cs425.project.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CatalogService catalogService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("product", new Product());
        List<Catalog> catalogList = catalogService.findAll();
        model.addAttribute("catalog", catalogList);
        return "webapps/addProduct";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("product") Product product,
                       BindingResult result,
                       @RequestParam("image_upload") MultipartFile image,
                       @RequestParam("product_category") final Catalog selectedCatalog, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "webapps/addProduct";
        }

        //read uploaded image as bytes and set image attribute of product entity
        if (!image.isEmpty()) {
            try {
                byte[] bytes = image.getBytes();
                product.setProductPic(bytes);
            } catch (Exception e) {
                System.out.println("You failed to upload  => " + e.getMessage());
            }
        }

        product.setCatalog(selectedCatalog);
        System.out.println("********SUCCESSFUL**********");
        System.out.println("*********SUCCESSFUL*********");
        product = productService.save(product);
//        update with correct url
        return "redirect:/";
    }
}
