package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;

public final /* synthetic */ class StudyPageFragment$$ExternalSyntheticLambda5 implements BaseDialog.OnDismissListener {
    public final /* synthetic */ StudyPageFragment f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ ShowTab f$2;

    public /* synthetic */ StudyPageFragment$$ExternalSyntheticLambda5(StudyPageFragment studyPageFragment, boolean z, ShowTab showTab) {
        this.f$0 = studyPageFragment;
        this.f$1 = z;
        this.f$2 = showTab;
    }

    public final void dismiss() {
        StudyPageFragment.m387showSwitchDialog$lambda12$lambda11(this.f$0, this.f$1, this.f$2);
    }
}
