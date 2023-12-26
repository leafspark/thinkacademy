package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import java.util.List;

public final /* synthetic */ class ChooseStudentDialog$$ExternalSyntheticLambda0 implements OnItemClickListener {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ ChooseStudentDialog f$1;

    public /* synthetic */ ChooseStudentDialog$$ExternalSyntheticLambda0(List list, ChooseStudentDialog chooseStudentDialog) {
        this.f$0 = list;
        this.f$1 = chooseStudentDialog;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ChooseStudentDialog.m279_init_$lambda6(this.f$0, this.f$1, baseQuickAdapter, view, i);
    }
}
