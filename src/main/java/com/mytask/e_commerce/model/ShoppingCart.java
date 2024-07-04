package com.mytask.e_commerce.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private User user;

    @Column(name = "total_cost")
    private BigDecimal totalCost = new BigDecimal(0);


    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductShoppingCart> productShoppingCartList = new ArrayList<>();

    @Column(name = "checked_out")
    private boolean checkedOut = false;

    public void addProduct(Product product){
    for (ProductShoppingCart productShoppingCartItem : productShoppingCartList){
        if (productShoppingCartItem.getProduct().equals(product)){
            if (product.getProductQuantity()>1) {
                productShoppingCartItem.setQuantity(productShoppingCartItem.getQuantity() + 1);
                product.setProductQuantity(product.getProductQuantity()-1);
                this.setTotalCost(this.getTotalCost().add(product.getProductPrice()));
                return;
            }
            else {
                throw new RuntimeException("product is not available anymore");
            }
        }
    }
        if (product.getProductQuantity()>1) {

            ProductShoppingCart productShoppingCartItem = new ProductShoppingCart();
            productShoppingCartItem.setShoppingCart(this);
            productShoppingCartItem.setProduct(product);
            productShoppingCartItem.setQuantity(1);
            product.setProductQuantity(product.getProductQuantity()-1);
            this.setTotalCost(this.getTotalCost().add(product.getProductPrice()));
            productShoppingCartList.add(productShoppingCartItem);
        }
        else {
            throw new RuntimeException("product is not available anymore");
        }
    }

//    public List<Product> refreshShoppingCart (ShoppingCart shoppingCart){
//        List<Product> productList = new ArrayList<>();
//        if (this.getProductShoppingCartList() != null){
//            for (ProductShoppingCart item : this.getProductShoppingCartList()){
//                productList.add((item.getProduct()));
//            }
//        }
//        return productList;
//    }

    public void removeProduct(Product product){
        for (ProductShoppingCart productShoppingCart : productShoppingCartList){
            if (productShoppingCart.getProduct().equals(product)){
                if (productShoppingCart.getQuantity()>1){
                    productShoppingCart.setQuantity(productShoppingCart.getQuantity()-1);
                }
                else {
                    productShoppingCartList.remove(productShoppingCart);
                }
                this.setTotalCost(this.getTotalCost().subtract(product.getProductPrice()));
                product.setProductQuantity(product.getProductQuantity()+1);
                return;
            }
        }
        throw new RuntimeException("product not found in cart");
    }

    public ShoppingCart(){

    }

    public ShoppingCart(User user, BigDecimal totalCost, List<ProductShoppingCart> productShoppingCartList, boolean checkedOut) {
        this.user = user;
        this.totalCost = totalCost;
        this.productShoppingCartList = productShoppingCartList;
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

    public List<ProductShoppingCart> getProductShoppingCartList() {
        return productShoppingCartList;
    }

    public void setProductShoppingCartList(List<ProductShoppingCart> productShoppingCartList) {
        this.productShoppingCartList = productShoppingCartList;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
