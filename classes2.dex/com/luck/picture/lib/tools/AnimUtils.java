package com.luck.picture.lib.tools;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class AnimUtils {
    private static final int DURATION = 450;

    public static void zoom(View view, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 1.12f}), ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 1.12f})});
            animatorSet.setDuration(450);
            animatorSet.start();
        }
    }

    public static void disZoom(View view, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.12f, 1.0f}), ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.12f, 1.0f})});
            animatorSet.setDuration(450);
            animatorSet.start();
        }
    }

    public static void rotateArrow(ImageView imageView, boolean z) {
        RotateAnimation rotateAnimation = new RotateAnimation(180.0f, 360.0f, ((float) imageView.getWidth()) / 2.0f, ((float) imageView.getHeight()) / 2.0f);
        rotateAnimation.setDuration(350);
        imageView.startAnimation(rotateAnimation);
    }
}
