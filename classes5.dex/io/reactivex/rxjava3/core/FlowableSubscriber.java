package io.reactivex.rxjava3.core;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public interface FlowableSubscriber<T> extends Subscriber<T> {
    void onSubscribe(Subscription subscription);
}
