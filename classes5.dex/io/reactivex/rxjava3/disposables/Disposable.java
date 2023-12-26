package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

public interface Disposable {
    void dispose();

    boolean isDisposed();

    /* renamed from: io.reactivex.rxjava3.disposables.Disposable$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Disposable fromRunnable(Runnable runnable) {
            Objects.requireNonNull(runnable, "run is null");
            return new RunnableDisposable(runnable);
        }

        public static Disposable fromAction(Action action) {
            Objects.requireNonNull(action, "action is null");
            return new ActionDisposable(action);
        }

        public static Disposable fromFuture(Future<?> future) {
            Objects.requireNonNull(future, "future is null");
            return fromFuture(future, true);
        }

        public static Disposable fromFuture(Future<?> future, boolean z) {
            Objects.requireNonNull(future, "future is null");
            return new FutureDisposable(future, z);
        }

        public static Disposable fromSubscription(Subscription subscription) {
            Objects.requireNonNull(subscription, "subscription is null");
            return new SubscriptionDisposable(subscription);
        }

        public static Disposable fromAutoCloseable(AutoCloseable autoCloseable) {
            Objects.requireNonNull(autoCloseable, "autoCloseable is null");
            return new AutoCloseableDisposable(autoCloseable);
        }

        public static AutoCloseable toAutoCloseable(Disposable disposable) {
            Objects.requireNonNull(disposable, "disposable is null");
            disposable.getClass();
            return new Disposable$$ExternalSyntheticLambda0(disposable);
        }

        public static Disposable empty() {
            return fromRunnable(Functions.EMPTY_RUNNABLE);
        }

        public static Disposable disposed() {
            return EmptyDisposable.INSTANCE;
        }
    }
}
