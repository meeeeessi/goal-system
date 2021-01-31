package org.wang.goal.service;

import org.apache.ibatis.annotations.Param;
import org.wang.goal.domain.Permission;
import org.wang.goal.domain.Role;

import java.util.List;

public interface IPermService {
    List<Role> selectAllPermInfo();
    void updatePermInfo(Permission permission);
    void deletePermInfoById(Integer roleId,Integer permId);
}
