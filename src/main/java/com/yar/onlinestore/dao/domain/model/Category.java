package com.yar.onlinestore.dao.domain.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    private long id;

    @Column
    private String name;

    @ManyToOne
    private Category parent;

    @OneToMany
    private Set<Category> childrens = new HashSet<>(0);

    @OneToMany
    private Set<Product> products = new HashSet<>(0);


}
