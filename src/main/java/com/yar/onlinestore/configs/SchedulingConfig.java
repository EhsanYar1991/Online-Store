package com.yar.onlinestore.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * SchedulingConfig
 * Created by E.YARMOHAMMADI on 8/9/2017.
 */
@Configuration
@EnableScheduling
@ComponentScan("com.stts.onlinestore.*")
public class SchedulingConfig implements SchedulingConfigurer {


    /*@Bean
    public SessionManagerQueueBased sessionManagerQueueBased(){
        return new SessionManagerQueueBased();
    }*/

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public ScheduledExecutorService taskExecutor() {
        return Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()+1);
    }



}