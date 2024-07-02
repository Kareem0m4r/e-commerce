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

    @GetMapping("/{userId}/shoppingCart")
    public ResponseEntity<UserShoppingCartDTO> getShoppingCartForUser(@PathVariable long userId){

        return ResponseEntity.ok(shoppingCartService.findByUserId(userId));
    }

    @PostMapping("/add/{userId}/{productId}")
    public UserShoppingCartDTO addProductToShoppingCart(@PathVariable long userId, @PathVariable long productId){

        return shoppingCartService.addProductToShoppingCart(userId,productId);
    }

    @PostMapping("/remove/{userId}/{productId}")
    public UserShoppingCartDTO removeProductFromShoppingCart(@PathVariable long userId, @PathVariable long productId){

        return shoppingCartService.removeProductFromShoppingCart(userId,productId);
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
