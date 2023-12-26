package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

abstract class FlowableStageSubscriber<T> extends CompletableFuture<T> implements FlowableSubscriber<T> {
    final AtomicReference<Subscription> upstream = new AtomicReference<>();
    T value;

    /* access modifiers changed from: protected */
    public abstract void afterSubscribe(Subscription subscription);

    FlowableStageSubscriber() {
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            afterSubscribe(subscription);
        }
    }

    public final void onError(Throwable th) {
        clear();
        if (!completeExceptionally(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    /* access modifiers changed from: protected */
    public final void cancelUpstream() {
        SubscriptionHelper.cancel(this.upstream);
    }

    /* access modifiers changed from: protected */
    public final void clear() {
        this.value = null;
        this.upstream.lazySet(SubscriptionHelper.CANCELLED);
    }

    public final boolean cancel(boolean z) {
        cancelUpstream();
        return super.cancel(z);
    }

    public final boolean complete(T t) {
        cancelUpstream();
        return super.complete(t);
    }

    public final boolean completeExceptionally(Throwable th) {
        cancelUpstream();
        return super.completeExceptionally(th);
    }
}
