package org.wang.goal.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Team {
    private Integer id;
    private String name;
    private Integer grade;
    private Integer point;
    private String value;
    private String leagueType;
    private Date birthday;
    private String address;
    private String homeField;
    private String chiefCoach;
    private Integer captain;
    private Timestamp createTime;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(String leagueType) {
        this.leagueType = leagueType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeField() {
        return homeField;
    }

    public void setHomeField(String homeField) {
        this.homeField = homeField;
    }

    public String getChiefCoach() {
        return chiefCoach;
    }

    public void setChiefCoach(String chiefCoach) {
        this.chiefCoach = chiefCoach;
    }

    public Integer getCaptain() {
        return captain;
    }

    public void setCaptain(Integer captain) {
        this.captain = captain;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", point=" + point +
                ", value='" + value + '\'' +
                ", leagueType='" + leagueType + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", homeField='" + homeField + '\'' +
                ", chiefCoach='" + chiefCoach + '\'' +
                ", captain=" + captain +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                '}';
    }
}
