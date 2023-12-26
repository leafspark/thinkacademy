package io.reactivex.rxjava3.observables;

import io.reactivex.rxjava3.core.Observable;

public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    protected GroupedObservable(K k) {
        this.key = k;
    }

    public K getKey() {
        return this.key;
    }
}
