package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.core.MaybeSource;

public interface HasUpstreamMaybeSource<T> {
    MaybeSource<T> source();
}
