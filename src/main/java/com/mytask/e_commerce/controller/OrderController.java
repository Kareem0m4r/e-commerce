package com.mytask.e_commerce.controller;

import com.mytask.e_commerce.dto.OrderDTO;
import com.mytask.e_commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable long id){
        return orderService.findDTOById(id);
    }

    @GetMapping
    public List<OrderDTO> findALl(){
        return orderService.findAll();
    }

    @GetMapping("/history/{userId}")
    public List<OrderDTO> findOrderHistoryByUserId(@PathVariable long userId){
        return orderService.findOrderHistoryByUserId(userId);
    }
}
