package test.bank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
/**
 * Unmapped Spring configuration files found.  Please configure Spring facet.  Demo (1 file)
 */
public class LogAspect {

	@Before("execution(* *.*(..))")
	public void logBefore(JoinPoint jionPoint){
		System.out.println("假设这是一个日志:"+jionPoint.getTarget().getClass().getName()+"."+jionPoint.getSignature().getName()+"方法开始执行！");
	}

	@After("execution(* *.*(..))")
	public void logAfter(JoinPoint jionPoint){
		System.out.println("假设这是一个日志:"+jionPoint.getTarget().getClass().getName()+"."+jionPoint.getSignature().getName()+"方法执行完成！");
	}
}
