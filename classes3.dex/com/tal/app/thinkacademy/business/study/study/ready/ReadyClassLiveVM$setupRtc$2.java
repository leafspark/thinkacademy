package com.tal.app.thinkacademy.business.study.study.ready;

import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.lib.player.widget.RtcNetTestCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/business/study/study/ready/ReadyClassLiveVM$setupRtc$2", "Lcom/tal/app/thinkacademy/lib/player/widget/RtcNetTestCallback;", "onRtcOnceLastMileQuality", "", "quality", "", "type", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyClassLiveVM.kt */
public final class ReadyClassLiveVM$setupRtc$2 implements RtcNetTestCallback {
    final /* synthetic */ ReadyClassLiveVM this$0;

    ReadyClassLiveVM$setupRtc$2(ReadyClassLiveVM readyClassLiveVM) {
        this.this$0 = readyClassLiveVM;
    }

    public void onRtcOnceLastMileQuality(int i, String str) {
        Intrinsics.checkNotNullParameter(str, ClassParamsKt.TYPE);
        if (!this.this$0.mEnableRtcTest) {
            this.this$0.log("rtc网络状态回调，rtc网络测试结束");
            return;
        }
        if (i > 3) {
            this.this$0.log(Intrinsics.stringPlus("Rtc网络检测结果回调 quality=", Integer.valueOf(i)));
        }
        this.this$0.getMNetTestState().postStickyData(Integer.valueOf(i));
    }
}
