package com.leo.keepboot.aspectj;

import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by Liuq on 2019-12-04.
 */
@Component
public class Hello {
    public void sayHello(){
        System.out.println("i am aop");
    }
}
