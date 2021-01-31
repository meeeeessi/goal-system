package org.wang.goal.service;

import org.wang.goal.domain.Player;
import org.wang.goal.domain.Role;
import org.wang.goal.domain.Team;
import org.wang.goal.domain.User;

import java.util.List;

public interface IUserService {

    //注册用户
    void registerUser(User user);

    //根据email查询用户是否已存在
    User selectUserByEmail(String email);

    //根据email查询用户所有角色
    User selectRolesByEmail(String email);

    //查询所有用户及角色基本信息
    List<User<Role>> selectAllUserInfo();

    //查询所有用户及关注球队信息
    User<Team> selectAllUserTeamInfo(String email);

    //查询所有用户及关注球员信息
    User<Player> selectAllUserPlayerInfo(String email);

    //根据email查询用户详细信息
    User selectUserDetailInfo(String email);

    //用户信息修改
    void updateUserInfo(User user);

    //删除用户信息
    void deleteUserByEmail(String email);

    //用户取关球队
    void deleteAttentionTeam(String email,String teamId);

    //用户取关球员
    void deleteAttentionPlayer(String email,String playerId);

}
