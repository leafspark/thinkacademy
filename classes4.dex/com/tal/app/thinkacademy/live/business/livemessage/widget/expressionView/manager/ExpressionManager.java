package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionAllInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.util.Expressions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpressionManager {
    private int currentItem = 0;
    private List<View> dots;
    private Context mContext;
    private Map<Integer, ExpressionAllInfoEntity> mExPressionAllMap;
    private ExPressionEditDataInter mExPressionEditData;
    private List<ExpressionAllInfoEntity> mExpressionAllList;
    private ExpressionListener mExpressionListenerData;
    private LayoutInflater mInflater;
    private RecyclerView mRvCustomList;
    private List<View> views;

    public ExpressionManager(Context context, RecyclerView recyclerView, ExPressionEditDataInter exPressionEditDataInter) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.dots = new ArrayList();
        this.views = new ArrayList();
        this.mRvCustomList = recyclerView;
        this.mExPressionEditData = exPressionEditDataInter;
    }

    public void initInflaterData() {
        if (!this.dots.isEmpty()) {
            this.dots.get(0).setBackgroundResource(R.drawable.shape_oval_black);
        }
    }

    private void setNativeLoadResource() {
        this.mExpressionAllList = this.mExPressionEditData.getExpressionAllList();
        this.mExPressionAllMap = this.mExPressionEditData.getExpressionAllMap();
    }

    public void setInitExpressionData() {
        initInflaterData();
        setNativeLoadResource();
    }

    public List<ExpressionAllInfoEntity> getExpressionAllList() {
        return this.mExPressionEditData.getExpressionAllList();
    }

    public Map<Integer, ExpressionAllInfoEntity> getExpressionAllMap() {
        return this.mExPressionEditData.getExpressionAllMap();
    }

    public List<View> mViews() {
        return this.views;
    }

    public void setPageDots(List<View> list) {
        if (!list.isEmpty()) {
            this.dots.clear();
            list.get(0).setBackgroundResource(R.drawable.shape_oval_black);
            this.dots = list;
        }
    }

    public ViewPager.OnPageChangeListener getPageLinster() {
        ExpressionListener expressionListener = new ExpressionListener(this.currentItem, this.mExpressionAllList, this.dots, this.mRvCustomList);
        this.mExpressionListenerData = expressionListener;
        return expressionListener;
    }

    public void traversalDotNum(List<ExpressionAllInfoEntity> list) {
        for (int i = 0; i < list.size(); i++) {
            getCardPage(list.get(i));
        }
    }

    public void getCardPage(ExpressionAllInfoEntity expressionAllInfoEntity) {
        int i = 0;
        if (expressionAllInfoEntity.getCatogaryId() == Expressions.exPressionCatogary) {
            int expressionNum = expressionAllInfoEntity.getExpressionNum();
            this.currentItem = (int) Math.ceil((double) (expressionAllInfoEntity.getExpressionInfoList().size() / expressionNum));
            if (expressionAllInfoEntity.getExpressionInfoList().size() % expressionNum > 0) {
                this.currentItem++;
            }
            expressionAllInfoEntity.setPageNum(this.currentItem);
            while (i < this.currentItem) {
                List<View> list = this.views;
                LayoutInflater layoutInflater = this.mInflater;
                int i2 = R.layout.layout_chat_expression;
                list.add(!(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i2, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i2, (ViewGroup) null));
                i++;
            }
        } else if (expressionAllInfoEntity.getCatogaryId() == Expressions.exGifCatogary) {
            int ceil = (int) Math.ceil((double) (((float) expressionAllInfoEntity.getExpressionInfoList().size()) / ((float) expressionAllInfoEntity.getExpressionNum())));
            this.currentItem = ceil;
            expressionAllInfoEntity.setPageNum(ceil);
            while (i < this.currentItem) {
                List<View> list2 = this.views;
                LayoutInflater layoutInflater2 = this.mInflater;
                int i3 = R.layout.layout_chat_gif_gridview;
                list2.add(!(layoutInflater2 instanceof LayoutInflater) ? layoutInflater2.inflate(i3, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater2, i3, (ViewGroup) null));
                i++;
            }
        }
    }
}
