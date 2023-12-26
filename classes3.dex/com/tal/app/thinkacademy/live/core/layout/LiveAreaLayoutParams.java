package com.tal.app.thinkacademy.live.core.layout;

import android.view.ViewGroup;
import android.widget.FrameLayout;

public class LiveAreaLayoutParams {
    public int bottom;
    public int height;
    public int left;
    public int right;
    public int top;
    public int width;

    public FrameLayout.LayoutParams newLp() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.width, this.height);
        layoutParams.topMargin = this.top;
        layoutParams.setMarginStart(this.left);
        return layoutParams;
    }

    public FrameLayout.LayoutParams mergeLp(FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = this.width;
        layoutParams.height = this.height;
        layoutParams.topMargin = this.top;
        layoutParams.setMarginStart(this.left);
        return layoutParams;
    }

    public ViewGroup.MarginLayoutParams mergeLp(ViewGroup.MarginLayoutParams marginLayoutParams) {
        marginLayoutParams.width = this.width;
        marginLayoutParams.height = this.height;
        marginLayoutParams.topMargin = this.top;
        marginLayoutParams.setMarginStart(this.left);
        return marginLayoutParams;
    }

    public LiveAreaLayoutParams clone() {
        LiveAreaLayoutParams liveAreaLayoutParams = new LiveAreaLayoutParams();
        liveAreaLayoutParams.width = this.width;
        liveAreaLayoutParams.height = this.height;
        liveAreaLayoutParams.left = this.left;
        liveAreaLayoutParams.top = this.top;
        liveAreaLayoutParams.right = this.right;
        liveAreaLayoutParams.bottom = this.bottom;
        return liveAreaLayoutParams;
    }

    public String toString() {
        return "LiveAreaLayoutParams{width=" + this.width + ", height=" + this.height + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }
}
