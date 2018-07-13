package com.yar.onlinestore.bootstrap;

import com.yar.onlinestore.configs.security.SecurityRole;
import com.yar.onlinestore.dao.domain.model.User;
import com.yar.onlinestore.dao.domain.model.UserRole;
import com.yar.onlinestore.dao.repository.UserRepository;
import com.yar.onlinestore.dao.repository.UserRoleRepository;
import com.yar.onlinestore.service.domain.PasswordCodingManagement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordCodingManagement passwordCodingManagement;


    @Value(value = "${security.user.name}")
    private String adminUsername;

    @Value(value = "${security.user.password}")
    private String adminPassword;

    @Value(value = "${security.user.role}")
    private String adminRole;

    public UserLoader(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordCodingManagement passwordCodingManagement) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordCodingManagement = passwordCodingManagement;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        checkSecurityRoles();

        adminUserLoader();

    }


    private void adminUserLoader() {

        // check or add administrator user to db
        User adminUser = userRepository.findByUsername(adminUsername);
        UserRole byRole = userRoleRepository.findByRole(this.adminRole);
        if (adminUser == null) {
            adminUser = new User();
            adminUser.setUsername(adminUsername);
            adminUser.setPassword(passwordCodingManagement.encoding(adminPassword));
            adminUser.setEnabled(true);
            if (byRole != null) {
                adminUser.getUserRoleSet().add(byRole);
            } else {
                byRole = new UserRole(this.adminRole);
                userRoleRepository.save(byRole);
            }
            userRepository.saveAndFlush(adminUser);
        }
    }


    private void checkSecurityRoles() {
        // check or add security roles to db
        checkOrPersistSecurityRole(SecurityRole.ADMIN);
        checkOrPersistSecurityRole(SecurityRole.MANAGER);
        checkOrPersistSecurityRole(SecurityRole.USER);
        checkOrPersistSecurityRole(SecurityRole.ANONYMOUS);
    }

    private void checkOrPersistSecurityRole(SecurityRole securityRole) {
        UserRole byRole = userRoleRepository.findByRole(securityRole.getRole());
        if (byRole == null) {
            byRole = new UserRole(securityRole.getRole());
            userRoleRepository.save(byRole);
        }
    }
}
