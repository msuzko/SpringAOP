package com.mec.spring.aop.loggins;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Aspect
public class LoggerFiles {

    @Pointcut("execution(* *(..)) && within(com.mec.spring.aop.objects.*)")
    private void allMethods(){
    }

    @Around("allMethods() && @annotation(com.mec.spring.aop.annotations.ShowTime)")
    public Object watchTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + joinPoint.getSignature().toShortString());
        Object output = null;
        try {
            output = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinPoint.getSignature().toShortString() + ", time = " + time + " ms");
        return output;
    }

    @AfterReturning(pointcut = "allMethods() && @annotation(com.mec.spring.aop.annotations.ShowResult)", returning = "obj")
    public void print(Object obj) {
        System.out.println("Print info begin >>");
        if (obj instanceof Set) {
            Set set = (Set) obj;
            for (Object object : set)
                System.out.println(object);
        } else if (obj instanceof Map){
            Map map = (Map) obj;
            for (Object object:map.keySet())
                System.out.println("key = "+object+", value = "+map.get(object));
        }
        System.out.println("Print info end <<");
        System.out.println();
    }
}
