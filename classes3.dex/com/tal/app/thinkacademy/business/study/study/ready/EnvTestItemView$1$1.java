package com.tal.app.thinkacademy.business.study.study.ready;

import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnvTestItemView.kt */
final class EnvTestItemView$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EnvTestItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnvTestItemView$1$1(EnvTestItemView envTestItemView) {
        super(0);
        this.this$0 = envTestItemView;
    }

    public final void invoke() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.this$0.getMContext().getPackageName(), (String) null));
        this.this$0.getMContext().startActivity(intent);
    }
}
