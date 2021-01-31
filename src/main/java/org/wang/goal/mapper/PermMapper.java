package org.wang.goal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wang.goal.domain.Permission;
import org.wang.goal.domain.Role;

import java.util.List;

@Mapper
public interface PermMapper {
    List<Role> selectAllPermInfo();
    void updatePermInfo(Permission permission);
    void deleteRoleInfoById(@Param("roleId") Integer roleId);
    void deletePermInfoById(@Param("permId") Integer permId);
    void deleteRolePermInfoById(@Param("roleId") Integer roleId, @Param("permId") Integer permId);
}
