package com.jdjm.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class myTestMybatis1 {
    public static void main(String[] args) throws IOException {
        //注意别导错Resources  不用Resources也可以用new InputStream("mybatis-config.xml")的方式 效果一样
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //这边如果调用openSessoin如果设置了true，则下面sqlSession.commit();这行就不用写了；因为设置为true
        //代表的就是自动提交，但是自动提交也就没有了事务，所以不推荐这样写
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int count = sqlSession.insert("insertStory");
        System.out.println("成功插入记录数:"+count);

        //记得手动提交
        sqlSession.commit();
    }
}
