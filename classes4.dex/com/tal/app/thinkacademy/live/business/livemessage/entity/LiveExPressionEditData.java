package com.tal.app.thinkacademy.live.business.livemessage.entity;

import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionAllInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.manager.ExPressionEditDataInter;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.util.Expressions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveExPressionEditData implements ExPressionEditDataInter {
    private String[] bottomImageNames;
    private int[] bottomImageResources;
    private int[] bottomResourceIds;
    private String[] expressionGifIds;
    private int[] expressionGifImages;
    private String[] expressionGifNames;
    private String[] expressionIds;
    private String[] expressionImageNames;
    private int[] expressionImages;
    private int[] expressionJpgImages;
    private Map<Integer, ExpressionAllInfoEntity> mExPressionAllMaps;
    private Map<String, ExpressionInfoEntity> mExPressionMap;
    private List<ExpressionAllInfoEntity> mExpressionAllInfoLists;
    private List<ExpressionInfoEntity> mExpressionList;

    public LiveExPressionEditData() {
        initNativeExpression();
        initFillExpressionList();
    }

    private void initNativeExpression() {
        this.expressionImages = new int[]{R.drawable.emoji_1f60a, R.drawable.emoji_1f604, R.drawable.emoji_1f633, R.drawable.emoji_1f60c, R.drawable.emoji_1f601, R.drawable.emoji_1f61d, R.drawable.emoji_1f625, R.drawable.emoji_1f623, R.drawable.emoji_1f628, R.drawable.emoji_1f632, R.drawable.emoji_1f62d, R.drawable.emoji_1f602, R.drawable.emoji_1f631, R.drawable.emoji_1f47f, R.drawable.emoji_1f44d, R.drawable.emoji_1f44c, R.drawable.emoji_270c};
        this.expressionIds = Expressions.expressionImgIds;
        this.expressionImageNames = new String[]{"[e]em_1[e]", "[e]em_2[e]", "[e]em_3[e]", "[e]em_4[e]", "[e]em_5[e]", "[e]em_6[e]", "[e]em_7[e]", "[e]em_8[e]", "[e]em_9[e]", "[e]em_10[e]", "[e]em_11[e]", "[e]em_12[e]", "[e]em_13[e]", "[e]em_14[e]", "[e]em_15[e]", "[e]em_16[e]", "[e]em_17[e]"};
        this.expressionJpgImages = Expressions.exPressionJpgImages;
        this.expressionGifImages = Expressions.exPressionGifImages;
        this.expressionGifIds = Expressions.exPressionIds;
        this.expressionGifNames = Expressions.exPressionNames;
        this.bottomImageResources = Expressions.bottomImageResource;
        this.bottomResourceIds = Expressions.imageResourceId;
        this.bottomImageNames = Expressions.imageResourceName;
        this.mExpressionAllInfoLists = new ArrayList();
        this.mExPressionAllMaps = new HashMap();
    }

    private void initFillExpressionList() {
        this.mExpressionList = new ArrayList();
        this.mExPressionMap = new HashMap();
        for (int i = 0; i < this.expressionImages.length; i++) {
            this.mExpressionList.add(new ExpressionInfoEntity(this.expressionIds[i], this.expressionImageNames[i], this.expressionImages[i]));
            this.mExPressionMap.put(this.expressionIds[i], new ExpressionInfoEntity(this.expressionIds[i], this.expressionImageNames[i], this.expressionImages[i]));
        }
        ExpressionAllInfoEntity expressionAllInfoEntity = new ExpressionAllInfoEntity(this.mExpressionList);
        expressionAllInfoEntity.setExpressionNum(17);
        expressionAllInfoEntity.setBottomImageId(this.bottomResourceIds[0]);
        expressionAllInfoEntity.setBottomImageName(this.bottomImageNames[0]);
        expressionAllInfoEntity.setBackgroundResource(this.bottomImageResources[0]);
        expressionAllInfoEntity.setCatogaryId(Expressions.exPressionCatogary);
        expressionAllInfoEntity.setExpressionInfoList(this.mExpressionList);
        expressionAllInfoEntity.setExpressionInfoMap(this.mExPressionMap);
        this.mExpressionAllInfoLists.add(expressionAllInfoEntity);
        this.mExPressionAllMaps.put(Integer.valueOf(this.bottomResourceIds[0]), expressionAllInfoEntity);
        this.mExpressionList = new ArrayList();
        this.mExPressionMap = new HashMap();
        for (int i2 = 0; i2 < this.expressionGifImages.length; i2++) {
            this.mExpressionList.add(new ExpressionInfoEntity(this.expressionGifIds[i2], this.expressionGifImages[i2], this.expressionJpgImages[i2], this.expressionGifNames[i2]));
            this.mExPressionMap.put(this.expressionGifIds[i2], new ExpressionInfoEntity(this.expressionGifIds[i2], this.expressionGifImages[i2], this.expressionJpgImages[i2], this.expressionGifNames[i2]));
        }
        ExpressionAllInfoEntity expressionAllInfoEntity2 = new ExpressionAllInfoEntity(this.mExpressionList);
        expressionAllInfoEntity2.setExpressionNum(8);
        expressionAllInfoEntity2.setBottomImageId(this.bottomResourceIds[1]);
        expressionAllInfoEntity2.setBottomImageName(this.bottomImageNames[1]);
        expressionAllInfoEntity2.setBackgroundResource(this.bottomImageResources[1]);
        expressionAllInfoEntity2.setCatogaryId(Expressions.exGifCatogary);
        expressionAllInfoEntity2.setExpressionInfoList(this.mExpressionList);
        expressionAllInfoEntity2.setExpressionInfoMap(this.mExPressionMap);
    }

    public void setmExpressionAllInfoLists(List<ExpressionAllInfoEntity> list) {
        this.mExpressionAllInfoLists = list;
    }

    public void setmExPressionAllMaps(Map<Integer, ExpressionAllInfoEntity> map) {
        this.mExPressionAllMaps = map;
    }

    public List<ExpressionAllInfoEntity> getExpressionAllList() {
        return this.mExpressionAllInfoLists;
    }

    public Map<Integer, ExpressionAllInfoEntity> getExpressionAllMap() {
        return this.mExPressionAllMaps;
    }
}
