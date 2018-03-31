package com.wmg.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: guoxin
 * Date: 14-2-28
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class TimerUtils {

    private static final Logger logger = LoggerFactory.getLogger(TimerUtils.class);

    private final static ConcurrentHashMap<String, ScheduledFuture> map = new ConcurrentHashMap<String, ScheduledFuture>();
    private final static ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("异步任务集-" + r.toString());
            return thread;
        }
    });

    static {
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                List<String> list = new ArrayList<String>();

                for (ConcurrentHashMap.Entry<String, ScheduledFuture> entry : map.entrySet()) {
                    ScheduledFuture future = entry.getValue();
                    if (future.isDone()) {
                        list.add(entry.getKey());
                    }
                }
                if (list.size() > 0) {
                    logger.info("从定时器中移除已经完成的任务:" + list);
                }

                for (String key : list) {
                    map.remove(key);
                }
            }
        }, 1, 1, TimeUnit.MINUTES);
    }

    /**
     * 延迟执行一个任务
     *
     * @param runnable
     * @param delay
     * @param timeUnit
     * @return
     */
    public static String setTimeout(Runnable runnable, long delay, TimeUnit timeUnit) {

        String id = UUID.randomUUID().toString();
        return setTimeout(id, runnable, delay, timeUnit);
    }

    public static String setTimeout(Runnable runnable, long delay) {
        return setTimeout(runnable, delay, TimeUnit.MILLISECONDS);
    }

    public static String setTimeout(Runnable runnable) {
        return setTimeout(runnable, 0);
    }

    /**
     * 延迟执行一个指定任务
     * 如果任务已经添加,则取消先前任务
     *
     * @param id
     * @param runnable
     * @param delay
     * @param timeUnit
     * @return
     */
    public static String setTimeout(String id, Runnable runnable, long delay, TimeUnit timeUnit) {


        clearTimeout(id);
        logger.info("添加一个延时任务:id=" + id + " delay=" + delay + " timeUnit=" + timeUnit + "  runnable=" + runnable);
        ScheduledFuture future = service.schedule(runnable, delay, timeUnit);
        map.put(id, future);
        return id;
    }

    public static String setTimeout(String id, Runnable runnable, long delay) {
        return setTimeout(id, runnable, delay, TimeUnit.MILLISECONDS);
    }

    public static String setTimeout(String id, Runnable runnable) {
        return setTimeout(id, runnable, 0);
    }


    public static void clearTimeout(String id) {


        ScheduledFuture future = map.remove(id);
        if (future != null) {
            try {

                boolean b = future.cancel(true);
                logger.info("取消一个延时任务:id=" + id + " 状态(如果无法取消任务，则返回false，这通常是由于它已经正常完成;否则返回true)=" + b);
            } catch (Exception e) {
                logger.error("取消一个延时任务异常:id=" + id, e);
            }
        }
    }

    /**
     * 延迟执行一个任务
     *
     * @param runnable
     * @param delay
     * @param timeUnit
     * @return
     */
    public static String setInterval(Runnable runnable, long initialDelay, long delay, TimeUnit timeUnit) {

        String id = UUID.randomUUID().toString();
        return setInterval(id, runnable, initialDelay, delay, timeUnit);
    }

    public static String setInterval(Runnable runnable, long delay) {
        return setInterval(runnable, 0, delay, TimeUnit.MILLISECONDS);
    }


    /**
     * 延迟执行一个指定任务
     * 如果任务已经添加,则取消先前任务
     *
     * @param id
     * @param runnable
     * @param delay
     * @param timeUnit
     * @return
     */
    public static String setInterval(String id, Runnable runnable, long initialDelay, long delay, TimeUnit timeUnit) {


        clearInterval(id);
        logger.info("添加一个定时任务:id=" + id + " delay=" + delay + " timeUnit=" + timeUnit + "  runnable=" + runnable);
        ScheduledFuture future = service.scheduleWithFixedDelay(runnable, initialDelay, delay, timeUnit);
        map.put(id, future);
        return id;
    }

    public static String setInterval(String id, Runnable runnable, long delay) {
        return setInterval(id, runnable, 0, delay, TimeUnit.MILLISECONDS);
    }

    public static void clearInterval(String id) {


        ScheduledFuture future = map.remove(id);
        if (future != null) {
            try {
                logger.info("取消一个定时任务:id=" + id);
                future.cancel(true);
            } catch (Exception e) {
                logger.error("取消一个定时任务异常:id=" + id, e);
            }
        }
    }

    static int index = 0;
    public static void main(String[] args){

        System.out.println("index=" + index++ + " " + System.currentTimeMillis()/1000);
        TimerUtils.setInterval("测试interval方法", new Runnable() {

            @Override
            public void run() {
                System.out.println("index=" + index++ + " " + System.currentTimeMillis()/1000);
            }
        }, 2, 4, TimeUnit.SECONDS);
    }
}
