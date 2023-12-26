package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity;

import java.util.List;
import java.util.Map;

public class ExpressionAllInfoEntity {
    private int backgroundResource;
    private int bottomImageId;
    private String bottomImageName;
    private String bottomImageUrl;
    private int catogaryId;
    private int expressionNum = 14;
    private List<ExpressionInfoEntity> mExpressionInfoList;
    private Map<String, ExpressionInfoEntity> mExpressionInfoMap;
    private int pageNum;

    public ExpressionAllInfoEntity(int i, List<ExpressionInfoEntity> list) {
        this.catogaryId = i;
        this.mExpressionInfoList = list;
    }

    public ExpressionAllInfoEntity(List<ExpressionInfoEntity> list) {
        this.mExpressionInfoList = list;
    }

    public int getBottomImageId() {
        return this.bottomImageId;
    }

    public void setBottomImageId(int i) {
        this.bottomImageId = i;
    }

    public String getBottomImageName() {
        return this.bottomImageName;
    }

    public void setBottomImageName(String str) {
        this.bottomImageName = str;
    }

    public String getBottomImageUrl() {
        return this.bottomImageUrl;
    }

    public void setBottomImageUrl(String str) {
        this.bottomImageUrl = str;
    }

    public int getBackgroundResource() {
        return this.backgroundResource;
    }

    public void setBackgroundResource(int i) {
        this.backgroundResource = i;
    }

    public int getCatogaryId() {
        return this.catogaryId;
    }

    public void setCatogaryId(int i) {
        this.catogaryId = i;
    }

    public int getExpressionNum() {
        return this.expressionNum;
    }

    public void setExpressionNum(int i) {
        this.expressionNum = i;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public List<ExpressionInfoEntity> getExpressionInfoList() {
        return this.mExpressionInfoList;
    }

    public void setExpressionInfoList(List<ExpressionInfoEntity> list) {
        this.mExpressionInfoList = list;
    }

    public Map<String, ExpressionInfoEntity> getExpressionInfoMap() {
        return this.mExpressionInfoMap;
    }

    public void setExpressionInfoMap(Map<String, ExpressionInfoEntity> map) {
        this.mExpressionInfoMap = map;
    }

    public String toString() {
        return "ExpressionAllInfoEntity [backgroundResource=" + this.backgroundResource + ", bottomImageUrl=" + this.bottomImageUrl + ", bottomImageId=" + this.bottomImageId + ", bottomImageName=" + this.bottomImageName + ", catogaryId=" + this.catogaryId + ", pageNum=" + this.pageNum + ", data=" + this.mExpressionInfoList + ", map=" + this.mExpressionInfoMap + "]";
    }
}
