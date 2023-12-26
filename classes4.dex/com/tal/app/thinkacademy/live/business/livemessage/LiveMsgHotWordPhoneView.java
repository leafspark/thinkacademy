package com.tal.app.thinkacademy.live.business.livemessage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.DriverTrack;

public class LiveMsgHotWordPhoneView extends BaseLivePluginView implements View.OnClickListener {
    private ConstraintLayout clParent;
    private TextView[] hotWords;
    private ImageView ivClose;
    private LiveMsgPluginDriver mLiveMsgPluginDriver;
    private TextView tvDone;
    private TextView tvHaHa;
    private TextView tvNotUnderstand;
    private TextView tvUnderstand;

    public LiveMsgHotWordPhoneView(Context context) {
        super(context);
    }

    public LiveMsgHotWordPhoneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LiveMsgHotWordPhoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_live_msg_hot_word;
    }

    public void setDriver(LiveMsgPluginDriver liveMsgPluginDriver) {
        this.mLiveMsgPluginDriver = liveMsgPluginDriver;
    }

    public void initViews() {
        LiveMsgHotWordPhoneView.super.initViews();
        this.clParent = getInflateView().findViewById(R.id.cl_live_business_hot_word_parent);
        this.tvDone = (TextView) getInflateView().findViewById(R.id.tv_done);
        this.tvNotUnderstand = (TextView) getInflateView().findViewById(R.id.tv_dont_understand);
        this.tvHaHa = (TextView) getInflateView().findViewById(R.id.tv_hahaha);
        this.tvUnderstand = (TextView) getInflateView().findViewById(R.id.tv_understand);
        ImageView imageView = (ImageView) getInflateView().findViewById(R.id.iv_live_business_hot_word_close);
        this.ivClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, LiveMsgHotWordPhoneView.class);
                LiveMsgHotWordPhoneView.this.closeHotWordView();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        TextView[] textViewArr = {this.tvDone, this.tvNotUnderstand, this.tvHaHa, this.tvUnderstand};
        this.hotWords = textViewArr;
        int length = textViewArr.length;
        for (int i = 0; i < length; i++) {
            this.hotWords[i].setOnClickListener(this);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.clParent.getLayoutParams();
        layoutParams.setMarginStart(LiveAreaContext.get().getVisibleLp().left);
        this.clParent.setLayoutParams(layoutParams);
        setTranslationY((float) SizeUtils.dp2px(80.0f));
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, LiveMsgHotWordPhoneView.class);
        if (view.getId() == R.id.tv_done) {
            sendMessage(0);
        } else if (view.getId() == R.id.tv_dont_understand) {
            sendMessage(1);
        } else if (view.getId() == R.id.tv_hahaha) {
            sendMessage(2);
        } else {
            sendMessage(3);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    private void sendMessage(int i) {
        String charSequence = this.hotWords[i].getText().toString();
        this.mLiveMsgPluginDriver.sendHotWord(charSequence);
        closeHotWordView();
        DriverTrack.INSTANCE.classRoomInteractShorcutSend(charSequence);
    }

    public void hotWordSelected(int i) {
        int length = this.hotWords.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != i) {
                this.hotWords[i2].setSelected(false);
            }
        }
        if (i != -1) {
            this.hotWords[i].setSelected(true);
            this.mLiveMsgPluginDriver.track_click_quickr_reply(this.hotWords[i].getText().toString());
        }
    }

    private void clearHotWordSelected() {
        hotWordSelected(-1);
    }

    public void showHotWordView() {
        ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[]{(float) getMeasuredHeight(), 0.0f}).start();
    }

    public void closeHotWordView() {
        ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[]{0.0f, (float) getMeasuredHeight()}).start();
        clearHotWordSelected();
    }
}
