package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.GridLayoutManager;

public interface GridSpanSizeLookup {
    int getSpanSize(GridLayoutManager gridLayoutManager, int i, int i2);
}
