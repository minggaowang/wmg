package com.wmg.service;

import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: guoxin
 * Date: 14-2-28
 * Time: 下午2:56
 * To change this template use File | Settings | File Templates.
 */
public interface SystemStartUpListener {

    public void startUp(ApplicationContext context);
}
