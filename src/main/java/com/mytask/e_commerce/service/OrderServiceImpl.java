package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.OrderDTO;
import com.mytask.e_commerce.mapper.OrderMapper;
import com.mytask.e_commerce.model.Order;
import com.mytask.e_commerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderMapper orderMapper;

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
}
