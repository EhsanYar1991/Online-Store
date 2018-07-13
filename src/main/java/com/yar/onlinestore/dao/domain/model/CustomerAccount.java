package com.yar.onlinestore.dao.domain.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount extends Account {


    @Column(name = "COMPLEX_NAME")
    private String complexName;

    @OneToOne
    private Cart cart;

    @OneToMany
    private Set<Order> orders = new HashSet<>(0);

    @OneToMany
    private Set<Payment> payments = new HashSet<>(0);


    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }


    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "complexName='" + complexName + '\'' +
                '}';
    }
}
