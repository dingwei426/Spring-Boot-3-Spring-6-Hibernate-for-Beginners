package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // there is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvide(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

}
