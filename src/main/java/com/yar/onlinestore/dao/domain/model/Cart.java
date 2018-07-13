package com.yar.onlinestore.dao.domain.model;


import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    private long id;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Instant createdDate;

    @OneToOne
    private CustomerAccount customerAccount;


    @OneToMany
    private Set<LineItem> lineItems = new HashSet<>();

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
}
