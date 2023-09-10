package com.jdjm;

import com.jdjm.entity.Student;
import com.jdjm.mapper.StudentMapper;
import com.jdjm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class StudentMapperTest {

    @Test
    public void testqueryStudent(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryStudent(1);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testqueryStudentAssociation(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentAssociation(1);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testqueryStudentBySet(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentBySet(1);
        System.out.println(student);
        sqlSession.close();
    }
}
