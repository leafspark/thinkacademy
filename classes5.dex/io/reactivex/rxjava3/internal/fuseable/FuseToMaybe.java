package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.core.Maybe;

public interface FuseToMaybe<T> {
    Maybe<T> fuseToMaybe();
}
