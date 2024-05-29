package com.org.quiz.admin.models;

public class AllQuizModel {

    public static final int VIEW_QUIZ_CATEGORY_NAME = 0;
    public static final int VIEW_QUIZ_NAME = 1;
    private int viewType;

    private String title;

    public AllQuizModel() {
    }

    public AllQuizModel(int viewType, String title) {
        this.viewType = viewType;
        this.title = title;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
