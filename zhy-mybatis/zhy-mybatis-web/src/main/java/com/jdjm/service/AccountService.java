package com.jdjm.service;

import com.jdjm.exceptionn.MoneyNoEnoughException;
import com.jdjm.exceptionn.TransferException;

public interface AccountService {

    public void transfer(String from,String to,Double money) throws MoneyNoEnoughException, TransferException;
}
