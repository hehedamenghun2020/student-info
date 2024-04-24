package com.example.controller;


import com.example.service.StudentService;
import com.example.service.UserService;
import com.sun.deploy.net.HttpResponse;
import com.example.entity.User;
import com.example.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    StudentService studentService;
    UserMapper userMapper;

    //-----------------------------登录注册功能
    //登录：
    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

    @GetMapping("/result")
    public String result(HttpServletRequest req, HttpServletRequest request, HttpServletResponse resp, HttpSession session) {
        boolean flag = false;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//
//        User user = new User();
//        user.setName(username);
//        user.setPassword(password);
//        boolean flag = userService.login(user,session,request);
        session.setAttribute("loginUser",username);
////        String uname=(String)session.getAttribute("loginUser");
////        System.out.println(uname);
//        if(flag==true){
//            return "index";
//        }else {
//            return "Middle";
//        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8", "root", "eric0919");
             Statement s = c.createStatement()) {

            String sql = "select * from user where name = '" + username + "' and password = '" + password + "'";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next())
                flag = true;
            else
                flag = false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(flag==true){
            return "index";
        }else {
            return "Middle";
        }
    }

    @GetMapping("/middle")
    public String middle(){
        return "Login";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/login";
    }


    //注册：
    @GetMapping("/zhuCe")
    public String zhuCe(){
        return "Zhuce";
    }
    @GetMapping("/end")
    public String end(HttpServletRequest req, HttpServletResponse resp){

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setName(username);
        user.setPassword(password);
        boolean flag = userService.zhuCe(user);
        if(flag==true){
            return "End1";
        }else{
            return "End2";
        }
    }
}
