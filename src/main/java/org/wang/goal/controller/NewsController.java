package org.wang.goal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wang.goal.domain.News;
import org.wang.goal.service.INewsService;
import org.wang.goal.utils.DateUtil;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsServiceImpl;

    @GetMapping("/selectAllNews")
    public String selectAllNews(){
        return "homePage";
    }

    //新闻管理
    @GetMapping("/newsManagement")
    public String newsManagement(Model model){
        model.addAttribute("allNewsInfoList",newsServiceImpl.selectAllPermInfo());
        return "news-management";
    }

    //新闻修改
    @PostMapping("/updateNewsInfo")
    public String updateNewsInfo(@RequestParam("id") String id,@RequestParam("newsTitle") String newsTitle,@RequestParam("author") String author,@RequestParam("publishTime") String publishTime) throws ParseException {
        newsServiceImpl.updateNewsInfo(id,newsTitle,author, DateUtil.typeSwitch(publishTime));
        return "redirect:/news/newsManagement";
    }

    //新闻删除
    @GetMapping("/deleteNewsInfo")
    public String deleteNewsInfo(@RequestParam("id") String id){
        newsServiceImpl.deleteNewsInfo(id);
        return "redirect:/news/newsManagement";
    }

}
