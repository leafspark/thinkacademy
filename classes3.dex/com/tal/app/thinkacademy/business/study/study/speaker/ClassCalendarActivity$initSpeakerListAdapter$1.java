package com.tal.app.thinkacademy.business.study.study.speaker;

import com.tal.app.thinkacademy.business.study.study.entity.CalendarItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "type", "Lcom/tal/app/thinkacademy/business/study/study/speaker/ClickType;", "item", "Lcom/tal/app/thinkacademy/business/study/study/entity/CalendarItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarActivity.kt */
final class ClassCalendarActivity$initSpeakerListAdapter$1 extends Lambda implements Function2<ClickType, CalendarItem, Unit> {
    final /* synthetic */ ClassCalendarActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassCalendarActivity$initSpeakerListAdapter$1(ClassCalendarActivity classCalendarActivity) {
        super(2);
        this.this$0 = classCalendarActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ClickType) obj, (CalendarItem) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ClickType clickType, CalendarItem calendarItem) {
        Intrinsics.checkNotNullParameter(clickType, ClassParamsKt.TYPE);
        Intrinsics.checkNotNullParameter(calendarItem, "item");
        this.this$0.itemClick(clickType, calendarItem);
    }
}
