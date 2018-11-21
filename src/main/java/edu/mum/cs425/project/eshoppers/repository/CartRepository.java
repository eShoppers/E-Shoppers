package edu.mum.cs425.project.eshoppers.repository;

import edu.mum.cs425.project.eshoppers.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findCartByCustomer_Cid(Long cid);
}
