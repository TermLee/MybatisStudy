package com.term.dao;

import com.term.model.Teacher;
import com.term.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherMapperTest {
    @Test
    public void testGetAllTeachers() {
        final SqlSession sqlSession = MybatisUtils.getAutoCommitSqlSession();
        final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        for (Teacher teacher : mapper.getAllTeachers()){
            System.out.println(teacher);
        }
        sqlSession.close();
    }
}
