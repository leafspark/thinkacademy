package com.kwai.koom.base.loop;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kwai/koom/base/loop/LoopThread;", "Landroid/os/HandlerThread;", "()V", "LOOP_HANDLER", "Landroid/os/Handler;", "getLOOP_HANDLER$koom_monitor_base_SharedCppRelease", "()Landroid/os/Handler;", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: LoopThread.kt */
public final class LoopThread extends HandlerThread {
    public static final LoopThread INSTANCE;
    private static final Handler LOOP_HANDLER;

    static {
        LoopThread loopThread = new LoopThread();
        INSTANCE = loopThread;
        loopThread.start();
        LOOP_HANDLER = new Handler(loopThread.getLooper());
    }

    private LoopThread() {
        super("LoopThread", 10);
    }

    public final Handler getLOOP_HANDLER$koom_monitor_base_SharedCppRelease() {
        return LOOP_HANDLER;
    }
}
