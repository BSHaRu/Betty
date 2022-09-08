package com.koreate.betty.global.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Component
//@Aspect
@Slf4j
public class LogAOP {

	@Around("execution(* com.koreate.betty.domain..*.*(..))")
	public Object service(ProceedingJoinPoint pjp) {

		log.info("================aop start ==============");

		Object o = null;
		try {
			log.info("target = {} ", pjp.getTarget());
			log.info("method = {} ",  pjp.getSignature().getName());
			log.info("params = {} ", Arrays.toString(pjp.getArgs()));
			o = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			log.info("return = {}", o);
			log.info("================aop send ==============");
		}

		return o;
	}
}
