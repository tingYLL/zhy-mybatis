package com.jdjm.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;

    //一个SqlSessionFactory对应一个environment，所以没有必要每次调用工具类的时候都new 一个SqlSessionFactory 使用静态代码块 在类加载的时候new一个就行了
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
