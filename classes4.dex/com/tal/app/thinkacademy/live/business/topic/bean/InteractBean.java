package com.tal.app.thinkacademy.live.business.topic.bean;

import java.util.List;

public class InteractBean {
    private int countDownTime;
    private long currentTime;
    private String interactId;
    private String pageId;
    private String pageTitle;
    private String paperId;
    private int planId;
    private boolean publishTopic;
    private List<List<String>> quesAnswer;
    private String quesId;
    private List<List<String>> quesOptions;
    private int quesScore;
    private String quesTypeId;
    private String quesTypeName;
    private String questionId;
    private int realCountDownTime;
    private int rightCoin;
    private String teacherId;
    private String teacherType;

    public String getQuesId() {
        return this.quesId;
    }

    public void setQuesId(String str) {
        this.quesId = str;
    }

    public String getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(String str) {
        this.questionId = str;
    }

    public int getRightCoin() {
        return this.rightCoin;
    }

    public void setRightCoin(int i) {
        this.rightCoin = i;
    }

    public boolean isPublishTopic() {
        return this.publishTopic;
    }

    public void setPublishTopic(boolean z) {
        this.publishTopic = z;
    }

    public String getPageId() {
        return this.pageId;
    }

    public void setPageId(String str) {
        this.pageId = str;
    }

    public String getQuesTypeName() {
        return this.quesTypeName;
    }

    public void setQuesTypeName(String str) {
        this.quesTypeName = str;
    }

    public String getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(String str) {
        this.teacherId = str;
    }

    public String getTeacherType() {
        return this.teacherType;
    }

    public void setTeacherType(String str) {
        this.teacherType = str;
    }

    public int getQuesScore() {
        return this.quesScore;
    }

    public void setQuesScore(int i) {
        this.quesScore = i;
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

    public void setPageTitle(String str) {
        this.pageTitle = str;
    }

    public String getQuesTypeId() {
        return this.quesTypeId;
    }

    public void setQuesTypeId(String str) {
        this.quesTypeId = str;
    }

    public String getPaperId() {
        return this.paperId;
    }

    public void setPaperId(String str) {
        this.paperId = str;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getCountDownTime() {
        return this.countDownTime;
    }

    public void setCountDownTime(int i) {
        this.countDownTime = i;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public String getInteractId() {
        return this.interactId;
    }

    public void setInteractId(String str) {
        this.interactId = str;
    }

    public List<List<String>> getQuesOptions() {
        return this.quesOptions;
    }

    public void setQuesOptions(List<List<String>> list) {
        this.quesOptions = list;
    }

    public List<List<String>> getQuesAnswer() {
        return this.quesAnswer;
    }

    public void setQuesAnswer(List<List<String>> list) {
        this.quesAnswer = list;
    }

    public int getRealCountDownTime() {
        return this.realCountDownTime;
    }

    public void setRealCountDownTime(int i) {
        this.realCountDownTime = i;
    }
}
