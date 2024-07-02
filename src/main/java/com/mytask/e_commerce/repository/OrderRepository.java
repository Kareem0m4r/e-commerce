package com.mytask.e_commerce.repository;

import com.mytask.e_commerce.model.Order;
import com.mytask.e_commerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllOrdersByUser_UserId(long userId);

}
