package com.example.productorderservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {

	@Around("execution(* com.example.productorderservice..*Adapter.*(..))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
		long startTime = System.currentTimeMillis();
		System.out.println("START : " + joinPoint.toString());
		try {
			return joinPoint.proceed();
		}finally {
			long endTime= System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("END : " + joinPoint.toString() + " " + totalTime + " ms");
		}
	}
}
