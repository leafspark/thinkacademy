package com.tal.app.thinkacademy.lib.utils;

import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class RxUnDoubleUtil$$ExternalSyntheticLambda5 implements Consumer {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ RxUnDoubleUtil$$ExternalSyntheticLambda5(Ref.IntRef intRef, Function0 function0, int i, Function0 function02) {
        this.f$0 = intRef;
        this.f$1 = function0;
        this.f$2 = i;
        this.f$3 = function02;
    }

    public final void accept(Object obj) {
        RxUnDoubleUtil.m128setOnCountClickListener$lambda5(this.f$0, this.f$1, this.f$2, this.f$3, (Integer) obj);
    }
}
