package com.jdjm.dao.impl;

import com.jdjm.dao.AccountDao;
import com.jdjm.pojo.Account;
import com.jdjm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-08-23-14:05:39
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectAccount(String accountNO) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Account account = sqlSession.selectOne("account.selectAccount",accountNO);

        //查询不用commit
        sqlSession.close();
        return account;
    }

    @Override
    public int updateBalance(Account account) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int count = sqlSession.update("account.updateBalance", account);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

}
