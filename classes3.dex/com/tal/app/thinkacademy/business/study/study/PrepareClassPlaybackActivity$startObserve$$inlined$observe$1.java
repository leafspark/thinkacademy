package com.tal.app.thinkacademy.business.study.study;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class PrepareClassPlaybackActivity$startObserve$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ PrepareClassPlaybackActivity this$0;

    public PrepareClassPlaybackActivity$startObserve$$inlined$observe$1(PrepareClassPlaybackActivity prepareClassPlaybackActivity) {
        this.this$0 = prepareClassPlaybackActivity;
    }

    public final void onChanged(T t) {
        StateData stateData = (StateData) t;
        int i = PrepareClassPlaybackActivity.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        if (i == 1) {
            this.this$0.mRequestEnd = System.currentTimeMillis();
            PrepareClassPlaybackActivity prepareClassPlaybackActivity = this.this$0;
            prepareClassPlaybackActivity.allRoundTrip = prepareClassPlaybackActivity.allRoundTrip + (this.this$0.mRequestEnd - this.this$0.mRequestStart);
            PrepareClassPlaybackActivity prepareClassPlaybackActivity2 = this.this$0;
            prepareClassPlaybackActivity2.mRequestSuccessCount = prepareClassPlaybackActivity2.mRequestSuccessCount + 1.0f;
            float unused = this.this$0.mRequestSuccessCount;
            if (!this.this$0.isStopRequest) {
                this.this$0.getMViewModel().requestNetStatus();
                PrepareClassPlaybackActivity prepareClassPlaybackActivity3 = this.this$0;
                prepareClassPlaybackActivity3.mRequestCounts = prepareClassPlaybackActivity3.mRequestCounts + 1;
                int unused2 = this.this$0.mRequestCounts;
                this.this$0.mRequestStart = System.currentTimeMillis();
            }
        } else if (i == 2) {
            XesLog.it(this.this$0.TAG, new Object[]{Intrinsics.stringPlus("netStatus -> ", stateData.getData())});
            if (!this.this$0.isStopRequest) {
                this.this$0.getMViewModel().requestNetStatus();
                PrepareClassPlaybackActivity prepareClassPlaybackActivity4 = this.this$0;
                prepareClassPlaybackActivity4.mRequestCounts = prepareClassPlaybackActivity4.mRequestCounts + 1;
                int unused3 = this.this$0.mRequestCounts;
                this.this$0.mRequestStart = System.currentTimeMillis();
            }
        } else if (i == 3 && !this.this$0.isStopRequest) {
            this.this$0.getMViewModel().requestNetStatus();
            PrepareClassPlaybackActivity prepareClassPlaybackActivity5 = this.this$0;
            prepareClassPlaybackActivity5.mRequestCounts = prepareClassPlaybackActivity5.mRequestCounts + 1;
            int unused4 = this.this$0.mRequestCounts;
            this.this$0.mRequestStart = System.currentTimeMillis();
        }
    }
}
