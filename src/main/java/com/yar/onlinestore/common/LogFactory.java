package com.yar.onlinestore.common;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public interface LogFactory {


    Logger log = LoggerFactory.getLogger(LogFactory.class);

    default String getBeforeCallLogValue(JoinPoint joinPoint) {
        StringBuilder logValue = new StringBuilder();
        logValue.append(joinPoint.getSignature().getName());
        logValue.append(" ---- Args: (");
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length != 0) {
            for (Object arg : args) {
                if (arg != null) {
                    logValue.append("[").append(arg.toString()).append("]");
                }else {
                    logValue.append("[").append("null").append("]");
                }
            }
        } else {
            logValue.append("null");
        }
        logValue.append(")");
        return logValue.toString();
    }

    default String getAfterCallLogValue(JoinPoint joinPoint) {
        return " ---- called: ["
                + joinPoint.getSignature().getName()
                + "]";
    }

    default String getAfterCallLogValue(JoinPoint joinPoint , Object resultObj) {
        return joinPoint.getSignature().getName() +
                " ---- return ["
                + (resultObj != null ? resultObj.toString() : null)
                + "]";
    }

    @SuppressWarnings("UnnecessaryInterfaceModifier")
    default public Logger getLog() {
        return this.log;
    }
}
