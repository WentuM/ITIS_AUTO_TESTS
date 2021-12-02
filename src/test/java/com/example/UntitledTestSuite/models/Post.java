package com.example.UntitledTestSuite.models;

public class Post {
    private String textPost;
    private String fileName;

    public Post(String textPost, String fileName) {
        this.textPost = textPost;
        this.fileName = fileName;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
