package com.jdjm.service.impl;

import com.jdjm.dao.AccountDao;
import com.jdjm.dao.impl.AccountDaoImpl;
import com.jdjm.exceptionn.MoneyNoEnoughException;
import com.jdjm.exceptionn.TransferException;
import com.jdjm.pojo.Account;
import com.jdjm.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String from,String to,Double money) throws MoneyNoEnoughException,TransferException{
        Account accountFrom = accountDao.selectAccount(from);
        if(accountFrom.getBalance() >= money){
            Account accountTo = accountDao.selectAccount(to);
            accountFrom.setBalance(accountFrom.getBalance() - money);
            accountTo.setBalance(accountTo.getBalance()+money);
            int count = accountDao.updateBalance(accountFrom);
            count += accountDao.updateBalance(accountTo);
            if(count != 2){
                throw new TransferException("未知错误!");
            }
        }else{
            throw new MoneyNoEnoughException("余额不足!");
        }
    }
}
