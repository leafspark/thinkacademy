package com.tal.app.thinkacademy.live.core.layout.impl;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaType;

public class PhoneSmallLiveAreaStrategy extends AbsLiveAreaStrategy {
    public static final float PPT_RATIO = 1.3333334f;
    public static final float VIDEO_HEAD_RATIO = 0.6666667f;
    public static final float VISIBLE_RATIO_MAX = 1.8333334f;
    public static final float VISIBLE_RATIO_MIN = 1.7777778f;

    public PhoneSmallLiveAreaStrategy(FragmentActivity fragmentActivity) {
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
        this.mScreenLp.width = i;
        this.mScreenLp.height = screenHeight;
        this.mVisibleLp.width = videoLayoutParams.width;
        this.mVisibleLp.height = videoLayoutParams.height;
        this.mVisibleLp.left = (i - videoLayoutParams.width) / 2;
        this.mVisibleLp.top = (screenHeight - videoLayoutParams.height) / 2;
        this.mVisibleLp.right = this.mVisibleLp.left;
        this.mVisibleLp.bottom = this.mVisibleLp.top;
        this.mPptLp.width = (int) (((float) videoLayoutParams.height) * 1.3333334f);
        this.mPptLp.height = this.mVisibleLp.height;
        this.mPptLp.left = this.mVisibleLp.left;
        this.mPptLp.top = this.mVisibleLp.top;
        this.mPptLp.right = (this.mVisibleLp.right + this.mVisibleLp.width) - this.mPptLp.width;
        this.mPptLp.bottom = this.mVisibleLp.bottom;
        this.mHeadLp.width = this.mVisibleLp.width - this.mPptLp.width;
        this.mHeadLp.height = (int) (((float) this.mHeadLp.width) / 0.6666667f);
        this.mHeadLp.left = this.mPptLp.left + this.mPptLp.width;
        this.mHeadLp.right = this.mVisibleLp.right;
        this.mHeadLp.top = this.mPptLp.top;
        this.mHeadLp.bottom = (this.mVisibleLp.bottom + this.mVisibleLp.height) - this.mHeadLp.height;
        this.mFuncLp.width = this.mHeadLp.width;
        this.mFuncLp.height = this.mVisibleLp.height - this.mHeadLp.height;
        this.mFuncLp.top = this.mHeadLp.top + this.mHeadLp.height;
        this.mFuncLp.bottom = this.mPptLp.bottom;
        this.mFuncLp.left = this.mHeadLp.left;
        this.mFuncLp.right = this.mHeadLp.right;
        return true;
    }

    public LiveAreaType getLiveType() {
        return LiveAreaType.LIVE_SMALL_PHONE;
    }

    private ViewGroup.LayoutParams getVideoLayoutParams(Activity activity) {
        Rect rect = new Rect();
        ((View) activity.findViewById(16908290).getParent()).getWindowVisibleDisplayFrame(rect);
        int i = rect.right - rect.left;
        int screenHeight = ScreenUtils.getScreenHeight();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        float f = (float) i;
        float f2 = (float) screenHeight;
        float f3 = (1.0f * f) / f2;
        if (f3 < 1.7777778f) {
            layoutParams.width = i;
            layoutParams.height = (int) (f / 1.7777778f);
        } else if (f3 > 1.8333334f) {
            layoutParams.width = (int) (f2 * 1.8333334f);
            layoutParams.height = screenHeight;
        } else {
            layoutParams.width = i;
            layoutParams.height = screenHeight;
        }
        return layoutParams;
    }
}
