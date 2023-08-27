package com.jdjm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    //一个SqlSessionFactory对应一个environment，所以没有必要每次调用工具类的时候都new 一个SqlSessionFactory 使用静态代码块 在类加载的时候new一个就行了
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    //因此线程池的存在，如果某个线程再次利用的时候，调用get方法的时候 就会得到当前已经关闭的SqlSession，所以必须移除
    public static void removeSqlSession(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
