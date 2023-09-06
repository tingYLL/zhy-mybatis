package com.jdjm.mapper;

import com.jdjm.entity.SysRole;
import com.jdjm.vo.SysRoleDTO;
import org.apache.ibatis.annotations.MapKey;

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

    //通过map封装查询结果
    public Map<String,Object> queryMap(String id);

    //通过List<Map>封装查询结果
    public List<Map<String,Object>> queryMapAll();

    @MapKey("role_name")
//    @MapKey("id")
    public Map<String,Map<String,Object>> queryMapBigAll();

    //通过<resultMap>做表字段与实体类属性的隐射
    public List<SysRole> queryByResultMap();

    //开启了驼峰命名自动映射以后
    public List<SysRole> queryAllAuto();
}
