package com.yar.onlinestore.dao.domain.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    private long id;

    @Column
    private String name;

    @Column
    private long price;

    @ManyToOne
    private ProviderAccount providerAccount;

    @ManyToOne
    private Category category;

    @OneToMany
    private Set<LineItem> lineItems = new HashSet<>(0);

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public ProviderAccount getProviderAccount() {
        return providerAccount;
    }

    public void setProviderAccount(ProviderAccount providerAccount) {
        this.providerAccount = providerAccount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
