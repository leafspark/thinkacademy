package com.tal.app.thinkacademy.lib.utils;

import android.view.View;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class RxUnDoubleUtil$$ExternalSyntheticLambda3 implements ObservableOnSubscribe {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ Ref.IntRef f$1;

    public /* synthetic */ RxUnDoubleUtil$$ExternalSyntheticLambda3(View view, Ref.IntRef intRef) {
        this.f$0 = view;
        this.f$1 = intRef;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        RxUnDoubleUtil.m126setOnCountClickListener$lambda4(this.f$0, this.f$1, observableEmitter);
    }
}
