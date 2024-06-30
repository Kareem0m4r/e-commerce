package com.mytask.e_commerce.dto;

import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.model.Status;
import com.mytask.e_commerce.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class OrderDTO {

    private long orderId;

    private Status status;

    private User user;

    private BigDecimal orderTotalAmount;

    private List<Product> productOrderList = new ArrayList<>();

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public List<Product> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<Product> productOrderList) {
        this.productOrderList = productOrderList;
    }

}
