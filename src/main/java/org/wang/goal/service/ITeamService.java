package org.wang.goal.service;

import org.wang.goal.domain.Team;

import java.sql.Timestamp;
import java.util.List;

public interface ITeamService {

    List<Team> showAllTeamData(String email);

    List<Team> queryAllTeamData();

    void attentionTeam(String userId, String teamId, Timestamp createTime);

    void updateTeamInfo(Team team);

    void deleteTeamInfo(String id);

    void deleteAttentionTeam(String userId, String teamId);

}
