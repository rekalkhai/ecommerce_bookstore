package com.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT * FROM orders WHERE customerID = ?1",nativeQuery = true)
    List<Order> findByCustomerID(Integer customerID);

    @Query(value = "SELECT * FROM orders WHERE productID = ?1",nativeQuery = true)
    List<Order> findByProductID(Integer productID);

}