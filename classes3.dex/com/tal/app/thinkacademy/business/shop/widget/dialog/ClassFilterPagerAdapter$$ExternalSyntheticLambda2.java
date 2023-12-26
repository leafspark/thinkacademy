package com.tal.app.thinkacademy.business.shop.widget.dialog;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

public final /* synthetic */ class ClassFilterPagerAdapter$$ExternalSyntheticLambda2 implements OnItemClickListener {
    public final /* synthetic */ ClassTabListTeacherAdapter f$0;
    public final /* synthetic */ ClassFilterPagerAdapter f$1;

    public /* synthetic */ ClassFilterPagerAdapter$$ExternalSyntheticLambda2(ClassTabListTeacherAdapter classTabListTeacherAdapter, ClassFilterPagerAdapter classFilterPagerAdapter) {
        this.f$0 = classTabListTeacherAdapter;
        this.f$1 = classFilterPagerAdapter;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ClassFilterPagerAdapter.m364instantiateItem$lambda5$lambda4(this.f$0, this.f$1, baseQuickAdapter, view, i);
    }
}
