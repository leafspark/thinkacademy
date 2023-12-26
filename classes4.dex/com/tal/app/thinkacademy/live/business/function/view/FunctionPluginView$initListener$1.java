package com.tal.app.thinkacademy.live.business.function.view;

import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginView.kt */
final class FunctionPluginView$initListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FunctionPluginView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionPluginView$initListener$1(FunctionPluginView functionPluginView) {
        super(0);
        this.this$0 = functionPluginView;
    }

    public final void invoke() {
        if (!PermissionUtils.isGranted("android.permission.RECORD_AUDIO")) {
            this.this$0.getDriver().showPermissionWindow(true);
        } else if (this.this$0.isMicOff() && !this.this$0.getTeacherMicAllow()) {
            this.this$0.showNotAllowMicPopUpWindow(true);
        } else if (this.this$0.isMicOff() || !this.this$0.getMIsTeacherForbidMuteMic()) {
            FunctionPluginView functionPluginView = this.this$0;
            functionPluginView.setMicOff(!functionPluginView.isMicOff());
            this.this$0.getDriver().controlLocalAudio(true ^ this.this$0.isMicOff());
        } else {
            this.this$0.showNotAllowMicPopUpWindow(false);
        }
    }
}
