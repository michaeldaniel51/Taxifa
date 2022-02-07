package com.danny.taxifa.annotations;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Around("@annotation(ShowExecutionTime)")
    public Object logg(ProceedingJoinPoint joinPoint) throws Throwable{

        Date dat =  new Date();
        System.out.println(dat.toString());
        System.out.println(joinPoint.proceed());
        return joinPoint.proceed();


    }







}
