package com.mytask.e_commerce.service;

import com.mytask.e_commerce.dto.UserShoppingCartDTO;
import com.mytask.e_commerce.mapper.ProductMapper;
import com.mytask.e_commerce.mapper.ShoppingCartMapper;
import com.mytask.e_commerce.mapper.UserMapper;
import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.model.Role;
import com.mytask.e_commerce.model.ShoppingCart;
import com.mytask.e_commerce.model.User;
import com.mytask.e_commerce.repository.ShoppingCartRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EntityManager entityManager;

    @Override
    public UserShoppingCartDTO findById(long id) {
        return shoppingCartRepository.findById(id)
                .map(shoppingCartMapper::toDTO)
                .orElse(new UserShoppingCartDTO());
    }

    @Override
    public ShoppingCart save(UserShoppingCartDTO userShoppingCartDTO) {
        ShoppingCart shoppingCart = shoppingCartRepository.save(shoppingCartMapper.toEntity(userShoppingCartDTO));
        return shoppingCart;
    }

    @Override
    public List<UserShoppingCartDTO> findAll() {
        List<UserShoppingCartDTO> myUserDTOList = shoppingCartMapper.toDTOList(shoppingCartRepository.findAll());
        return myUserDTOList;
    }

    @Transactional
    @Override
    public UserShoppingCartDTO addProductToShoppingCart(long userId, long productId) {
        User user = userService.findEntityById(userId);
        if (user.getRole().equals(Role.ADMIN)){
            throw new RuntimeException("this is for usertype customer only");
        }
        Product product = productService.findEntityById(productId);
        ShoppingCart shoppingCart = user.getUserShoppingCart();
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUser(user);
            shoppingCart.setTotalCost(BigDecimal.ZERO);
            shoppingCart.setProducts(new ArrayList<>());
        } else {
            if (shoppingCart.getProducts() == null) {
                shoppingCart.setProducts(new ArrayList<>());
            }
        }
        if (product.getProductQuantity()>0) {
            shoppingCart.getProducts().add(product);
            shoppingCart.setTotalCost(shoppingCart.getTotalCost().add(product.getProductPrice()));
            product.setProductQuantity((product.getProductQuantity() - 1));
            shoppingCart = shoppingCartRepository.save(shoppingCart);
        }
        else {
            throw new RuntimeException("product is out of stock");
        }
        return shoppingCartMapper.toDTO(shoppingCart);
    }

    @Override
    public UserShoppingCartDTO removeProductFromShoppingCart(long userId, long productId) {
        User user = userService.findEntityById(userId);
        Product product = productService.findEntityById(productId);
        ShoppingCart shoppingCart = user.getUserShoppingCart();
        if (shoppingCart != null){
            if (shoppingCart.getProducts().contains(product)){
                shoppingCart.getProducts().remove(product);
                shoppingCart.setTotalCost(shoppingCart.getTotalCost().subtract(product.getProductPrice()));
                product.setProductQuantity(product.getProductQuantity() + 1);
                shoppingCart = shoppingCartRepository.save(shoppingCart);
            }else {
                throw  new RuntimeException("product not found in cart");
            }
        }else {
            throw new RuntimeException("user has no shopping cart");
        }

        return shoppingCartMapper.toDTO(shoppingCart);
    }

    @Override
    public UserShoppingCartDTO findByUserId(long userId) {
        return shoppingCartMapper.toDTO(shoppingCartRepository.findShoppingCartsByUser_UserId(userId));
    }
}
