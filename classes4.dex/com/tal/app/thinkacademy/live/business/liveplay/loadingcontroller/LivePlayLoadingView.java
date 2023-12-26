package com.tal.app.thinkacademy.live.business.liveplay.loadingcontroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkcademy.lib.commui.widget.LoadingView;

public class LivePlayLoadingView extends BaseLivePluginView {
    protected FrameLayout mFlArea;
    protected ImageView mIvNoTeacher;
    private LinearLayout mLlState;
    private LoadingView mLvBufferLoading;
    protected TeacherOnlineListen mTeacherOnlineListen;
    private TextView mTvTip;
    protected View mVGuide;

    public void setTeacherOnlineListen(TeacherOnlineListen teacherOnlineListen) {
        this.mTeacherOnlineListen = teacherOnlineListen;
    }

    public LivePlayLoadingView(Context context) {
        super(context);
    }

    public LivePlayLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LivePlayLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_liveplay_loading_view;
    }

    public void initViews() {
        LivePlayLoadingView.super.initViews();
        this.mFlArea = (FrameLayout) findViewById(R.id.fl_live_business_liveplay_courseware_area);
        this.mLvBufferLoading = findViewById(R.id.lv_live_business_liveplay_buffer_load);
        this.mIvNoTeacher = (ImageView) findViewById(R.id.iv_livebusiness_liveplay_no_teacher);
        this.mLlState = (LinearLayout) findViewById(R.id.ll_live_business_liveplay_state);
        this.mTvTip = (TextView) findViewById(R.id.tv_live_business_liveplay_state);
        this.mVGuide = findViewById(R.id.live_business_simple_guide);
    }

    public void showCoursewareLoading(boolean z) {
        if (z) {
            setVisibility(0);
            this.mFlArea.setBackgroundResource(R.color.color_ffffff);
            this.mFlArea.setVisibility(0);
            this.mLvBufferLoading.setVisibility(0);
            this.mLlState.setVisibility(8);
            return;
        }
        this.mLvBufferLoading.setVisibility(8);
    }

    public void showNoTeacher(boolean z) {
        if (z) {
            setVisibility(0);
            this.mIvNoTeacher.setVisibility(0);
        } else {
            this.mIvNoTeacher.setVisibility(8);
        }
        TeacherOnlineListen teacherOnlineListen = this.mTeacherOnlineListen;
        if (teacherOnlineListen != null) {
            teacherOnlineListen.videoOnLine(!z);
        }
    }

    public void showBufferLoading(boolean z) {
        if (z) {
            setVisibility(0);
            this.mFlArea.setVisibility(0);
            this.mFlArea.setBackgroundResource(R.color.transparent);
            this.mLvBufferLoading.setVisibility(0);
            this.mLlState.setVisibility(8);
            return;
        }
        this.mLvBufferLoading.setVisibility(8);
    }

    public void showCoursewareState(boolean z, String str) {
        if (z) {
            setVisibility(0);
            this.mFlArea.setBackgroundResource(R.color.color_ffffff);
            this.mFlArea.setVisibility(0);
            this.mLlState.setVisibility(0);
            this.mLvBufferLoading.setVisibility(8);
            this.mTvTip.setText(str);
        } else {
            this.mLlState.setVisibility(8);
        }
        TeacherOnlineListen teacherOnlineListen = this.mTeacherOnlineListen;
        if (teacherOnlineListen != null) {
            teacherOnlineListen.teacherOnLine(!z);
        }
    }

    public void hideLoading() {
        this.mFlArea.setVisibility(8);
    }

    public void setLayoutParams() {
        int i = LiveAreaContext.get().getVisibleLp().width;
        int dp2px = LiveAreaContext.get().getVisibleLp().height - (PadUtils.isPad(this.mContext) ? SizeUtils.dp2px(61.0f) : 0);
        ConstraintLayout.LayoutParams layoutParams = this.mVGuide.getLayoutParams();
        layoutParams.dimensionRatio = i + ":" + dp2px;
        layoutParams.width = i;
        layoutParams.height = dp2px;
        this.mVGuide.setLayoutParams(layoutParams);
        LiveAreaContext.get().layoutObserver.observe(this.mContext, new Observer<LiveAreaContext>() {
            public void onChanged(LiveAreaContext liveAreaContext) {
                ConstraintLayout.LayoutParams layoutParams = LivePlayLoadingView.this.mVGuide.getLayoutParams();
                LiveAreaLayoutParams visibleLp = LiveAreaContext.get().getVisibleLp();
                int i = visibleLp.width;
                int dp2px = visibleLp.height - (PadUtils.isPad(LivePlayLoadingView.this.mContext) ? SizeUtils.dp2px(61.0f) : 0);
                layoutParams.dimensionRatio = i + ":" + dp2px;
                layoutParams.width = i;
                layoutParams.height = dp2px;
                LivePlayLoadingView.this.mVGuide.setLayoutParams(layoutParams);
            }
        });
    }
}
