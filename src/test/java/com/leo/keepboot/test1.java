package com.leo.keepboot;

import com.leo.keepboot.webservice.CallWebservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * Created by Liuq on 2019-12-02.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test1 {
    @Autowired
    private CallWebservice callWebservice;
    @Test
    public void call(){
        callWebservice.getdata();
    }
}
