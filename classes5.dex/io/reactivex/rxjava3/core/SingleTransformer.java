package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface SingleTransformer<Upstream, Downstream> {
    SingleSource<Downstream> apply(Single<Upstream> single);
}
