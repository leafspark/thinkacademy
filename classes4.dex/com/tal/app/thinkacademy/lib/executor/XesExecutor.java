package com.tal.app.thinkacademy.lib.executor;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/lib/executor/XesExecutor;", "", "()V", "TAG", "", "hiExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "isPaused", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "mainHandler", "Landroid/os/Handler;", "pauseCondition", "Ljava/util/concurrent/locks/Condition;", "execute", "", "priority", "", "runnable", "Ljava/lang/Runnable;", "pause", "resume", "Callable", "PriorityRunnable", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesExecutor.kt */
public final class XesExecutor {
    public static final XesExecutor INSTANCE = new XesExecutor();
    private static final String TAG = "XesExecutor";
    private static ThreadPoolExecutor hiExecutor;
    /* access modifiers changed from: private */
    public static boolean isPaused;
    /* access modifiers changed from: private */
    public static ReentrantLock lock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Condition pauseCondition;

    private XesExecutor() {
    }

    static {
        Condition newCondition = lock.newCondition();
        Intrinsics.checkNotNullExpressionValue(newCondition, "lock.newCondition()");
        pauseCondition = newCondition;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        hiExecutor = new ThreadPoolExecutor(availableProcessors + 1, (availableProcessors * 2) + 1, 30, TimeUnit.SECONDS, new PriorityBlockingQueue(), new XesExecutor$$ExternalSyntheticLambda0(new AtomicLong())) {
            final /* synthetic */ PriorityBlockingQueue<? extends Runnable> $blockingQueue;
            final /* synthetic */ int $corePoolSize;
            final /* synthetic */ long $keepAliveTime;
            final /* synthetic */ int $maxPoolSize;
            final /* synthetic */ ThreadFactory $threadFactory;
            final /* synthetic */ TimeUnit $unit;

            {
                this.$corePoolSize = r9;
                this.$maxPoolSize = r10;
                this.$keepAliveTime = r11;
                this.$unit = r13;
                this.$blockingQueue = r14;
                this.$threadFactory = r15;
            }

            /* access modifiers changed from: protected */
            public void beforeExecute(Thread thread, Runnable runnable) {
                if (XesExecutor.isPaused) {
                    XesExecutor.lock.lock();
                    try {
                        XesExecutor.pauseCondition.await();
                    } finally {
                        XesExecutor.lock.unlock();
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void afterExecute(Runnable runnable, Throwable th) {
                Objects.requireNonNull(runnable, "null cannot be cast to non-null type com.tal.app.thinkacademy.lib.executor.XesExecutor.PriorityRunnable");
                XesLog.et(XesExecutor.TAG, Intrinsics.stringPlus("已执行完的任务的优先级是：", Integer.valueOf(((PriorityRunnable) runnable).getPriority())));
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final Thread m81_init_$lambda0(AtomicLong atomicLong, Runnable runnable) {
        Intrinsics.checkNotNullParameter(atomicLong, "$seq");
        Thread thread = new Thread(runnable);
        thread.setName(Intrinsics.stringPlus("Xes-executor-", Long.valueOf(atomicLong.getAndIncrement())));
        return thread;
    }

    public static /* synthetic */ void execute$default(XesExecutor xesExecutor, int i, Runnable runnable, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        xesExecutor.execute(i, runnable);
    }

    public final void execute(int i, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        hiExecutor.execute(new PriorityRunnable(i, runnable));
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/executor/XesExecutor$Callable;", "T", "Ljava/lang/Runnable;", "()V", "onBackground", "()Ljava/lang/Object;", "onCompleted", "", "t", "(Ljava/lang/Object;)V", "onPrepare", "run", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: XesExecutor.kt */
    public static abstract class Callable<T> implements Runnable {
        public abstract T onBackground();

        public abstract void onCompleted(T t);

        public void onPrepare() {
        }

        /* access modifiers changed from: private */
        /* renamed from: run$lambda-0  reason: not valid java name */
        public static final void m82run$lambda0(Callable callable) {
            Intrinsics.checkNotNullParameter(callable, "this$0");
            callable.onPrepare();
        }

        public void run() {
            Handler access$getMainHandler$p = XesExecutor.mainHandler;
            XesExecutor$Callable$$ExternalSyntheticLambda0 xesExecutor$Callable$$ExternalSyntheticLambda0 = new XesExecutor$Callable$$ExternalSyntheticLambda0(this);
            if (!(access$getMainHandler$p instanceof Handler)) {
                access$getMainHandler$p.post(xesExecutor$Callable$$ExternalSyntheticLambda0);
            } else {
                AsynchronousInstrumentation.handlerPost(access$getMainHandler$p, xesExecutor$Callable$$ExternalSyntheticLambda0);
            }
            Object onBackground = onBackground();
            XesExecutor.mainHandler.removeCallbacksAndMessages((Object) null);
            Handler access$getMainHandler$p2 = XesExecutor.mainHandler;
            XesExecutor$Callable$$ExternalSyntheticLambda1 xesExecutor$Callable$$ExternalSyntheticLambda1 = new XesExecutor$Callable$$ExternalSyntheticLambda1(this, onBackground);
            if (!(access$getMainHandler$p2 instanceof Handler)) {
                access$getMainHandler$p2.post(xesExecutor$Callable$$ExternalSyntheticLambda1);
            } else {
                AsynchronousInstrumentation.handlerPost(access$getMainHandler$p2, xesExecutor$Callable$$ExternalSyntheticLambda1);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: run$lambda-1  reason: not valid java name */
        public static final void m83run$lambda1(Callable callable, Object obj) {
            Intrinsics.checkNotNullParameter(callable, "this$0");
            callable.onCompleted(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0011\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0000H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/lib/executor/XesExecutor$PriorityRunnable;", "Ljava/lang/Runnable;", "", "priority", "", "runnable", "(ILjava/lang/Runnable;)V", "getPriority", "()I", "compareTo", "other", "run", "", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: XesExecutor.kt */
    public static final class PriorityRunnable implements Runnable, Comparable<PriorityRunnable> {
        private final int priority;
        private final Runnable runnable;

        public PriorityRunnable(int i, Runnable runnable2) {
            Intrinsics.checkNotNullParameter(runnable2, "runnable");
            this.priority = i;
            this.runnable = runnable2;
        }

        public final int getPriority() {
            return this.priority;
        }

        public int compareTo(PriorityRunnable priorityRunnable) {
            Intrinsics.checkNotNullParameter(priorityRunnable, "other");
            int i = this.priority;
            int i2 = priorityRunnable.priority;
            if (i < i2) {
                return 1;
            }
            return i > i2 ? -1 : 0;
        }

        public void run() {
            this.runnable.run();
        }
    }

    public final void pause() {
        lock.lock();
        try {
            isPaused = true;
            XesLog.et(TAG, "XesExecutor is paused");
        } finally {
            lock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void resume() {
        lock.lock();
        try {
            isPaused = false;
            pauseCondition.signalAll();
            lock.unlock();
            XesLog.et(TAG, "XesExecutor is resumed");
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }
}
