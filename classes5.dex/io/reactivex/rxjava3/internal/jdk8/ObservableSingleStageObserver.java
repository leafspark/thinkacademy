package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableSingleStageObserver<T> extends ObservableStageObserver<T> {
    final T defaultItem;
    final boolean hasDefault;

    public ObservableSingleStageObserver(boolean z, T t) {
        this.hasDefault = z;
        this.defaultItem = t;
    }

    public void onNext(T t) {
        if (this.value != null) {
            this.value = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.value = t;
    }

    public void onComplete() {
        if (!isDone()) {
            Object obj = this.value;
            clear();
            if (obj != null) {
                complete(obj);
            } else if (this.hasDefault) {
                complete(this.defaultItem);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }
}
