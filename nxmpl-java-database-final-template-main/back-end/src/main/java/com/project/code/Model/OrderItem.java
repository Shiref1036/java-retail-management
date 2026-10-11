package com.project.code.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class OrderItem { //child entities for order details


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference //OrderDetails... is the parent entity
    private OrderDetails order;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;


    private Integer quantity ;


    private Double price ;

    public OrderItem(){}
    public OrderItem(OrderDetails orderDetails , Product product , Integer quantity){
        this.product = product ;
        this.order = orderDetails ;
        this.quantity =quantity ;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public OrderDetails getOrder() {
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(OrderDetails order) {
        this.order = order;
    }
}

