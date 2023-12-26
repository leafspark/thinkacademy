package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableFirstStageSubscriber<T> extends FlowableStageSubscriber<T> {
    final T defaultItem;
    final boolean hasDefault;

    public FlowableFirstStageSubscriber(boolean z, T t) {
        this.hasDefault = z;
        this.defaultItem = t;
    }

    public void onNext(T t) {
        complete(t);
    }

    public void onComplete() {
        if (!isDone()) {
            clear();
            if (this.hasDefault) {
                complete(this.defaultItem);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void afterSubscribe(Subscription subscription) {
        subscription.request(1);
    }
}
