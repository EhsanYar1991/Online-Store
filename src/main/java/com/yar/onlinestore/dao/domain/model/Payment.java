package com.yar.onlinestore.dao.domain.model;


import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    private long id;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Instant paid;

    @Column
    private long amount;

    @Column
    private String detail;

    @ManyToOne
    private CustomerAccount customerAccount;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getPaid() {
        return paid;
    }

    public void setPaid(Instant paid) {
        this.paid = paid;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
}
