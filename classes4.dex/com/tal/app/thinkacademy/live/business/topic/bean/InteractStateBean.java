package com.tal.app.thinkacademy.live.business.topic.bean;

import java.util.List;

public class InteractStateBean {
    private int countDownTime;
    private int interactStatus;
    private int isRight;
    private boolean isSubmit;
    private String questionContent;
    private String questionId;
    private int questionType;
    public long startTime;
    private List<String> userAnswer;
    private List<List<String>> userAnswerForUI;

    public int getCountDownTime() {
        return this.countDownTime;
    }

    public void setCountDownTime(int i) {
        this.countDownTime = i;
    }

    public int getInteractStatus() {
        return this.interactStatus;
    }

    public void setInteractStatus(int i) {
        this.interactStatus = i;
    }

    public int getIsRight() {
        return this.isRight;
    }

    public void setIsRight(int i) {
        this.isRight = i;
    }

    public String getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(String str) {
        this.questionId = str;
    }

    public List<String> getUserAnswer() {
        return this.userAnswer;
    }

    public void setUserAnswer(List<String> list) {
        this.userAnswer = list;
    }

    public List<List<String>> getUserAnswerForUI() {
        return this.userAnswerForUI;
    }

    public void setUserAnswerForUI(List<List<String>> list) {
        this.userAnswerForUI = list;
    }

    public int getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(int i) {
        this.questionType = i;
    }

    public boolean isSubmit() {
        return this.isSubmit;
    }

    public void setSubmit(boolean z) {
        this.isSubmit = z;
    }

    public String getQuestionContent() {
        return this.questionContent;
    }

    public void setQuestionContent(String str) {
        this.questionContent = str;
    }
}
