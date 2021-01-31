package org.wang.goal.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wang.goal.domain.Record;
import org.wang.goal.service.INewsService;
import org.wang.goal.service.IRecordService;
import org.wang.goal.utils.DateUtil;
import org.wang.goal.utils.GetAddressUtil;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/com")
public class CommonController {

    private static final String RECORD_LOGOUT_STATUS="退出";

    @Autowired
    private INewsService newsServiceImpl;

    @Autowired
    private IRecordService recordServiceImpl;

    //登录界面
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //注册界面
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    //其他页面返回首页
    @GetMapping("/homePage")
    public String homePage(Model model){
        model.addAttribute("newsList",newsServiceImpl.selectAllNews());
        return "home-page";
    }

    //比赛
    @GetMapping("/showAllContest")
    public String showAllContest(){
        return "contest";
    }

    //退出登陆
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        Record record=new Record();
        record.setUserId(session.getAttribute("emailToken").toString());
        record.setStatus(GetAddressUtil.getAddress()+"     "+RECORD_LOGOUT_STATUS);
        record.setCreateTime(DateUtil.getCurrentDate());
        recordServiceImpl.insertRecord(record);
        subject.logout();
        return "login";
    }

}
