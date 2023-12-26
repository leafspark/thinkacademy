package com.tal.app.thinkacademy.lib.utils;

import android.view.View;
import io.reactivex.rxjava3.core.ObservableEmitter;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class RxUnDoubleUtil$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ ObservableEmitter f$0;
    public final /* synthetic */ Ref.IntRef f$1;

    public /* synthetic */ RxUnDoubleUtil$$ExternalSyntheticLambda1(ObservableEmitter observableEmitter, Ref.IntRef intRef) {
        this.f$0 = observableEmitter;
        this.f$1 = intRef;
    }

    public final void onClick(View view) {
        RxUnDoubleUtil.m127setOnCountClickListener$lambda4$lambda3(this.f$0, this.f$1, view);
    }
}
