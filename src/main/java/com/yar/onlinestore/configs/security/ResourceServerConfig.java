package com.yar.onlinestore.configs.security;

import com.yar.onlinestore.service.domain.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter /*ResourceServerConfigurerAdapter*/ {


    private final AuthenticationManager authenticationManager;
    private final UserManagement userManagement;

    @Value(value = "${security.user.name}")
    private String username;

    @Value(value = "${security.user.password}")
    private String password;

    @Value(value = "${security.user.role}")
    private String role;


    @Autowired
    public ResourceServerConfig(AuthenticationManager authenticationManager, UserManagement userManagement) {
        this.authenticationManager = authenticationManager;
        this.userManagement = userManagement;
    }



    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .userDetailsService(userManagement)
                .authorizeRequests().antMatchers("/RCL/services/*").permitAll()
                .and().logout().logoutSuccessUrl("/login").permitAll()
                .and().authorizeRequests().antMatchers("/prometheus").hasAnyAuthority(SecurityRole.ADMIN.getRole()).anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/admin").hasAnyAuthority(SecurityRole.ADMIN.getRole()).anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/manager").hasAnyAuthority(SecurityRole.ADMIN.getRole(), SecurityRole.MANAGER.getRole()).anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/report").hasAnyAuthority(SecurityRole.ADMIN.getRole(), SecurityRole.MANAGER.getRole(), SecurityRole.USER.getRole()).anyRequest().authenticated()
                .and().authorizeRequests().antMatchers("/swagger-ui.html").hasAnyAuthority(SecurityRole.ADMIN.getRole(), SecurityRole.MANAGER.getRole(), SecurityRole.USER.getRole()).anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .and().csrf().disable().headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.parentAuthenticationManager(authenticationManager).inMemoryAuthentication()
                .withUser(username).password(password).roles(role);
    }


}
