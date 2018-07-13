package com.yar.onlinestore.dao.repository;

import com.yar.onlinestore.dao.domain.model.User;
import com.yar.onlinestore.dao.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findByUserRoleSetContains(UserRole userRole);



}
