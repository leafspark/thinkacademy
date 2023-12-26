package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateP.kt */
final class GradeAggregateP$footViewShow$1$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextView $dayPrompt;
    final /* synthetic */ GradeAggregateP this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateP$footViewShow$1$6(TextView textView, GradeAggregateP gradeAggregateP) {
        super(0);
        this.$dayPrompt = textView;
        this.this$0 = gradeAggregateP;
    }

    public final void invoke() {
        this.$dayPrompt.setVisibility(8);
        this.this$0.showDayDialog();
        this.this$0.clearFocus();
    }
}
