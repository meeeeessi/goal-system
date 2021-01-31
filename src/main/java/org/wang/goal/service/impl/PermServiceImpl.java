package org.wang.goal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.goal.domain.Permission;
import org.wang.goal.domain.Role;
import org.wang.goal.mapper.PermMapper;
import org.wang.goal.service.IPermService;

import java.util.List;

@Service
public class PermServiceImpl implements IPermService {

    @Autowired
    PermMapper permMapper;

    @Override
    public List<Role> selectAllPermInfo() {
        return permMapper.selectAllPermInfo();
    }

    @Override
    public void updatePermInfo(Permission permission) {
        permMapper.updatePermInfo(permission);
    }

    @Override
    public void deletePermInfoById(Integer roleId, Integer permId) {
        permMapper.deleteRoleInfoById(roleId);
        permMapper.deletePermInfoById(permId);
        permMapper.deleteRolePermInfoById(roleId, permId);
    }
}
