package org.wang.goal.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wang.goal.domain.Record;
import org.wang.goal.domain.User;
import org.wang.goal.service.INewsService;
import org.wang.goal.service.IRecordService;
import org.wang.goal.service.IUserService;
import org.wang.goal.utils.DateUtil;
import org.wang.goal.utils.GetAddressUtil;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final String RECORD_LOGIN_STATUS="登陆";

    @Autowired
    private IUserService userServiceImpl;

    @Autowired
    private INewsService newsServiceImpl;

    @Autowired
    private IRecordService recordServiceImpl;

    //登录
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session){
        //获取主体对象
        Subject subject= SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(email,password));
        model.addAttribute("newsList",newsServiceImpl.selectAllNews());
        session.setAttribute("emailToken",email);
        Record record=new Record();
        record.setUserId(email);
        record.setStatus(GetAddressUtil.getAddress()+"     "+RECORD_LOGIN_STATUS);
        record.setCreateTime(DateUtil.getCurrentDate());
        recordServiceImpl.insertRecord(record);
        return "home-page";
    }

    //注册
    @PostMapping("/register")
    public String registerUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password){
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userServiceImpl.registerUser(user);
        return "redirect:/com/login";
    }

    //关注
    @GetMapping("/attention")
    public String attention(Model model,HttpSession session){

        model.addAttribute("attentionTeam",userServiceImpl.selectAllUserTeamInfo(session.getAttribute("emailToken").toString()));
        model.addAttribute("attentionPlayer",userServiceImpl.selectAllUserPlayerInfo(session.getAttribute("emailToken").toString()));

        return "attention";
    }

    //取关
    @GetMapping("/deleteAttention")
    public String deleteAttention(@RequestParam("id") String id,@RequestParam("type") String type,HttpSession session){
        if(type.equals("球队")){
            userServiceImpl.deleteAttentionTeam(session.getAttribute("emailToken").toString(),id);
        }else if (type.equals("球员")){
            userServiceImpl.deleteAttentionPlayer(session.getAttribute("emailToken").toString(),id);
        }
        return "redirect:/user/attention";
    }

    //根据用户email查询用户详细信息
    @GetMapping("/information")
    public String information(Model model,HttpSession session){
        model.addAttribute("userInfo",userServiceImpl.selectUserDetailInfo(session.getAttribute("emailToken").toString()));
        return "information";
    }

    //用户修改个人详细信息
    @PostMapping("/updateUserInfoByEmail")
    public String updateUserInfoByEmail(User user){
        userServiceImpl.updateUserInfo(user);
        return "redirect:/user/information";
    }

    //用户管理
    @GetMapping("/userManagement")
    public String selectAllUserInfo(Model model){
        model.addAttribute("allUserInfoList",userServiceImpl.selectAllUserInfo());
        return "user-management";
    }

    //编辑
    @GetMapping("/edit")
    public String edit(){
        return "edit";
    }


    //超级管理员：用户信息修改
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail, @RequestParam("userTime") String userTime, @RequestParam("roleName") String roleName) throws ParseException, JSONException {
        User user=new User();
        user.setName(userName);
        user.setEmail(userEmail);
        user.setCreateTime(DateUtil.typeSwitch(userTime));
        userServiceImpl.updateUserInfo(user);
        return "redirect:/user/userManagement";
    }

    @GetMapping("/deleteUserInfo")
    public String deleteUserInfo(@RequestParam("email") String email){
        System.out.println("--------------delete-------------"+email);
        userServiceImpl.deleteUserByEmail(email);
        return "redirect:/user/userManagement";
    }

    //记录查询
    @GetMapping("/selectRecord")
    public String selectRecord(Model model){
        model.addAttribute("recordList",recordServiceImpl.selectRecord());
        return "record";
    }

}
