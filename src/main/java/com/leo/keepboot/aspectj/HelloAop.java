package com.leo.keepboot.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by Liuq on 2019-12-04.
 */
@Component
@Aspect
@Order(2)
public class HelloAop {
    @Before("execution(* com.leo.keepboot.aspectj.Hello.*(..))")
    public void sayHi(){
        System.out.println("second hi...");
    }
/*    @Before("execution(* com.leo.keepboot.aspectj.Hello.*(..))")
    public void sayBye(){
        System.out.println("Bye...");
    }*/
}
