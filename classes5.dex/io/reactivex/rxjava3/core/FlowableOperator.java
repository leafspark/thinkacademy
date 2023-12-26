package io.reactivex.rxjava3.core;

import org.reactivestreams.Subscriber;

@FunctionalInterface
public interface FlowableOperator<Downstream, Upstream> {
    Subscriber<? super Upstream> apply(Subscriber<? super Downstream> subscriber) throws Throwable;
}
