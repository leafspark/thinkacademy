package com.zhpan.bannerview.provider;

import android.view.View;

public class ViewStyleSetter {
    private View mView;

    public ViewStyleSetter(View view) {
        this.mView = view;
    }

    public void setRoundRect(float f) {
        this.mView.setClipToOutline(true);
        this.mView.setOutlineProvider(new RoundViewOutlineProvider(f));
    }

    public void setOvalView() {
        this.mView.setClipToOutline(true);
        this.mView.setOutlineProvider(new OvalViewOutlineProvider());
    }

    public void clearShapeStyle() {
        this.mView.setClipToOutline(false);
    }
}
