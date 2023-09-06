package com.jdjm;

import com.jdjm.entity.SysRole;
import com.jdjm.mapper.DynamicSqlMapper;
import com.jdjm.utils.SqlSessionUtil;
import com.jdjm.vo.SysRoleDTO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyTest {

    @Test
    public void testQueryRole(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
//        List<SysRole> sysRoles = mapper.queryRole(new SysRoleDTO("管理员", "SYSTEM", "管理员"));

        //测试当三个查询条件都为空的时候 where标签是否可以实现不生成 where 关键字的效果
//        List<SysRole> sysRoles = mapper.queryRole(new SysRoleDTO("", "", ""));

//      测试
        List<SysRole> sysRoles = mapper.queryRole(new SysRoleDTO("", "SYSTEM", "管理员"));

        sysRoles.forEach(System.out::println);
    }


    @Test
    public void testQueryRoleByTrim(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
//        List<SysRole> sysRoles = mapper.queryRoleByTrim(new SysRoleDTO("", "SYSTEM", "管理员"));
//        List<SysRole> sysRoles = mapper.queryRole(new SysRoleDTO("", "", ""));
        List<SysRole> sysRoles = mapper.queryRole(new SysRoleDTO("管理员", "", null));
        sysRoles.forEach(System.out::println);
    }
}
