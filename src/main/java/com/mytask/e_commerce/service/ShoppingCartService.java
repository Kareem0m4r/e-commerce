package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.ShoppingCartDTO;
import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.model.ShoppingCart;
import com.mytask.e_commerce.model.User;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCartDTO findById(long id);

    ShoppingCart save(ShoppingCartDTO shoppingCartDTO);

    List<ShoppingCartDTO> findAll();

    ShoppingCartDTO addProductToShoppingCart(long userId,long productId);



}
