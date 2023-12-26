package com.tal.app.thinkacademy.live.business.exercise;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class ExerciseBackPluginDriver$special$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ ExerciseBackPluginDriver this$0;

    public ExerciseBackPluginDriver$special$$inlined$observe$1(ExerciseBackPluginDriver exerciseBackPluginDriver) {
        this.this$0 = exerciseBackPluginDriver;
    }

    public final void onChanged(T t) {
        XesLog.i(ExerciseBackPluginDriver.TAG, "回放", Intrinsics.stringPlus("JS给的答题结果", t));
        ExercisePluginView access$getMExercisePluginView$p = this.this$0.mExercisePluginView;
        if (access$getMExercisePluginView$p != null) {
            access$getMExercisePluginView$p.showCoinsView(0);
        }
        this.this$0.removePlugin(5000);
        XesLog.i(ExerciseBackPluginDriver.TAG, "回放", "启动延时5s销毁插件");
    }
}
