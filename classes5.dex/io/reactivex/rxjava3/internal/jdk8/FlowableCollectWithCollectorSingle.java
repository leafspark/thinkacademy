package io.reactivex.rxjava3.internal.jdk8;

import io.ktor.client.plugins.HttpTimeout;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import org.reactivestreams.Subscription;

public final class FlowableCollectWithCollectorSingle<T, A, R> extends Single<R> implements FuseToFlowable<R> {
    final Collector<? super T, A, R> collector;
    final Flowable<T> source;

    public FlowableCollectWithCollectorSingle(Flowable<T> flowable, Collector<? super T, A, R> collector2) {
        this.source = flowable;
        this.collector = collector2;
    }

    public Flowable<R> fuseToFlowable() {
        return new FlowableCollectWithCollector(this.source, this.collector);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.source.subscribe(new CollectorSingleObserver(singleObserver, this.collector.supplier().get(), this.collector.accumulator(), this.collector.finisher()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }

    static final class CollectorSingleObserver<T, A, R> implements FlowableSubscriber<T>, Disposable {
        final BiConsumer<A, T> accumulator;
        A container;
        boolean done;
        final SingleObserver<? super R> downstream;
        final Function<A, R> finisher;
        Subscription upstream;

        CollectorSingleObserver(SingleObserver<? super R> singleObserver, A a, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            this.downstream = singleObserver;
            this.container = a;
            this.accumulator = biConsumer;
            this.finisher = function;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(HttpTimeout.INFINITE_TIMEOUT_MS);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.accumulator.accept(this.container, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.container = null;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.upstream = SubscriptionHelper.CANCELLED;
                A a = this.container;
                this.container = null;
                try {
                    R apply = this.finisher.apply(a);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    this.downstream.onSuccess(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                }
            }
        }

        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }
    }
}
