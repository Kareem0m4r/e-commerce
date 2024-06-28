package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.ShoppingCartDTO;
import com.mytask.e_commerce.dto.UserDTO;
import com.mytask.e_commerce.mapper.ProductMapper;
import com.mytask.e_commerce.mapper.ShoppingCartMapper;
import com.mytask.e_commerce.model.ShoppingCart;
import com.mytask.e_commerce.model.User;
import com.mytask.e_commerce.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public ShoppingCartDTO findById(long id) {
        return shoppingCartRepository.findById(id)
                .map(shoppingCartMapper::toDTO)
                .orElse(new ShoppingCartDTO());
    }

    @Override
    public ShoppingCart save(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = shoppingCartRepository.save(shoppingCartMapper.toEntity(shoppingCartDTO));
        return shoppingCart;
    }

    @Override
    public List<ShoppingCartDTO> findAll() {
        List<ShoppingCartDTO> myUserDTOList = shoppingCartMapper.toDTOList(shoppingCartRepository.findAll());
        return myUserDTOList;
    }

    @Override
    public ShoppingCartDTO addProductToShoppingCart(long userId, long productId) {
        ShoppingCart shoppingCart =  shoppingCartMapper.toEntity(userService.findById(userId).getUserShoppingCart());
        shoppingCart.getProductShoppingCartsList().add(productMapper.toEntity(productService.findById(productId)));
        return shoppingCartMapper.toDTO(shoppingCartRepository.save(shoppingCart));
    }
}
