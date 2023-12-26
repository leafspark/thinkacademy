package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.core.ObservableSource;

public interface HasUpstreamObservableSource<T> {
    ObservableSource<T> source();
}
