package com.jdjm.exceptionn;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-08-23-15:11:36
 */
public class MoneyNoEnoughException extends Exception{
    public MoneyNoEnoughException(){}
    public MoneyNoEnoughException(String message){
        super(message);
    }
}
