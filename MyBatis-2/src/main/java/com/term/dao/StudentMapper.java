package com.term.dao;

import com.term.model.Student;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface StudentMapper {
    List<Student> getAllStudents();
    List<Student> getAllStudents2();

    @Insert("Insert into student (id,name,tid) values (#{id},#{name},#{teacher.id})")
    int addStudent(Student student);
}
