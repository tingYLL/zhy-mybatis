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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int count = sqlSession.insert("insertStory");
        System.out.println("成功插入记录数:"+count);

        //记得手动提交
        sqlSession.commit();
    }
}
