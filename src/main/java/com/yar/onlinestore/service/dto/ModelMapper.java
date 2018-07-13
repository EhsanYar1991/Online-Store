package com.yar.onlinestore.service.dto;

import com.yar.onlinestore.common.LogFactory;
import com.yar.onlinestore.dao.domain.model.User;
import com.yar.onlinestore.dao.domain.model.UserRole;
import com.yar.onlinestore.service.domain.PasswordCodingManagement;
import com.yar.onlinestore.service.dto.user.UserDTO;
import com.yar.onlinestore.service.dto.user.UserRoleDTO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ModelMapper {

    private final PasswordCodingManagement passwordCodingManagement;

    @Autowired
    public ModelMapper(PasswordCodingManagement passwordCodingManagement) {
        this.passwordCodingManagement = passwordCodingManagement;
    }

    public UserDTO convertUserEntityToUserDTO(User user) {
        UserDTO userDTO = null;
        if (user != null) {
            Hibernate.initialize(user.getUserRoleSet());
            userDTO = new UserDTO();
            userDTO.setUserId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(passwordCodingManagement.decoding(user.getPassword()));
            userDTO.setEnable(user.isEnabled());
            if (!user.getUserRoleSet().isEmpty()) {
                for (UserRole userRole : user.getUserRoleSet()) {
                    UserRoleDTO userRoleDTO = new UserRoleDTO();
                    userRoleDTO.setRole(userRole.getRole());
                    userDTO.getRoleSet().add(userRoleDTO);
                }
            }
        }
        return userDTO;
    }

    public User convertUserDtoToUserEntity(UserDTO userDTO) {
        User user = null;
        if (userDTO != null) {
            user = new User();
            user.setId(userDTO.getUserId());
            user.setUsername(userDTO.getUsername());
            user.setPassword(passwordCodingManagement.encoding(userDTO.getPassword()));
            user.setEnabled(userDTO.isEnable());
//            if (userDTO.getSerial() == 0) user.setUserSerial(new UserSerial());
            if (!userDTO.getRoleSet().isEmpty()) {
                for (UserRoleDTO userRoleDTO : userDTO.getRoleSet()) {
                    UserRole userRole = new UserRole();
                    userRole.setId(userRoleDTO.getUserRoleId());
                    userRole.setRole(userRoleDTO.getRole());
                    user.getUserRoleSet().add(userRole);
                }
            }
        }
        return user;
    }

    public Set<User> convertUserDtoToUserEntitySet(Set<UserDTO> userDTOSet){
        Set<User> userSet = null;
        if ( userDTOSet != null && !userDTOSet.isEmpty()) {
            userSet = new HashSet<>();
            for (UserDTO userDTO : userDTOSet) {
                userSet.add(convertUserDtoToUserEntity(userDTO));
            }
        }
        return userSet;
    }

    public Set<UserDTO> convertUserEntityToUserDTO(Set<User> userEntities){
        Set<UserDTO> userDTOSet = null;
        if ( userEntities != null && !userEntities.isEmpty()) {
            userDTOSet = new HashSet<>();
            for (User user : userEntities) {
                userDTOSet.add(convertUserEntityToUserDTO(user));
            }
        }
        return userDTOSet;
    }

    public List<UserDTO> convertUserEntityToUserDTO(List<User> userList){
        List<UserDTO> userDTOSet = null;
        if ( userList != null && !userList.isEmpty()) {
            userDTOSet = new ArrayList<>();
            for (User user : userList) {
                userDTOSet.add(convertUserEntityToUserDTO(user));
            }
        }
        return userDTOSet;
    }


    public UserRoleDTO convertUserRoleEntityToUserRoleDto(UserRole userRole){
        UserRoleDTO userRoleDTO = null;
        if (userRole != null){
            userRoleDTO = new UserRoleDTO();
            userRoleDTO.setUserRoleId(userRole.getId());
            userRoleDTO.setRole(userRole.getRole());
        }
        return userRoleDTO;
    }

    public Set<UserRoleDTO> convertUserRoleEntityToUserRoleDtoSet(Set<UserRole> userRoleEntities){
        Set<UserRoleDTO> userRoleDTOSet = null;
        if (userRoleEntities!= null && !userRoleEntities.isEmpty()){
            userRoleDTOSet = new HashSet<>();
            for (UserRole userRole : userRoleEntities){
                userRoleDTOSet.add(convertUserRoleEntityToUserRoleDto(userRole));
            }
        }
        return userRoleDTOSet;
    }

    public Set<UserRoleDTO> convertUserRoleEntityToUserRoleDtoSet(List<UserRole> userRoleEntities){
        Set<UserRoleDTO> userRoleDTOSet = null;
        if (userRoleEntities!= null && !userRoleEntities.isEmpty()){
            userRoleDTOSet = new HashSet<>();
            for (UserRole userRole : userRoleEntities){
                userRoleDTOSet.add(convertUserRoleEntityToUserRoleDto(userRole));
            }
        }
        return userRoleDTOSet;
    }

    public UserRole convertUserRoleDtoToUserRoleEntity(UserRoleDTO userRoleDTO){
        UserRole userRole = null;
        if (userRoleDTO!= null){
            userRole = new UserRole();
            userRole.setId(userRoleDTO.getUserRoleId());
            userRole.setRole(userRoleDTO.getRole());
        }
        return userRole;
    }

    public Set<UserRole> convertUserRoleDtoToUserRoleEntitySet(Set<UserRoleDTO> userRoleDTOSet){
        Set<UserRole> userRoleEntities = null;
        if (userRoleDTOSet!= null && !userRoleDTOSet.isEmpty()){
            userRoleEntities = new HashSet<>();
            for (UserRoleDTO userRoleDTO : userRoleDTOSet){
                userRoleEntities.add(convertUserRoleDtoToUserRoleEntity(userRoleDTO));
            }
        }
        return userRoleEntities;
    }



    private Date getDateStringValue(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            LogFactory.log.error(e.getMessage());
        }
        return date;
    }

    private Date getDateTimeStringValue(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            LogFactory.log.error(e.getMessage());
        }
        return date;
    }


}
