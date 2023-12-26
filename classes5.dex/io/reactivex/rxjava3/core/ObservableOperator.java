package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface ObservableOperator<Downstream, Upstream> {
    Observer<? super Upstream> apply(Observer<? super Downstream> observer) throws Throwable;
}
