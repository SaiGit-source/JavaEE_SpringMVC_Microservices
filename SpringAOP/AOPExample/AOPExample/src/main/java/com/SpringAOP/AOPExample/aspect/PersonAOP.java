package com.SpringAOP.AOPExample.aspect;

import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Aspect means Secondary logic not Business logic
@Component
public class PersonAOP {
	
	
	// @Before(value="execution(* com.SpringAOP.AOPExample.rest.*.*(..))") in the rest folder, all files then all classes in that
	// @Before(value="execution(* com.SpringAOP.AOPExample.rest.PersonController.getAllPerson(..))")
	@Before(value="execution(* com.SpringAOP.AOPExample.rest.PersonController.savePersonRecord(..))") // pointcut says where/which method() to apply the Aspect or secondary logic
	// @Before(value="execution(* com.SpringAOP.AOPExample.rest.PersonController.*(..))")
	public void beforeAdviceController(JoinPoint joinPoint) {
		System.out.println("Before Controller: Request made to "+ joinPoint.getSignature()+" at "+LocalTime.now());
	}
	
	// @Before(value="execution(* com.SpringAOP.AOPExample.service.*.*(..))")
	@Before(value="execution(* com.SpringAOP.AOPExample.service.PersonService.registerPerson(..))") // only applied to one service method - PointCut
	public void beforeAdviceService(JoinPoint joinPoint) { // JoinPoint is at what point Aspect Logic should be executed
		System.out.println("Before Service: Request made to "+ joinPoint.getSignature()+" at "+LocalTime.now());
	}
	
	
	//@After(value="execution(* com.SpringAOP.AOPExample.rest.*.*(..))")
	@After(value="execution(* com.SpringAOP.AOPExample.service.PersonController.getAllPerson(..)") // only applied to one service method - PointCut
	public void afterAdviceController(JoinPoint joinPoint) { // JoinPoint is at what point Aspect Logic should be executed
		System.out.println("After Controller: Request made to "+ joinPoint.getSignature()+" at "+LocalTime.now());
	}

	// @After(value="execution(* com.SpringAOP.AOPExample.service.*.*(..))")
	@After(value="execution(* com.SpringAOP.AOPExample.service.PersonService.getAllPersonInfo(..)") // only applied to one service method - PointCut
	public void afterAdviceService(JoinPoint joinPoint) { // JoinPoint is at what point Aspect Logic should be executed
		System.out.println("After Service: Request made to "+ joinPoint.getSignature()+" at "+LocalTime.now());
	}

}
