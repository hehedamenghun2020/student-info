package com.example.entity;


public class User {
    private int id;
    private String name;
    private String password;
    private String u_name;
    public  User(){

    }

    public User(int id, String name, String password,String u_name) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.u_name=u_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getU_name(){
        return u_name;
    }
    public void setU_name(String u_name){
        this.u_name=u_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", u_name='" + u_name + '\'' +
                '}';
    }
}