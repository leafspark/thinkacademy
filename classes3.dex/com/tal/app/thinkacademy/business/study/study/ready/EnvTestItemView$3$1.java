package com.tal.app.thinkacademy.business.study.study.ready;

import com.tal.app.thinkacademy.business.study.study.ready.EnvTestItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnvTestItemView.kt */
final class EnvTestItemView$3$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ EnvTestItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnvTestItemView$3$1(EnvTestItemView envTestItemView) {
        super(1);
        this.this$0 = envTestItemView;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        EnvTestItemView.CheckCallback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.changeName(StringsKt.trim(str).toString());
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }
}
