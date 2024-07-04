package com.mytask.e_commerce.controller;

import com.mytask.e_commerce.dto.OrderDTO;
import com.mytask.e_commerce.dto.UserShoppingCartDTO;
import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.model.User;
import com.mytask.e_commerce.service.OrderService;
import com.mytask.e_commerce.service.ShoppingCartService;
import com.mytask.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id){

        return ResponseEntity.ok(userService.findDTOById(id));
    }

    @GetMapping("/shoppingcart")
    public UserShoppingCartDTO getShoppingCartForUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (shoppingCartService.findByUserId(Integer.parseInt(auth.getName())));
    }

    @PostMapping("/add/{productId}")
    public UserShoppingCartDTO addProductToShoppingCart(@PathVariable long productId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return shoppingCartService.addProductToShoppingCart(Integer.parseInt(auth.getName()),productId);
    }

    @PostMapping("/remove/{productId}")
    public UserShoppingCartDTO removeProductFromShoppingCart(@PathVariable long productId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return shoppingCartService.removeProductFromShoppingCart(Integer.parseInt(auth.getName()),productId);
    }

    @PostMapping("/checkout/{userId}")
    public OrderDTO shoppingCartCheckOut(@PathVariable Long userId){
        return orderService.shoppingCartCheckOut(userId);
    }

    @PostMapping()
    public User saveUser(@RequestBody UserDTO userDTO){
        return (userService.save(userDTO));
    }

    @GetMapping()
    public List<UserDTO> findAll(){
        return userService.findAll();
    }


}
