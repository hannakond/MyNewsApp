package com.example.android.mynewsapp;

public class MyNews {
    final private String author;
    final private String title;
    final private String url;
    final private String date;
    final private String topic;
    public MyNews(String author, String title, String url, String date, String topic) {
        this.author = author;
        this.title = title;
        this.url = url;
        this.date = date;
        this.topic = topic;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
    public String getDate() {
        return date;
    }
    public String getTopic() {
        return topic;
    }
}
