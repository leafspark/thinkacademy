package com.zhpan.bannerview.holder;

import android.view.View;

public interface ViewHolder<T> {
    int getLayoutId();

    void onBind(View view, T t, int i, int i2);
}
