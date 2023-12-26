package com.tal.app.thinkacademy.business.study.study.speaker;

import com.tbruyelle.rxpermissions3.Permission;
import io.reactivex.rxjava3.functions.Consumer;

public final /* synthetic */ class ClassCalendarActivity$$ExternalSyntheticLambda7 implements Consumer {
    public final /* synthetic */ ClassCalendarActivity f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ ClassCalendarActivity$$ExternalSyntheticLambda7(ClassCalendarActivity classCalendarActivity, String str) {
        this.f$0 = classCalendarActivity;
        this.f$1 = str;
    }

    public final void accept(Object obj) {
        ClassCalendarActivity.m465requestCallPhonePermission$lambda33(this.f$0, this.f$1, (Permission) obj);
    }
}
