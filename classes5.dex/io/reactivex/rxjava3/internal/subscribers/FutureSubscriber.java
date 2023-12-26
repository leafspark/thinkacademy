package io.reactivex.rxjava3.internal.subscribers;

import io.ktor.client.plugins.HttpTimeout;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
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
    final AtomicReference<Subscription> upstream = new AtomicReference<>();
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
            subscriptionHelper = (Subscription) this.upstream.get();
            if (subscriptionHelper == this || subscriptionHelper == SubscriptionHelper.CANCELLED) {
                return false;
            }
        } while (!this.upstream.compareAndSet(subscriptionHelper, SubscriptionHelper.CANCELLED));
        if (subscriptionHelper != null) {
            subscriptionHelper.cancel();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
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
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit));
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
        SubscriptionHelper.setOnce(this.upstream, subscription, HttpTimeout.INFINITE_TIMEOUT_MS);
    }

    public void onNext(T t) {
        if (this.value != null) {
            this.upstream.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.value = t;
    }

    public void onError(Throwable th) {
        SubscriptionHelper subscriptionHelper;
        if (this.error != null || (subscriptionHelper = (Subscription) this.upstream.get()) == this || subscriptionHelper == SubscriptionHelper.CANCELLED || !this.upstream.compareAndSet(subscriptionHelper, this)) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.error = th;
        countDown();
    }

    public void onComplete() {
        if (this.value == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        SubscriptionHelper subscriptionHelper = (Subscription) this.upstream.get();
        if (subscriptionHelper != this && subscriptionHelper != SubscriptionHelper.CANCELLED && this.upstream.compareAndSet(subscriptionHelper, this)) {
            countDown();
        }
    }
}
