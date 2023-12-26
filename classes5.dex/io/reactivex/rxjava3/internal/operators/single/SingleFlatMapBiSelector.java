package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapBiSelector<T, U, R> extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends U>> mapper;
    final BiFunction<? super T, ? super U, ? extends R> resultSelector;
    final SingleSource<T> source;

    public SingleFlatMapBiSelector(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.source = singleSource;
        this.mapper = function;
        this.resultSelector = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new FlatMapBiMainObserver(singleObserver, this.mapper, this.resultSelector));
    }

    static final class FlatMapBiMainObserver<T, U, R> implements SingleObserver<T>, Disposable {
        final InnerObserver<T, U, R> inner;
        final Function<? super T, ? extends SingleSource<? extends U>> mapper;

        FlatMapBiMainObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.inner = new InnerObserver<>(singleObserver, biFunction);
            this.mapper = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this.inner);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.inner.get());
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.inner, disposable)) {
                this.inner.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                Object apply = this.mapper.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                SingleSource singleSource = (SingleSource) apply;
                if (DisposableHelper.replace(this.inner, (Disposable) null)) {
                    this.inner.value = t;
                    singleSource.subscribe(this.inner);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.inner.downstream.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.inner.downstream.onError(th);
        }

        static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements SingleObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final SingleObserver<? super R> downstream;
            final BiFunction<? super T, ? super U, ? extends R> resultSelector;
            T value;

            InnerObserver(SingleObserver<? super R> singleObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.downstream = singleObserver;
                this.resultSelector = biFunction;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(U u) {
                T t = this.value;
                this.value = null;
                try {
                    Object apply = this.resultSelector.apply(t, u);
                    Objects.requireNonNull(apply, "The resultSelector returned a null value");
                    this.downstream.onSuccess(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                }
            }

            public void onError(Throwable th) {
                this.downstream.onError(th);
            }
        }
    }
}
