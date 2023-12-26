package com.scwang.smart.refresh.layout.api;

import android.animation.ValueAnimator;
import com.scwang.smart.refresh.layout.constant.RefreshState;

public interface RefreshKernel {
    ValueAnimator animSpinner(int i);

    RefreshKernel finishTwoLevel();

    RefreshContent getRefreshContent();

    RefreshLayout getRefreshLayout();

    RefreshKernel moveSpinner(int i, boolean z);

    RefreshKernel requestDefaultTranslationContentFor(RefreshComponent refreshComponent, boolean z);

    RefreshKernel requestDrawBackgroundFor(RefreshComponent refreshComponent, int i);

    RefreshKernel requestFloorBottomPullUpToCloseRate(float f);

    RefreshKernel requestFloorDuration(int i);

    RefreshKernel requestNeedTouchEventFor(RefreshComponent refreshComponent, boolean z);

    RefreshKernel requestRemeasureHeightFor(RefreshComponent refreshComponent);

    RefreshKernel setState(RefreshState refreshState);

    RefreshKernel startTwoLevel(boolean z);
}
