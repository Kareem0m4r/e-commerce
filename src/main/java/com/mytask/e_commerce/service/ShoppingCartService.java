package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.UserShoppingCartDTO;
import com.mytask.e_commerce.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    UserShoppingCartDTO findById(long id);

    ShoppingCart save(UserShoppingCartDTO userShoppingCartDTO);

    List<UserShoppingCartDTO> findAll();

    UserShoppingCartDTO addProductToShoppingCart(long userId, long productId);

    UserShoppingCartDTO removeProductFromShoppingCart(long userId, long productId);

    UserShoppingCartDTO findByUserId(long userId);

    ShoppingCart clearShoppingCart(ShoppingCart shoppingCart);

}
