package com.yar.onlinestore.service.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serializable;



/**
 * Created by e.yarmohammadi on 9/11/2017.
 */
public class UserRoleDTO implements Serializable {
    private static final long serialVersionUID = 4148600667564058638L;

    @JsonIgnore
    @ApiModelProperty(notes = "The database generated role ID")
    private long userRoleId;

    @ApiModelProperty(notes = "Role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "userRoleId=" + userRoleId +
                ", role='" + role + '\'' +
                '}';
    }
}
