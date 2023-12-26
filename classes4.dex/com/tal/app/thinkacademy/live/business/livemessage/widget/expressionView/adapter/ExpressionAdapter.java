package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.adapter.BaseRecycleAdapter;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.ExpressionView;
import com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity.ExpressionAllInfoEntity;
import java.util.List;

public class ExpressionAdapter extends BaseRecycleAdapter<ExpressionAllInfoEntity> {
    /* access modifiers changed from: private */
    public ExpressionView mExpressionView;

    public ExpressionAdapter(Context context, List<ExpressionAllInfoEntity> list, ExpressionView expressionView) {
        super(context, list);
        this.mExpressionView = expressionView;
    }

    /* access modifiers changed from: protected */
    public BaseRecycleAdapter<ExpressionAllInfoEntity>.BaseHolder getViewholder(View view) {
        return new ExpressionViewHolder(view);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.item_expression_list_view;
    }

    /* access modifiers changed from: protected */
    public void bindItemView(BaseRecycleAdapter<ExpressionAllInfoEntity>.BaseHolder baseHolder, ExpressionAllInfoEntity expressionAllInfoEntity, int i) {
        ExpressionViewHolder expressionViewHolder = (ExpressionViewHolder) baseHolder;
        if (i == 0) {
            expressionViewHolder.itemView.setBackgroundColor(Color.parseColor("#dddddd"));
        }
        expressionViewHolder.ivExpressionImage.setImageResource(expressionAllInfoEntity.getBackgroundResource());
        OnClickListener(expressionViewHolder.ivExpressionImage, expressionAllInfoEntity.getBottomImageId());
    }

    /* access modifiers changed from: protected */
    public void OnClickListener(final ImageView imageView, final int i) {
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, ExpressionAdapter.class);
                ExpressionAdapter.this.mExpressionView.bootomImageClick(imageView, i);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    class ExpressionViewHolder extends BaseRecycleAdapter<ExpressionAllInfoEntity>.BaseHolder {
        /* access modifiers changed from: private */
        public ImageView ivExpressionImage;

        public ExpressionViewHolder(View view) {
            super(view);
            this.ivExpressionImage = (ImageView) view.findViewById(R.id.iv_expression_gif_image);
        }
    }
}
