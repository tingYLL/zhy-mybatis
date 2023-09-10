package com.jdjm.mapper;

import com.jdjm.entity.SysRole;
import com.jdjm.vo.SysRoleDTO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface DynamicSqlMapper {

    public List<SysRole> queryRole(@Param("vo") SysRoleDTO sysRoleDTO);

    public List<SysRole> queryRoleByTrim(@Param("vo") SysRoleDTO sysRoleDTO);


//    测试动态sql的set标签的使用
    public Boolean updateBySet(@Param("vo")SysRole sysRole);

//    测试choose标签的使用
    public List<SysRole> queryByChoose(@Param("vo") SysRoleDTO sysRoleDTO);

//    foreach标签 批量插入
    public int insertBatchByForeach(@Param("list") List<SysRole> list);

//    foreach标签 批量删除  （in）
    public int delByBatchForeach(@Param("ids") String[] ids);

//    foreach标签的 批量删除(or方式)
    public int delByBatchForeachOr(@Param("ids") String[] ids);
}
