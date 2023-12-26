package com.kwai.koom.base;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
/* compiled from: Monitor_Thread.kt */
final class Monitor_ThreadKt$async$1 implements Runnable {
    final /* synthetic */ Function0 $block;

    Monitor_ThreadKt$async$1(Function0 function0) {
        this.$block = function0;
    }

    public final void run() {
        ExecutorService executorService;
        Function0<ExecutorService> executorServiceInvoker$koom_monitor_base_SharedCppRelease = MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getExecutorServiceInvoker$koom_monitor_base_SharedCppRelease();
        if (!(executorServiceInvoker$koom_monitor_base_SharedCppRelease == null || (executorService = (ExecutorService) executorServiceInvoker$koom_monitor_base_SharedCppRelease.invoke()) == null)) {
            Function0 function0 = this.$block;
            if (function0 != null) {
                function0 = new Monitor_ThreadKt$sam$java_lang_Runnable$0(function0);
            }
            if (executorService.submit((Runnable) function0) != null) {
                return;
            }
        }
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new Function0<Unit>(this) {
            final /* synthetic */ Monitor_ThreadKt$async$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.$block.invoke();
            }
        }, 31, (Object) null);
    }
}
