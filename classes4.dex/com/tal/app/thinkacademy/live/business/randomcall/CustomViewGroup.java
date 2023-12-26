package com.tal.app.thinkacademy.live.business.randomcall;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomViewGroup extends ConstraintLayout {
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
