package com.tal.app.thinkacademy.live.business.topic.bean.request;

import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import java.util.List;

public class SubmitAnswerRequest {
    private int classId;
    private String interactId;
    private int isRight;
    private int planId;
    private String questionId;
    private List<String> userAnswer;
    private GameJsSubmitData userAnswerResult;
    private String userName;

    public SubmitAnswerRequest(int i, int i2, String str, String str2, List<String> list, int i3, String str3, GameJsSubmitData gameJsSubmitData) {
        this.planId = i;
        this.classId = i2;
        this.interactId = str;
        this.questionId = str2;
        this.userAnswer = list;
        this.isRight = i3;
        this.userName = str3;
        this.userAnswerResult = gameJsSubmitData;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public String getInteractId() {
        return this.interactId;
    }

    public void setInteractId(String str) {
        this.interactId = str;
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

    public int getIsRight() {
        return this.isRight;
    }

    public void setIsRight(int i) {
        this.isRight = i;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public GameJsSubmitData getUserAnswerResult() {
        return this.userAnswerResult;
    }

    public void setUserAnswerResult(GameJsSubmitData gameJsSubmitData) {
        this.userAnswerResult = gameJsSubmitData;
    }
}
