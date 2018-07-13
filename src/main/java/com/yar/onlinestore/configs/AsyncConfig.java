package com.yar.onlinestore.configs;

import com.yar.onlinestore.common.LogFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * Created by E.YARMOHAMMADI on 8/26/2017.
 */
@Configuration
@EnableAsync
@ComponentScan("com.stts.onlinestore.*")
public class AsyncConfig implements AsyncConfigurer {

/*    @Bean
//    @Scope("thread")
    public SessionManagerQueueBased sessionManagerQueueBased(){
        return new SessionManagerQueueBased();
    }*/

    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors()+1);
//        executor.setMaxPoolSize(42);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(11);
        executor.setKeepAliveSeconds(5);
        executor.setThreadGroupName("AsyncThreadPoolTaskExecutorGroup");
        executor.setThreadNamePrefix("AsyncThreadPoolTaskExecutor");
        executor.setThreadPriority(Thread.MAX_PRIORITY);
        executor.setAllowCoreThreadTimeOut(true);
        executor.initialize();
        return executor;
    }





    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new RCLAsyncUncaughtExceptionHandler();
    }


    static class RCLAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {


        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            try {
                throw throwable;
            } catch (Throwable throwable1) {
                LogFactory.log.error(throwable.getMessage(),throwable1);
            }
        }
    }


}