package com.zhpan.bannerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.zhpan.bannerview.provider.BannerScroller;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

public class CatchViewPager extends ViewPager {
    private boolean disableTouchScroll;
    private boolean firstLayout;
    private ArrayList<Integer> mArrayList;
    private BannerScroller mBannerScroller;
    private boolean mOverlapStyle;
    private SparseIntArray mSparseIntArray;

    public CatchViewPager(Context context) {
        this(context, (AttributeSet) null);
    }

    public CatchViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mArrayList = new ArrayList<>();
        this.mSparseIntArray = new SparseIntArray();
        this.mOverlapStyle = false;
        this.firstLayout = true;
        hookScroller();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.disableTouchScroll) {
                return false;
            }
            return CatchViewPager.super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [androidx.viewpager.widget.ViewPager, android.view.View, com.zhpan.bannerview.view.CatchViewPager] */
    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (!this.mOverlapStyle) {
            return CatchViewPager.super.getChildDrawingOrder(i, i2);
        }
        if (i2 == 0 || this.mSparseIntArray.size() != i) {
            this.mArrayList.clear();
            this.mSparseIntArray.clear();
            int viewCenterX = getViewCenterX(this);
            for (int i3 = 0; i3 < i; i3++) {
                int abs = Math.abs(viewCenterX - getViewCenterX(getChildAt(i3))) + 1;
                this.mArrayList.add(Integer.valueOf(abs));
                this.mSparseIntArray.append(abs, i3);
            }
            Collections.sort(this.mArrayList);
        }
        return this.mSparseIntArray.get(this.mArrayList.get((i - 1) - i2).intValue());
    }

    private int getViewCenterX(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[0] + (view.getWidth() / 2);
    }

    public void setOverlapStyle(boolean z) {
        this.mOverlapStyle = z;
    }

    public void setScrollDuration(int i) {
        this.mBannerScroller.setDuration(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.disableTouchScroll) {
            return false;
        }
        return CatchViewPager.super.onTouchEvent(motionEvent);
    }

    public void disableTouchScroll(boolean z) {
        this.disableTouchScroll = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        CatchViewPager.super.onAttachedToWindow();
        hookFirstLayout();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        CatchViewPager.super.onDetachedFromWindow();
        this.firstLayout = false;
    }

    private void hookScroller() {
        try {
            BannerScroller bannerScroller = new BannerScroller(getContext());
            this.mBannerScroller = bannerScroller;
            bannerScroller.setDuration(500);
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, this.mBannerScroller);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void hookFirstLayout() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mFirstLayout");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.valueOf(this.firstLayout));
            setCurrentItem(getCurrentItem());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public void setFirstLayout(boolean z) {
        this.firstLayout = z;
    }
}
