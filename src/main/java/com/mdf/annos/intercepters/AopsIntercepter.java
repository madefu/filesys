package com.mdf.annos.intercepters;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.mdf.annos.Aops;

@Aspect
@Component
public class AopsIntercepter {
	
	@Around("@annotation(com.mdf.annos.Aops)")
    public Object limit(ProceedingJoinPoint joinPoint) throws Throwable {
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		Aops apos = method.getAnnotation(Aops.class);
        
		return joinPoint.proceed();
		
	}
}
