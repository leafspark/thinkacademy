package com.tal.app.thinkacademy.common.base;

import com.tbruyelle.rxpermissions3.Permission;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class BaseVmActivity$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BaseVmActivity$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void accept(Object obj) {
        BaseVmActivity.m4request$lambda1(this.f$0, (Permission) obj);
    }
}
