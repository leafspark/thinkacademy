package com.tal.app.thinkacademy.live.business.vote.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public class VoteLightResultItem extends LinearLayout {
    /* access modifiers changed from: private */
    public Context mContext;
    private int mCurrentNum;
    private View mView;
    private Handler mainHandler;
    /* access modifiers changed from: private */
    public TextView tv_num;
    /* access modifiers changed from: private */
    public TextView tv_select;
    private TextView tv_x;

    public VoteLightResultItem(Context context) {
        this(context, true, "");
    }

    public VoteLightResultItem(Context context, Boolean bool, String str) {
        this(context, (AttributeSet) null, bool, str);
    }

    public VoteLightResultItem(Context context, AttributeSet attributeSet, Boolean bool, String str) {
        super(context, attributeSet);
        this.mContext = context;
        if ("TRUE".equalsIgnoreCase(str) || "FALSE".equals(str)) {
            LayoutInflater from = LayoutInflater.from(context);
            int i = R.layout.live_business_vote_result_widen;
            this.mView = !(from instanceof LayoutInflater) ? from.inflate(i, this, true) : XMLParseInstrumentation.inflate(from, i, this, true);
        } else {
            LayoutInflater from2 = LayoutInflater.from(context);
            int i2 = R.layout.live_business_vote_result;
            this.mView = !(from2 instanceof LayoutInflater) ? from2.inflate(i2, this, true) : XMLParseInstrumentation.inflate(from2, i2, this, true);
        }
        this.tv_num = (TextView) this.mView.findViewById(R.id.live_business_result_bottom);
        this.tv_select = (TextView) this.mView.findViewById(R.id.live_business_result_top);
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public void setSelect(final boolean z) {
        Handler handler = this.mainHandler;
        AnonymousClass1 r1 = new Runnable() {
            public void run() {
                if (VoteLightResultItem.this.tv_select.isSelected() != z) {
                    VoteLightResultItem.this.tv_select.setSelected(z);
                    if (z) {
                        VoteLightResultItem.this.tv_select.setTextColor(VoteLightResultItem.this.getResources().getColor(R.color.white));
                    } else {
                        VoteLightResultItem.this.tv_select.setTextColor(VoteLightResultItem.this.getResources().getColor(R.color.COLOR_FF5C3D));
                    }
                }
            }
        };
        if (!(handler instanceof Handler)) {
            handler.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, r1);
        }
    }

    public void setSelectFalse() {
        Handler handler = this.mainHandler;
        AnonymousClass2 r1 = new Runnable() {
            public void run() {
                VoteLightResultItem.this.tv_select.setSelected(false);
                VoteLightResultItem.this.tv_select.setTextColor(VoteLightResultItem.this.getResources().getColor(R.color.COLOR_FF5C3D));
            }
        };
        if (!(handler instanceof Handler)) {
            handler.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, r1);
        }
    }

    public View getLayout() {
        return this.mView;
    }

    public TextView getSelectTextView() {
        return this.tv_select;
    }

    public TextView getPercentTextView() {
        return this.tv_num;
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.tv_select.setOnClickListener(onClickListener);
    }

    public void showNum(final boolean z) {
        Handler handler = this.mainHandler;
        AnonymousClass3 r1 = new Runnable() {
            public void run() {
                if (z) {
                    VoteLightResultItem.this.tv_num.setVisibility(0);
                } else {
                    VoteLightResultItem.this.tv_num.setVisibility(8);
                }
            }
        };
        if (!(handler instanceof Handler)) {
            handler.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, r1);
        }
    }

    public void setNum(final int i) {
        this.mCurrentNum = i;
        Handler handler = this.mainHandler;
        AnonymousClass4 r1 = new Runnable() {
            public void run() {
                VoteLightResultItem.this.tv_num.setText(VoteLightResultItem.this.mContext.getString(R.string.vote_result_percent, new Object[]{Integer.valueOf(i)}));
            }
        };
        if (!(handler instanceof Handler)) {
            handler.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, r1);
        }
    }

    public int getCurrentNum() {
        return this.mCurrentNum;
    }
}
