package com.example.lab1;

import java.util.HashMap;
import java.util.Objects;

public class ToDo {
    String title;
    String content;

    public ToDo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ToDo() {
    }
}