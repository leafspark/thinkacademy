package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity;

public class ExpressionInfoEntity {
    private int exPressionUrl;
    private int expressionGifUrl;
    private String expressionId;
    private String expressionName;
    private String expressionNetUrl;
    private String expressionUrlName;
    private String gifExpressionUrl;

    public String getGifExpressionUrl() {
        return this.gifExpressionUrl;
    }

    public void setGifExpressionUrl(String str) {
        this.gifExpressionUrl = str;
    }

    public ExpressionInfoEntity(String str, String str2, int i) {
        this.expressionId = str;
        this.expressionUrlName = str2;
        this.exPressionUrl = i;
    }

    public ExpressionInfoEntity(String str, int i, int i2, String str2) {
        this.expressionId = str;
        this.expressionGifUrl = i;
        this.exPressionUrl = i2;
        this.expressionName = str2;
    }

    public ExpressionInfoEntity(String str, String str2, String str3) {
        this.expressionId = str;
        this.expressionName = str3;
        this.gifExpressionUrl = str2;
    }

    public String getExpressionId() {
        return this.expressionId;
    }

    public void setExpressionId(String str) {
        this.expressionId = str;
    }

    public int getExpressionGifUrl() {
        return this.expressionGifUrl;
    }

    public void setExpressionGifUrl(int i) {
        this.expressionGifUrl = i;
    }

    public String getExpressionUrlName() {
        return this.expressionUrlName;
    }

    public void setExpressionUrlName(String str) {
        this.expressionUrlName = str;
    }

    public String getExpressionName() {
        return this.expressionName;
    }

    public void setExpressionName(String str) {
        this.expressionName = str;
    }

    public String getExpressionNetUrl() {
        return this.expressionNetUrl;
    }

    public void setExpressionNetUrl(String str) {
        this.expressionNetUrl = str;
    }

    public int getExPressionUrl() {
        return this.exPressionUrl;
    }

    public void setExPressionUrl(int i) {
        this.exPressionUrl = i;
    }

    public String toString() {
        return "ExpressionInfoEntity [expressionId=" + this.expressionId + ", expressionUrlName=" + this.expressionUrlName + ", expressionName=" + this.expressionName + ", expressionNetUrl=" + this.expressionNetUrl + ", exPressionUrl=" + this.exPressionUrl + "]";
    }
}
