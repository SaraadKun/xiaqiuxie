package com.saraad.demo.aspect;

import com.saraad.demo.test.ILog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Aspect
@Component
public class AopAdvice {

    @Autowired
    ILog logger;

    ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @AfterReturning(value = "execution(* com.saraad.demo.test.ITestService.*(..))", returning = "res")
    public void afterReturningAdvice(JoinPoint joinPoint, Object res) {
        executorService.submit(() -> logger.log(res.toString()));
        System.out.printf("After returning advice run.  ThreadName : %s, method: %s, res : %s\n",
                Thread.currentThread().getName(),
                joinPoint.getSignature().getName(),
                res.toString());
    }

    @Before(value = "execution(* com.saraad.demo.test.ILog.*(..))")
    public void logAdvice() {
        System.out.printf("log advice run. ThreadName : %s\n", Thread.currentThread().getName());
    }


}
