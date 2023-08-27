package com.jdjm.service.impl;

import com.jdjm.dao.AccountDao;
import com.jdjm.dao.impl.AccountDaoImpl;
import com.jdjm.exceptionn.MoneyNoEnoughException;
import com.jdjm.exceptionn.TransferException;
import com.jdjm.pojo.Account;
import com.jdjm.service.AccountService;
import com.jdjm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    private SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    @Override
    public void transfer(String from,String to,Double money) throws MoneyNoEnoughException,TransferException{
        Account accountFrom = accountDao.selectAccount(from);
        if(accountFrom.getBalance() >= money){
            Account accountTo = accountDao.selectAccount(to);
            accountFrom.setBalance(accountFrom.getBalance() - money);

            //模拟异常
//            String s = null;
//            s.toString();

            accountTo.setBalance(accountTo.getBalance()+money);
            int count = accountDao.updateBalance(accountFrom);
            count += accountDao.updateBalance(accountTo);
            if(count != 2){
                throw new TransferException("未知错误!");
            }
        }else{
            throw new MoneyNoEnoughException("余额不足!");
        }


        /**
         *提交事务，
         * accountFrom.setBalance(accountFrom.getBalance() - money);
         * accountTo.setBalance(accountTo.getBalance()+money);
         * 以上两行代码都执行成功才允许提交 不允许在accountFrom.setBalance或者accountTo.setBalance中做完插入就自己提交了 应该在业务层提交
         * 如果在这两个方法执行期间发生了异常 此时的事务没有提交 数据库中的数据自然不会被修改
         */
        sqlSession.commit();

        //提交完必须解绑ThreadLocal和当前线程的关系，防止线程池利用该线程的时候调用get得到已经关闭的SqlSession对象
        SqlSessionUtil.removeSqlSession(sqlSession);
    }
}
