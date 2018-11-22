package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import edu.mum.cs425.project.eshoppers.service.ProductService;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CatalogService catalogService;

//    @RequestMapping(value="/products", method = RequestMethod.GET)
//    public ModelAndView productList() {
//        List<Product> products = productService.findProductByCatalog()
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("products", products);
//        modelAndView.setViewName("webapps/products");
//        return modelAndView;
//
//    }

    @RequestMapping(value="/products/{catalogName}", method = RequestMethod.GET)
    public ModelAndView productList(@PathVariable String catalogName) {
        List<Product> products = productService.findProductByCatalog(catalogService.findCatalogByCatalogName(catalogName));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("webapps/products");

        List<String> productImages = recreateImages(products);
        modelAndView.addObject("productImages", productImages );

        return modelAndView;
    }

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public ModelAndView productListForCustomer() {
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("webapps/products");

        List<String> productImages = recreateImages(products);
        modelAndView.addObject("productImages", productImages );

        return modelAndView;
    }

    @RequestMapping(value="/edit/products", method = RequestMethod.GET)
    public ModelAndView productListForAdmin() {
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("webapps/editproducts");

        List<String> productImages = recreateImages(products);
        modelAndView.addObject("productImages", productImages );

        return modelAndView;
    }

    public static List<String> recreateImages(List<Product> products){
        List<String> productImages = new ArrayList<>();

        try{
            for(Product p: products){
                byte[] encodeBase64 = Base64.encode(p.getProductPic()).getBytes();
                String base64Encoded = new String(encodeBase64, "UTF-8");
                productImages.add(base64Encoded);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return productImages;
    }

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

    @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findOne(id));
        return "webapps/addProduct";
    }

    @RequestMapping(value="/product/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model){
        productService.delete(id);
        return "redirect:/products";
    }

}
