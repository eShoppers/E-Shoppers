package edu.mum.cs425.project.eshoppers.service;

import edu.mum.cs425.project.eshoppers.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order save(Order order);
    Order findOne(Long id);
    void delete(Long id);
}
