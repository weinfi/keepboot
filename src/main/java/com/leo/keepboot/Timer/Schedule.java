package com.leo.keepboot.Timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;
import java.util.Timer;

/**
 * Description:
 * Created by Liuq on 2019-12-02.
 */
public class Schedule {
    private final static Log log = LogFactory.getLog(Schedule.class);
    public void startServer(ApplicationContext context){
        Calendar cal = Calendar.getInstance();
        int minutes = cal.get(Calendar.MINUTE);//��ǰ��
        int hours = cal.get(Calendar.HOUR_OF_DAY); //��ǰСʱ
        int seconds = cal.get(Calendar.SECOND);//��ǰ��
        //    long currentTime = (hours * 60 * 60 + minutes * 60 + seconds) * 1000;
        long time = 20000;
        log.info("���趨ʱ��ĺ��룺" + (time));
        Timer timer = new Timer(true);
        UploadTimer uploadTimer = (UploadTimer) context.getBean("uploadTimer");
        timer.schedule(uploadTimer,time);
    }
}
