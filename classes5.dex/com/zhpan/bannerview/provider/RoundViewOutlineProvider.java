package com.zhpan.bannerview.provider;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

public class RoundViewOutlineProvider extends ViewOutlineProvider {
    private float mRadius;

    public RoundViewOutlineProvider(float f) {
        this.mRadius = f;
    }

    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), this.mRadius);
    }
}
