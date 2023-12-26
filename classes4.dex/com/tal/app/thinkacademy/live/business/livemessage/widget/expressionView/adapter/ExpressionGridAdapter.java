package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionAllInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionInfoEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.util.Expressions;
import java.util.List;

public class ExpressionGridAdapter extends BaseAdapter {
    private Context mContext;
    private ExpressionAllInfoEntity mDatas;
    private List<ExpressionInfoEntity> mLstData;

    public long getItemId(int i) {
        return (long) i;
    }

    public ExpressionGridAdapter(Context context, List<ExpressionInfoEntity> list, ExpressionAllInfoEntity expressionAllInfoEntity) {
        this.mContext = context;
        this.mLstData = list;
        this.mDatas = expressionAllInfoEntity;
    }

    public List<ExpressionInfoEntity> getData() {
        return this.mLstData;
    }

    public void setData(List<ExpressionInfoEntity> list) {
        this.mLstData = list;
    }

    public ExpressionAllInfoEntity getDatas() {
        return this.mDatas;
    }

    public void setDatas(ExpressionAllInfoEntity expressionAllInfoEntity) {
        this.mDatas = expressionAllInfoEntity;
    }

    public int getCount() {
        return this.mLstData.size();
    }

    public Object getItem(int i) {
        return this.mLstData.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        ViewHolder viewHolder2 = null;
        if (view == null) {
            if (this.mDatas.getCatogaryId() == Expressions.exPressionCatogary) {
                LayoutInflater from = LayoutInflater.from(this.mContext);
                int i2 = R.layout.item_chat_expression;
                view = !(from instanceof LayoutInflater) ? from.inflate(i2, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i2, (ViewGroup) null);
                viewHolder = new ViewHolder();
                ImageView unused = viewHolder.image = (ImageView) view.findViewById(R.id.iv_chat_expression_item);
                view.setTag(viewHolder);
            } else if (this.mDatas.getCatogaryId() == Expressions.exGifCatogary) {
                LayoutInflater from2 = LayoutInflater.from(this.mContext);
                int i3 = R.layout.item_chat_gif_gridview;
                view = !(from2 instanceof LayoutInflater) ? from2.inflate(i3, (ViewGroup) null) : XMLParseInstrumentation.inflate(from2, i3, (ViewGroup) null);
                viewHolder = new ViewHolder();
                ImageView unused2 = viewHolder.image = (ImageView) view.findViewById(R.id.iv_chat_expression_gif);
                TextView unused3 = viewHolder.mText = (TextView) view.findViewById(R.id.tv_chat_expression_gif_name);
                view.setTag(viewHolder);
            }
            viewHolder2 = viewHolder;
        } else {
            viewHolder2 = (ViewHolder) view.getTag();
        }
        ExpressionInfoEntity expressionInfoEntity = this.mLstData.get(i);
        if (this.mDatas.getCatogaryId() == Expressions.exGifCatogary) {
            ImageLoaderJ.load(this.mContext, expressionInfoEntity.getGifExpressionUrl(), viewHolder2.image);
            viewHolder2.mText.setText(expressionInfoEntity.getExpressionName());
        } else {
            viewHolder2.image.setImageResource(expressionInfoEntity.getExPressionUrl());
        }
        return view;
    }

    private class ViewHolder {
        /* access modifiers changed from: private */
        public ImageView image;
        /* access modifiers changed from: private */
        public TextView mText;

        private ViewHolder() {
        }
    }
}
