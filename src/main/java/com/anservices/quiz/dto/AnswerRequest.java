package com.anservices.quiz.dto;

public class AnswerRequest {
    private Long questionId;
    private int selectedIndex;

    public AnswerRequest() {}

    public AnswerRequest(Long questionId, int selectedIndex) {
        this.questionId = questionId;
        this.selectedIndex = selectedIndex;
    }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public int getSelectedIndex() { return selectedIndex; }
    public void setSelectedIndex(int selectedIndex) { this.selectedIndex = selectedIndex; }
}
