package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface FlowableConverter<T, R> {
    R apply(Flowable<T> flowable);
}
