package cn.swallow.platform.core.aop;

import cn.swallow.platform.core.util.GsonHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Deprecated
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(cn.swallow.platform.core.common.annotation.BusinessLog)")
    public void log(){

    }

//    @Before("log()")
//    public void doBeforeController(JoinPoint joinPoint){
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        BusinessLog businessLog = method.getAnnotation(BusinessLog.class);
//        System.out.println("action名称" + businessLog.value());
//    }

//    @AfterReturning(pointcut = "log()",returning = "retValue")
//    public void doAfterController(JoinPoint joinPoint,Object retValue){
//        System.out.println("retValue is: "+retValue);
//    }

    //TODO 日志记录实现
    @Around("log()")
    public Object doAroudController(ProceedingJoinPoint pjp) throws Throwable{
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Object target = pjp.getTarget();
        Method method = target.getClass().getMethod(ms.getName(),ms.getParameterTypes());
        System.out.println("do Around advice start methodName : "+method.getName());
        Object returnVlue = pjp.proceed();
        System.out.println("do Around advice end : "+ GsonHelper.toJson(returnVlue));
        return returnVlue;
    }


}
