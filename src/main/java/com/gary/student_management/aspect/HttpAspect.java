package com.gary.student_management.aspect;

import com.gary.student_management.results.HttpResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Aspect
@Component
public class HttpAspect {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.gary.student_management.controllers.StudentController.*(..))")
    public void controllerMethod(){

    }

    @Before("controllerMethod()")
    public void before(JoinPoint joinPoint){
        String methodName =  joinPoint.getSignature().getName();
        logger.info("before method " + methodName + " execute");
    }

    @After("controllerMethod()")
    public void after(JoinPoint joinPoint){
        String methodName =  joinPoint.getSignature().getName();
        logger.info("after method " + methodName + " execute");
    }

}
