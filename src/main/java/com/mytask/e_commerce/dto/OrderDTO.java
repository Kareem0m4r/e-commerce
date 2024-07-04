package com.mytask.e_commerce.dto;

import com.mytask.e_commerce.model.Product;
import com.mytask.e_commerce.enums.Status;
import com.mytask.e_commerce.model.ProductOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class OrderDTO {

    private long orderId;

    private Status status;

    private long userId;

    private BigDecimal orderTotalAmount;

    private List<ProductOrder> productOrderList = new ArrayList<>();

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

}
