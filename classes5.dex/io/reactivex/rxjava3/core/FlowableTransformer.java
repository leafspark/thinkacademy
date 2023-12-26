package io.reactivex.rxjava3.core;

import org.reactivestreams.Publisher;

@FunctionalInterface
public interface FlowableTransformer<Upstream, Downstream> {
    Publisher<Downstream> apply(Flowable<Upstream> flowable);
}
