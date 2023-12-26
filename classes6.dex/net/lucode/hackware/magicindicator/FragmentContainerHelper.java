package net.lucode.hackware.magicindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

public class FragmentContainerHelper {
    private Animator.AnimatorListener mAnimatorListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            FragmentContainerHelper.this.dispatchPageScrollStateChanged(0);
            ValueAnimator unused = FragmentContainerHelper.this.mScrollAnimator = null;
        }
    };
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = (int) floatValue;
            float f = floatValue - ((float) i);
            if (floatValue < 0.0f) {
                i--;
                f += 1.0f;
            }
            FragmentContainerHelper.this.dispatchPageScrolled(i, f, 0);
        }
    };
    private int mDuration = 150;
    private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private int mLastSelectedIndex;
    private List<MagicIndicator> mMagicIndicators = new ArrayList();
    /* access modifiers changed from: private */
    public ValueAnimator mScrollAnimator;

    public FragmentContainerHelper() {
    }

    public FragmentContainerHelper(MagicIndicator magicIndicator) {
        this.mMagicIndicators.add(magicIndicator);
    }

    public static PositionData getImitativePositionData(List<PositionData> list, int i) {
        PositionData positionData;
        if (i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        }
        PositionData positionData2 = new PositionData();
        if (i < 0) {
            positionData = list.get(0);
        } else {
            i = (i - list.size()) + 1;
            positionData = list.get(list.size() - 1);
        }
        positionData2.mLeft = positionData.mLeft + (positionData.width() * i);
        positionData2.mTop = positionData.mTop;
        positionData2.mRight = positionData.mRight + (positionData.width() * i);
        positionData2.mBottom = positionData.mBottom;
        positionData2.mContentLeft = positionData.mContentLeft + (positionData.width() * i);
        positionData2.mContentTop = positionData.mContentTop;
        positionData2.mContentRight = positionData.mContentRight + (i * positionData.width());
        positionData2.mContentBottom = positionData.mContentBottom;
        return positionData2;
    }

    public void handlePageSelected(int i) {
        handlePageSelected(i, true);
    }

    public void handlePageSelected(int i, boolean z) {
        if (this.mLastSelectedIndex != i) {
            if (z) {
                ValueAnimator valueAnimator = this.mScrollAnimator;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    dispatchPageScrollStateChanged(2);
                }
                dispatchPageSelected(i);
                float f = (float) this.mLastSelectedIndex;
                ValueAnimator valueAnimator2 = this.mScrollAnimator;
                if (valueAnimator2 != null) {
                    f = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    this.mScrollAnimator.cancel();
                    this.mScrollAnimator = null;
                }
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.mScrollAnimator = valueAnimator3;
                valueAnimator3.setFloatValues(new float[]{f, (float) i});
                this.mScrollAnimator.addUpdateListener(this.mAnimatorUpdateListener);
                this.mScrollAnimator.addListener(this.mAnimatorListener);
                this.mScrollAnimator.setInterpolator(this.mInterpolator);
                this.mScrollAnimator.setDuration((long) this.mDuration);
                this.mScrollAnimator.start();
            } else {
                dispatchPageSelected(i);
                ValueAnimator valueAnimator4 = this.mScrollAnimator;
                if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                    dispatchPageScrolled(this.mLastSelectedIndex, 0.0f, 0);
                }
                dispatchPageScrollStateChanged(0);
                dispatchPageScrolled(i, 0.0f, 0);
            }
            this.mLastSelectedIndex = i;
        }
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setInterpolator(Interpolator interpolator) {
        if (interpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
    }

    public void attachMagicIndicator(MagicIndicator magicIndicator) {
        this.mMagicIndicators.add(magicIndicator);
    }

    private void dispatchPageSelected(int i) {
        for (MagicIndicator onPageSelected : this.mMagicIndicators) {
            onPageSelected.onPageSelected(i);
        }
    }

    /* access modifiers changed from: private */
    public void dispatchPageScrollStateChanged(int i) {
        for (MagicIndicator onPageScrollStateChanged : this.mMagicIndicators) {
            onPageScrollStateChanged.onPageScrollStateChanged(i);
        }
    }

    /* access modifiers changed from: private */
    public void dispatchPageScrolled(int i, float f, int i2) {
        for (MagicIndicator onPageScrolled : this.mMagicIndicators) {
            onPageScrolled.onPageScrolled(i, f, i2);
        }
    }
}
