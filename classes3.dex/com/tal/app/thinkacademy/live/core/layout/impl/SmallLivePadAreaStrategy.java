package com.tal.app.thinkacademy.live.core.layout.impl;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/layout/impl/SmallLivePadAreaStrategy;", "Lcom/tal/app/thinkacademy/live/core/layout/impl/AbsLiveAreaStrategy;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "generateArea", "", "getLiveType", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaType;", "Companion", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmallLivePadAreaStrategy.kt */
public final class SmallLivePadAreaStrategy extends AbsLiveAreaStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float FUNC_WIDTH = 80.0f;
    public static final float SCREEN_RATIO_1 = 1.4f;
    public static final float SCREEN_RATIO_2 = 1.6f;
    public static final float STREAM_HEIGHT_RATIO_0 = 0.15f;
    public static final float STREAM_HEIGHT_RATIO_1 = 0.1317f;
    public static final float STREAM_HEIGHT_RATIO_2 = 0.15f;
    public static final float TITLE_HEIGHT = 44.0f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallLivePadAreaStrategy(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/layout/impl/SmallLivePadAreaStrategy$Companion;", "", "()V", "FUNC_WIDTH", "", "SCREEN_RATIO_1", "SCREEN_RATIO_2", "STREAM_HEIGHT_RATIO_0", "STREAM_HEIGHT_RATIO_1", "STREAM_HEIGHT_RATIO_2", "TITLE_HEIGHT", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SmallLivePadAreaStrategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public boolean generateArea() {
        Activity activity = (FragmentActivity) this.mWeakActivity.get();
        boolean z = false;
        if (activity == null) {
            return false;
        }
        int i = activity.getResources().getDisplayMetrics().widthPixels;
        int i2 = activity.getResources().getDisplayMetrics().heightPixels;
        if (!BarUtils.isNavBarVisible(activity)) {
            i2 = ScreenUtils.getScreenHeight();
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        layoutParams.width = i;
        layoutParams.height = i2;
        if (this.mScreenLp.width == i && this.mVisibleLp.width == layoutParams.width && this.mScreenLp.height == layoutParams.height) {
            return false;
        }
        this.mScreenLp.width = layoutParams.width;
        this.mScreenLp.height = layoutParams.height;
        this.mVisibleLp.width = this.mScreenLp.width;
        this.mVisibleLp.height = this.mScreenLp.height;
        this.mTitleLp.width = this.mVisibleLp.width;
        this.mTitleLp.height = SizeUtils.dp2px(44.0f);
        this.mTitleLp.bottom = (this.mVisibleLp.bottom + this.mVisibleLp.height) - this.mTitleLp.height;
        float f = (float) i2;
        float f2 = (((float) i) * 1.0f) / f;
        float f3 = 0.15f;
        if (!(0.0f <= f2 && f2 <= 1.4f)) {
            if (1.4f <= f2 && f2 <= 1.6f) {
                z = true;
            }
            if (z) {
                f3 = 0.1317f;
            }
        }
        this.mHeadLp.width = this.mTitleLp.width;
        this.mHeadLp.height = (int) (f * f3);
        this.mHeadLp.left = this.mTitleLp.left;
        this.mHeadLp.top = this.mTitleLp.top + this.mTitleLp.height;
        this.mHeadLp.right = this.mTitleLp.right;
        this.mHeadLp.bottom = this.mTitleLp.bottom - this.mHeadLp.height;
        this.mPptLp.width = this.mVisibleLp.width;
        this.mPptLp.height = (this.mVisibleLp.height - this.mTitleLp.height) - this.mHeadLp.height;
        this.mPptLp.left = this.mVisibleLp.left;
        this.mPptLp.top = this.mHeadLp.top + this.mHeadLp.height;
        this.mPptLp.right = this.mPptLp.left;
        this.mPptLp.bottom = this.mVisibleLp.bottom;
        this.mFuncLp.height = this.mPptLp.height;
        this.mFuncLp.width = SizeUtils.dp2px(80.0f);
        this.mFuncLp.left = (this.mPptLp.left + this.mPptLp.width) - this.mFuncLp.width;
        this.mFuncLp.top = this.mPptLp.top;
        this.mFuncLp.right = this.mPptLp.right;
        this.mFuncLp.bottom = this.mPptLp.bottom;
        return true;
    }

    public LiveAreaType getLiveType() {
        return LiveAreaType.LIVE_SMALL_PAD;
    }
}
