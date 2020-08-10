package com.bjsxt.vo;

import java.io.Serializable;

public class Company implements Serializable {
    private String title;
    private String note;

    @Override
    public String toString() {
        return "Company{" +
                "title='" + title + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}