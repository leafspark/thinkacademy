package com.tal.app.thinkacademy.business.shop.widget.dialog;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

public final /* synthetic */ class ClassFilterPagerAdapter$$ExternalSyntheticLambda0 implements OnItemClickListener {
    public final /* synthetic */ ClassTabListDayAdapter f$0;
    public final /* synthetic */ ClassFilterPagerAdapter f$1;

    public /* synthetic */ ClassFilterPagerAdapter$$ExternalSyntheticLambda0(ClassTabListDayAdapter classTabListDayAdapter, ClassFilterPagerAdapter classFilterPagerAdapter) {
        this.f$0 = classTabListDayAdapter;
        this.f$1 = classFilterPagerAdapter;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ClassFilterPagerAdapter.m363instantiateItem$lambda3$lambda2(this.f$0, this.f$1, baseQuickAdapter, view, i);
    }
}
