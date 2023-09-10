package com.jdjm;

import com.jdjm.entity.SysRole;
import com.jdjm.mapper.DynamicSqlMapper;
import com.jdjm.utils.SqlSessionUtil;
import com.jdjm.vo.SysRoleDTO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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


    @Test
    public void testUpdateBySet(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        SysRole sysRole = new SysRole("1695366190980997125",null,"SYSTEM",
                null,null,null,null);
        Boolean aBoolean = mapper.updateBySet(sysRole);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        SysRoleDTO sysRoleDTO = new SysRoleDTO("", "SYSTEM", null);
//        SysRoleDTO sysRoleDTO = new SysRoleDTO("管理员", "SYSTEM", null);
        List<SysRole> sysRoles = mapper.queryByChoose(sysRoleDTO);
        sysRoles.forEach(sysRole -> System.out.println(sysRole));
    }

//    foreach标签 批量删除
    @Test
    public void testdelByBatchForeach(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        String[] ids = {"1695366190980997129","1695366190980997130","1695366190980997131"};
        int count = mapper.delByBatchForeach(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testinsertBatchByForeach(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<SysRole> list = new ArrayList<>();
        SysRole sysRole1 = new SysRole();
        sysRole1.setRoleName("徐晃来也");
        sysRole1.setRoleCode("SYSTEM");

        SysRole sysRole2 = new SysRole();
        sysRole2.setRoleCode("COMMON");
        sysRole2.setRoleName("麻花");

        list.add(sysRole1);
        list.add(sysRole2);

        int i = mapper.insertBatchByForeach(list);
        sqlSession.commit(); sqlSession.close();
    }



    @Test
    public void testdelByBatchForeachOr(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        String[] ids = {"1695366190980997129","1695366190980997130","1695366190980997131"};
        int count = mapper.delByBatchForeachOr(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}
