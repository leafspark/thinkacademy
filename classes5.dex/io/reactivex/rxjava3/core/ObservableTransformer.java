package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> apply(Observable<Upstream> observable);
}
