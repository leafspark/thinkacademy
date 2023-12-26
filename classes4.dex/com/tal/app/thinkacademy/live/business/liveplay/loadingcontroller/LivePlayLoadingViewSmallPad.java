package com.tal.app.thinkacademy.live.business.liveplay.loadingcontroller;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;

public class LivePlayLoadingViewSmallPad extends LivePlayLoadingView {
    /* access modifiers changed from: private */
    public LiveAreaCompat.CourseRate mRateType;

    public LivePlayLoadingViewSmallPad(Context context, LiveAreaCompat.CourseRate courseRate) {
        super(context);
        this.mRateType = courseRate;
    }

    public LivePlayLoadingViewSmallPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LivePlayLoadingViewSmallPad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initViews() {
        super.initViews();
        this.mIvNoTeacher.setVisibility(8);
    }

    public void setLayoutParams() {
        ConstraintLayout.LayoutParams layoutParams = this.mVGuide.getLayoutParams();
        LiveAreaLayoutParams pptCenterLp = LiveAreaCompat.pptCenterLp(this.mRateType);
        layoutParams.width = pptCenterLp.width;
        layoutParams.height = pptCenterLp.height;
        layoutParams.dimensionRatio = layoutParams.width + ":" + layoutParams.height;
        this.mVGuide.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = this.mFlArea.getLayoutParams();
        layoutParams2.width = pptCenterLp.width;
        layoutParams2.height = pptCenterLp.height;
        layoutParams2.dimensionRatio = layoutParams2.width + ":" + layoutParams2.height;
        LiveAreaContext.get().layoutObserver.observe(this.mContext, new Observer<LiveAreaContext>() {
            public void onChanged(LiveAreaContext liveAreaContext) {
                ConstraintLayout.LayoutParams layoutParams = LivePlayLoadingViewSmallPad.this.mVGuide.getLayoutParams();
                LiveAreaLayoutParams pptCenterLp = LiveAreaCompat.pptCenterLp(LivePlayLoadingViewSmallPad.this.mRateType);
                layoutParams.width = pptCenterLp.width;
                layoutParams.height = pptCenterLp.height;
                layoutParams.dimensionRatio = layoutParams.width + ":" + layoutParams.height;
                LivePlayLoadingViewSmallPad.this.mVGuide.setLayoutParams(layoutParams);
                ConstraintLayout.LayoutParams layoutParams2 = LivePlayLoadingViewSmallPad.this.mFlArea.getLayoutParams();
                layoutParams2.width = pptCenterLp.width;
                layoutParams2.height = pptCenterLp.height;
                layoutParams2.dimensionRatio = layoutParams2.width + ":" + layoutParams2.height;
                LivePlayLoadingViewSmallPad.this.mFlArea.setLayoutParams(layoutParams2);
            }
        });
    }

    public void showNoTeacher(boolean z) {
        super.showNoTeacher(z);
        this.mIvNoTeacher.setVisibility(8);
    }
}
