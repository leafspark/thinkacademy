package com.tal.app.thinkacademy.business.study.study;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.study.study.PrepareClassActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class PrepareClassActivity$startObserve$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ PrepareClassActivity this$0;

    public PrepareClassActivity$startObserve$$inlined$observe$1(PrepareClassActivity prepareClassActivity) {
        this.this$0 = prepareClassActivity;
    }

    public final void onChanged(T t) {
        StateData stateData = (StateData) t;
        int i = PrepareClassActivity.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        if (i == 1) {
            this.this$0.mRequestEnd = System.currentTimeMillis();
            PrepareClassActivity prepareClassActivity = this.this$0;
            prepareClassActivity.allRoundTrip = prepareClassActivity.allRoundTrip + (this.this$0.mRequestEnd - this.this$0.mRequestStart);
            PrepareClassActivity prepareClassActivity2 = this.this$0;
            prepareClassActivity2.mRequestSuccessCount = prepareClassActivity2.mRequestSuccessCount + 1.0f;
            float unused = this.this$0.mRequestSuccessCount;
            if (!this.this$0.isStopRequest) {
                this.this$0.getMViewModel().requestNetStatus();
                PrepareClassActivity prepareClassActivity3 = this.this$0;
                prepareClassActivity3.mRequestCounts = prepareClassActivity3.mRequestCounts + 1;
                int unused2 = this.this$0.mRequestCounts;
                this.this$0.mRequestStart = System.currentTimeMillis();
            }
        } else if (i == 2) {
            XesLog.it("PrepareClassActivity - netStatus ->", new Object[]{stateData.getData()});
            if (!this.this$0.isStopRequest) {
                this.this$0.getMViewModel().requestNetStatus();
                PrepareClassActivity prepareClassActivity4 = this.this$0;
                prepareClassActivity4.mRequestCounts = prepareClassActivity4.mRequestCounts + 1;
                int unused3 = this.this$0.mRequestCounts;
                this.this$0.mRequestStart = System.currentTimeMillis();
            }
        } else if (i == 3 && !this.this$0.isStopRequest) {
            this.this$0.getMViewModel().requestNetStatus();
            PrepareClassActivity prepareClassActivity5 = this.this$0;
            prepareClassActivity5.mRequestCounts = prepareClassActivity5.mRequestCounts + 1;
            int unused4 = this.this$0.mRequestCounts;
            this.this$0.mRequestStart = System.currentTimeMillis();
        }
    }
}
