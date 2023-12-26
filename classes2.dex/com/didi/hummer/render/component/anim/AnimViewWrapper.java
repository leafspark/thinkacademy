package com.didi.hummer.render.component.anim;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import com.didi.hummer.render.component.view.HMBase;

public class AnimViewWrapper {
    private HMBase mTarget;

    public AnimViewWrapper(HMBase hMBase) {
        this.mTarget = hMBase;
    }

    public void setBackgroundColor(int i) {
        this.mTarget.getBackgroundHelper().setBackgroundColor(i);
    }

    public int getBackgroundColor() {
        return this.mTarget.getBackgroundHelper().getBackgroundColor();
    }

    public void setRotation(float f) {
        this.mTarget.getView().setRotation(f);
    }

    public float getRotation() {
        return this.mTarget.getView().getRotation();
    }

    public void setRotationY(float f) {
        this.mTarget.getView().setRotationY(f);
    }

    public float getRotationY() {
        return this.mTarget.getView().getRotationY();
    }

    public void setRotationX(float f) {
        this.mTarget.getView().setRotationX(f);
    }

    public float getRotationX() {
        return this.mTarget.getView().getRotationX();
    }

    public float getScaleY() {
        return this.mTarget.getView().getScaleY();
    }

    public void setScaleY(float f) {
        this.mTarget.getView().setScaleY(f);
    }

    public float getScaleX() {
        return this.mTarget.getView().getScaleX();
    }

    public void setScaleX(float f) {
        this.mTarget.getView().setScaleX(f);
    }

    public void setTranslationX(float f) {
        this.mTarget.getView().setTranslationX(f);
    }

    public float getTranslationX() {
        return this.mTarget.getView().getTranslationX();
    }

    public void setTranslationY(float f) {
        this.mTarget.getView().setTranslationY(f);
    }

    public float getTranslationY() {
        return this.mTarget.getView().getTranslationY();
    }

    public void setAlpha(float f) {
        this.mTarget.getView().setAlpha(f);
    }

    public float getAlpha() {
        return this.mTarget.getView().getAlpha();
    }

    public void setWidth(int i) {
        this.mTarget.getYogaNode().setWidth((float) i);
        this.mTarget.getView().requestLayout();
    }

    public int getWidth() {
        return this.mTarget.getView().getWidth();
    }

    public void setHeight(int i) {
        this.mTarget.getYogaNode().setHeight((float) i);
        this.mTarget.getView().requestLayout();
    }

    public int getHeight() {
        return this.mTarget.getView().getHeight();
    }

    public void setSkewX(float f) {
        if (Build.VERSION.SDK_INT >= 29) {
            View view = this.mTarget.getView();
            Matrix animationMatrix = view.getAnimationMatrix();
            if (animationMatrix == null) {
                animationMatrix = new Matrix();
            }
            float[] fArr = new float[9];
            animationMatrix.getValues(fArr);
            animationMatrix.setSkew(f, fArr[3]);
            view.setAnimationMatrix(animationMatrix);
        }
    }

    public float getSkewX() {
        if (Build.VERSION.SDK_INT < 29) {
            return 0.0f;
        }
        Matrix animationMatrix = this.mTarget.getView().getAnimationMatrix();
        if (animationMatrix == null) {
            animationMatrix = this.mTarget.getView().getMatrix();
        }
        float[] fArr = new float[9];
        animationMatrix.getValues(fArr);
        return fArr[1];
    }

    public void setSkewY(float f) {
        if (Build.VERSION.SDK_INT >= 29) {
            View view = this.mTarget.getView();
            Matrix animationMatrix = view.getAnimationMatrix();
            if (animationMatrix == null) {
                animationMatrix = new Matrix();
            }
            float[] fArr = new float[9];
            animationMatrix.getValues(fArr);
            animationMatrix.setSkew(fArr[1], f);
            view.setAnimationMatrix(animationMatrix);
        }
    }

    public float getSkewY() {
        if (Build.VERSION.SDK_INT < 29) {
            return 0.0f;
        }
        Matrix animationMatrix = this.mTarget.getView().getAnimationMatrix();
        if (animationMatrix == null) {
            animationMatrix = this.mTarget.getView().getMatrix();
        }
        float[] fArr = new float[9];
        animationMatrix.getValues(fArr);
        return fArr[3];
    }
}
