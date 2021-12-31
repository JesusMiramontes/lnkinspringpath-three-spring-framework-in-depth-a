package com.miramontes.three.linkin.becomespringdev.a.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging(){}

//    @Before("executeLogging()")
//    public void logMethodCall(JoinPoint joinPoint){
//        StringBuilder sb = new StringBuilder("Method: ");
//        sb.append(joinPoint.getSignature().getName());
//        Object[] args = joinPoint.getArgs();
//        if(null != args && args.length > 0){
//            sb.append(" args=[ | ");
//            Arrays.asList(args).forEach(arg -> {
//                sb.append(arg).append(" | ");
//            });
//            sb.append("]");
//        }
//        LOGGER.info(sb.toString());
//    }

//    @AfterReturning(value = "executeLogging()", returning = "returnValue")
//    public void logMethodCall(JoinPoint joinPoint, Object returnValue){
//        StringBuilder sb = new StringBuilder("Method: ");
//        sb.append(joinPoint.getSignature().getName());
//        Object[] args = joinPoint.getArgs();
//        if(null != args && args.length > 0){
//            sb.append(" args=[ | ");
//            Arrays.asList(args).forEach(arg -> {
//                sb.append(arg).append(" | ");
//            });
//            sb.append("]");
//        }
//
//        if(returnValue instanceof Collection){
//            sb.append(", returning: ").append(((Collection) returnValue).size()).append(" instance(s)");
//        } else {
//            sb.append(" returning: ").append(returnValue.toString());
//        }
//
//        LOGGER.info(sb.toString());
//    }

    @Around(value = "executeLogging()")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long totalTime = System.currentTimeMillis() - startTime;

        StringBuilder sb = new StringBuilder("Method: ");
        sb.append(joinPoint.getSignature().getName());

        sb.append(" totalTime: ").append(totalTime).append("ms");

        Object[] args = joinPoint.getArgs();
        if(null != args && args.length > 0){
            sb.append(" args=[ | ");
            Arrays.asList(args).forEach(arg -> {
                sb.append(arg).append(" | ");
            });
            sb.append("]");
        }

        if(returnValue instanceof Collection){
            sb.append(", returning: ").append(((Collection) returnValue).size()).append(" instance(s)");
        } else {
            sb.append(" returning: ").append(returnValue.toString());
        }

        LOGGER.info(sb.toString());

        return returnValue;
    }
}
