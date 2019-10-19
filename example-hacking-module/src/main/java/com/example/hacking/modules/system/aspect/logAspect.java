package com.example.hacking.modules.system.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/19
 */
@Slf4j
@Aspect
@Component
public class logAspect {
    @Pointcut("execution(public * com.example.hacking.modules.demo.controller.*.*(..))")
    public void executeMethod(){

    }

    @Around("executeMethod()")
    public Object aroundMethodLog(ProceedingJoinPoint point) throws Throwable {
        log.info("LogInfo:-----------------------------------");
        Object result = point.proceed();
        log.info("LogInfo:-----------------------------------");
        return result;

    }

}
