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

public class VoteLightItem extends LinearLayout {
    private int mCurrentNum;
    private View mView;
    private Handler mainHandler;
    /* access modifiers changed from: private */
    public TextView tv_num;
    /* access modifiers changed from: private */
    public TextView tv_select;
    private TextView tv_x;

    public VoteLightItem(Context context) {
        this(context, true);
    }

    public VoteLightItem(Context context, Boolean bool) {
        this(context, (AttributeSet) null, bool);
    }

    public VoteLightItem(Context context, AttributeSet attributeSet, Boolean bool) {
        super(context, attributeSet);
        if (bool.booleanValue()) {
            LayoutInflater from = LayoutInflater.from(context);
            int i = R.layout.live_business_vote_select_left_item;
            this.mView = !(from instanceof LayoutInflater) ? from.inflate(i, this, true) : XMLParseInstrumentation.inflate(from, i, this, true);
        } else {
            LayoutInflater from2 = LayoutInflater.from(context);
            int i2 = R.layout.live_business_vote_select_light_item;
            this.mView = !(from2 instanceof LayoutInflater) ? from2.inflate(i2, this, true) : XMLParseInstrumentation.inflate(from2, i2, this, true);
        }
        this.tv_num = (TextView) this.mView.findViewById(R.id.tv_vote_1);
        this.tv_select = (TextView) this.mView.findViewById(R.id.tv_1_page_livevideo_vote_select);
        this.tv_x = (TextView) this.mView.findViewById(R.id.tv_vote_1_x);
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public void setSelect(final boolean z) {
        Handler handler = this.mainHandler;
        AnonymousClass1 r1 = new Runnable() {
            public void run() {
                if (VoteLightItem.this.tv_select.isSelected() != z) {
                    VoteLightItem.this.tv_select.setSelected(z);
                    if (z) {
                        VoteLightItem.this.tv_select.setTextColor(VoteLightItem.this.getResources().getColor(R.color.white));
                    } else {
                        VoteLightItem.this.tv_select.setTextColor(VoteLightItem.this.getResources().getColor(R.color.COLOR_FF5C3D));
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
                VoteLightItem.this.tv_select.setSelected(false);
                VoteLightItem.this.tv_select.setTextColor(VoteLightItem.this.getResources().getColor(R.color.COLOR_FF5C3D));
            }
        };
        if (!(handler instanceof Handler)) {
            handler.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, r1);
        }
    }

    public TextView getSelectTextView() {
        return this.tv_select;
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.tv_select.setOnClickListener(onClickListener);
    }

    public void showNum(boolean z) {
        Handler handler = this.mainHandler;
        AnonymousClass3 r0 = new Runnable() {
            public void run() {
            }
        };
        if (!(handler instanceof Handler)) {
            handler.post(r0);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, r0);
        }
    }

    public void setNum(final int i) {
        this.mCurrentNum = i;
        Handler handler = this.mainHandler;
        AnonymousClass4 r1 = new Runnable() {
            public void run() {
                VoteLightItem.this.tv_num.setText(String.valueOf(i));
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
