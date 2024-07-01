package com.mytask.e_commerce.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private BigDecimal totalCost;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    @Column(name = "checked_out")
    private boolean checkedOut = false;

    public ShoppingCart(){

    }

    public ShoppingCart(User user, BigDecimal totalCost, List<Product> products, boolean checkedOut) {
        this.user = user;
        this.totalCost = totalCost;
        this.products = products;
        this.checkedOut = checkedOut;
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

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
