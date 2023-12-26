package com.tal.app.thinkacademy.business.study.study.ready;

import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.widget.gold.FlyCoinListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/business/study/study/ready/BeforeClassLiveActivity$onClick$1$1$1", "Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinListener;", "onFlyCoinEnd", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeforeClassLiveActivity.kt */
public final class BeforeClassLiveActivity$onClick$1$1$1 implements FlyCoinListener {
    final /* synthetic */ BeforeClassLiveActivity this$0;

    BeforeClassLiveActivity$onClick$1$1$1(BeforeClassLiveActivity beforeClassLiveActivity) {
        this.this$0 = beforeClassLiveActivity;
    }

    public void onFlyCoinEnd() {
        this.this$0.getBinding().tvCheckInCoin.setVisibility(8);
        this.this$0.getBinding().btnCheckInCover.setVisibility(0);
        this.this$0.showViewToast(true, R.string.prepare_sign_success);
    }
}
