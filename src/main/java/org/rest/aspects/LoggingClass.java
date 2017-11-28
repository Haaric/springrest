package org.rest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingClass {
	
	@Before("allMethodsPointcut()")
	public void beforeLoggingAdvice(JoinPoint joinPoint) {
		System.out.println("Before running loggingAdvice on method="+joinPoint.toString());
	}
	
	@After("allMethodsPointcut()")
	public void afterLoggingAdvice(JoinPoint joinPoint) {
		System.out.println("After running loggingAdvice on method="+joinPoint.toString());
	}
	
	/*@Pointcut()
	public void getMethods() {
		
	}
	
	@Pointcut()
	public void postMethods() {
			
	}*/
	
	@Pointcut("within(org.rest..*)")
	public void allMethodsPointcut(){}
}
