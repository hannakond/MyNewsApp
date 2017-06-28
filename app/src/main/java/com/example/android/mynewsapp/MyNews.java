package com.example.android.mynewsapp;

/**
 * Created by anna on 28.06.2017.
 */

public class MyNews {
    private String author;
    private String title;
    private String url;
    private String date;
    private String topic;
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
