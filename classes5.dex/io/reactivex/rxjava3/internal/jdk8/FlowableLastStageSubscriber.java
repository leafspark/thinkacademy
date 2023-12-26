package io.reactivex.rxjava3.internal.jdk8;

import io.ktor.client.plugins.HttpTimeout;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableLastStageSubscriber<T> extends FlowableStageSubscriber<T> {
    final T defaultItem;
    final boolean hasDefault;

    public FlowableLastStageSubscriber(boolean z, T t) {
        this.hasDefault = z;
        this.defaultItem = t;
    }

    public void onNext(T t) {
        this.value = t;
    }

    public void onComplete() {
        if (!isDone()) {
            Object obj = this.value;
            clear();
            if (obj != null) {
                complete(obj);
            } else if (this.hasDefault) {
                complete(this.defaultItem);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void afterSubscribe(Subscription subscription) {
        subscription.request(HttpTimeout.INFINITE_TIMEOUT_MS);
    }
}
