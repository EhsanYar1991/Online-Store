package com.yar.onlinestore.service.domain;


import com.yar.onlinestore.dao.domain.model.UserRole;
import com.yar.onlinestore.dao.repository.UserRoleRepository;
import com.yar.onlinestore.service.dto.ModelMapper;
import com.yar.onlinestore.service.dto.user.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by e.yarmohammadi on 9/11/2017.
 */

@Service
@Transactional
public class UserRoleManagement {

    private final UserRoleRepository userRoleRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleManagement(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }


    @SuppressWarnings("unchecked")
    public Set<UserRoleDTO> getAllRoles() {
        Set<UserRole> all = (Set<UserRole>) userRoleRepository.findAll();
        return modelMapper.convertUserRoleEntityToUserRoleDtoSet(all);
    }

    public UserRoleDTO getUserRoleByRole(String role) {
        return modelMapper.convertUserRoleEntityToUserRoleDto(userRoleRepository.findByRole(role));
    }


    public UserRoleDTO persist(UserRoleDTO userRoleDTO) {
        UserRole userRole = userRoleRepository.saveAndFlush(modelMapper.convertUserRoleDtoToUserRoleEntity(userRoleDTO));
        return modelMapper.convertUserRoleEntityToUserRoleDto(userRole);
    }
}
