package dev.blog.dao;

public class PostReview {
    private String postTitle;
    private String postSubtitle;
    private String postTime;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostSubtitle() {
        return postSubtitle;
    }

    public void setPostSubtitle(String postSubtitle) {
        this.postSubtitle = postSubtitle;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public PostReview(String postTitle, String postSubtitle, String postTime) {
        this.postTitle = postTitle;
        this.postSubtitle = postSubtitle;
        this.postTime = postTime;
    }
}
