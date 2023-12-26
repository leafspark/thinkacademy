package androidx.window.java.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J2\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u0011H\u0002J$\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J\u0014\u0010\u0016\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u0014\u0010\u0017\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0001R\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/window/java/layout/WindowInfoTrackerCallbackAdapter;", "Landroidx/window/layout/WindowInfoTracker;", "tracker", "(Landroidx/window/layout/WindowInfoTracker;)V", "consumerToJobMap", "", "Landroidx/core/util/Consumer;", "Lkotlinx/coroutines/Job;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "addListener", "", "T", "executor", "Ljava/util/concurrent/Executor;", "consumer", "flow", "Lkotlinx/coroutines/flow/Flow;", "addWindowLayoutInfoListener", "activity", "Landroid/app/Activity;", "Landroidx/window/layout/WindowLayoutInfo;", "removeListener", "removeWindowLayoutInfoListener", "windowLayoutInfo", "window-java_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WindowInfoTrackerCallbackAdapter.kt */
public final class WindowInfoTrackerCallbackAdapter implements WindowInfoTracker {
    private final Map<Consumer<?>, Job> consumerToJobMap = new LinkedHashMap();
    private final ReentrantLock lock = new ReentrantLock();
    private final WindowInfoTracker tracker;

    public Flow<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.tracker.windowLayoutInfo(activity);
    }

    public WindowInfoTrackerCallbackAdapter(WindowInfoTracker windowInfoTracker) {
        Intrinsics.checkNotNullParameter(windowInfoTracker, "tracker");
        this.tracker = windowInfoTracker;
    }

    public final void addWindowLayoutInfoListener(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        addListener(executor, consumer, this.tracker.windowLayoutInfo(activity));
    }

    public final void removeWindowLayoutInfoListener(Consumer<WindowLayoutInfo> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        removeListener(consumer);
    }

    private final <T> void addListener(Executor executor, Consumer<T> consumer, Flow<? extends T> flow) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (this.consumerToJobMap.get(consumer) == null) {
                this.consumerToJobMap.put(consumer, BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executor)), (CoroutineContext) null, (CoroutineStart) null, new WindowInfoTrackerCallbackAdapter$addListener$1$1(flow, consumer, (Continuation<? super WindowInfoTrackerCallbackAdapter$addListener$1$1>) null), 3, (Object) null));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock2.unlock();
        }
    }

    private final void removeListener(Consumer<?> consumer) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            Job job = this.consumerToJobMap.get(consumer);
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job remove = this.consumerToJobMap.remove(consumer);
        } finally {
            lock2.unlock();
        }
    }
}
