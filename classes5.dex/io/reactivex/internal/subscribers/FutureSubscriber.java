package io.reactivex.internal.subscribers;

import io.ktor.client.plugins.HttpTimeout;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    Throwable error;
    final AtomicReference<Subscription> s = new AtomicReference<>();
    T value;

    public void cancel() {
    }

    public void request(long j) {
    }

    public FutureSubscriber() {
        super(1);
    }

    public boolean cancel(boolean z) {
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) this.s.get();
            if (subscriptionHelper == this || subscriptionHelper == SubscriptionHelper.CANCELLED) {
                return false;
            }
        } while (!this.s.compareAndSet(subscriptionHelper, SubscriptionHelper.CANCELLED));
        if (subscriptionHelper != null) {
            subscriptionHelper.cancel();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return SubscriptionHelper.isCancelled(this.s.get());
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new TimeoutException();
            }
        }
        if (!isCancelled()) {
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.s, subscription)) {
            subscription.request(HttpTimeout.INFINITE_TIMEOUT_MS);
        }
    }

    public void onNext(T t) {
        if (this.value != null) {
            this.s.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.value = t;
    }

    public void onError(Throwable th) {
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) this.s.get();
            if (subscriptionHelper == this || subscriptionHelper == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
        } while (!this.s.compareAndSet(subscriptionHelper, this));
        countDown();
    }

    public void onComplete() {
        SubscriptionHelper subscriptionHelper;
        if (this.value == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscriptionHelper = (Subscription) this.s.get();
            if (subscriptionHelper == this || subscriptionHelper == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!this.s.compareAndSet(subscriptionHelper, this));
        countDown();
    }
}
