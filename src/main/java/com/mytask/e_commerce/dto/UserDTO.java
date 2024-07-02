package com.mytask.e_commerce.dto;

import com.mytask.e_commerce.model.Order;
import com.mytask.e_commerce.model.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {
    private long userId;
    private String userName;
    private String userEmail;
    private Role role;
    private String password;
//    private UserShoppingCartDTO userShoppingCartDTO;
//    private List<Order> orderList = new ArrayList<>();


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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public UserShoppingCartDTO getUserShoppingCart() {
//        return userShoppingCartDTO;
//    }
//
//    public void setUserShoppingCart(UserShoppingCartDTO userShoppingCartDTO) {
//        this.userShoppingCartDTO = userShoppingCartDTO;
//    }

//    public List<Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(List<Order> orderList) {
//        this.orderList = orderList;
//    }
}
