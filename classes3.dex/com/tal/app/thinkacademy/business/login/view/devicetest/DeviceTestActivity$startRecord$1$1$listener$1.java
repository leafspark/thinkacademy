package com.tal.app.thinkacademy.business.login.view.devicetest;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.common.utils.MkAiSoundSizeUtil;
import com.tal.app.thinkacademy.common.utils.PCMShortListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0017\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/login/view/devicetest/DeviceTestActivity$startRecord$1$1$listener$1", "Lcom/tal/app/thinkacademy/common/utils/PCMShortListener;", "onAudio", "", "data", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestActivity.kt */
public final class DeviceTestActivity$startRecord$1$1$listener$1 implements PCMShortListener {
    final /* synthetic */ Function1<Double, Unit> $block;
    final /* synthetic */ DeviceTestActivity $this_run;

    DeviceTestActivity$startRecord$1$1$listener$1(DeviceTestActivity deviceTestActivity, Function1<? super Double, Unit> function1) {
        this.$this_run = deviceTestActivity;
        this.$block = function1;
    }

    public void onAudio(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, DbParams.KEY_DATA);
        this.$this_run.runOnUiThread(new DeviceTestActivity$startRecord$1$1$listener$1$$ExternalSyntheticLambda0(this.$block, MkAiSoundSizeUtil.INSTANCE.calculateRealVolume(sArr, sArr.length)));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAudio$lambda-0  reason: not valid java name */
    public static final void m144onAudio$lambda0(Function1 function1, double d) {
        Intrinsics.checkNotNullParameter(function1, "$block");
        function1.invoke(Double.valueOf(d));
    }
}
