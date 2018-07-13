package com.yar.onlinestore.common.logging;


import com.yar.onlinestore.common.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect class for Logging system.
 * Created by E.YARMOHAMMADI on 7/17/2017.
 */

@Aspect
@Component
public class RestLoggingAspect implements LogFactory {


    /**
     * logging for process of before service called
     * @param joinPoint join point of aspectJ component
     */
    @Before("execution(* com.stts.onlinestore.controller.rest..*.*(..))")
    public void beforeCallService(JoinPoint joinPoint) throws Throwable {
        getLog().debug(getBeforeCallLogValue(joinPoint));
    }

    /**
     * logging for process of after service called
     *
     * @param joinPoint join point of aspectJ component
     */
    @After("execution(* com.stts.onlinestore.controller.rest..*.*(..))")
    public void receiveMessageSystemCall(JoinPoint joinPoint) throws Throwable {
        getLog().debug(getAfterCallLogValue(joinPoint));
    }


    /**
     * logging for process of after service called
     * @param exception join point of aspectJ component
     */
    @AfterThrowing(pointcut = "execution(* com.stts.onlinestore.controller.rest..*.*(..))" , throwing = "exception")
    public void afterThrowingException(Exception exception) throws Throwable{
        getLog().debug(exception.getMessage(),exception);
    }


}
