package com.mytask.e_commerce.dto;

import com.mytask.e_commerce.model.Order;
import com.mytask.e_commerce.model.ShoppingCart;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private long productId;

    private String productName;

    private String productDescription;

    private int productQuantity;

    private long productPrice;

//  private long shoppingCartId;
//
//  private List<Order> orderList = new ArrayList<>();


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

//    public long getShoppingCartId() {
//        return shoppingCartId;
//    }

//    public void setShoppingCartId(long shoppingCartId) {
//        this.shoppingCartId = shoppingCartId;
//    }

//
//    public List<Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(List<Order> orderList) {
//        this.orderList = orderList;
//    }
}
