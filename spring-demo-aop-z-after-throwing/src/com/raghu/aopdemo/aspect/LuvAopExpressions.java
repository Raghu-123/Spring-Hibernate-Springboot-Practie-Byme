package com.raghu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpressions {

	/*
	 * pointcut declaration
	 * Here  forDaoPackage is declared variable 
	 * we will reuse wherever pointcut expression is required
	 */
	@Pointcut("execution(* com.raghu.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create a pointcut for setter methods
	@Pointcut("execution(* com.raghu.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create a pointcut for getter methods
	@Pointcut("execution(* com.raghu.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	
	//create a pointcut: include package ... and exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	public void forDoaPackageNoSetterGetter() {}
	
}
