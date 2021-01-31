package org.wang.goal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.goal.domain.Player;
import org.wang.goal.mapper.PlayerMapper;
import org.wang.goal.service.IPlayerService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public List<Player> showAllPlayerData(String email) {
        return playerMapper.showAllPlayerData(email);
    }

    @Override
    public List<Player> queryAllPlayerData() {
        return playerMapper.queryAllPlayerData();
    }

    @Override
    public void attentionPlayer(String userId, String playerId, Timestamp createTime) {
        playerMapper.attentionPlayer(userId, playerId, createTime);
    }

    @Override
    public void updatePlayerInfo(Player player) {
        playerMapper.updatePlayerInfo(player);
    }

    @Override
    public void deletePlayerInfo(String id) {
        playerMapper.deletePlayerInfo(id);
    }

    @Override
    public void deleteAttentionPlayer(String userId, String playerId) {
        playerMapper.deleteAttentionPlayer(userId, playerId);
    }
}
