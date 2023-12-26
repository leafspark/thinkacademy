package com.tal.app.thinkacademy.live.core.layout.impl;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaType;

public class BigClassLiveAreaStrategy extends AbsLiveAreaStrategy {
    public static final float PPT_RATIO = 1.3333334f;
    public static final float VIDEO_HEAD_RATIO = 1.3333334f;
    private static final float VIDEO_MAN_RATIO_PAD = 1.6f;
    public static final float VIDEO_MAX_RATIO = 1.8888888f;
    private static final float VIDEO_MIN_RATIO_PAD = 1.6f;
    public static final float VIDEO_RATIO = 1.7777778f;

    public BigClassLiveAreaStrategy(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public boolean generateArea() {
        Activity activity = (Activity) this.mWeakActivity.get();
        if (activity == null) {
            return false;
        }
        ViewGroup.LayoutParams videoLayoutParams = getVideoLayoutParams(activity);
        Rect rect = new Rect();
        ((View) activity.findViewById(16908290).getParent()).getWindowVisibleDisplayFrame(rect);
        int i = rect.right - rect.left;
        int screenHeight = ScreenUtils.getScreenHeight();
        if (this.mScreenLp.width == i && this.mVisibleLp.width == videoLayoutParams.width && this.mVisibleLp.height == videoLayoutParams.height) {
            return false;
        }
        if (this.isPad && this.mScreenLp.width == i && this.mVisibleLp.width == videoLayoutParams.width && this.mVisibleLp.height == videoLayoutParams.height - SizeUtils.dp2px(61.0f)) {
            return false;
        }
        this.mScreenLp.width = i;
        this.mScreenLp.height = screenHeight;
        this.mVisibleLp.width = videoLayoutParams.width;
        this.mVisibleLp.height = videoLayoutParams.height;
        this.mVisibleLp.left = (i - videoLayoutParams.width) / 2;
        this.mVisibleLp.right = this.mVisibleLp.left;
        this.mVisibleLp.top = (screenHeight - videoLayoutParams.height) / 2;
        if (this.isPad && BarUtils.isNavBarVisible(activity)) {
            this.mVisibleLp.top = 0;
        }
        this.mVisibleLp.bottom = this.mVisibleLp.top;
        if (this.isPad) {
            this.mPptLp.height = this.mVisibleLp.height - SizeUtils.dp2px(61.0f);
        } else {
            this.mPptLp.height = this.mVisibleLp.height;
        }
        this.mPptLp.width = (int) (((float) this.mPptLp.height) * 1.3333334f);
        this.mPptLp.left = this.mVisibleLp.left;
        this.mPptLp.right = (this.mVisibleLp.right + this.mVisibleLp.width) - this.mPptLp.width;
        this.mPptLp.top = this.mVisibleLp.top;
        this.mPptLp.bottom = this.mVisibleLp.bottom;
        this.mHeadLp.width = this.mVisibleLp.width - this.mPptLp.width;
        this.mHeadLp.height = (int) (((float) this.mHeadLp.width) / 1.3333334f);
        this.mHeadLp.left = this.mPptLp.left + this.mPptLp.width;
        this.mHeadLp.right = this.mVisibleLp.right;
        this.mHeadLp.top = this.mPptLp.top;
        this.mHeadLp.bottom = (this.mVisibleLp.bottom + this.mVisibleLp.height) - this.mHeadLp.height;
        this.mMsgLp.width = this.mHeadLp.width;
        this.mMsgLp.height = videoLayoutParams.height - this.mHeadLp.height;
        this.mMsgLp.left = this.mHeadLp.left;
        this.mMsgLp.right = this.mHeadLp.right;
        this.mMsgLp.top = this.mHeadLp.top + this.mHeadLp.height;
        this.mMsgLp.bottom = this.mVisibleLp.bottom;
        return true;
    }

    public LiveAreaType getLiveType() {
        return LiveAreaType.LIVE_BIG;
    }

    private ViewGroup.LayoutParams getVideoLayoutParams(Activity activity) {
        Rect rect = new Rect();
        ((View) activity.findViewById(16908290).getParent()).getWindowVisibleDisplayFrame(rect);
        int i = rect.right - rect.left;
        int screenHeight = ScreenUtils.getScreenHeight();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (this.isPad) {
            int navBarHeight = BarUtils.getNavBarHeight();
            if (BarUtils.isNavBarVisible(activity)) {
                screenHeight -= navBarHeight;
            }
            float f = (float) i;
            float f2 = (float) screenHeight;
            float f3 = (1.0f * f) / f2;
            if (f3 < 1.6f) {
                layoutParams.width = i;
                layoutParams.height = (int) (f / 1.6f);
            } else if (f3 > 1.6f) {
                layoutParams.height = screenHeight;
                layoutParams.width = (int) (f2 * 1.6f);
            } else {
                layoutParams.width = i;
                layoutParams.height = screenHeight;
            }
        } else {
            float f4 = (float) i;
            float f5 = (float) screenHeight;
            float f6 = (1.0f * f4) / f5;
            if (f6 > 1.7777778f && f6 <= 1.8888888f) {
                layoutParams.width = i;
                layoutParams.height = screenHeight;
            } else if (f6 > 1.8888888f) {
                layoutParams.height = screenHeight;
                layoutParams.width = (int) (f5 * 1.8888888f);
            } else {
                layoutParams.width = i;
                layoutParams.height = (int) (f4 / 1.7777778f);
            }
        }
        return layoutParams;
    }
}
