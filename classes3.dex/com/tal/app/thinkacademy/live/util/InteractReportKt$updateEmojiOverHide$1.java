package com.tal.app.thinkacademy.live.util;

import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/util/InteractReportKt$updateEmojiOverHide$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/entity/EmptyBean;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractReport.kt */
public final class InteractReportKt$updateEmojiOverHide$1 extends OmyCallback<HiResponse<EmptyBean>> {
    final /* synthetic */ Function1<Integer, Unit> $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InteractReportKt$updateEmojiOverHide$1(Function1<? super Integer, Unit> function1, InteractReportKt$updateEmojiOverHide$2 interactReportKt$updateEmojiOverHide$2) {
        super((IError) interactReportKt$updateEmojiOverHide$2);
        this.$listener = function1;
    }

    public void onSuccess(HiResponse<EmptyBean> hiResponse) {
        Function1<Integer, Unit> function1 = this.$listener;
        if (function1 != null) {
            function1.invoke(0);
        }
    }
}
