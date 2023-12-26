package com.tal.user.global.trade.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.api.TalTradeSdk;

public class TalTradeSecondaryConfirmationLayout extends RelativeLayout {
    private String cancel;
    /* access modifiers changed from: private */
    public OnClickListener clickListener;
    private String confirm;
    private String descrip;
    private View rootView;
    private String title;
    private TextView tvCancel;
    private TextView tvConfirm;
    private TextView tvDescrip;
    private TextView tvTitle;
    private View viewCenterLine;

    public interface OnClickListener {
        void cancel();

        void confirm();
    }

    public TalTradeSecondaryConfirmationLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TalTradeSecondaryConfirmationLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TalTradeSecondaryConfirmationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SecondaryConfirmation);
        this.title = obtainStyledAttributes.getString(R.styleable.SecondaryConfirmation_taltrade_sc_title);
        this.cancel = obtainStyledAttributes.getString(R.styleable.SecondaryConfirmation_taltrade_sc_cancel);
        this.confirm = obtainStyledAttributes.getString(R.styleable.SecondaryConfirmation_taltrade_sc_confirm);
        this.descrip = obtainStyledAttributes.getString(R.styleable.SecondaryConfirmation_taltrade_sc_descrip);
        LayoutInflater from = LayoutInflater.from(context);
        int i = R.layout.view_tal_trade_secondary_confirmation;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, this) : XMLParseInstrumentation.inflate(from, i, this);
        this.rootView = inflate;
        this.tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.tvCancel = (TextView) this.rootView.findViewById(R.id.tv_cancel);
        this.tvConfirm = (TextView) this.rootView.findViewById(R.id.tv_confirm);
        this.tvDescrip = (TextView) this.rootView.findViewById(R.id.tv_descrip);
        this.viewCenterLine = this.rootView.findViewById(R.id.viewCenterLine);
        this.tvDescrip.setText(this.descrip);
        this.tvTitle.setText(this.title);
        this.tvCancel.setText(this.cancel);
        this.tvConfirm.setText(this.confirm);
        this.tvConfirm.setTextColor(TalTradeSdk.getInstance().getPrimaryColor());
        if (TextUtils.isEmpty(this.descrip)) {
            this.tvDescrip.setVisibility(8);
        } else {
            this.tvDescrip.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.cancel)) {
            this.tvCancel.setVisibility(8);
            this.viewCenterLine.setVisibility(8);
        } else {
            this.tvCancel.setVisibility(0);
            this.viewCenterLine.setVisibility(0);
        }
        this.tvCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, TalTradeSecondaryConfirmationLayout.class);
                if (TalTradeSecondaryConfirmationLayout.this.clickListener != null) {
                    TalTradeSecondaryConfirmationLayout.this.clickListener.cancel();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.tvConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, TalTradeSecondaryConfirmationLayout.class);
                if (TalTradeSecondaryConfirmationLayout.this.clickListener != null) {
                    TalTradeSecondaryConfirmationLayout.this.clickListener.confirm();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void setClickListener(OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public TextView getTvTitle() {
        return this.tvTitle;
    }

    public TextView getTvCancel() {
        return this.tvCancel;
    }

    public TextView getTvConfirm() {
        return this.tvConfirm;
    }

    public TextView getTvDescrip() {
        return this.tvDescrip;
    }
}
