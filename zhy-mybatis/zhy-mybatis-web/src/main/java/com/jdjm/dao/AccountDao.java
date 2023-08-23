package com.jdjm.dao;

import com.jdjm.pojo.Account;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-08-23-14:03:33
 */
public interface AccountDao {

    public Account selectAccount(String accountNO);

    public int updateBalance(Account account);
}
