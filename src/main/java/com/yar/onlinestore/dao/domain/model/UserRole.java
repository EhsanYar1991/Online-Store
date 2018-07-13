package com.yar.onlinestore.dao.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
@Entity
@Table(name = "USER_ROLES"/*, uniqueConstraints = @UniqueConstraint(columnNames = {"HC1USERROLEID304", "HC1USERID303"})*/)
public class UserRole implements Serializable {

    private static final long serialVersionUID = 4440254715270219418L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLE_SEQ")
    @SequenceGenerator(
            initialValue = 1,
            name = "USER_ROLE_SEQ",
            sequenceName = "USER_ROLE_SEQUENCE",
            allocationSize = 1
    )
    @Column(name = "USER_ROLE_ID")
    private long id;

    @NotNull
    @Column(name = "REGISTER_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate = new Date();

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.DETACH )
//    @Fetch(value = FetchMode.JOIN)
//    @JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "USER_ROLE_ID", referencedColumnName = "USER_ROLE_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"))
    private Set<User> userSet = new HashSet<>(0) ;

    @Column(name = "ROLE", nullable = false, length = 45, unique = true)
    private String role;


    public UserRole() {
    }

    public UserRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole that = (UserRole) o;

        return getRole() != null ? getRole().equals(that.getRole()) : that.getRole() == null;
    }

    @Override
    public int hashCode() {
        return getRole() != null ? getRole().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", registerDate=" + registerDate +
                ", role='" + role + '\'' +
                '}';
    }
}