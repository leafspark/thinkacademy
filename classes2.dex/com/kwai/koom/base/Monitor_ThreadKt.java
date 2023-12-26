package com.kwai.koom.base;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u001a\u001e\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u001a\u0018\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r\u001a\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u000f\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0010"}, d2 = {"mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "async", "", "delayMills", "", "block", "Lkotlin/Function0;", "postOnMainThread", "delay", "runnable", "Ljava/lang/Runnable;", "removeCallbacks", "runOnMainThread", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: Monitor_Thread.kt */
public final class Monitor_ThreadKt {
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static final Handler getMainHandler() {
        return mainHandler;
    }

    public static /* synthetic */ void async$default(long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        async(j, function0);
    }

    public static final void async(long j, Function0<Unit> function0) {
        ExecutorService executorService;
        Intrinsics.checkNotNullParameter(function0, "block");
        if (j != 0) {
            mainHandler.postDelayed(new Monitor_ThreadKt$async$1(function0), j);
            return;
        }
        Function0<ExecutorService> executorServiceInvoker$koom_monitor_base_SharedCppRelease = MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getExecutorServiceInvoker$koom_monitor_base_SharedCppRelease();
        if (executorServiceInvoker$koom_monitor_base_SharedCppRelease == null || (executorService = (ExecutorService) executorServiceInvoker$koom_monitor_base_SharedCppRelease.invoke()) == null || executorService.submit(new Monitor_ThreadKt$sam$java_lang_Runnable$0(function0)) == null) {
            ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new Monitor_ThreadKt$async$2(function0), 31, (Object) null);
        }
    }

    public static /* synthetic */ void postOnMainThread$default(long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        postOnMainThread(j, (Function0<Unit>) function0);
    }

    public static final void postOnMainThread(long j, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        mainHandler.postDelayed(new Monitor_ThreadKt$sam$java_lang_Runnable$0(function0), j);
    }

    public static final void runOnMainThread(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
            return;
        }
        Handler handler = mainHandler;
        Runnable monitor_ThreadKt$sam$java_lang_Runnable$0 = new Monitor_ThreadKt$sam$java_lang_Runnable$0(function0);
        if (!(handler instanceof Handler)) {
            handler.post(monitor_ThreadKt$sam$java_lang_Runnable$0);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, monitor_ThreadKt$sam$java_lang_Runnable$0);
        }
    }

    public static /* synthetic */ void postOnMainThread$default(long j, Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        postOnMainThread(j, runnable);
    }

    public static final void postOnMainThread(long j, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        mainHandler.postDelayed(runnable, j);
    }

    public static final void removeCallbacks(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        mainHandler.removeCallbacks(runnable);
    }
}
