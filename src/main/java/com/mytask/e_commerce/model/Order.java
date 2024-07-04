package com.mytask.e_commerce.model;

import com.mytask.e_commerce.enums.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long orderId;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_total_amount")
    private BigDecimal orderTotalAmount;

    @ManyToMany
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productOrderList = new ArrayList<>();

    public Order(){

    }

    public Order(Status status, User user, BigDecimal orderTotalAmount, List<Product> productOrderList) {
        this.status = status;
        this.user = user;
        this.orderTotalAmount = orderTotalAmount;
        this.productOrderList = productOrderList;
    }

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
