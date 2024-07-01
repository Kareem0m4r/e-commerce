package com.mytask.e_commerce.controller;

import com.mytask.e_commerce.dto.ProductDTO;
import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable long id){
        return productService.findDTOById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductDTO productDTO){
        productDTO.setProductId(0);
        return productService.save(productDTO);
    }

    @GetMapping
    public List<ProductDTO> findALl(){
        return productService.findAll();
    }
}
