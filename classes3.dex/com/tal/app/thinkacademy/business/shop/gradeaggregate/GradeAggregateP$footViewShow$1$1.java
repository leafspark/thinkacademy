package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateP.kt */
final class GradeAggregateP$footViewShow$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<ImageView> $ivSeleted;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateP$footViewShow$1$1(Ref.ObjectRef<ImageView> objectRef) {
        super(0);
        this.$ivSeleted = objectRef;
    }

    public final void invoke() {
        ((ImageView) this.$ivSeleted.element).setSelected(!((ImageView) this.$ivSeleted.element).isSelected());
    }
}
