package com.tal.app.thinkacademy.business.study.study.ready;

import com.tal.app.thinkacademy.business.study.study.entity.CheckInData;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.widget.gold.FlyCoinConfig;
import com.tal.app.thinkacademy.common.widget.gold.FlyCoinLineConfig;
import com.tal.app.thinkacademy.common.widget.gold.FlyCoinLineDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeforeClassLiveActivity.kt */
final class BeforeClassLiveActivity$onClick$1 extends Lambda implements Function1<CheckInData, Unit> {
    final /* synthetic */ BeforeClassLiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BeforeClassLiveActivity$onClick$1(BeforeClassLiveActivity beforeClassLiveActivity) {
        super(1);
        this.this$0 = beforeClassLiveActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CheckInData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CheckInData checkInData) {
        Unit unit;
        if (checkInData == null) {
            unit = null;
        } else {
            BeforeClassLiveActivity beforeClassLiveActivity = this.this$0;
            beforeClassLiveActivity.getBinding().signLottie.setListener(new BeforeClassLiveActivity$onClick$1$1$1(beforeClassLiveActivity));
            beforeClassLiveActivity.getBinding().signLottie.playFlyCoinAnimation(beforeClassLiveActivity.rightCoin, new FlyCoinConfig(false, false, new FlyCoinLineConfig(FlyCoinLineDirection.DOWN, 70, 1000), new FlyCoinLineConfig(FlyCoinLineDirection.UP, 70, 1000), (FlyCoinLineConfig) null));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            BeforeClassLiveActivity beforeClassLiveActivity2 = this.this$0;
            beforeClassLiveActivity2.getBinding().btnCheckIn.setEnabled(true);
            beforeClassLiveActivity2.showViewToast(false, R.string.prepare_sign_fail);
        }
    }
}
