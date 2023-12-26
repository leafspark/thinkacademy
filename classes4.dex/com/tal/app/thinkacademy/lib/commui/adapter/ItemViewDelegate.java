package com.tal.app.thinkacademy.lib.commui.adapter;

public interface ItemViewDelegate<T> {
    void convert(ViewHolder viewHolder, T t, int i);

    int getItemViewLayoutId();

    boolean isForViewType(T t, int i);
}
