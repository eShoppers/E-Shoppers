package edu.mum.cs425.project.eshoppers.service;

import org.springframework.stereotype.Service;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.domain.Cart;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface CartService {
    public List<Cart> findAll();
    public Cart save(Cart cart);
    public void delete(Long id);
    List<Cart> findCartByCustomer_Cid(Long cid);

}
