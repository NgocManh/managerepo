package com.example.testhiber.aop;

import org.apache.logging.log4j.spi.LoggerAdapter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
//    private final Logger logger = (Logger) LoggerFactory.getLogger(LoggerAdapter.class);

    @Pointcut("within(com.example.testhiber..*)")
    public void loggingPointcut(){}

    @Before("loggingPointcut()")
    public void logMethodAccess(JoinPoint joinPoint)
    {
//        logger.info();
        System.out.println("------- Method " + joinPoint.getSignature().getName() + "  is called -----------");
    }

}
