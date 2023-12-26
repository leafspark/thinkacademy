package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import java.util.Objects;
import java.util.Optional;
import org.reactivestreams.Subscriber;

public final class FlowableMapOptional<T, R> extends Flowable<R> {
    final Function<? super T, Optional<? extends R>> mapper;
    final Flowable<T> source;

    public FlowableMapOptional(Flowable<T> flowable, Function<? super T, Optional<? extends R>> function) {
        this.source = flowable;
        this.mapper = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new MapOptionalConditionalSubscriber((ConditionalSubscriber) subscriber, this.mapper));
        } else {
            this.source.subscribe(new MapOptionalSubscriber(subscriber, this.mapper));
        }
    }

    static final class MapOptionalSubscriber<T, R> extends BasicFuseableSubscriber<T, R> implements ConditionalSubscriber<T> {
        final Function<? super T, Optional<? extends R>> mapper;

        MapOptionalSubscriber(Subscriber<? super R> subscriber, Function<? super T, Optional<? extends R>> function) {
            super(subscriber);
            this.mapper = function;
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        public boolean tryOnNext(T t) {
            if (this.done) {
                return true;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext((Object) null);
                return true;
            }
            try {
                Optional<? extends R> apply = this.mapper.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (!optional.isPresent()) {
                    return false;
                }
                this.downstream.onNext(optional.get());
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public R poll() throws Throwable {
            while (true) {
                Object poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.mapper.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (optional.isPresent()) {
                    return optional.get();
                }
                if (this.sourceMode == 2) {
                    this.qs.request(1);
                }
            }
        }
    }

    static final class MapOptionalConditionalSubscriber<T, R> extends BasicFuseableConditionalSubscriber<T, R> {
        final Function<? super T, Optional<? extends R>> mapper;

        MapOptionalConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, Optional<? extends R>> function) {
            super(conditionalSubscriber);
            this.mapper = function;
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        public boolean tryOnNext(T t) {
            if (this.done) {
                return true;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext((Object) null);
                return true;
            }
            try {
                Optional<? extends R> apply = this.mapper.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (optional.isPresent()) {
                    return this.downstream.tryOnNext(optional.get());
                }
                return false;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public R poll() throws Throwable {
            while (true) {
                Object poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.mapper.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (optional.isPresent()) {
                    return optional.get();
                }
                if (this.sourceMode == 2) {
                    this.qs.request(1);
                }
            }
        }
    }
}
