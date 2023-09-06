package com.jdjm.mapper;

import com.jdjm.entity.SysRole;
import com.jdjm.vo.SysRoleDTO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface DynamicSqlMapper {

    public List<SysRole> queryRole(@Param("vo") SysRoleDTO sysRoleDTO);
}
