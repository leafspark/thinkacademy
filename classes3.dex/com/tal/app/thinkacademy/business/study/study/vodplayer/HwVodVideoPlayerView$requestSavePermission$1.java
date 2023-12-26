package com.tal.app.thinkacademy.business.study.study.vodplayer;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwVodVideoPlayerView.kt */
final class HwVodVideoPlayerView$requestSavePermission$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ HwVodVideoPlayerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HwVodVideoPlayerView$requestSavePermission$1(HwVodVideoPlayerView hwVodVideoPlayerView) {
        super(1);
        this.this$0 = hwVodVideoPlayerView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"用户给了权限，开始截图"});
            this.this$0.takePhoto();
            return;
        }
        XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"用户没有给权限，放弃截图"});
    }
}
