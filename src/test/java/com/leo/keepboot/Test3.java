package com.leo.keepboot;

import com.leo.keepboot.aspectj.Hello;
import com.leo.keepboot.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description:
 * Created by Liuq on 2019-12-04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test3 {
    @Autowired
    private List<OrderService> orderService;
    @Test
    public void hi(){
      Object[] a =orderService.toArray();
        System.out.println(a);
    }
}
