package com.tal.app.thinkacademy.business.study.study.speaker;

import android.content.Context;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.common.utils.JumpUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tal/app/thinkacademy/business/study/study/speaker/OutsideOfClassType;", "theOutsideEntity", "Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarActivity.kt */
final class ClassCalendarActivity$startObserve$2$1$3 extends Lambda implements Function2<OutsideOfClassType, TheOutsideEntity, Unit> {
    final /* synthetic */ ClassCalendarActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassCalendarActivity$startObserve$2$1$3(ClassCalendarActivity classCalendarActivity) {
        super(2);
        this.this$0 = classCalendarActivity;
    }

    public final void invoke(OutsideOfClassType outsideOfClassType, TheOutsideEntity theOutsideEntity) {
        Intrinsics.checkNotNullParameter(outsideOfClassType, "$noName_0");
        Intrinsics.checkNotNullParameter(theOutsideEntity, "theOutsideEntity");
        Context context = (Context) this.this$0;
        String downLoadUrl = theOutsideEntity.getDownLoadUrl();
        if (downLoadUrl == null) {
            downLoadUrl = "";
        }
        JumpUtilKt.jumpUrl(context, downLoadUrl);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((OutsideOfClassType) obj, (TheOutsideEntity) obj2);
        return Unit.INSTANCE;
    }
}
