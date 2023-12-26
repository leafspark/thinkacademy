package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import com.tal.app.thinkacademy.business.study.study.dialog.InternetSafetyTipsDialog;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassPlaybackActivity.kt */
final class PrepareClassPlaybackActivity$setValues$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PrepareClassPlaybackActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrepareClassPlaybackActivity$setValues$1(PrepareClassPlaybackActivity prepareClassPlaybackActivity) {
        super(0);
        this.this$0 = prepareClassPlaybackActivity;
    }

    public final void invoke() {
        InternetSafetyTipsDialog access$getMInternetSafetyTipsDialog$p;
        if (this.this$0.mInternetSafetyTipsDialog == null) {
            this.this$0.mInternetSafetyTipsDialog = new InternetSafetyTipsDialog((Context) this.this$0, Intrinsics.stringPlus(UrlUtils.INSTANCE.getStudentHost(), "policyTip/internetSafetyTips"));
        }
        InternetSafetyTipsDialog access$getMInternetSafetyTipsDialog$p2 = this.this$0.mInternetSafetyTipsDialog;
        boolean z = false;
        if (access$getMInternetSafetyTipsDialog$p2 != null && !access$getMInternetSafetyTipsDialog$p2.isShowing()) {
            z = true;
        }
        if (z && (access$getMInternetSafetyTipsDialog$p = this.this$0.mInternetSafetyTipsDialog) != null) {
            access$getMInternetSafetyTipsDialog$p.show();
        }
    }
}
