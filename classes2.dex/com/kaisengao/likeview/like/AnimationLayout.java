package com.kaisengao.likeview.like;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.kaisengao.likeview.like.evaluator.CurveEvaluatorRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AnimationLayout extends FrameLayout implements IAnimationLayout {
    protected List<AnimatorSet> mAnimatorSets;
    protected CurveEvaluatorRecord mEvaluatorRecord;
    protected float mPicHeight;
    protected float mPicWidth;
    protected final Random mRandom;
    protected int mViewHeight;
    protected int mViewWidth;

    public AnimationLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRandom = new Random();
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.mAnimatorSets = new ArrayList();
        this.mEvaluatorRecord = new CurveEvaluatorRecord();
    }

    public void getPictureInfo(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeResource(getContext().getResources(), i, options);
        this.mPicWidth = (float) options.outWidth;
        this.mPicHeight = (float) options.outHeight;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mViewWidth = getMeasuredWidth();
        this.mViewHeight = getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewWidth = getMeasuredWidth();
        this.mViewHeight = getMeasuredHeight();
    }

    protected static class CurveUpdateLister implements ValueAnimator.AnimatorUpdateListener {
        private final View mChild;

        protected CurveUpdateLister(View view) {
            this.mChild = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            this.mChild.setX(pointF.x);
            this.mChild.setY(pointF.y);
            this.mChild.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
        }
    }

    protected class AnimationEndListener extends AnimatorListenerAdapter {
        private final AnimatorSet mAnimatorSet;
        private final View mChild;
        private final ViewGroup mParent;

        protected AnimationEndListener(View view, ViewGroup viewGroup, AnimatorSet animatorSet) {
            this.mChild = view;
            this.mParent = viewGroup;
            this.mAnimatorSet = animatorSet;
            AnimationLayout.this.mAnimatorSets.add(animatorSet);
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.mParent.removeView(this.mChild);
            AnimationLayout.this.mAnimatorSets.remove(this.mAnimatorSet);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        destroy();
    }

    public void destroy() {
        for (AnimatorSet next : this.mAnimatorSets) {
            next.getListeners().clear();
            next.cancel();
        }
        this.mAnimatorSets.clear();
        this.mEvaluatorRecord.destroy();
    }
}
