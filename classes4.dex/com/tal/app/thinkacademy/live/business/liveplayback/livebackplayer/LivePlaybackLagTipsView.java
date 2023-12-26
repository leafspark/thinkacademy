package com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public class LivePlaybackLagTipsView extends BaseLivePluginView {
    /* access modifiers changed from: private */
    public View.OnClickListener mOnClickListener;
    private TextView mPlayLagTipsTextView;
    private View mPlayLagTipsView;

    public LivePlaybackLagTipsView(Context context) {
        super(context);
    }

    public LivePlaybackLagTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LivePlaybackLagTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initViews() {
        LivePlaybackLagTipsView.super.initViews();
        this.mPlayLagTipsView = findViewById(R.id.playLagTipLayout);
        this.mPlayLagTipsTextView = (TextView) findViewById(R.id.lagTipsTextView);
        showLagTips();
    }

    public int getLayoutId() {
        return R.layout.live_business_playback_lag_tips_view;
    }

    public void setTipsClickListen(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    private void showLagTips() {
        String string = getContext().getString(R.string.playback_play_lag_tip_pre);
        String string2 = getContext().getString(R.string.playback_play_lag_tip_next);
        TextHighLightUtil.INSTANCE.setTextHighLightWithClick(this.mPlayLagTipsTextView, String.format("%s%s", new Object[]{string, string2}), string2, R.color.color_ffaa0a, new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, LivePlaybackLagTipsView.class);
                if (LivePlaybackLagTipsView.this.mOnClickListener != null) {
                    LivePlaybackLagTipsView.this.mOnClickListener.onClick(view);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mPlayLagTipsView.setVisibility(0);
    }
}
