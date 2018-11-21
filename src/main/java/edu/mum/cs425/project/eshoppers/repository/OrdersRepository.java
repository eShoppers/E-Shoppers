package edu.mum.cs425.project.eshoppers.repository;

import edu.mum.cs425.project.eshoppers.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findOrdersByCustomer_Cid(Long cid);
}
