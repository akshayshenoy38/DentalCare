package com.example.akshay.dentalcare3;

public class DocBlogItem {
    private int imageResource;
    private String docBlogTitle;
    private String blogDate;
    private String content;

    public DocBlogItem(int imageResource, String docBlogTitle, String blogDate, String content) {
        this.imageResource = imageResource;
        this.docBlogTitle = docBlogTitle;
        this.blogDate = blogDate;
        this.content = content;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setDocBlogTitle(String docBlogTitle) {
        this.docBlogTitle = docBlogTitle;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDocBlogTitle() {
        return docBlogTitle;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public String getContent() {
        return content;
    }
}
