package com.anservices.quiz.model;

import java.util.List;

public class Question {
    private Long id;
    private String text;
    private List<String> options;
    private int correctIndex;

    public Question() {}

    public Question(Long id, String text, List<String> options, int correctIndex) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public int getCorrectIndex() { return correctIndex; }
    public void setCorrectIndex(int correctIndex) { this.correctIndex = correctIndex; }
}
