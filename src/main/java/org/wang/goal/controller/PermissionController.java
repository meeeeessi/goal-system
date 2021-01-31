package org.wang.goal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wang.goal.domain.Permission;
import org.wang.goal.service.IPermService;

@Controller
@RequestMapping("/perm")
public class PermissionController {

    @Autowired
    IPermService permServiceImpl;

    //权限管理
    @GetMapping("/permManagement")
    public String permManagement(Model model){
        model.addAttribute("allPermInfoList",permServiceImpl.selectAllPermInfo());
        System.out.println(permServiceImpl.selectAllPermInfo());
        return "perm-management";
    }

    //修改权限内容
    @PostMapping("/updatePermInfo")
    public String updatePermInfo(@RequestParam("permId") String permId, @RequestParam("permName") String permName, @RequestParam("permURL") String permURL){
        Permission permission=new Permission();
        permission.setId(Integer.parseInt(permId));
        permission.setName(permName);
        permission.setUrl(permURL);
        permServiceImpl.updatePermInfo(permission);
        return "redirect:/perm/permManagement";
    }

    //删除角色及权限信息
    @GetMapping("/deletePermInfo")
    public String deletePermInfo(@RequestParam("roleId") String roleId, @RequestParam("permId") String permId){
        System.out.println("============="+roleId+"=============="+permId);
        permServiceImpl.deletePermInfoById(Integer.parseInt(roleId),Integer.parseInt(permId));
        return "redirect:/perm/permManagement";
    }

}
