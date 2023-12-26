package com.zhpan.bannerview.holder;

import com.zhpan.bannerview.holder.ViewHolder;

public interface HolderCreator<VH extends ViewHolder> {
    VH createViewHolder();
}
