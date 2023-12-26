package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedSchedule;
import com.tal.app.thinkacademy.business.study.study.speaker.RecordedClickType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarAdapter.kt */
final class RecordedCalendarAdapter$convert$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseViewHolder $holder;
    final /* synthetic */ RecordedSchedule $item;
    final /* synthetic */ RecordedCalendarAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecordedCalendarAdapter$convert$1$3(RecordedCalendarAdapter recordedCalendarAdapter, RecordedSchedule recordedSchedule, BaseViewHolder baseViewHolder) {
        super(0);
        this.this$0 = recordedCalendarAdapter;
        this.$item = recordedSchedule;
        this.$holder = baseViewHolder;
    }

    public final void invoke() {
        Function3 access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.invoke(RecordedClickType.ExamType, this.$item, Integer.valueOf(this.$holder.getLayoutPosition()));
        }
    }
}
