package com.didi.hummer.component.scroller;

import android.view.View;

public interface OnScrollListener {
    void onScrollChanged(View view, int i, int i2, int i3, int i4);

    void onScrollFinished();

    void onScrollStarted();

    void onScrollUp();
}
