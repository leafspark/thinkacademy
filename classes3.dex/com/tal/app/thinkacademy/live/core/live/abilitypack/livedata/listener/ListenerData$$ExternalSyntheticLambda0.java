package com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener;

import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class ListenerData$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ListenerData$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onChanged(Object obj) {
        ListenerData.m512observeListener$lambda0(this.f$0, (ListenerBody) obj);
    }
}
