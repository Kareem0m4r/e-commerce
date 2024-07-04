package com.mytask.e_commerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.model.ProductShoppingCart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class UserShoppingCartDTO {
    private long shoppingCartId;

    private String userId;

    private BigDecimal totalCost;

    private List<ProductShoppingCart> productShoppingCartList;


    private boolean checkedOut = false;

    public UserShoppingCartDTO(){

    }

    public UserShoppingCartDTO(String userId, BigDecimal totalCost, List<ProductShoppingCart> productShoppingCartList, boolean checkedOut) {
        this.userId = userId;
        this.totalCost = totalCost;
        this.productShoppingCartList = productShoppingCartList;
        this.checkedOut = checkedOut;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public List<ProductShoppingCart> getProductShoppingCartList() {
        return productShoppingCartList;
    }

    public void setProductShoppingCartList(List<ProductShoppingCart> productShoppingCartList) {
        this.productShoppingCartList = productShoppingCartList;
    }


}
