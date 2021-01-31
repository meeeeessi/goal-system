package org.wang.goal.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wang.goal.domain.Player;
import org.wang.goal.service.IPlayerService;
import org.wang.goal.utils.DateUtil;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private IPlayerService playerServiceImpl;

    //球员
    @GetMapping("/showAllPlayerData")
    public String showAllPlayerData(Model model,HttpSession session){
        model.addAttribute("playerDataList",playerServiceImpl.showAllPlayerData(session.getAttribute("emailToken").toString()));
        return "player-data";
    }

    //球员管理
    @GetMapping("/playerManagement")
    public String playerManagement(Model model){
        model.addAttribute("playerDetailDataList",playerServiceImpl.queryAllPlayerData());
        return "player-management";
    }

    //关注or取关球队
    @PostMapping("/playerStatus")
    @ResponseBody
    public String teamStatus(@Param("playerId") String playerId, @Param("status") String status, HttpSession session){

        if(status.equals("关注")){
            playerServiceImpl.attentionPlayer(session.getAttribute("emailToken").toString(),playerId, DateUtil.getCurrentDate());
            return "{\"result\":\"已关注\"}";
        }else if (status.equals("已关注")){
            playerServiceImpl.deleteAttentionPlayer(session.getAttribute("emailToken").toString(),playerId);
            return "{\"result\":\"关注\"}";
        }
        return "error";
    }

    //修改球员信息
    @PostMapping("/updatePlayerInfo")
    public String updatePlayerInfo(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("team") String team,@RequestParam("age") String age,@RequestParam("value") String value,@RequestParam("number") String number){
        Player player=new Player();
        player.setId(Integer.parseInt(id));
        player.setName(name);
        player.setTeam(team);
        player.setAge(Integer.parseInt(age));
        player.setValue(value);
        player.setNumber(Integer.parseInt(number));
        playerServiceImpl.updatePlayerInfo(player);
        return "redirect:/player/playerManagement";
    }

    //删除球员信息
    @GetMapping("/deletePlayerInfo")
    public String deletePlayerInfo(@RequestParam("id") String id){
        playerServiceImpl.deletePlayerInfo(id);
        return "redirect:/player/playerManagement";
    }

}
