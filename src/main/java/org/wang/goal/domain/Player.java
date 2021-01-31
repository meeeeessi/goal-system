package org.wang.goal.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.DateTimeException;

public class Player {
    private Integer id;
    private String name;
    private String team;
    private Integer grade;
    private Integer age;
    private BigDecimal height;
    private BigDecimal weight;
    private Date birthday;
    private String nationality;
    private String value;
    private String position;
    private Integer number;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", birthday=" + birthday +
                ", nationality='" + nationality + '\'' +
                ", value='" + value + '\'' +
                ", position='" + position + '\'' +
                ", number=" + number +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                '}';
    }
}
