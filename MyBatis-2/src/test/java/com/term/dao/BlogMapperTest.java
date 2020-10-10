package com.term.dao;

import com.term.model.Blog;
import com.term.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogMapperTest {
    @Test
    public void testAddBlog() throws UnsupportedEncodingException {
        final SqlSession sqlSession = MybatisUtils.getAutoCommitSqlSession();
        final BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.addBlog(new Blog(5, new String("红色警戒".getBytes(),
                "UTF-8"), "暴力乌龟", new Date(), 999));
        sqlSession.close();

    }

    @Test
    public void testSelectBlogByIf() {
        final SqlSession sqlSession = MybatisUtils.getAutoCommitSqlSession();
        final BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("title", "红警");
        List<Blog> blogs = blogMapper.selectBlogByIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectBlogByWhen() {
        final SqlSession sqlSession = MybatisUtils.getAutoCommitSqlSession();
        final BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("author", "暴力乌龟");
        map.put("title", "红警");
        List<Blog> blogs = blogMapper.selectBlogByWhen(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
