package com.yar.onlinestore.dao.domain.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by e.yarmohammadi on 9/10/2017.
 */

@SuppressWarnings("unused")
@Entity
@Table(name = "USERS"/*,uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID", "USER_ROLE_ID"})}*/)
public class User implements Serializable {

    private static final long serialVersionUID = -5341997005920685311L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(
            initialValue = 1,
            name = "USER_SEQ",
            sequenceName = "USER_SEQUENCE",
            allocationSize = 1
    )
    @Column(name = "USER_ID")
    private long id;


    @Column(name = "REGISTER_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate = new Date();

    @Column(name = "USERNAME", nullable = false, length = 45, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 60)
    private String password;

    @Column(name = "ENABLE", nullable = false)
    private boolean enabled;

    @Fetch(FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @Fetch(value = FetchMode.JOIN)
//    @JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ROLE_ID"))
    private Set<UserRole> userRoleSet = new HashSet<>(0);


    @OneToOne
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", registerDate=" + registerDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", userRoleSet=" + userRoleSet +
                '}';
    }
}
