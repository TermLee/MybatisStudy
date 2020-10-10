package com.term.dao;

import com.term.model.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    @Insert("insert into blog (id,title,author,create_time,views) values (#{id},#{title},#{author},#{createTime},#{views})")
    int addBlog(Blog blog);

    List<Blog> selectBlogByIf(Map<String, Object> map);

    List<Blog> selectBlogByWhen(Map<String, Object> map);



}
