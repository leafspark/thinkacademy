package com.tal.app.thinkacademy.business.study.study.dialog;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tal.app.thinkacademy.business.study.study.adapter.SwitchListAdapter;

public final /* synthetic */ class SwitchDialog$$ExternalSyntheticLambda2 implements OnItemClickListener {
    public final /* synthetic */ SwitchDialog f$0;
    public final /* synthetic */ SwitchListAdapter f$1;

    public /* synthetic */ SwitchDialog$$ExternalSyntheticLambda2(SwitchDialog switchDialog, SwitchListAdapter switchListAdapter) {
        this.f$0 = switchDialog;
        this.f$1 = switchListAdapter;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        SwitchDialog.m421lambda1$lambda0(this.f$0, this.f$1, baseQuickAdapter, view, i);
    }
}
