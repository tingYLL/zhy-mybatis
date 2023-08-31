package com.jdjm;

import com.jdjm.entity.SysRole;
import com.jdjm.mapper.SysRoleMapper;
import com.jdjm.utils.SqlSessionUtil;
import com.jdjm.vo.SysRoleDTO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testSysRole {



    @Test
    public void testQueryRole(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
        SysRoleDTO sysRoleDTO = new SysRoleDTO();
        sysRoleDTO.setRoleName("系统管理员");
        List<SysRole> list = mapper.queryRole(sysRoleDTO);
        for(SysRole sysRole:list){
            System.out.println(sysRole);
        }
        sqlSession.close();
    }


    @Test
    public void queryAllRoleOrderBy(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
        List<SysRole> list = mapper.queryAllRoleOrderBy("asc");
        list.forEach(sysRole -> System.out.println(sysRole));
        sqlSession.close();
    }

    @Test
    public void deleteBatchByIds(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
        int count = mapper.deleteBatchByIds("1,2,8");
        System.out.println("删除了几条记录"+count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testQueryRoleByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
        List<SysRole> list = mapper.queryRoleByLike("用户");
        list.forEach(sysRole -> System.out.println(sysRole));
        sqlSession.close();
    }

    @Test
    public void testInsertAndGetId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("刘备");
        sysRole.setRoleCode("007");
        sysRole.setDescription("hhhh");
        int count = mapper.insertAndGetId(sysRole);
        System.out.println(sysRole);
        sqlSession.commit();
        sqlSession.close();
    }


    //用Map获得查询结果 dang
    @Test
    public void testQueryMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
        Map<String, Object> map = mapper.queryMap("1695366190980997123");
        System.out.println(map);
    }

    @Test
    public void testQueryAllMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysRoleMapper mapper = sqlSession.getMapper(SysRoleMapper.class);
        List<Map<String, Object>> maps = mapper.queryMapAll();
        System.out.println(maps);
    }

}
