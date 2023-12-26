package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class PreviewViewPager extends ViewPager {
    private MyViewPageHelper helper;

    public PreviewViewPager(Context context) {
        super(context);
    }

    public PreviewViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.helper = new MyViewPageHelper(this);
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public void setCurrentItem(int i, boolean z) {
        MScroller scroller = this.helper.getScroller();
        if (Math.abs(getCurrentItem() - i) > 1) {
            scroller.setNoDuration(true);
            PreviewViewPager.super.setCurrentItem(i, z);
            scroller.setNoDuration(false);
            return;
        }
        scroller.setNoDuration(false);
        PreviewViewPager.super.setCurrentItem(i, z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return PreviewViewPager.super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return PreviewViewPager.super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return PreviewViewPager.super.dispatchTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
            return false;
        }
    }
}
