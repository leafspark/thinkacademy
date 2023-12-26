package com.tal.app.thinkacademy.live.business.exercise;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class ExercisePluginView$special$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ ExercisePluginView this$0;

    public ExercisePluginView$special$$inlined$observe$1(ExercisePluginView exercisePluginView) {
        this.this$0 = exercisePluginView;
    }

    public final void onChanged(T t) {
        String str = (String) t;
        if (this.this$0.mWebAgent != null) {
            WebAgent access$getMWebAgent$p = this.this$0.mWebAgent;
            Intrinsics.checkNotNull(access$getMWebAgent$p);
            access$getMWebAgent$p.jsCallBack("window.clientMessageHandlers", this.this$0.mJs);
            XesLog.i(this.this$0.TAG, this.this$0.mLiveType, "答题内容通知给Js开始渲染题");
        }
    }
}
