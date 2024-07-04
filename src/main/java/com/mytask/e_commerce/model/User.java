package com.mytask.e_commerce.model;

import com.mytask.e_commerce.enums.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long userId;

    @Column(name = "name")
    private String userName;
    @Column(name = "email")
    private String userEmail;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active = true;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ShoppingCart userShoppingCart;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();

    public User(){

    }

    public User(String userName, String userEmail, String role, String password,boolean active) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.role = role;
        this.password = password;
        this.active = active;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingCart getUserShoppingCart() {
        return userShoppingCart;
    }

    public void setUserShoppingCart(ShoppingCart userShoppingCart) {
        this.userShoppingCart = userShoppingCart;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
