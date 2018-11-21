package edu.mum.cs425.project.eshoppers.service;

import edu.mum.cs425.project.eshoppers.domain.Customer;
import org.springframework.stereotype.Service;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.domain.Cart;


import java.util.List;
import java.util.Optional;


public interface CartService {
     Cart save(Cart cart);
    void delete(Long id);
    List<Cart> findAll();
    List<Cart> findCartByCustomer_Cid(long id);
   Cart findCartById(Long id);
}
