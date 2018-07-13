package com.yar.onlinestore.dao.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROVIDER_ACCOUNT")
public class ProviderAccount extends Account {


    @Column(name = "PROVIDER_NAME")
    private String providerName;

    @OneToMany
    private Set<Product> products = new HashSet<>(0);

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }


    @Override
    public String toString() {
        return "ProviderAccount{" +
                "providerName='" + providerName + '\'' +
                '}';
    }
}
