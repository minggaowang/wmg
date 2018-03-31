package com.wmg.service.impl;

import com.wmg.service.SystemStartUpListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------------------------------
 * <h4>Copyright (C) All rights reserved by BetaSoft</h4>
 * <p/>
 * Developer: guoxin
 * Date: 13-7-4 下午12:44
 * <p/>
 * Change Description
 * <p/>
 * ------------------------------------------------
 */
@Service
public class StartUpService extends InstantiationAwareBeanPostProcessorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(StartUpService.class);

    private List<SystemStartUpListener> systemStartListeners = new ArrayList<SystemStartUpListener>();

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) {

         if(bean instanceof SystemStartUpListener){
             systemStartListeners.add((SystemStartUpListener) bean);
         }
        return true;
    }

    public void startUp(ApplicationContext context) {

        for(SystemStartUpListener listener:systemStartListeners){

            listener.startUp(context);
        }
    }
}
