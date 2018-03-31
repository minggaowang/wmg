package com.wmg.exception;

/**
 * Created by wangminggao on 2016/1/7.
 */
public class ServiceHandleException extends RuntimeException {
    private String msgDes;  //异常对应的描述信息

    public ServiceHandleException() {
    }

    public ServiceHandleException(String message) {
        super(message);
         if(message.contains(":")){
             String[] msgs = message.split(":");
             msgDes = msgs[1];
         }
    }

    public ServiceHandleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceHandleException(Throwable cause) {
        super(cause);
    }

    public ServiceHandleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getMsgDes() {
        return msgDes;
    }
}
