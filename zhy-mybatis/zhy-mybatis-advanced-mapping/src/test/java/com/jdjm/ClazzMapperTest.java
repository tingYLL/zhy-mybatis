package com.jdjm;

import com.jdjm.entity.Clazz;
import com.jdjm.entity.Student;
import com.jdjm.mapper.ClazzMapper;
import com.jdjm.mapper.StudentMapper;
import com.jdjm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class ClazzMapperTest {
    @Test
    public void testqueryClazz(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.queryClazz(1000);
        System.out.println(clazz);
        sqlSession.close();
    }
}
