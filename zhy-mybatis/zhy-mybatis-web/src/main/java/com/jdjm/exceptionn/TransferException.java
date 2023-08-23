package com.jdjm.exceptionn;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-08-23-15:25:51
 */
public class TransferException extends Exception{
    public TransferException(){}
    public TransferException(String message){
        super(message);
    }
}
