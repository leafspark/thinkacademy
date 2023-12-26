package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginViewPad.kt */
final class AllOnStagePluginViewPad$initViews$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AllOnStagePluginViewPad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginViewPad$initViews$3(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        super(0);
        this.this$0 = allOnStagePluginViewPad;
    }

    public final void invoke() {
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
            mRtcViewModel.enableLocalVideo(!this.this$0.mCameraState);
        }
    }
}
