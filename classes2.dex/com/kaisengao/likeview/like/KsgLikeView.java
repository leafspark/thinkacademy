package com.kaisengao.likeview.like;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.kaisengao.likeview.R;
import com.kaisengao.likeview.like.AnimationLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KsgLikeView extends AnimationLayout {
    private final String TAG;
    private int mCurveDuration;
    private int mEnterDuration;
    private List<Integer> mLikeRes;

    public KsgLikeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public KsgLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = KsgLikeView.class.getName();
        initTypedArray(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mLikeRes = new ArrayList();
    }

    private void initTypedArray(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.KsgLikeView);
        this.mEnterDuration = obtainStyledAttributes.getInteger(R.styleable.KsgLikeView_ksg_enter_duration, 1500);
        this.mCurveDuration = obtainStyledAttributes.getInteger(R.styleable.KsgLikeView_ksg_curve_duration, 4500);
        obtainStyledAttributes.recycle();
    }

    public void addLikeImage(int i) {
        addLikeImages(Integer.valueOf(i));
    }

    public void addLikeImages(Integer... numArr) {
        addLikeImages((List<Integer>) Arrays.asList(numArr));
    }

    public void addLikeImages(List<Integer> list) {
        this.mLikeRes.addAll(list);
    }

    public void addFavor() {
        if (this.mLikeRes.isEmpty()) {
            Log.e(this.TAG, "请添加资源文件！");
            return;
        }
        int abs = Math.abs(this.mLikeRes.get(this.mRandom.nextInt(this.mLikeRes.size())).intValue());
        FrameLayout.LayoutParams createLayoutParams = createLayoutParams(abs);
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setImageResource(abs);
        start(appCompatImageView, this, createLayoutParams);
    }

    private FrameLayout.LayoutParams createLayoutParams(int i) {
        getPictureInfo(i);
        return new FrameLayout.LayoutParams((int) this.mPicWidth, (int) this.mPicHeight, 81);
    }

    private void start(View view, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams) {
        AnimatorSet generateEnterAnimation = generateEnterAnimation(view);
        ValueAnimator generateCurveAnimation = generateCurveAnimation(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{generateCurveAnimation, generateEnterAnimation});
        animatorSet.addListener(new AnimationLayout.AnimationEndListener(view, viewGroup, animatorSet));
        animatorSet.start();
        viewGroup.addView(view, layoutParams);
    }

    private AnimatorSet generateEnterAnimation(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.2f, 1.0f}), ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{0.2f, 1.0f}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{0.2f, 1.0f})});
        animatorSet.setInterpolator(new LinearInterpolator());
        return animatorSet.setDuration((long) this.mEnterDuration);
    }

    private ValueAnimator generateCurveAnimation(View view) {
        PointF pointF = new PointF((((float) this.mViewWidth) - this.mPicWidth) / 2.0f, ((float) this.mViewHeight) - this.mPicHeight);
        ValueAnimator ofObject = ValueAnimator.ofObject(this.mEvaluatorRecord.getCurrentPath(getTogglePoint(1), getTogglePoint(2)), new Object[]{pointF, new PointF(((((float) this.mViewWidth) - this.mPicWidth) / 2.0f) + ((float) ((this.mRandom.nextBoolean() ? 1 : -1) * this.mRandom.nextInt(100))), 0.0f)});
        ofObject.addUpdateListener(new AnimationLayout.CurveUpdateLister(view));
        ofObject.setInterpolator(new LinearInterpolator());
        return ofObject.setDuration((long) this.mCurveDuration);
    }

    private PointF getTogglePoint(int i) {
        PointF pointF = new PointF();
        pointF.x = (float) this.mRandom.nextInt(this.mViewWidth - 100);
        pointF.y = ((float) this.mRandom.nextInt(this.mViewHeight - 100)) / ((float) i);
        return pointF;
    }
}
