package com.yar.onlinestore.dao.domain.model;


import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT_ADDRESS")
public class AccountAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ADDRESS_SEQ")
    @SequenceGenerator(
            initialValue = 1,
            name = "ACCOUNT_ADDRESS_SEQ",
            sequenceName = "ACCOUNT_ADDRESS_SEQUENCE",
            allocationSize = 1
    )
    @Column(name = "ADDRESS_ID")
    private long id;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    private Account account;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "AccountAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
