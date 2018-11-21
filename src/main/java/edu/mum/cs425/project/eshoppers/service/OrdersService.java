package edu.mum.cs425.project.eshoppers.service;

import edu.mum.cs425.project.eshoppers.domain.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll();
    Orders save(Orders order);
    Orders findOne(Long id);
    void delete(Long id);
    List<Orders> findOrdersByCustomer_Cid(Long cid);
}