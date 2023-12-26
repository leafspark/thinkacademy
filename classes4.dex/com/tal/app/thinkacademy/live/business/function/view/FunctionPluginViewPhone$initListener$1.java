package com.tal.app.thinkacademy.live.business.function.view;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginViewPhone.kt */
final class FunctionPluginViewPhone$initListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FunctionPluginViewPhone this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionPluginViewPhone$initListener$1(FunctionPluginViewPhone functionPluginViewPhone) {
        super(0);
        this.this$0 = functionPluginViewPhone;
    }

    public final void invoke() {
        boolean isGranted = PermissionUtils.isGranted("android.permission.RECORD_AUDIO");
        XesLog.dt("功能区", Intrinsics.stringPlus("点击麦克风开关 isPermissionMic = ", Boolean.valueOf(isGranted)));
        if (!isGranted) {
            this.this$0.getDriver().showPermissionWindow(true);
            return;
        }
        XesLog.dt("功能区", "点击麦克风开关 isMicOff=" + this.this$0.isMicOff() + ",teacherMicAllow=" + this.this$0.getTeacherMicAllow() + ",mIsTeacherForbidMuteMic=$");
        if (this.this$0.isMicOff() && !this.this$0.getTeacherMicAllow()) {
            this.this$0.showNotAllowMicPopUpWindow(true);
        } else if (this.this$0.isMicOff() || !this.this$0.getMIsTeacherForbidMuteMic()) {
            FunctionPluginViewPhone functionPluginViewPhone = this.this$0;
            functionPluginViewPhone.setMicOff(!functionPluginViewPhone.isMicOff());
            this.this$0.getDriver().controlLocalAudio(true ^ this.this$0.isMicOff());
        } else {
            XesLog.dt("功能区", "点击麦克风开关,不允许关闭麦克风");
            this.this$0.showNotAllowMicPopUpWindow(false);
        }
    }
}
