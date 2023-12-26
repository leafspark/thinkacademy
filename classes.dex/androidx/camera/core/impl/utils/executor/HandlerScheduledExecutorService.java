package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

final class HandlerScheduledExecutorService extends AbstractExecutorService implements ScheduledExecutorService {
    private static ThreadLocal<ScheduledExecutorService> sThreadLocalInstance = new ThreadLocal<ScheduledExecutorService>() {
        public ScheduledExecutorService initialValue() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return CameraXExecutors.mainThreadExecutor();
            }
            if (Looper.myLooper() != null) {
                return new HandlerScheduledExecutorService(new Handler(Looper.myLooper()));
            }
            return null;
        }
    };
    private final Handler mHandler;

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    HandlerScheduledExecutorService(Handler handler) {
        this.mHandler = handler;
    }

    static ScheduledExecutorService currentThreadExecutor() {
        ScheduledExecutorService scheduledExecutorService = sThreadLocalInstance.get();
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            HandlerScheduledExecutorService handlerScheduledExecutorService = new HandlerScheduledExecutorService(new Handler(myLooper));
            sThreadLocalInstance.set(handlerScheduledExecutorService);
            return handlerScheduledExecutorService;
        }
        throw new IllegalStateException("Current thread has no looper!");
    }

    public ScheduledFuture<?> schedule(final Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(new Callable<Void>() {
            public Void call() {
                runnable.run();
                return null;
            }
        }, j, timeUnit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        long uptimeMillis = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
        HandlerScheduledFuture handlerScheduledFuture = new HandlerScheduledFuture(this.mHandler, uptimeMillis, callable);
        if (this.mHandler.postAtTime(handlerScheduledFuture, uptimeMillis)) {
            return handlerScheduledFuture;
        }
        return Futures.immediateFailedScheduledFuture(createPostFailedException());
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService" + " does not yet support fixed-rate scheduling.");
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService" + " does not yet support fixed-delay scheduling.");
    }

    public void shutdown() {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService" + " cannot be shut down. Use Looper.quitSafely().");
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService" + " cannot be shut down. Use Looper.quitSafely().");
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService" + " cannot be shut down. Use Looper.quitSafely().");
    }

    public void execute(Runnable runnable) {
        if (!this.mHandler.post(runnable)) {
            throw createPostFailedException();
        }
    }

    private RejectedExecutionException createPostFailedException() {
        return new RejectedExecutionException(this.mHandler + " is shutting down");
    }

    private static class HandlerScheduledFuture<V> implements RunnableScheduledFuture<V> {
        final AtomicReference<CallbackToFutureAdapter.Completer<V>> mCompleter = new AtomicReference<>((Object) null);
        private final ListenableFuture<V> mDelegate;
        private final long mRunAtMillis;
        private final Callable<V> mTask;

        public boolean isPeriodic() {
            return false;
        }

        HandlerScheduledFuture(final Handler handler, long j, final Callable<V> callable) {
            this.mRunAtMillis = j;
            this.mTask = callable;
            this.mDelegate = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<V>() {
                public Object attachCompleter(CallbackToFutureAdapter.Completer<V> completer) throws RejectedExecutionException {
                    completer.addCancellationListener(new Runnable() {
                        public void run() {
                            if (HandlerScheduledFuture.this.mCompleter.getAndSet((Object) null) != null) {
                                handler.removeCallbacks(HandlerScheduledFuture.this);
                            }
                        }
                    }, CameraXExecutors.directExecutor());
                    HandlerScheduledFuture.this.mCompleter.set(completer);
                    return "HandlerScheduledFuture-" + callable.toString();
                }
            });
        }

        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.mRunAtMillis - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public int compareTo(Delayed delayed) {
            return Long.compare(getDelay(TimeUnit.MILLISECONDS), delayed.getDelay(TimeUnit.MILLISECONDS));
        }

        public void run() {
            CallbackToFutureAdapter.Completer andSet = this.mCompleter.getAndSet((Object) null);
            if (andSet != null) {
                try {
                    andSet.set(this.mTask.call());
                } catch (Exception e) {
                    andSet.setException(e);
                }
            }
        }

        public boolean cancel(boolean z) {
            return this.mDelegate.cancel(z);
        }

        public boolean isCancelled() {
            return this.mDelegate.isCancelled();
        }

        public boolean isDone() {
            return this.mDelegate.isDone();
        }

        public V get() throws ExecutionException, InterruptedException {
            return this.mDelegate.get();
        }

        public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.mDelegate.get(j, timeUnit);
        }
    }
}
