package com.tal.app.thinkacademy.business.study.study.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassAdapter.kt */
final class ClassAdapter$convert$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ClassAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassAdapter$convert$1(ClassAdapter classAdapter) {
        super(0);
        this.this$0 = classAdapter;
    }

    public final void invoke() {
        Function1<ChildClick, Unit> listener = this.this$0.getListener();
        if (listener != null) {
            listener.invoke(ChildClick.CLOSE);
        }
    }
}
