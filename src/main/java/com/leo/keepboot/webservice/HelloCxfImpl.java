package com.leo.keepboot.webservice;

import org.springframework.stereotype.Service;

/**
 * Description:
 * Created by Liuq on 2019-12-02.
 */
@Service
public class HelloCxfImpl implements HelloCxf {
    @Override
    public String postInfo(String a) {
        if(a !=null){
            return "success " + a;
        }
        return "error";
    }
}
