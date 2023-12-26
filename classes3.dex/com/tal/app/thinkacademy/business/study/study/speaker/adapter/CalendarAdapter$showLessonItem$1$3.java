package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import android.content.Context;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.study.study.entity.CalendarItem;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity;
import com.tal.app.thinkacademy.business.study.study.speaker.ClickType;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CalendarAdapter.kt */
final class CalendarAdapter$showLessonItem$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseViewHolder $holder;
    final /* synthetic */ CalendarItem $item;
    final /* synthetic */ CalendarAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CalendarAdapter$showLessonItem$1$3(BaseViewHolder baseViewHolder, CalendarItem calendarItem, CalendarAdapter calendarAdapter) {
        super(0);
        this.$holder = baseViewHolder;
        this.$item = calendarItem;
        this.this$0 = calendarAdapter;
    }

    public final void invoke() {
        if (this.$holder.itemView.getContext() instanceof ClassCalendarActivity) {
            Context context = this.$holder.itemView.getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity");
            ClassCalendarActivity classCalendarActivity = (ClassCalendarActivity) context;
            int i = -1;
            String planId = this.$item.getLessonDetails().getPlanId();
            if (planId != null) {
                i = Integer.parseInt(planId);
            }
            Integer valueOf = Integer.valueOf(i);
            final CalendarAdapter calendarAdapter = this.this$0;
            final CalendarItem calendarItem = this.$item;
            classCalendarActivity.startCheckStudentInClass(valueOf, new Function0<Unit>() {
                public final void invoke() {
                    Function2 access$getListener$p = calendarAdapter.listener;
                    if (access$getListener$p != null) {
                        access$getListener$p.invoke(ClickType.Common, calendarItem);
                    }
                }
            });
        }
    }
}
