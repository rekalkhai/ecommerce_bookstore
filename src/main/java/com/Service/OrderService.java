package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Order;
import com.Interface.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public void addOrder(Order order){
        repository.save(order);
    }

    public List<Order> findByCustomerID(Integer customerID){
        return repository.findByCustomerID(customerID);
    }

    public List<Order> findByProductID(Integer productID){
        return repository.findByProductID(productID);
    }

    public void deleteOrderById(Integer oid) {
        repository.deleteById(oid);
    }

    public  void deleteOrderByProductID(List<Order> orders) {
        repository.deleteAll(orders);
    }
}