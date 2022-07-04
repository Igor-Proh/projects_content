package com.prokhnov.projectcontent.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllersAspect {

    private final String ARR = " >>> ";

    @Before("execution(public String save* (..))")
    public void logBeforeSave(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public String update* (..))")
    public void logBeforeUpdate(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public String delete* (..))")
    public void logBeforeDelete(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Before("execution(public String add* (..))")
    public void logBeforeAdd(JoinPoint joinPoint) {
        System.out.println(ARR + joinPoint.getSignature().getName()
                + ARR + joinPoint.getSignature().getDeclaringTypeName());
    }

}
