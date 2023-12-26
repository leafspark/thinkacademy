package com.tal.app.thinkacademy.live.business.videocall.pager;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public abstract class BaseVideoCallPager extends BaseLivePluginView {
    protected FrameLayout flVideoContainer;
    protected boolean isHalfBodyState;
    protected boolean isPlayBack;
    protected String mInteractionId;
    protected View tvRaiseHand;
    protected int videoViewHeight;
    protected int videoViewWidth;

    /* access modifiers changed from: protected */
    public abstract void initVideoViewSize();

    public void initView() {
    }

    public void setHandNumVisible(boolean z) {
    }

    public void setRaiseHandClickListener(View.OnClickListener onClickListener) {
    }

    public void setSpeaker(String str, String str2, String str3, boolean z) {
    }

    public boolean showConformDlg(int i) {
        return false;
    }

    public void showVideoMask(boolean z, int i) {
    }

    public void updateHandNum(int i) {
    }

    public void updateUI(int i, int i2, boolean z, boolean z2) {
    }

    public void updateUIisSpeaking(int i, int i2, boolean z) {
    }

    public BaseVideoCallPager(Context context, boolean z) {
        super(context);
        this.isPlayBack = z;
        initVideoViewSize();
        initView();
    }

    public void setInteractionId(String str) {
        this.mInteractionId = str;
    }

    public void removeRenderView(SurfaceView surfaceView) {
        StringBuilder sb = new StringBuilder();
        sb.append("removeRenderView: surfaceView=");
        sb.append(surfaceView != null);
        XesLog.dt(sb.toString(), new Object[0]);
        if (surfaceView != null) {
            this.flVideoContainer.removeView(surfaceView);
        }
    }

    public void removeRenderView() {
        XesLog.dt("removeRenderView: remove all", new Object[0]);
        this.flVideoContainer.removeAllViews();
    }

    public void addRenderView(SurfaceView surfaceView) {
        StringBuilder sb = new StringBuilder();
        sb.append("addRenderView: surfaceView=");
        sb.append(surfaceView != null);
        XesLog.dt(sb.toString(), new Object[0]);
        if (surfaceView != null) {
            ViewGroup viewGroup = (ViewGroup) surfaceView.getParent();
            if (viewGroup != null) {
                XesLog.dt("addRenderView: surfaceView has parent", new Object[0]);
                viewGroup.removeView(surfaceView);
            }
            this.flVideoContainer.addView(surfaceView);
            if (surfaceView.getVisibility() != 0) {
                surfaceView.setVisibility(0);
            }
            ((FrameLayout.LayoutParams) surfaceView.getLayoutParams()).gravity = 17;
            surfaceView.requestLayout();
        }
    }

    public int getVideoViewWidth() {
        return this.videoViewWidth;
    }

    public int getVideoViewHeight() {
        return this.videoViewHeight;
    }
}
