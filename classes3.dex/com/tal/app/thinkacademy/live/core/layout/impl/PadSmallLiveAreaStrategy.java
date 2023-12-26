package com.tal.app.thinkacademy.live.core.layout.impl;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaType;
import kotlin.Deprecated;

@Deprecated(message = "已废弃，使用SmallLivePadAreaStrategy")
public class PadSmallLiveAreaStrategy extends AbsLiveAreaStrategy {
    public static final float FUNC_RATIO = 0.33333334f;
    public static final float MAX_VISIBLE_RATIO = 1.6f;
    public static final float MIN_VISIBLE_RATIO = 1.3888888f;
    public static final float PPT_RATIO = 1.3333334f;
    public static final float STREAM_RATIO = 0.12f;

    public PadSmallLiveAreaStrategy(FragmentActivity fragmentActivity) {
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
        this.mVisibleLp.right = this.mVisibleLp.left;
        this.mVisibleLp.top = (screenHeight - videoLayoutParams.height) / 2;
        if (BarUtils.isNavBarVisible(activity)) {
            this.mVisibleLp.top = ((screenHeight - BarUtils.getNavBarHeight()) - videoLayoutParams.height) / 2;
        }
        this.mVisibleLp.bottom = this.mVisibleLp.top;
        this.mHeadLp.width = this.mVisibleLp.width;
        this.mHeadLp.height = (int) (((float) this.mHeadLp.width) * 0.12f);
        this.mHeadLp.left = this.mVisibleLp.left;
        this.mHeadLp.right = this.mVisibleLp.right;
        this.mHeadLp.top = this.mVisibleLp.top;
        this.mHeadLp.bottom = (this.mVisibleLp.bottom + this.mVisibleLp.height) - this.mHeadLp.height;
        this.mPptLp.height = this.mVisibleLp.height - this.mHeadLp.height;
        this.mPptLp.width = (int) (((float) this.mPptLp.height) * 1.3333334f);
        this.mPptLp.top = this.mHeadLp.top + this.mHeadLp.height;
        this.mPptLp.bottom = this.mVisibleLp.bottom;
        this.mFuncLp.width = (int) (((float) this.mPptLp.height) * 0.33333334f);
        this.mFuncLp.height = this.mPptLp.height;
        this.mFuncLp.top = this.mPptLp.top;
        this.mFuncLp.bottom = this.mPptLp.bottom;
        this.mPptLp.left = this.mVisibleLp.left + (((this.mVisibleLp.width - this.mPptLp.width) - this.mFuncLp.width) / 2);
        this.mPptLp.right = this.mFuncLp.width + this.mPptLp.left;
        this.mFuncLp.left = this.mPptLp.left + this.mPptLp.width;
        this.mFuncLp.right = this.mPptLp.left;
        return true;
    }

    public LiveAreaType getLiveType() {
        return LiveAreaType.LIVE_SMALL_PAD;
    }

    private ViewGroup.LayoutParams getVideoLayoutParams(Activity activity) {
        Rect rect = new Rect();
        ((View) activity.findViewById(16908290).getParent()).getWindowVisibleDisplayFrame(rect);
        int i = rect.right - rect.left;
        int screenHeight = ScreenUtils.getScreenHeight();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        int navBarHeight = BarUtils.getNavBarHeight();
        if (BarUtils.isNavBarVisible(activity)) {
            screenHeight -= navBarHeight;
        }
        float f = (((float) i) * 1.0f) / ((float) screenHeight);
        if (f > 1.6f) {
            layoutParams.height = screenHeight;
            layoutParams.width = (int) (((float) screenHeight) * 1.6f);
        } else if (f < 1.3888888f) {
            layoutParams.width = i;
            layoutParams.height = (int) (((float) i) / 1.3888888f);
        } else {
            layoutParams.width = i;
            layoutParams.height = screenHeight;
        }
        return layoutParams;
    }
}
