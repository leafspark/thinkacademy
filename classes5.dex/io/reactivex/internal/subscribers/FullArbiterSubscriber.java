package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.FullArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

public final class FullArbiterSubscriber<T> implements FlowableSubscriber<T> {
    final FullArbiter<T> arbiter;
    Subscription s;

    public FullArbiterSubscriber(FullArbiter<T> fullArbiter) {
        this.arbiter = fullArbiter;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.s, subscription)) {
            this.s = subscription;
            this.arbiter.setSubscription(subscription);
        }
    }

    public void onNext(T t) {
        this.arbiter.onNext(t, this.s);
    }

    public void onError(Throwable th) {
        this.arbiter.onError(th, this.s);
    }

    public void onComplete() {
        this.arbiter.onComplete(this.s);
    }
}
