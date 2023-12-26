package com.tal.app.thinkacademy.live.business.drawing;

import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/business/drawing/DrawPluginDriver$realSubmit$1", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawPluginDriver.kt */
public final class DrawPluginDriver$realSubmit$1 implements IError {
    final /* synthetic */ DrawPluginDriver this$0;

    DrawPluginDriver$realSubmit$1(DrawPluginDriver drawPluginDriver) {
        this.this$0 = drawPluginDriver;
    }

    public void onFail(int i, String str) {
        this.this$0.hideSubmitDialog();
        GraffitiBean access$getGraffitiBean$p = this.this$0.graffitiBean;
        if (access$getGraffitiBean$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            access$getGraffitiBean$p = null;
        }
        InteractReportKt.XesLogReport$default("uploadImage", "draw", access$getGraffitiBean$p.getInteractId(), 0, (String) null, 16, (Object) null);
        ToastUtils.showShort(str, new Object[0]);
        this.this$0.isSubmitting = false;
    }

    public void onError(int i, String str) {
        this.this$0.hideSubmitDialog();
        GraffitiBean access$getGraffitiBean$p = this.this$0.graffitiBean;
        if (access$getGraffitiBean$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graffitiBean");
            access$getGraffitiBean$p = null;
        }
        InteractReportKt.XesLogReport$default("uploadImage", "draw", access$getGraffitiBean$p.getInteractId(), 0, (String) null, 16, (Object) null);
        ToastUtils.showShort(str, new Object[0]);
        this.this$0.isSubmitting = false;
    }
}
