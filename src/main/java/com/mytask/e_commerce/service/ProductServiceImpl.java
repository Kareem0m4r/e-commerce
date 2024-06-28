package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.ProductDTO;
import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.mapper.ProductMapper;
import com.mytask.e_commerce.mapper.ShoppingCartMapper;
import com.mytask.e_commerce.mapper.UserMapper;
import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.model.User;
import com.mytask.e_commerce.repository.ProductRepository;
import com.mytask.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductDTO findById(long id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .orElse(new ProductDTO());
    }

    @Override
    public Product save(ProductDTO productDTO) {
        Product product = productRepository.save(productMapper.toEntity(productDTO));
        return product;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> myUserDTOList = productMapper.toDTOList(productRepository.findAll());
        return myUserDTOList;
    }
}
