package com.tal.app.thinkacademy.business.login.view.devicetest;

import com.tal.app.thinkacademy.common.utils.VolumeChangeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestActivity.kt */
final class DeviceTestActivity$obtainSystemMediaVoiceSize$2$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function3<Integer, Integer, Integer, Unit> $block;
    final /* synthetic */ VolumeChangeHelper $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestActivity$obtainSystemMediaVoiceSize$2$1(Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3, VolumeChangeHelper volumeChangeHelper) {
        super(1);
        this.$block = function3;
        this.$this_run = volumeChangeHelper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$block.invoke(Integer.valueOf(i), Integer.valueOf(this.$this_run.getMaxVolume()), Integer.valueOf(this.$this_run.getMinVolume()));
    }
}
