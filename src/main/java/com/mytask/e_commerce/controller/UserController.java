package com.mytask.e_commerce.controller;

import com.mytask.e_commerce.dto.ProductDTO;
import com.mytask.e_commerce.dto.ShoppingCartDTO;
import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.mapper.ProductMapper;
import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.model.User;
import com.mytask.e_commerce.service.ProductService;
import com.mytask.e_commerce.service.ShoppingCartService;
import com.mytask.e_commerce.service.UserService;
import org.mapstruct.control.MappingControl;
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
    private ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserbyId(@PathVariable long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/{userId}/shoppingCart")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartForUser(@PathVariable long userId){
        return ResponseEntity.ok(userService.findById(userId).getUserShoppingCart());
    }

    @PostMapping("/{userId}/{productId}")
    public ShoppingCartDTO addProductToShoppingCart(@PathVariable long userId, @PathVariable long productId){

        return shoppingCartService.addProductToShoppingCart(userId,productId);
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
