package com.miramontes.three.linkin.becomespringdev.a.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging(){}

    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint){
        StringBuilder sb = new StringBuilder("Method: ");
        sb.append(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if(null != args && args.length > 0){
            sb.append(" args=[ | ");
            Arrays.asList(args).forEach(arg -> {
                sb.append(arg).append(" | ");
            });
            sb.append("]");
        }
        LOGGER.info(sb.toString());
    }
}
