package com.tal.app.thinkacademy.business.shop;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDetailsActivity.kt */
final class TeacherDetailsActivity$initListener$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TeacherDetailsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeacherDetailsActivity$initListener$2(TeacherDetailsActivity teacherDetailsActivity) {
        super(0);
        this.this$0 = teacherDetailsActivity;
    }

    public final void invoke() {
        this.this$0.setSeleted(false);
        LinearLayoutManager access$getMLinearLayoutManager$p = this.this$0.mLinearLayoutManager;
        if (access$getMLinearLayoutManager$p != null) {
            access$getMLinearLayoutManager$p.scrollToPositionWithOffset(this.this$0.classPosition, 0);
        }
    }
}
