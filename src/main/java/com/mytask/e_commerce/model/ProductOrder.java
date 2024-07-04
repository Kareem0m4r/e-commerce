package com.mytask.e_commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "order_product")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long productOrderId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public ProductOrder(){

    }

    public ProductOrder(com.mytask.e_commerce.model.Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public long getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(long productOrderId) {
        this.productOrderId = productOrderId;
    }

    public com.mytask.e_commerce.model.Order getOrder() {
        return order;
    }

    public void setOrder(com.mytask.e_commerce.model.Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
