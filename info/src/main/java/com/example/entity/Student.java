package com.example.entity;

import org.springframework.dao.DataAccessException;


public class Student {
    private Integer id;
    private String name;
    private Integer sex;
    private String birth;
    private Integer time;
    private Integer score1;
    private Integer score2;
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Integer getSex(){
        return sex;
    }
    public void setSex(Integer sex){
        this.sex=sex;
    }
    public String getBirth(){
        return birth;
    }
    public void setBirth(String birth){
        this.birth=birth;
    }
    public Integer getTime(){
        return time;
    }
    public void setTime(Integer time){
        this.time=time;
    }
    public Integer getScore1(){
        return score1;
    }
    public void setScore1(Integer score1){
        this.score1=score1;
    }
    public Integer getScore2(){
        return score2;
    }
    public void setScore2(Integer score2){
        this.score2=score2;
    }
}
