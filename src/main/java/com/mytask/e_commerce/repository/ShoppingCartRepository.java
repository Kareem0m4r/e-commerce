package com.mytask.e_commerce.repository;

import com.mytask.e_commerce.dto.UserShoppingCartDTO;
import com.mytask.e_commerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    ShoppingCart findShoppingCartsByUser_UserId(long userId);
}
