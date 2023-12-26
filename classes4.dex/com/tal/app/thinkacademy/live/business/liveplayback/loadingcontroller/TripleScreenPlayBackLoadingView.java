package com.tal.app.thinkacademy.live.business.liveplayback.loadingcontroller;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkcademy.lib.commui.widget.LoadingView;

class TripleScreenPlayBackLoadingView extends BaseLoadingView {
    /* access modifiers changed from: private */
    public Button mBtnRetry;
    private Button mBtnSwitchLine;
    /* access modifiers changed from: private */
    public ConstraintLayout mClRoot;
    /* access modifiers changed from: private */
    public IOnClickListener mClickListener;
    /* access modifiers changed from: private */
    public FrameLayout mFlReplay;
    private ImageView mIvReplay;
    /* access modifiers changed from: private */
    public LinearLayout mLlError;
    /* access modifiers changed from: private */
    public LinearLayout mLlLoading;
    /* access modifiers changed from: private */
    public LoadingView mLvBufferLoad;
    /* access modifiers changed from: private */
    public TextView mTvErrorTip;

    public TripleScreenPlayBackLoadingView(Context context) {
        super(context);
    }

    public int getLayoutId() {
        return R.layout.live_business_playback_loading_view;
    }

    public void initViews() {
        super.initViews();
        this.mLlLoading = (LinearLayout) findViewById(R.id.ll_live_business_loading);
        this.mLlError = (LinearLayout) findViewById(R.id.ll_live_business_error);
        this.mTvErrorTip = (TextView) findViewById(R.id.tv_live_business_error_tip);
        this.mBtnRetry = (Button) findViewById(R.id.btn_live_business_error_retry);
        this.mLvBufferLoad = findViewById(R.id.lv_live_business_buffer_load);
        this.mFlReplay = (FrameLayout) findViewById(R.id.fl_live_business_video_replay);
        this.mIvReplay = (ImageView) findViewById(R.id.iv_live_business_video_replay);
        this.mClRoot = findViewById(R.id.cl_live_business_loading_root);
        this.mBtnSwitchLine = (Button) findViewById(R.id.btn_live_business_switchLine);
    }

    public void setClickListener(IOnClickListener iOnClickListener) {
        this.mClickListener = iOnClickListener;
        this.mBtnRetry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, TripleScreenPlayBackLoadingView.class);
                TripleScreenPlayBackLoadingView.this.showLoading();
                TripleScreenPlayBackLoadingView.this.mClickListener.onRetryClickListener();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mIvReplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, TripleScreenPlayBackLoadingView.class);
                TripleScreenPlayBackLoadingView.this.mClickListener.onReplayClickListener();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mBtnSwitchLine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, TripleScreenPlayBackLoadingView.class);
                if (TripleScreenPlayBackLoadingView.this.mClickListener != null) {
                    TripleScreenPlayBackLoadingView.this.mClickListener.onSwitchLine();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void hideView() {
        post(new Runnable() {
            public void run() {
                TripleScreenPlayBackLoadingView.this.setVisibility(8);
            }
        });
    }

    public void showLoading() {
        post(new Runnable() {
            public void run() {
                TripleScreenPlayBackLoadingView.this.setVisibility(0);
                TripleScreenPlayBackLoadingView.this.mClRoot.setBackgroundResource(R.color.white);
                TripleScreenPlayBackLoadingView.this.mLlLoading.setVisibility(0);
                TripleScreenPlayBackLoadingView.this.mLlError.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mLvBufferLoad.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mFlReplay.setVisibility(8);
            }
        });
    }

    public void showError(final boolean z, final String str) {
        post(new Runnable() {
            public void run() {
                TripleScreenPlayBackLoadingView.this.setVisibility(0);
                TripleScreenPlayBackLoadingView.this.mTvErrorTip.setText(str);
                TripleScreenPlayBackLoadingView.this.mClRoot.setBackgroundResource(R.color.white);
                TripleScreenPlayBackLoadingView.this.mLlLoading.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mLlError.setVisibility(0);
                TripleScreenPlayBackLoadingView.this.mLvBufferLoad.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mFlReplay.setVisibility(8);
                if (z) {
                    TripleScreenPlayBackLoadingView.this.mBtnRetry.setVisibility(0);
                } else {
                    TripleScreenPlayBackLoadingView.this.mBtnRetry.setVisibility(8);
                }
            }
        });
    }

    public void showBufferLoad() {
        post(new Runnable() {
            public void run() {
                TripleScreenPlayBackLoadingView.this.setVisibility(0);
                TripleScreenPlayBackLoadingView.this.mClRoot.setBackgroundResource(R.color.transparent);
                TripleScreenPlayBackLoadingView.this.mLlLoading.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mLlError.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mLvBufferLoad.setVisibility(0);
                TripleScreenPlayBackLoadingView.this.mFlReplay.setVisibility(8);
            }
        });
    }

    public void showReplay() {
        post(new Runnable() {
            public void run() {
                TripleScreenPlayBackLoadingView.this.setVisibility(0);
                TripleScreenPlayBackLoadingView.this.mClRoot.setBackgroundResource(R.color.transparent);
                TripleScreenPlayBackLoadingView.this.mLlLoading.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mLlError.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mLvBufferLoad.setVisibility(8);
                TripleScreenPlayBackLoadingView.this.mFlReplay.setVisibility(0);
            }
        });
    }
}
