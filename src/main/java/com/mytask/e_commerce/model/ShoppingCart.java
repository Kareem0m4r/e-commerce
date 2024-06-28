package com.mytask.e_commerce.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long shoppingCartId;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_cost")
    private long totalCost;

    @ManyToMany
    @JoinTable(
            name = "shopping_list_product",
            joinColumns = @JoinColumn(name = "Shopping_list_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productShoppingCartsList = new ArrayList<>();

    @Column(name = "checked_out")
    private boolean checkedOut = false;

    public ShoppingCart(){

    }
    public ShoppingCart(long totalCost, List<Product> productList) {
        this.totalCost = totalCost;
        this.productShoppingCartsList = productList;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public List<Product> getProductShoppingCartsList() {
        return productShoppingCartsList;
    }

    public void setProductShoppingCartsList(List<Product> productShoppingCartsList) {
        this.productShoppingCartsList = productShoppingCartsList;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
