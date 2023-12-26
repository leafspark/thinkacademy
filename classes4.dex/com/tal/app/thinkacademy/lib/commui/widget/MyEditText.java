package com.tal.app.thinkacademy.lib.commui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;

public class MyEditText extends AppCompatEditText {
    private boolean mBottomFlag = false;
    private int mOffsetHeight;

    private void init() {
    }

    public MyEditText(Context context) {
        super(context);
        init();
    }

    public MyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MyEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MyEditText.super.onMeasure(i, i2);
        int height = getLayout().getHeight();
        int totalPaddingTop = getTotalPaddingTop();
        this.mOffsetHeight = ((height + totalPaddingTop) + getTotalPaddingBottom()) - getHeight();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mBottomFlag = false;
        }
        if (this.mBottomFlag) {
            motionEvent.setAction(3);
        }
        return MyEditText.super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = MyEditText.super.onTouchEvent(motionEvent);
        if (!this.mBottomFlag) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        MyEditText.super.onScrollChanged(i, i2, i3, i4);
        if (i2 == this.mOffsetHeight || i2 == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.mBottomFlag = true;
        }
    }
}
