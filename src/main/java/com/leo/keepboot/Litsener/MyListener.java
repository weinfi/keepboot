package com.leo.keepboot.Litsener;

import com.leo.keepboot.Timer.Schedule;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Description:
 * Created by Liuq on 2019-11-27.
 */
@WebListener
public class MyListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-------hello listener--------");
        final WebApplicationContext wb = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());//‘ÿ»Îweb»›∆˜
        new Schedule().startServer(wb);
    }
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-------see you--------");
    }
}
