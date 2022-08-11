package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author sunxian
 * @version 2022-06-01 13:39
 */
//@Aspect
@Slf4j
@Component
public class Aspect2 {

    // target 限制连接点匹配目标对象为指定类型的类
   @Pointcut("args(com.example.demo.entity.Animal,..)") // 切入点表达式
    private void  writeLog() {}// 方法签名


    @Around("writeLog()")
    public Object pointcut(ProceedingJoinPoint point) throws Throwable {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        log.info("访问接口33333 {}",method.getName());
        return point.proceed();
    }

}
