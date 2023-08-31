package com.jdjm.mapper;

import com.jdjm.entity.SysRole;
import com.jdjm.vo.SysRoleDTO;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {
    public List<SysRole> queryRole(SysRoleDTO sysRoleDTO);

    public List<SysRole> queryAllRoleOrderBy(String ascOrDesc);

    //批量删除
    public int deleteBatchByIds(String ids);

    //模糊查询
    public List<SysRole> queryRoleByLike(String roleName);

    public int insertAndGetId(SysRole sysRole);

    public Map<String,Object> queryMap(String id);

    public List<Map<String,Object>> queryMapAll();
}
