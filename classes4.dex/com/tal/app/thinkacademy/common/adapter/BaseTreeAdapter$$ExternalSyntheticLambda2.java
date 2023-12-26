package com.tal.app.thinkacademy.common.adapter;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

public final /* synthetic */ class BaseTreeAdapter$$ExternalSyntheticLambda2 implements View.OnLongClickListener {
    public final /* synthetic */ BaseViewHolder f$0;
    public final /* synthetic */ BaseTreeAdapter f$1;

    public /* synthetic */ BaseTreeAdapter$$ExternalSyntheticLambda2(BaseViewHolder baseViewHolder, BaseTreeAdapter baseTreeAdapter) {
        this.f$0 = baseViewHolder;
        this.f$1 = baseTreeAdapter;
    }

    public final boolean onLongClick(View view) {
        return BaseTreeAdapter.m0bindViewClickListener$lambda11$lambda10(this.f$0, this.f$1, view);
    }
}
