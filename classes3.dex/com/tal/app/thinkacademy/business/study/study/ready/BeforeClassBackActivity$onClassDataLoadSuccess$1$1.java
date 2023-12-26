package com.tal.app.thinkacademy.business.study.study.ready;

import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeforeClassBackActivity.kt */
final class BeforeClassBackActivity$onClassDataLoadSuccess$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map<String, Object> $map;
    final /* synthetic */ BeforeClassBackActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BeforeClassBackActivity$onClassDataLoadSuccess$1$1(BeforeClassBackActivity beforeClassBackActivity, Map<String, Object> map) {
        super(0);
        this.this$0 = beforeClassBackActivity;
        this.$map = map;
    }

    public final void invoke() {
        if (!this.this$0.isFinishing() && !this.this$0.isDestroyed()) {
            HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
            String mPlanId = this.this$0.getMPlanId();
            if (mPlanId == null) {
                mPlanId = "";
            }
            String mCourseId = this.this$0.getMCourseId();
            if (mCourseId == null) {
                mCourseId = "";
            }
            hWEventTracking.ostaEnterPlayback(mPlanId, mCourseId, this.this$0.getMCoursewareDownloadFinished(), Long.valueOf(this.this$0.getMCoursewareNeedDownloadSize() / ((long) 1024)), Long.valueOf(this.this$0.getMCoursewareDownloadTime() / ((long) 1000)), Long.valueOf(this.this$0.getMViewModel().getServerTime() - this.this$0.mStartTime));
            this.this$0.enterClassRoom(this.$map);
        }
    }
}
