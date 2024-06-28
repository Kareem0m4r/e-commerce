package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.ProductDTO;
import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.model.User;

import java.util.List;

public interface ProductService {
    ProductDTO findById(long id);

    Product save(ProductDTO productDTO);

    List<ProductDTO> findAll();

}
