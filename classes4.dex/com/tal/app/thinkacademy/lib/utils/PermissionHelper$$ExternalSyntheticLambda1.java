package com.tal.app.thinkacademy.lib.utils;

import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class PermissionHelper$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ PermissionHelper$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void accept(Object obj) {
        PermissionHelper.m123request$lambda1(this.f$0, (Boolean) obj);
    }
}
