package com.leo.keepboot.Timer;

import com.leo.keepboot.webservice.CallWebservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

/**
 * Description:
 * Created by Liuq on 2019-12-02.
 */
@Component
public class UploadTimer extends TimerTask {
    @Autowired
    private CallWebservice callWebservice;
    @Override
    public void run() {
        callWebservice.getdata();
    }
}
