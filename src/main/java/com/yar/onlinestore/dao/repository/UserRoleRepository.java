package com.yar.onlinestore.dao.repository;

import com.yar.onlinestore.dao.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    UserRole findByRole(String role);


}
