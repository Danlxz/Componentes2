package com.example.componentes2;

public class Item {

    private String title, date, content;
    private int userPhoto;

    public Item() {
    }

    public Item(String title, String date, String content, int userPhoto) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.userPhoto = userPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }
}
