package com.tal.app.thinkacademy.business.study.study.service;

import com.tal.app.thinkacademy.business.study.study.constants.TwoButtonType;
import com.tal.app.thinkacademy.business.study.study.entity.CalendarItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/study/study/constants/TwoButtonType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyService.kt */
final class StudyService$onRoute$dialog$1 extends Lambda implements Function1<TwoButtonType, Unit> {
    final /* synthetic */ CalendarItem $item;
    final /* synthetic */ StudyService this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudyService.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TwoButtonType.values().length];
            iArr[TwoButtonType.LEFT.ordinal()] = 1;
            iArr[TwoButtonType.RIGHT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudyService$onRoute$dialog$1(StudyService studyService, CalendarItem calendarItem) {
        super(1);
        this.this$0 = studyService;
        this.$item = calendarItem;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TwoButtonType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TwoButtonType twoButtonType) {
        Intrinsics.checkNotNullParameter(twoButtonType, "it");
        if (WhenMappings.$EnumSwitchMapping$0[twoButtonType.ordinal()] == 1) {
            StudyService.enterLiveRoom$default(this.this$0, this.$item, false, 2, (Object) null);
        }
    }
}
