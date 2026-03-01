package com.apad99.JobBoard.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.apad99.JobBoard.service.JobService.getAllJobs(..))")
    public void LogMethodCall() {
        LOGGER.info("Method called");
    }

    @After("execution(* com.apad99.JobBoard.service.JobService.getAllJobs(..))")
    public void LogMethodExecuted() {
        LOGGER.info("Method executed");
    }

    @AfterThrowing("execution(* com.apad99.JobBoard.service.JobService.getAllJobs(..))")
    public void LogMethodCraahed() {
        LOGGER.info("Method experienced an issue");
    }

    @AfterReturning("execution(* com.apad99.JobBoard.service.JobService.getAllJobs(..))")
    public void LogMethodExecutedSuccess() {
        LOGGER.info("Method executed successfully");
    }
}
