package edu.mum.cs425.project.eshoppers.repository;

import edu.mum.cs425.project.eshoppers.domain.Cart;
import edu.mum.cs425.project.eshoppers.domain.Customer;
import edu.mum.cs425.project.eshoppers.domain.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
                Cart findCartById(Long id);
      List<Cart> findCartByCustomer_Cid(long id);

}
