package com.tal.app.thinkacademy.live.business.homework.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

public class HomeworkEntity implements MultiItemEntity {
    private int correctPoint;
    @SerializedName("newCorrectStatus")
    private int correctStatus;
    private String correctThumbUrl;
    private String correctUrl;
    private int index;
    private String interactId;
    private String photoThumbUrl;
    private String photoUrl;
    private String questionThumbUrl;
    private String questionUrl;
    private int rewardType;
    private int rightCoin;
    private String tagType;

    public HomeworkEntity(int i, String str, String str2, int i2) {
        this.index = i;
        this.correctUrl = str;
        this.interactId = str2;
        this.correctStatus = i2;
    }

    public HomeworkEntity(int i, String str, String str2, int i2, String str3) {
        this.index = i;
        this.correctUrl = str;
        this.interactId = str2;
        this.correctStatus = i2;
        this.tagType = str3;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String str) {
        this.photoUrl = str;
    }

    public String getPhotoThumbUrl() {
        return this.photoThumbUrl;
    }

    public void setPhotoThumbUrl(String str) {
        this.photoThumbUrl = str;
    }

    public int getCorrectStatus() {
        return this.correctStatus;
    }

    public void setCorrectStatus(int i) {
        this.correctStatus = i;
    }

    public String getInteractId() {
        return this.interactId;
    }

    public void setInteractId(String str) {
        this.interactId = str;
    }

    public String getQuestionUrl() {
        return this.questionUrl;
    }

    public void setQuestionUrl(String str) {
        this.questionUrl = str;
    }

    public String getQuestionThumbUrl() {
        return this.questionThumbUrl;
    }

    public void setQuestionThumbUrl(String str) {
        this.questionThumbUrl = str;
    }

    public String getCorrectUrl() {
        return this.correctUrl;
    }

    public void setCorrectUrl(String str) {
        this.correctUrl = str;
    }

    public String getCorrectThumbUrl() {
        return this.correctThumbUrl;
    }

    public void setCorrectThumbUrl(String str) {
        this.correctThumbUrl = str;
    }

    public String getTagType() {
        return this.tagType;
    }

    public void setTagType(String str) {
        this.tagType = str;
    }

    public int getItemType() {
        return this.correctStatus;
    }

    public int getCorrectPoint() {
        return this.correctPoint;
    }

    public void setCorrectPoint(int i) {
        this.correctPoint = i;
    }

    public int getRewardType() {
        return this.rewardType;
    }

    public void setRewardType(int i) {
        this.rewardType = i;
    }

    public int getRightCoin() {
        return this.rightCoin;
    }

    public void setRightCoin(int i) {
        this.rightCoin = i;
    }
}
