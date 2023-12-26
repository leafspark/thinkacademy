package cn.dreamtobe.kpswitch.handler;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import cn.dreamtobe.kpswitch.IPanelConflictLayout;
import cn.dreamtobe.kpswitch.util.ViewUtil;
import com.tal.app.thinkacademy.lib.commui.R;

public class KPSwitchPanelLayoutHandler implements IPanelConflictLayout {
    private boolean mIgnoreRecommendHeight = false;
    private boolean mIsHide = false;
    private boolean mIsKeyboardShowing = false;
    private final View panelLayout;
    private final int[] processedMeasureWHSpec = new int[2];

    public KPSwitchPanelLayoutHandler(View view, AttributeSet attributeSet) {
        this.panelLayout = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.KPSwitchPanelLayout);
                this.mIgnoreRecommendHeight = typedArray.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean filterSetVisibility(int i) {
        if (i == 0) {
            this.mIsHide = false;
        }
        if (i == this.panelLayout.getVisibility()) {
            return true;
        }
        if (!isKeyboardShowing() || i != 0) {
            return false;
        }
        return true;
    }

    public int[] processOnMeasure(int i, int i2) {
        if (this.mIsHide) {
            this.panelLayout.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, BasicMeasure.EXACTLY);
            i2 = View.MeasureSpec.makeMeasureSpec(0, BasicMeasure.EXACTLY);
            i = makeMeasureSpec;
        }
        int[] iArr = this.processedMeasureWHSpec;
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public void setIsKeyboardShowing(boolean z) {
        this.mIsKeyboardShowing = z;
    }

    public boolean isKeyboardShowing() {
        return this.mIsKeyboardShowing;
    }

    public boolean isVisible() {
        return !this.mIsHide;
    }

    public void handleShow() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    public void handleHide() {
        this.mIsHide = true;
    }

    public void resetToRecommendPanelHeight(int i) {
        if (!this.mIgnoreRecommendHeight) {
            ViewUtil.refreshHeight(this.panelLayout, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.mIgnoreRecommendHeight = z;
    }
}
