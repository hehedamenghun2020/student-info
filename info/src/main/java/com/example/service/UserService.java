package com.example.service;


import com.example.entity.User;
import com.example.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User selectUserById(int id){
        return userMapper.selectUserById(id);
    }

    public boolean login(User user, HttpSession session, HttpServletRequest request){
        String name = user.getName();
        String password = user.getPassword();
        User u1 =  userMapper.selectUserByName(name);
        request.getSession().setAttribute("loginUser",name);
        if(u1==null){
            return false;
        }else{
            if(u1.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean zhuCe(User user){
        int x = userMapper.insertUser(user);
        if(x>0){
            return true;
        }else {
            return false;
        }
    }

}
