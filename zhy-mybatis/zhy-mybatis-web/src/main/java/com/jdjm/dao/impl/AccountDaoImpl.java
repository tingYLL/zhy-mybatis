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
//        sqlSession.close();
        return account;
    }

    @Override
    public int updateBalance(Account account) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int count = sqlSession.update("account.updateBalance", account);


        /**
         * sqlSession的关闭移到service层中了
         * 改进后使用ThreadLocal的方式获得SqlSession，controller调service，service调dao，这三个层的方法都是处于同一个线程中的
         * ThreadLocal以线程为key，SqlSession为value，所以就可以实现这三个层使用的是同一个SqlSession
         * 之所以在service处于SqlSession的关闭是因为 在dao层做crud的时候如果发送错误，然后又提交的话会导致数据库中数据错误
         * 比如a扣了钱但b没有加钱
         */
//        sqlSession.commit();
//        sqlSession.close();
        return count;
    }

}
