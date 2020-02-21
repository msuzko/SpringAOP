package com.mec.spring.aop.loggins;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class LoggerFiles {

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
