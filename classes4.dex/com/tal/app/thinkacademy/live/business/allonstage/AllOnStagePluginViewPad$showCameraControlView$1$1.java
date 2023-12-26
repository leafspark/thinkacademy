package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginViewPad.kt */
final class AllOnStagePluginViewPad$showCameraControlView$1$1 extends Lambda implements Function1<Type, Unit> {
    final /* synthetic */ AllOnStagePluginViewPad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginViewPad$showCameraControlView$1$1(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        super(1);
        this.this$0 = allOnStagePluginViewPad;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Type) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Type type) {
        Intrinsics.checkNotNullParameter(type, "it");
        if (!PermissionUtils.isGranted("android.permission.CAMERA")) {
            AllOnStagePluginDriver mDriver = this.this$0.getMDriver();
            if (mDriver != null) {
                mDriver.showPermissionWindow(Type.CAMERA);
                return;
            }
            return;
        }
        RtcViewModel mRtcViewModel = this.this$0.getMRtcViewModel();
        if (mRtcViewModel != null) {
            mRtcViewModel.enableLocalVideo(true);
        }
    }
}
