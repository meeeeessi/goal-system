package org.wang.goal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wang.goal.domain.Team;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface TeamMapper {

    List<Team> showAllTeamData(String email);

    List<Team> queryAllTeamData();

    void attentionTeam(String userId, String teamId, Timestamp createTime);

    void updateTeamInfo(Team team);

    void deleteTeamInfo(String id);

    void deleteAttentionTeam(String userId, String teamId);

}
