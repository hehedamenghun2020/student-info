package com.example.dao;

import com.example.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> findall();
    List<Student> findit(String name);

    public int add(Student student);

    public int Delete(Integer id);

    //    @Update("update stu_info set id=#{id},name=#{name},sex=#{sex},birth=#{birth},time=#{time},score1=#{score1},score2=#{score2} where id=#{id}")
    public int update(Student student);

    @Select("select * from stu_info where id=#{id}")
    public Student get(int id);
    Student selectStudentById(Integer id);
}
