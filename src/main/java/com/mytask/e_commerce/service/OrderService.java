package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.OrderDTO;
import com.mytask.e_commerce.dto.ProductDTO;
import com.mytask.e_commerce.model.Order;
import com.mytask.e_commerce.model.Product;

import java.util.List;

public interface OrderService {
    OrderDTO findDTOById(long id);

    Order findEntityById(long id);

    Order save(OrderDTO orderDTO);

    List<OrderDTO> findAll();

    List<OrderDTO> findOrderHistoryByUserId(long userId);

    OrderDTO shoppingCartCheckOut(Long userId);
}
