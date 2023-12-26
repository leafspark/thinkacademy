package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import com.tal.app.thinkacademy.business.study.study.entity.CalendarItem;
import com.tal.app.thinkacademy.business.study.study.speaker.ClickType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CalendarAdapter.kt */
final class CalendarAdapter$showLessonItem$1$13 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CalendarItem $item;
    final /* synthetic */ CalendarAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CalendarAdapter$showLessonItem$1$13(CalendarAdapter calendarAdapter, CalendarItem calendarItem) {
        super(0);
        this.this$0 = calendarAdapter;
        this.$item = calendarItem;
    }

    public final void invoke() {
        Function2 access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.invoke(ClickType.PreviewQuestion, this.$item);
        }
    }
}
