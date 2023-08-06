package com.jdjm.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-08-06-21:21:15
 */
public class myTestMybatis1 {
    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            int count = sqlSession.insert("insertStory");
            System.out.println("成功插入记录数:"+count);

            //如果没有发生异常 就提交
            sqlSession.commit();
        } catch (Exception e) {
            if(sqlSession !=null){
                sqlSession.rollback();
            }
        } finally {
            //关闭会话 释放资源
            if(sqlSession !=null){
                sqlSession.rollback();
            }
        }

    }
}
