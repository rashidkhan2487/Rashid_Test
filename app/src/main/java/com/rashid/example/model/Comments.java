package com.rashid.example.model;

/**
 * Created by rashi on 2018-08-26.
 */

public class Comments {
    private String title;
    private int id;

    public Comments(String title, int id){
        this.title = title;
        this.id = id;
    }

    public Comments() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
