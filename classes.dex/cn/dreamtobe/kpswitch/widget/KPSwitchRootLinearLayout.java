package cn.dreamtobe.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import cn.dreamtobe.kpswitch.handler.KPSwitchRootLayoutHandler;

public class KPSwitchRootLinearLayout extends LinearLayout {
    private KPSwitchRootLayoutHandler conflictHandler;

    public KPSwitchRootLinearLayout(Context context) {
        super(context);
        init();
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        this.conflictHandler = new KPSwitchRootLayoutHandler(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.conflictHandler.handleBeforeMeasure(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }
}