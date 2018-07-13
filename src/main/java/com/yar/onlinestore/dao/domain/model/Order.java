package com.yar.onlinestore.dao.domain.model;


import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    private long number;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Instant orderedDate;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Instant shipped;

    @Column
    private String shippTo;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @Column
    private long total;

    @OneToMany
    private Set<LineItem> lineItems = new HashSet<>(0);

    @ManyToOne
    private CustomerAccount customerAccount;


    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Instant getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Instant orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Instant getShipped() {
        return shipped;
    }

    public void setShipped(Instant shipped) {
        this.shipped = shipped;
    }

    public String getShippTo() {
        return shippTo;
    }

    public void setShippTo(String shippTo) {
        this.shippTo = shippTo;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
