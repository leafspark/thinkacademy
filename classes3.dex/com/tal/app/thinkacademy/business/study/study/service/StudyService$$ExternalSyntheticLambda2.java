package com.tal.app.thinkacademy.business.study.study.service;

import com.tal.app.thinkacademy.business.study.study.SwitchType;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;

public final /* synthetic */ class StudyService$$ExternalSyntheticLambda2 implements BaseDialog.OnDismissListener {
    public final /* synthetic */ SwitchType f$0;
    public final /* synthetic */ SwitchOptionsList f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ StudyService$$ExternalSyntheticLambda2(SwitchType switchType, SwitchOptionsList switchOptionsList, boolean z, String str) {
        this.f$0 = switchType;
        this.f$1 = switchOptionsList;
        this.f$2 = z;
        this.f$3 = str;
    }

    public final void dismiss() {
        StudyService.m456showDialog$lambda23(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
