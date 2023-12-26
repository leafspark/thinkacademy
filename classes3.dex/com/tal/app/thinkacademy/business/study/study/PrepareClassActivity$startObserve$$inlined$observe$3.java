package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Observer;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.PrepareClassActivity;
import com.tal.app.thinkacademy.business.study.study.dialog.CheckInDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.CheckInFaildDialog;
import com.tal.app.thinkacademy.business.study.study.entity.CheckInStatus;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class PrepareClassActivity$startObserve$$inlined$observe$3<T> implements Observer<T> {
    final /* synthetic */ PrepareClassActivity this$0;

    public PrepareClassActivity$startObserve$$inlined$observe$3(PrepareClassActivity prepareClassActivity) {
        this.this$0 = prepareClassActivity;
    }

    public final void onChanged(T t) {
        CheckInStatus checkInStatus;
        StateData stateData = (StateData) t;
        int i = PrepareClassActivity.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                XesLog.it("PrepareClassActivity - prepareCheckInStatus ->", new Object[]{stateData.getData()});
            }
        } else if (stateData.getData() != null) {
            String str = null;
            if (!(stateData == null || (checkInStatus = (CheckInStatus) stateData.getData()) == null)) {
                str = checkInStatus.getStatus();
            }
            if (Intrinsics.areEqual((Object) DbParams.GZIP_DATA_EVENT, (Object) str) && !this.this$0.isFinishing()) {
                Long access$getMStartTime$p = this.this$0.mStartTime;
                Intrinsics.checkNotNull(access$getMStartTime$p);
                long longValue = access$getMStartTime$p.longValue();
                Long access$getMNowTime$p = this.this$0.mNowTime;
                Intrinsics.checkNotNull(access$getMNowTime$p);
                if (longValue > access$getMNowTime$p.longValue()) {
                    if (this.this$0.mCheckInDialog == null) {
                        this.this$0.mCheckInDialog = new CheckInDialog((Context) this.this$0, new PrepareClassActivity$startObserve$3$1(this.this$0));
                    }
                    CheckInDialog access$getMCheckInDialog$p = this.this$0.mCheckInDialog;
                    if (access$getMCheckInDialog$p == null || access$getMCheckInDialog$p.isShowing()) {
                        z = false;
                    }
                    if (z) {
                        CheckInDialog access$getMCheckInDialog$p2 = this.this$0.mCheckInDialog;
                        if (access$getMCheckInDialog$p2 != null) {
                            access$getMCheckInDialog$p2.show();
                        }
                        StudyTrack.classroomCheckin$default(StudyTrack.INSTANCE, "hw_classroom_checkin_show", this.this$0.subPlatformType, this.this$0.mCourseId, this.this$0.mPlanId, "签到", (Integer) null, 32, (Object) null);
                    }
                } else if (Intrinsics.areEqual((Object) "false", (Object) ShareDataManager.getInstance().getString(Intrinsics.stringPlus("planId-isShow-", this.this$0.mPlanId), "false", ShareDataManager.SHAREDATA_NOT_CLEAR))) {
                    if (this.this$0.mCheckInFaildDialog == null) {
                        this.this$0.mCheckInFaildDialog = new CheckInFaildDialog((Context) this.this$0);
                    }
                    CheckInFaildDialog access$getMCheckInFaildDialog$p = this.this$0.mCheckInFaildDialog;
                    if (access$getMCheckInFaildDialog$p == null || access$getMCheckInFaildDialog$p.isShowing()) {
                        z = false;
                    }
                    if (z) {
                        CheckInFaildDialog access$getMCheckInFaildDialog$p2 = this.this$0.mCheckInFaildDialog;
                        if (access$getMCheckInFaildDialog$p2 != null) {
                            access$getMCheckInFaildDialog$p2.show();
                        }
                        StudyTrack.classroomCheckin$default(StudyTrack.INSTANCE, "hw_classroom_checkin_show", this.this$0.subPlatformType, this.this$0.mCourseId, this.this$0.mPlanId, "错过签到", (Integer) null, 32, (Object) null);
                        Handler access$getMHandler$p = this.this$0.mHandler;
                        if (access$getMHandler$p != null) {
                            access$getMHandler$p.postDelayed(new PrepareClassActivity$startObserve$3$2(this.this$0), 5000);
                        }
                        ShareDataManager.getInstance().put(Intrinsics.stringPlus("planId-isShow-", this.this$0.mPlanId), "true", ShareDataManager.SHAREDATA_NOT_CLEAR);
                    }
                }
            }
        }
    }
}
