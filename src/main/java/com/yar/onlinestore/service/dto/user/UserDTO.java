package com.yar.onlinestore.service.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



/**
 * Created by e.yarmohammadi on 9/11/2017.
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -1545501143459010778L;

    @JsonIgnore
    @ApiModelProperty(notes = "The database generated user ID")
    private long userId;

    @ApiModelProperty(notes = "Username")
    private String username;

    @ApiModelProperty(notes = "Password")
    private String password;

    @ApiModelProperty(notes = "Enable")
    private boolean enable;

    @ApiModelProperty(notes = "User Serial")
    private long serial;

    @ApiModelProperty(notes = "User Role List")
    private Set<UserRoleDTO> roleSet = new HashSet<>();

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public long getSerial() {
        return serial;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public Set<UserRoleDTO> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<UserRoleDTO> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                ", serial=" + serial +
                ", roleSet=" + roleSet +
                '}';
    }
}
