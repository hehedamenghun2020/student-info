package com.example.controller;

import com.example.dao.UserMapper;
import com.example.entity.Student;
import com.example.entity.User;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import static java.lang.System.out;
import static org.yaml.snakeyaml.nodes.NodeId.mapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    private UserMapper userMapper;

    @RequestMapping("/index")
    public String Show(Model model, HttpSession session) {
        model.addAttribute("info", studentService.findall());
        return "/index";
    }

    //    @RequestMapping("/login")
//    public String login(){
//        return "/login";
//    }
    @RequestMapping("/chaxun")
    public String Chaxun(Model model, HttpServletRequest req) {
        String name = req.getParameter("sname");
        model.addAttribute("info", studentService.findit(name));
        return "/index";
    }

    @PostMapping("/add")
    public String add(Student student, Model model, HttpSession session, HttpServletResponse response,HttpServletRequest request) throws IOException {
        String username = (String) session.getAttribute("loginUser");
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        if (Objects.equals(username, "管理员")) {
            studentService.add(student);
            model.addAttribute("info", studentService.findall());
            return "index";
        } else {
            out.print("<script language=\"javascript\">alert('您不是管理员，无权进行此操作！');window.location.href='/index'</script>");
            return "/index";
        }
    }
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable int id, Model model, HttpSession session,HttpServletResponse response) throws IOException {
        String username = (String) session.getAttribute("loginUser");
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        if(Objects.equals(username,"管理员")){
            studentService.Delete(id);
            model.addAttribute("info", studentService.findall());
            return "index";
        }
        else{
            out.print("<script language=\"javascript\">alert('您不是管理员，无权进行此操作！');window.location.href='/index'</script>");
            return "/index";
        }
    }

    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model, @PathVariable int id ,HttpSession session,HttpServletResponse response) throws IOException {
        String username = (String) session.getAttribute("loginUser");
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        if(Objects.equals(username,"管理员")){
            Student students = studentService.get(id);
            model.addAttribute("info", students);
            return "update";
        }
        else {
            out.print("<script language=\"javascript\">alert('您不是管理员，无权进行此操作！');window.location.href='/index'</script>");
            return "index";
        }
    }

    @PostMapping("/update")
    public String updateUser(Model model, Student student, HttpServletRequest request,HttpSession session) {
        String id = request.getParameter("id");
        Student userById = studentService.get(Integer.parseInt(id));
        studentService.update(student);
//        System.out.println(student);
        model.addAttribute("info", studentService.findall());
        return "index";
    }
}
