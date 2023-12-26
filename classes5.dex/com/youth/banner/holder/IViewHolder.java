package com.youth.banner.holder;

import android.view.ViewGroup;

public interface IViewHolder<T, VH> {
    void onBindView(VH vh, T t, int i, int i2);

    VH onCreateHolder(ViewGroup viewGroup, int i);
}
