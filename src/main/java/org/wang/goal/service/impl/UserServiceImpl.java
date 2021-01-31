package org.wang.goal.service.impl;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.goal.domain.Player;
import org.wang.goal.domain.Role;
import org.wang.goal.domain.Team;
import org.wang.goal.domain.User;
import org.wang.goal.mapper.UserMapper;
import org.wang.goal.service.IUserService;
import org.wang.goal.utils.DateUtil;
import org.wang.goal.utils.SaltUtil;
import org.wang.goal.utils.UUIDUtil;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerUser(User user) {
        //1.生成随机盐
        String salt=SaltUtil.getSalt(8);
        //2.将随机盐保存到数据库
        user.setSalt(salt);
        //3.明文密码进行MD5+salt+hash散列
        Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());

        user.setId(UUIDUtil.getUUID());
        user.setCreateTime(DateUtil.getCurrentDate());
        user.setCreateBy(user.getName());
        userMapper.registerUser(user);
    }

    @Override
    public User selectUserByEmail(String name) {
        return userMapper.selectUserByEmail(name);
    }

    @Override
    public User selectRolesByEmail(String email) {
        return userMapper.selectRolesByEmail(email);
    }

    @Override
    public List<User<Role>> selectAllUserInfo() {
        return userMapper.selectAllUserInfo();
    }

    @Override
    public User<Team> selectAllUserTeamInfo(String email) {
        return userMapper.selectAllUserTeamInfo(email);
    }

    @Override
    public User<Player> selectAllUserPlayerInfo(String email) {
        return userMapper.selectAllUserPlayerInfo(email);
    }

    @Override
    public User selectUserDetailInfo(String email) {
        return userMapper.selectUserDetailInfo(email);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    @Override
    public void deleteUserByEmail(String email) {
        userMapper.deleteUserByEmail(email);
    }

    @Override
    public void deleteAttentionTeam(String email, String teamId) {
        userMapper.deleteAttentionTeam(email, teamId);
    }

    @Override
    public void deleteAttentionPlayer(String email, String playerId) {
        userMapper.deleteAttentionPlayer(email, playerId);
    }
}
