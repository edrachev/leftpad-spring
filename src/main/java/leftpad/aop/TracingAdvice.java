package leftpad.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAdvice {
	
	@Around("execution(* leftpad.services.*.*(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AOP logs: " + pjp.getSignature() + ", arguments: " + StringUtils.join(pjp.getArgs(), ", "));
		Object retVal = pjp.proceed();
        return retVal;
	}
}
