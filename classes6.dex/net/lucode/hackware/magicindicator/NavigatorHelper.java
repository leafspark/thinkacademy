package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

public class NavigatorHelper {
    private int mCurrentIndex;
    private SparseBooleanArray mDeselectedItems = new SparseBooleanArray();
    private int mLastIndex;
    private float mLastPositionOffsetSum;
    private SparseArray<Float> mLeavedPercents = new SparseArray<>();
    private OnNavigatorScrollListener mNavigatorScrollListener;
    private int mScrollState;
    private boolean mSkimOver;
    private int mTotalCount;

    public interface OnNavigatorScrollListener {
        void onDeselected(int i, int i2);

        void onEnter(int i, int i2, float f, boolean z);

        void onLeave(int i, int i2, float f, boolean z);

        void onSelected(int i, int i2);
    }

    public void onPageScrolled(int i, float f, int i2) {
        boolean z;
        float f2 = ((float) i) + f;
        float f3 = this.mLastPositionOffsetSum;
        boolean z2 = f3 <= f2;
        if (this.mScrollState == 0) {
            for (int i3 = 0; i3 < this.mTotalCount; i3++) {
                if (i3 != this.mCurrentIndex) {
                    if (!this.mDeselectedItems.get(i3)) {
                        dispatchOnDeselected(i3);
                    }
                    if (this.mLeavedPercents.get(i3, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        dispatchOnLeave(i3, 1.0f, false, true);
                    }
                }
            }
            dispatchOnEnter(this.mCurrentIndex, 1.0f, false, true);
            dispatchOnSelected(this.mCurrentIndex);
        } else if (f2 != f3) {
            int i4 = i + 1;
            if (f != 0.0f || !z2) {
                z = true;
            } else {
                i4 = i - 1;
                z = false;
            }
            for (int i5 = 0; i5 < this.mTotalCount; i5++) {
                if (!(i5 == i || i5 == i4 || this.mLeavedPercents.get(i5, Float.valueOf(0.0f)).floatValue() == 1.0f)) {
                    dispatchOnLeave(i5, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f4 = 1.0f - f;
                dispatchOnLeave(i4, f4, true, false);
                dispatchOnEnter(i, f4, true, false);
            } else if (z2) {
                dispatchOnLeave(i, f, true, false);
                dispatchOnEnter(i4, f, true, false);
            } else {
                float f5 = 1.0f - f;
                dispatchOnLeave(i4, f5, false, false);
                dispatchOnEnter(i, f5, false, false);
            }
        } else {
            return;
        }
        this.mLastPositionOffsetSum = f2;
    }

    private void dispatchOnEnter(int i, float f, boolean z, boolean z2) {
        if (this.mSkimOver || i == this.mCurrentIndex || this.mScrollState == 1 || z2) {
            OnNavigatorScrollListener onNavigatorScrollListener = this.mNavigatorScrollListener;
            if (onNavigatorScrollListener != null) {
                onNavigatorScrollListener.onEnter(i, this.mTotalCount, f, z);
            }
            this.mLeavedPercents.put(i, Float.valueOf(1.0f - f));
        }
    }

    private void dispatchOnLeave(int i, float f, boolean z, boolean z2) {
        if (!(this.mSkimOver || i == this.mLastIndex || this.mScrollState == 1)) {
            int i2 = this.mCurrentIndex;
            if ((!(i == i2 - 1 || i == i2 + 1) || this.mLeavedPercents.get(i, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        OnNavigatorScrollListener onNavigatorScrollListener = this.mNavigatorScrollListener;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onLeave(i, this.mTotalCount, f, z);
        }
        this.mLeavedPercents.put(i, Float.valueOf(f));
    }

    private void dispatchOnSelected(int i) {
        OnNavigatorScrollListener onNavigatorScrollListener = this.mNavigatorScrollListener;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onSelected(i, this.mTotalCount);
        }
        this.mDeselectedItems.put(i, false);
    }

    private void dispatchOnDeselected(int i) {
        OnNavigatorScrollListener onNavigatorScrollListener = this.mNavigatorScrollListener;
        if (onNavigatorScrollListener != null) {
            onNavigatorScrollListener.onDeselected(i, this.mTotalCount);
        }
        this.mDeselectedItems.put(i, true);
    }

    public void onPageSelected(int i) {
        this.mLastIndex = this.mCurrentIndex;
        this.mCurrentIndex = i;
        dispatchOnSelected(i);
        for (int i2 = 0; i2 < this.mTotalCount; i2++) {
            if (i2 != this.mCurrentIndex && !this.mDeselectedItems.get(i2)) {
                dispatchOnDeselected(i2);
            }
        }
    }

    public void onPageScrollStateChanged(int i) {
        this.mScrollState = i;
    }

    public void setNavigatorScrollListener(OnNavigatorScrollListener onNavigatorScrollListener) {
        this.mNavigatorScrollListener = onNavigatorScrollListener;
    }

    public void setSkimOver(boolean z) {
        this.mSkimOver = z;
    }

    public int getTotalCount() {
        return this.mTotalCount;
    }

    public void setTotalCount(int i) {
        this.mTotalCount = i;
        this.mDeselectedItems.clear();
        this.mLeavedPercents.clear();
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public int getScrollState() {
        return this.mScrollState;
    }
}
