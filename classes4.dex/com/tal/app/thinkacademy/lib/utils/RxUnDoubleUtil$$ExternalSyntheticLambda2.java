package com.tal.app.thinkacademy.lib.utils;

import android.view.View;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

public final /* synthetic */ class RxUnDoubleUtil$$ExternalSyntheticLambda2 implements ObservableOnSubscribe {
    public final /* synthetic */ View f$0;

    public /* synthetic */ RxUnDoubleUtil$$ExternalSyntheticLambda2(View view) {
        this.f$0 = view;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        RxUnDoubleUtil.m129setOnUnDoubleClickListener$lambda1(this.f$0, observableEmitter);
    }
}
