package com.jdjm;

import com.jdjm.entity.Student;
import com.jdjm.mapper.StudentMapper;
import com.jdjm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class StudentMapperTest {

    //多对一级联
    @Test
    public void testqueryStudent(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryStudent(1);
        System.out.println(student);
        sqlSession.close();
    }

    //多对一 association
    @Test
    public void testqueryStudentAssociation(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentAssociation(1);
        System.out.println(student);
        sqlSession.close();
    }

    //测试多对一之分步查询
    @Test
    public void testqueryStudentBySet(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentBySet(1);
        System.out.println(student);
        sqlSession.close();
    }

    //多对一 分步查询懒加载
    @Test
    public void testqueryStudentBySetLazy(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentBySetLazy(1);
//        System.out.println(student);
// TODO       只输出学生的名字，就不会执行另一条sql（因为只靠第一条sql就可以拿到学生的姓名 注意看控制台输出）但是如果输出整个学生对象(整个学生对象包含Clazz班级对象,此时
//  现需要通过另一条sql得到)的话就会两条sql都执行
        System.out.println(student.getName());
        sqlSession.close();
    }
}
