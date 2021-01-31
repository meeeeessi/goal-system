package org.wang.goal.controller;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wang.goal.domain.Team;
import org.wang.goal.service.INewsService;
import org.wang.goal.service.ITeamService;
import org.wang.goal.utils.DateUtil;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private ITeamService teamServiceImpl;

    //球队
    @GetMapping("/showAllTeamData")
    public String showAllTeamData(Model model, HttpSession session){
        model.addAttribute("teamDataList",teamServiceImpl.showAllTeamData(session.getAttribute("emailToken").toString()));
        return "team-data";
    }

    //球队管理
    @GetMapping("/teamManagement")
    public String teamManagement(Model model){
        model.addAttribute("teamDetailDataList",teamServiceImpl.queryAllTeamData());
        return "team-management";
    }

    //关注or取关球队
    @PostMapping("/teamStatus")
    @ResponseBody
    public String teamStatus(@Param("teamId") String teamId, @Param("status") String status, HttpSession session){
        System.out.println(teamId);
        System.out.println(status);

        if(status.equals("关注")){
            teamServiceImpl.attentionTeam(session.getAttribute("emailToken").toString(),teamId, DateUtil.getCurrentDate());
            return "{\"result\":\"已关注\"}";
        }else if (status.equals("已关注")){
            teamServiceImpl.deleteAttentionTeam(session.getAttribute("emailToken").toString(),teamId);
            return "{\"result\":\"关注\"}";
        }
        return "error";
    }

    @PostMapping("/updateTeamInfo")
    public String updateTeamInfo(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("leagueType") String leagueType,@RequestParam("birthday") String birthday,@RequestParam("address") String address,@RequestParam("homeField") String homeField){
        Team team=new Team();
        team.setId(Integer.parseInt(id));
        team.setName(name);
        team.setLeagueType(leagueType);
        team.setBirthday(Date.valueOf(birthday));
        team.setAddress(address);
        team.setHomeField(homeField);
        teamServiceImpl.updateTeamInfo(team);
        return "redirect:/team/teamManagement";
    }

    @GetMapping("/deleteTeamInfo")
    public String deleteTeamInfo(@RequestParam("id") String id){
        teamServiceImpl.deleteTeamInfo(id);
        return "redirect:/team/teamManagement";
    }

}
