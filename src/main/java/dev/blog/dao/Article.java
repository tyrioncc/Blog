package dev.blog.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String head;
    private String content;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    private Timestamp createTime;
    private Timestamp editTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "文章标题：" + title + " " + createTime.toString();
    }
}
