package com.wmg.util;

import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: guoxin
 * Date: 14-1-21
 * Time: 下午9:31
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContextUtils {

    private static ApplicationContext ac = null;

    public static void setApplicationContext(ApplicationContext context) {
        assert context != null;
        ac = context;
    }

    public static <T> T getBean(String name) {
        T t = (T) ac.getBean(name);
        return t;
    }

    public static <T> T getBean(Class<? extends T> cls) {
        T t = (T) ac.getBean(cls);
        return t;
    }
}
