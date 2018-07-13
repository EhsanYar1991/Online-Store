package com.yar.onlinestore.service.domain;


import com.yar.onlinestore.common.LogFactory;
import com.yar.onlinestore.common.exception.UserNotActiveException;
import com.yar.onlinestore.common.exception.UserServiceException;
import com.yar.onlinestore.dao.domain.model.User;
import com.yar.onlinestore.dao.domain.model.UserRole;
import com.yar.onlinestore.dao.repository.UserRepository;
import com.yar.onlinestore.dao.repository.UserRoleRepository;
import com.yar.onlinestore.service.dto.ModelMapper;
import com.yar.onlinestore.service.dto.user.UserDTO;
import com.yar.onlinestore.service.dto.user.UserRoleDTO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by e.yarmohammadi on 9/10/2017.
 */

@SuppressWarnings({"UnusedReturnValue", "unused", "WeakerAccess"})
@Service
@Transactional
public class UserManagement implements UserDetailsService {


//    @Value(value = "${security.user.name}")
//    private String adminUsername;
//
//    @Value(value = "${security.user.password}")
//    private String adminPassword;
//
//    @Value(value = "${security.user.role}")
//    private String adminRole;


    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final PasswordCodingManagement passwordCodingManagement;


    private final ModelMapper modelMapper;


    @Autowired
    public UserManagement(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordCodingManagement passwordCodingManagement, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordCodingManagement = passwordCodingManagement;
        this.modelMapper = modelMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {

        org.springframework.security.core.userdetails.User user = null;

        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            if (!userEntity.isEnabled()) {
                try {
                    throw new UserNotActiveException("User " + username + " was not activated");
                } catch (UserNotActiveException e) {
                    LogFactory.log.error(e.getMessage());
                }
            }
            List<GrantedAuthority> authorities = buildUserAuthority(userEntity.getUserRoleSet());

            user = buildUserForAuthentication(userEntity, authorities);
        } else {
            throw new UsernameNotFoundException("User " + username + " was not found in the " +
                    "database");
        }



        /*if ( user == null && username.equals(adminUsername) ){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(adminRole);
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
            simpleGrantedAuthorities.add(simpleGrantedAuthority);

            user = new org.springframework.security.core.userdetails.User(adminUsername,adminPassword,true,true,true,true,simpleGrantedAuthorities);
        }*/

        return user;
    }

    @Transactional(readOnly = true)
    public UserDTO findUserByUserName(String username) {
        User user = userRepository.findByUsername(username);
        return modelMapper.convertUserEntityToUserDTO(user);
    }

    @Transactional(readOnly = true)
    public User findUserEntityByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public UserDTO addUser(UserDTO userDTO, String role) throws UserServiceException {
        User user = userRepository.findByUsername(userDTO.getUsername());
        UserRole roleEntity = userRoleRepository.findByRole(role);
        Hibernate.initialize(roleEntity.getUserSet());
        if (user != null) throw new UserServiceException("user exist");

        user = modelMapper.convertUserDtoToUserEntity(userDTO);
        user.getUserRoleSet().clear();
//        user.getUserSerial().setUser(user);
        userRepository.save(user);
        Set<UserRole> userRoleEntities = new HashSet<>();
        userRoleEntities.add(roleEntity);
        user.setUserRoleSet(userRoleEntities);
        roleEntity.getUserSet().add(user);
        userRoleRepository.save(roleEntity);
        userRepository.save(user);

        return modelMapper.convertUserEntityToUserDTO(user);
    }

    // org.springframework.security.core.userdetails.User
    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        String decodingPassword = passwordCodingManagement.decoding(user.getPassword());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), decodingPassword, user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        if (userRoles != null && !userRoles.isEmpty()) {
            // Build user's authorities
            for (UserRole userRole : userRoles) {
                setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
            }
        }

        return new ArrayList<>(setAuths);
    }


    public void saveOrUpdateUser(User userByUserName) {
        userRepository.save(userByUserName);
    }


    public User saveUser(UserDTO userDTO) {
        User user = modelMapper.convertUserDtoToUserEntity(userDTO);
        userRepository.save(user);
        return user;
    }


    public UserDTO addRoleToUser(UserDTO userDTO) {
        UserDTO result = null;
        if (userDTO != null) {
            User byUsername = userRepository.findByUsername(userDTO.getUsername());
            if (byUsername == null) {
                byUsername = saveUser(userDTO);
            } else {
                Hibernate.initialize(byUsername.getUserRoleSet());
                for (UserRoleDTO userRoleDTO : userDTO.getRoleSet()) {
                    UserRole byRole = userRoleRepository.findByRole(userRoleDTO.getRole());
                    if (byRole != null) {
                        byUsername.getUserRoleSet().add(byRole);
                        byRole.getUserSet().add(byUsername);
                    } else {
                        UserRole userRole = modelMapper.convertUserRoleDtoToUserRoleEntity(userRoleDTO);
                        userRole.getUserSet().add(byUsername);
                        byUsername.getUserRoleSet().add(userRole);
                        userRoleRepository.save(userRole);
                    }
                }
                userRoleRepository.save(byUsername.getUserRoleSet());
            }
            byUsername.getUserRoleSet().addAll(byUsername.getUserRoleSet());

            userRepository.saveAndFlush(byUsername);
            result = modelMapper.convertUserEntityToUserDTO(byUsername);
        }
        return result;
    }

    public void addRoleToUser(User user, UserRole userRole) {

        if (user.getId() == 0) {
            userRepository.save(user);
        }
        if (userRole.getId() == 0) {
            userRoleRepository.save(userRole);
        }
        user.getUserRoleSet().add(userRole);
        userRole.getUserSet().add(user);
        userRepository.save(user);
        userRoleRepository.save(userRole);
    }


    @SuppressWarnings("unchecked")
    public List<UserDTO> getAllUsers() {
        return modelMapper.convertUserEntityToUserDTO(userRepository.findAll());
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUserEntities() {
        return  userRepository.findAll();
    }


    public void addNewRole(UserRoleDTO userRoleDTO) {
        UserRole byRole = userRoleRepository.findByRole(userRoleDTO.getRole());
        if (byRole != null) return;
        byRole = new UserRole();
        byRole.setRole(userRoleDTO.getRole());
        userRoleRepository.saveAndFlush(byRole);
    }

    public List<UserRole> getAllRoles() {
        return userRoleRepository.findAll();
    }

    public Set<UserRoleDTO> getAllRoleDtos() {
        return modelMapper.convertUserRoleEntityToUserRoleDtoSet(userRoleRepository.findAll());
    }


    public List<UserDTO> getAllUserWithRole(String role) {
        List<User> allByUserRoleSet = userRepository.findByUserRoleSetContains(userRoleRepository.findByRole(role));
        return modelMapper.convertUserEntityToUserDTO(allByUserRoleSet);
    }

}
