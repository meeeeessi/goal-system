package org.wang.goal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wang.goal.domain.Player;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PlayerMapper {
    List<Player> showAllPlayerData(String email);
    List<Player> queryAllPlayerData();
    void attentionPlayer(String userId, String playerId, Timestamp createTime);
    void updatePlayerInfo(Player player);
    void deletePlayerInfo(String id);
    void deleteAttentionPlayer(String userId, String playerId);
}
