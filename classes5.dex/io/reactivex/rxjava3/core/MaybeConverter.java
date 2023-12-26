package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface MaybeConverter<T, R> {
    R apply(Maybe<T> maybe);
}
