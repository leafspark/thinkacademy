package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.study.study.PrepareClassActivity;
import com.tal.app.thinkacademy.business.study.study.entity.PrepareClassBean;
import com.tal.app.thinkacademy.business.study.study.vm.PrepareClassVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class PrepareClassActivity$startObserve$$inlined$observe$2<T> implements Observer<T> {
    final /* synthetic */ PrepareClassActivity this$0;

    public PrepareClassActivity$startObserve$$inlined$observe$2(PrepareClassActivity prepareClassActivity) {
        this.this$0 = prepareClassActivity;
    }

    public final void onChanged(T t) {
        StateData stateData = (StateData) t;
        int i = PrepareClassActivity.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                XesLog.it("PrepareClassActivity - prepareDataStatus ->", new Object[]{stateData.getData()});
            }
        } else if (stateData.getData() != null) {
            Object data = stateData.getData();
            Intrinsics.checkNotNull(data);
            Boolean needForceDownloadCourseware = ((PrepareClassBean) data).getNeedForceDownloadCourseware();
            if (needForceDownloadCourseware != null) {
                if (needForceDownloadCourseware.booleanValue()) {
                    this.this$0.getBinding().tvJoinClass.getDelegate().setBackgroundColor(this.this$0.getColor(R.color.color_14ff503f));
                    this.this$0.getBinding().tvJoinClass.setTextColor(ContextCompat.getColor((Context) this.this$0, R.color.color_ffaa0a));
                    this.this$0.getBinding().tvJoinClass.setClickable(false);
                } else {
                    this.this$0.getBinding().tvJoinClass.getDelegate().setBackgroundColor(this.this$0.getColor(R.color.color_ffaa0a));
                    this.this$0.getBinding().tvJoinClass.setTextColor(ContextCompat.getColor((Context) this.this$0, R.color.color_ffffff));
                    this.this$0.getBinding().tvJoinClass.setClickable(true);
                }
            }
            Object data2 = stateData.getData();
            Intrinsics.checkNotNull(data2);
            if (((PrepareClassBean) data2).getConfig() != null) {
                PrepareClassActivity prepareClassActivity = this.this$0;
                Object data3 = stateData.getData();
                Intrinsics.checkNotNull(data3);
                PrepareClassBean.ConfigBean config = ((PrepareClassBean) data3).getConfig();
                Intrinsics.checkNotNull(config);
                prepareClassActivity.excellentAvgRoundTrip = config.getExcellentAvgRoundTrip();
                PrepareClassActivity prepareClassActivity2 = this.this$0;
                Object data4 = stateData.getData();
                Intrinsics.checkNotNull(data4);
                PrepareClassBean.ConfigBean config2 = ((PrepareClassBean) data4).getConfig();
                Intrinsics.checkNotNull(config2);
                prepareClassActivity2.excellentAvgSuccessRate = config2.getExcellentAvgSuccessRate();
                PrepareClassActivity prepareClassActivity3 = this.this$0;
                Object data5 = stateData.getData();
                Intrinsics.checkNotNull(data5);
                PrepareClassBean.ConfigBean config3 = ((PrepareClassBean) data5).getConfig();
                Intrinsics.checkNotNull(config3);
                prepareClassActivity3.normalAvgRoundTrip = config3.getNormalAvgRoundTrip();
                PrepareClassActivity prepareClassActivity4 = this.this$0;
                Object data6 = stateData.getData();
                Intrinsics.checkNotNull(data6);
                PrepareClassBean.ConfigBean config4 = ((PrepareClassBean) data6).getConfig();
                Intrinsics.checkNotNull(config4);
                prepareClassActivity4.normalAvgSuccessRate = config4.getNormalAvgSuccessRate();
                PrepareClassActivity prepareClassActivity5 = this.this$0;
                Object data7 = stateData.getData();
                Intrinsics.checkNotNull(data7);
                PrepareClassBean.ConfigBean config5 = ((PrepareClassBean) data7).getConfig();
                Intrinsics.checkNotNull(config5);
                prepareClassActivity5.mDuration = config5.getDurationTime();
                this.this$0.initStatusData();
            }
            PrepareClassActivity prepareClassActivity6 = this.this$0;
            Object data8 = stateData.getData();
            Intrinsics.checkNotNull(data8);
            prepareClassActivity6.mStartTime = ((PrepareClassBean) data8).getStartTime();
            PrepareClassActivity prepareClassActivity7 = this.this$0;
            Object data9 = stateData.getData();
            Intrinsics.checkNotNull(data9);
            prepareClassActivity7.mNowTime = ((PrepareClassBean) data9).getNowTime();
            this.this$0.calculateStartClassTime();
            if (this.this$0.isLive && !this.this$0.isAuditor && !this.this$0.isParentAudit) {
                PrepareClassVM access$getMViewModel = this.this$0.getMViewModel();
                String access$getMPlanId$p = this.this$0.mPlanId;
                Integer num = null;
                Integer valueOf = access$getMPlanId$p == null ? null : Integer.valueOf(Integer.parseInt(access$getMPlanId$p));
                String access$getMCourseId$p = this.this$0.mCourseId;
                if (access$getMCourseId$p != null) {
                    num = Integer.valueOf(Integer.parseInt(access$getMCourseId$p));
                }
                access$getMViewModel.checkInStatus(valueOf, num);
            }
        }
    }
}
