package io.reactivex.rxjava3.internal.fuseable;

import org.reactivestreams.Publisher;

public interface HasUpstreamPublisher<T> {
    Publisher<T> source();
}
