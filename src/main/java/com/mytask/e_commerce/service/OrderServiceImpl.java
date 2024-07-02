package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.OrderDTO;
import com.mytask.e_commerce.mapper.OrderMapper;
import com.mytask.e_commerce.model.Order;
import com.mytask.e_commerce.model.ShoppingCart;
import com.mytask.e_commerce.model.Status;
import com.mytask.e_commerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserService userService;
    @Autowired
    ShoppingCartService shoppingCartService;

    @Override
    public OrderDTO findDTOById(long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDTO)
                .orElse(new OrderDTO());
    }

    @Override
    public Order findEntityById(long id) {
        return orderRepository.findById(id).orElse(new Order());
    }

    @Override
    public Order save(OrderDTO orderDTO) {
        return orderRepository.save(orderMapper.toEntity(orderDTO));
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderMapper.toDTOList(orderRepository.findAll());
    }

    @Override
    public List<OrderDTO> findOrderHistoryByUserId(long userId) {
        return orderMapper.toDTOList(orderRepository.findAllOrdersByUser_UserId(userId));
    }

    @Override
    public OrderDTO shoppingCartCheckOut(Long userId) {
       ShoppingCart shoppingCart = userService.findEntityById(userId).getUserShoppingCart();
        Order order = new Order();
        if (!shoppingCart.getProducts().isEmpty()) {
           shoppingCart.setCheckedOut(true);
           order.setOrderTotalAmount(shoppingCart.getTotalCost());
           order.setProductOrderList(new ArrayList<>(shoppingCart.getProducts()));
           order.setUser(shoppingCart.getUser());
           order.setStatus(Status.Pending);
           orderRepository.save(order);
           shoppingCartService.clearShoppingCart(shoppingCart);
       }else {

            throw new RuntimeException("shopping cart is empty");
        }


        return orderMapper.toDTO(order);
    }
}
