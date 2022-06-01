package com.example.demo;

import com.example.demo.anotation.RequestLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author sunxian
 * @version 2022-06-01 13:39
 */
@Aspect
@Slf4j
@Component
public class MyAspect {


    //@Pointcut("execution(* transfer(..))") // 切入点表达式
    @Pointcut("@annotation(com.example.demo.anotation.RequestLog)")
    private void  writeLog() {}// 方法签名


    @Around("writeLog()")
    public Object pointcut(ProceedingJoinPoint point) throws Throwable {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 通过 AnnotationUtils.findAnnotation 获取 RateLimiter 注解
        RequestLog requestLog = AnnotationUtils.findAnnotation(method, RequestLog.class);
        int value = requestLog.value();
//        if(value==1){
//            throw new RuntimeException("!!!!");
//        }
        log.info("访问接口 {}",method.getName());
        return point.proceed();
    }

}
