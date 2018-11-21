package edu.mum.cs425.project.eshoppers.serviceImpl;

import edu.mum.cs425.project.eshoppers.domain.Orders;
import edu.mum.cs425.project.eshoppers.repository.OrdersRepository;
import edu.mum.cs425.project.eshoppers.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImplementation implements OrdersService {

    @Autowired
    OrdersRepository orderRepository;

    @Override
    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Orders save(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public Orders findOne(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Orders> findOrdersByCustomer_Cid(Long cid) {
        return orderRepository.findOrdersByCustomer_Cid(cid);
    }
}