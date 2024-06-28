package com.mytask.e_commerce.controller;

import com.mytask.e_commerce.dto.ShoppingCartDTO;
import com.mytask.e_commerce.model.ShoppingCart;
import com.mytask.e_commerce.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartByUserId(@PathVariable long id){
        return ResponseEntity.ok(shoppingCartService.findById(id));
    }

    @PostMapping()
    public ShoppingCart saveShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){

        return (shoppingCartService.save(shoppingCartDTO));
    }

    @GetMapping()
    public List<ShoppingCartDTO> findAll(){
        return shoppingCartService.findAll();
    }


}
