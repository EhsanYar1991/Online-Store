/*
* Remote Card Loading
* */

package com.yar.onlinestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(value = "com.yar.onlinestore.*")
public class RclApplication {


    public static void main(String[] args) {
        SpringApplication.run(RclApplication.class, args);
    }


}
