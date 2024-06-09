package com.org.course.core.models;

import java.io.Serializable;
import java.util.List;

public class CourseModel implements Serializable {

    private String name, author, desc;
    private Float duration;
    //private List<String> categories, languages;
    private String id;
    private boolean isAvailable;

    public CourseModel(String name, String author, String desc, Float duration, List<String> categories, List<String> languages, String id, boolean isAvailable) {
        this.name = name;
        this.author = author;
        this.desc = desc;
        this.duration = duration;
        //this.categories = categories;
        //this.languages = languages;
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

 /*   public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", desc='" + desc + '\'' +
                ", duration=" + duration +
                //", categories=" + categories +
                //", languages=" + languages +
                ", id='" + id + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
