package com.mytask.e_commerce.repository;

import com.mytask.e_commerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}