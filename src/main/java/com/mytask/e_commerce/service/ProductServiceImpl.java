package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.ProductDTO;
import com.mytask.e_commerce.mapper.ProductMapper;
import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.repository.ProductRepository;
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
    public ProductDTO findDTOById(long id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .orElse(new ProductDTO());
    }

    @Override
    public Product findEntityById(long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    @Override
    public Product save(ProductDTO productDTO) {
        Product product = productRepository.save(productMapper.toEntity(productDTO));
        return product;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> myProductDTOList = productMapper.toDTOList(productRepository.findAll());
        return myProductDTOList;
    }
}
