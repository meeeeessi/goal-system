package org.wang.goal.service;

import org.wang.goal.domain.Player;

import java.sql.Timestamp;
import java.util.List;

public interface IPlayerService {
    List<Player> showAllPlayerData(String email);
    List<Player> queryAllPlayerData();
    void attentionPlayer(String userId, String playerId, Timestamp createTime);
    void updatePlayerInfo(Player player);
    void deletePlayerInfo(String id);
    void deleteAttentionPlayer(String userId, String playerId);
}
