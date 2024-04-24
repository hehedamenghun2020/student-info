package com.example.service;

import com.example.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Student;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    public List<Student> findall(){
        return studentMapper.findall();
    }
    public List<Student> findit(String name){
        return studentMapper.findit(name);
    }
    public String add(Student student){
        int a=studentMapper.add(student);
        if(a==1){
            return "添加成功";
        }
        else{
            return "添加失败";
        }
    }
    public int update(Student student) {
        return studentMapper.update(student);
    }
    public Integer Delete(Integer id){
        return studentMapper.Delete(id);
    }
    public Student get(int id) {
        return studentMapper.get(id);
    }
    public Student selectStudentById(Integer id) {

        return studentMapper.selectStudentById(id);
    }
}
