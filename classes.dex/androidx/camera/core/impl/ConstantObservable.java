package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class ConstantObservable<T> implements Observable<T> {
    private static final ConstantObservable<Object> NULL_OBSERVABLE = new ConstantObservable<>((Object) null);
    private static final String TAG = "ConstantObservable";
    private final ListenableFuture<T> mValueFuture;

    public void removeObserver(Observable.Observer<? super T> observer) {
    }

    public static <U> Observable<U> withValue(U u) {
        if (u == null) {
            return NULL_OBSERVABLE;
        }
        return new ConstantObservable(u);
    }

    private ConstantObservable(T t) {
        this.mValueFuture = Futures.immediateFuture(t);
    }

    public ListenableFuture<T> fetchData() {
        return this.mValueFuture;
    }

    public void addObserver(Executor executor, Observable.Observer<? super T> observer) {
        this.mValueFuture.addListener(new ConstantObservable$$ExternalSyntheticLambda0(this, observer), executor);
    }

    public /* synthetic */ void lambda$addObserver$0$ConstantObservable(Observable.Observer observer) {
        try {
            observer.onNewData(this.mValueFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            observer.onError(e);
        }
    }
}
