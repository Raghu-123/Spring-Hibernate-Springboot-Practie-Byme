package com.raghu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.raghu.aopdemo.aspect.LuvAopExpressions.forDoaPackageNoSetterGetter()")
	public void logToCLoudAsync() {
		System.out.println("\n====> Logging to the cloud in Async fashion");
	}
}
