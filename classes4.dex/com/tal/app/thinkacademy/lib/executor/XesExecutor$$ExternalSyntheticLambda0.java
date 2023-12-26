package com.tal.app.thinkacademy.lib.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final /* synthetic */ class XesExecutor$$ExternalSyntheticLambda0 implements ThreadFactory {
    public final /* synthetic */ AtomicLong f$0;

    public /* synthetic */ XesExecutor$$ExternalSyntheticLambda0(AtomicLong atomicLong) {
        this.f$0 = atomicLong;
    }

    public final Thread newThread(Runnable runnable) {
        return XesExecutor.m81_init_$lambda0(this.f$0, runnable);
    }
}
