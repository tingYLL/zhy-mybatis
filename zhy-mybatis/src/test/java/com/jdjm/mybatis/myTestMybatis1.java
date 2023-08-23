package com.jdjm.mybatis;

import com.jdjm.mybatis.pojo.Story;
import com.jdjm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 * @Date 2023-08-06-21:21:15
 */
public class myTestMybatis1 {

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


    //通过SqlSessionUtil工具类获取SqlSession
//    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int count = sqlSession.insert("insertStory");
        System.out.println("插入几条数据:"+count);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * Map传参
     */
//    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("userId",1012);
        map.put("name","哈哈");
        map.put("story","这是故事内容");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.insert("insertStoryByMap",map);
        sqlSession.commit();
        sqlSession.close();;
    }

    /**
     * 实体类传参 完成一次插入
     */
//    @Test
    public void test4(){
        Story story = new Story();
        story.setStory("从前有座山");
        story.setName("huihkhk");
        story.setTag(1);
        story.setUserId(1003232);
        story.setIsDeleted(1);
        story.setCreateAt("2023-11-2");
        story.setUpdateAt("2023-12-2");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        sqlSession.insert("insertStoryByPOJO",story);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除
     */
//    @Test
    public void test5(){
        Story story = new Story();
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int count = sqlSession.delete("deleteRecord", 21);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 更新操作
     */
//    @Test
    public void test6(){
        Story story = new Story();
        story.setId(1);
        story.setStory("从前有座山");
        story.setName("huihkhk");
        story.setTag(1);
        story.setUserId(1003232);
        story.setIsDeleted(1);
        story.setCreateAt("2023-11-2");
        story.setUpdateAt("2023-12-2");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        int count = sqlSession.update("updateRecord", story);
        sqlSession.commit();
        sqlSession.close();
    }
}
