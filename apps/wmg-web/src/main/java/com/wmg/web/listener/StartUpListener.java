package com.wmg.web.listener;


import com.wmg.service.impl.StartUpService;
import com.wmg.util.ApplicationContextUtils;
import com.wmg.util.TimerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.TimeUnit;


public class StartUpListener implements ServletContextListener, Runnable {

    private static final Logger logger = LoggerFactory.getLogger(StartUpListener.class);
    private ApplicationContext ac;

    public void run() {
        StartUpService startUpService = ApplicationContextUtils.getBean("startUpService");
        startUpService.startUp(ac);
    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        ac = WebApplicationContextUtils.getWebApplicationContext(context);
        ApplicationContextUtils.setApplicationContext(ac);
        logger.info(context.getContextPath());
        TimerUtils.setTimeout(this, 10, TimeUnit.SECONDS);
    }

    public void contextDestroyed(ServletContextEvent event) {

    }
}
