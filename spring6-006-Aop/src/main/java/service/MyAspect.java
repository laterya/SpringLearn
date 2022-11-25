package service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//切面类
@Aspect
@Component
public class MyAspect {

    @Before("execution(* service.OrderService.*(..))")
    //需要加强的代码（通知)
    public void advice() {
        System.out.println("发布通知");
    }
}
