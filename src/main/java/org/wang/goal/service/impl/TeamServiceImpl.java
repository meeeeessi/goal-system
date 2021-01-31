package org.wang.goal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.goal.domain.Team;
import org.wang.goal.mapper.TeamMapper;
import org.wang.goal.service.ITeamService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Team> showAllTeamData(String email) {
        return teamMapper.showAllTeamData(email);
    }

    @Override
    public List<Team> queryAllTeamData() {
        return teamMapper.queryAllTeamData();
    }

    @Override
    public void attentionTeam(String userId, String teamId, Timestamp createTime) {
        teamMapper.attentionTeam(userId,teamId,createTime);
    }

    @Override
    public void updateTeamInfo(Team team) {
        teamMapper.updateTeamInfo(team);
    }

    @Override
    public void deleteTeamInfo(String id) {
        teamMapper.deleteTeamInfo(id);
    }

    @Override
    public void deleteAttentionTeam(String userId, String teamId) {
        teamMapper.deleteAttentionTeam(userId,teamId);
    }
}
