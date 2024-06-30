package com.mytask.e_commerce.controller;

import com.mytask.e_commerce.dto.UserShoppingCartDTO;
import com.mytask.e_commerce.model.ShoppingCart;
import com.mytask.e_commerce.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/{id}")
    public ResponseEntity<UserShoppingCartDTO> getShoppingCartByUserId(@PathVariable long id){
        return ResponseEntity.ok(shoppingCartService.findById(id));
    }

    @PostMapping()
    public ShoppingCart saveShoppingCart(@RequestBody UserShoppingCartDTO userShoppingCartDTO){

        return (shoppingCartService.save(userShoppingCartDTO));
    }

    @GetMapping()
    public List<UserShoppingCartDTO> findAll(){
        return shoppingCartService.findAll();
    }


}
