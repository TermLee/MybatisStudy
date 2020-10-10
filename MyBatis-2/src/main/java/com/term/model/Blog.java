package com.term.model;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private int id;
    private String title;
    private String author;
    private Date createTime;
    private int views;

    public Blog(int id, String title, String author, Date createTime, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createTime = createTime;
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", views=" + views +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Blog() {
    }
}
