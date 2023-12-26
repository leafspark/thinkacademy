package cn.dreamtobe.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import cn.dreamtobe.kpswitch.IPanelConflictLayout;
import cn.dreamtobe.kpswitch.IPanelHeightTarget;
import cn.dreamtobe.kpswitch.handler.KPSwitchPanelLayoutHandler;

public class KPSwitchPanelFrameLayout extends FrameLayout implements IPanelHeightTarget, IPanelConflictLayout {
    private KPSwitchPanelLayoutHandler panelLayoutHandler;

    public KPSwitchPanelFrameLayout(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.panelLayoutHandler = new KPSwitchPanelLayoutHandler(this, attributeSet);
    }

    public void setVisibility(int i) {
        if (!this.panelLayoutHandler.filterSetVisibility(i)) {
            super.setVisibility(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int[] processOnMeasure = this.panelLayoutHandler.processOnMeasure(i, i2);
        super.onMeasure(processOnMeasure[0], processOnMeasure[1]);
    }

    public boolean isKeyboardShowing() {
        return this.panelLayoutHandler.isKeyboardShowing();
    }

    public boolean isVisible() {
        return this.panelLayoutHandler.isVisible();
    }

    public void handleShow() {
        super.setVisibility(0);
    }

    public void handleHide() {
        this.panelLayoutHandler.handleHide();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.panelLayoutHandler.setIgnoreRecommendHeight(z);
    }

    public void refreshHeight(int i) {
        this.panelLayoutHandler.resetToRecommendPanelHeight(i);
    }

    public void onKeyboardShowing(boolean z) {
        this.panelLayoutHandler.setIsKeyboardShowing(z);
    }
}
