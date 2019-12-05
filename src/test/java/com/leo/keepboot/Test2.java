package com.leo.keepboot;

import com.leo.keepboot.aspectj.Hello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * Created by Liuq on 2019-12-04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {
    @Autowired
    private Hello hello;
    @Test
    public void hi(){
        hello.sayHello();
    }
}
