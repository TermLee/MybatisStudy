package com.term.dao;

import com.term.model.Student;
import com.term.model.Teacher;
import com.term.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentMapperTest {
    @Test
    public void testGetAllStudents(){
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        for(Student student : mapper.getAllStudents()){
            System.out.println(student);
        }

        sqlSession.close();
    }
    @Test
    public void testGetAllStudents2(){
        final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        for(Student student : mapper.getAllStudents2()){
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void testAddStudent() {
        final SqlSession sqlSession = MybatisUtils.getAutoCommitSqlSession();
        final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Teacher teacher = new Teacher(1,"zhangsan");
        mapper.addStudent(new Student(5, "xiaoming", teacher));
        sqlSession.close();
    }
}
