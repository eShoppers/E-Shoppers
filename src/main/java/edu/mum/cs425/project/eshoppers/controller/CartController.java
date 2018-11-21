package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Cart;
import edu.mum.cs425.project.eshoppers.domain.Customer;
import edu.mum.cs425.project.eshoppers.domain.Orders;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.service.CartService;
import edu.mum.cs425.project.eshoppers.service.CustomerService;
import edu.mum.cs425.project.eshoppers.service.OrdersService;
import edu.mum.cs425.project.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class CartController {

	@Autowired
	OrdersService ordersService;

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/shoppingCart")
	public String contactUs() {
		return "webapps/shoppingCart";
	}

	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public ModelAndView showCart(){

		//for test only
		addProductAndCustomerToCart();

		List<Cart> cartContent = cartService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cart", cartContent);
		modelAndView.setViewName("webapps/cart");

		return modelAndView;
	}

	//creates dummy cart
	private void addProductAndCustomerToCart(){
		Customer c = customerService.findOne(1L);
		Product p = productService.findOne(3L);
		Product p1 = productService.findOne(17L);

		Cart c1 = new Cart(c, 2, p);
		cartService.save(c1);

		Cart c2 = new Cart(c, 1, p1);
		cartService.save(c2);
	}

	@RequestMapping(value = "/place/order/{cid}", method = RequestMethod.GET)
	public String placeOrder(@PathVariable Long cid) {

		List<Cart> carts = cartService.findCartByCustomer_Cid(cid);

		for(Cart item: carts){
			Date d= new Date();
			Orders order = new Orders();

			order.setCustomer(item.getCustomer());
			order.setProduct(item.getProduct());
			order.setQuantity(item.getQuantity());
			order.setPrice(item.getProduct().getUnitPrice() * item.getQuantity());
			order.setOrderDate(LocalDate.now());
			order.setOrderId(cid.toString() +  d.getTime());
			ordersService.save(order);

			Product purchasedProduct = productService.findOne(item.getProduct().getId());
			Long stockQuantity = purchasedProduct.getQuantity();
			purchasedProduct.setQuantity(stockQuantity - item.getQuantity());
			productService.save(purchasedProduct);

		}

		System.out.println("Order placed successfully");

		String email = customerService.findOne(cid).getEmail();
		EmailController.sendEmail(email);

		//delete order from cart
		deleteOrderFromCart(carts);

//        update with correct url
		return "redirect:/";
	}

	private void deleteOrderFromCart(List<Cart> carts){
		for (Cart c: carts){
			cartService.delete(c.getId());
		}
	}

}
