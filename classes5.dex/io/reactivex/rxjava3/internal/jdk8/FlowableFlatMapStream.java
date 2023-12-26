package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMapStream<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    public FlowableFlatMapStream(Flowable<T> flowable, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        this.source = flowable;
        this.mapper = function;
        this.prefetch = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.stream.Stream} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> r4) {
        /*
            r3 = this;
            io.reactivex.rxjava3.core.Flowable<T> r0 = r3.source
            boolean r1 = r0 instanceof io.reactivex.rxjava3.functions.Supplier
            if (r1 == 0) goto L_0x002f
            r1 = 0
            io.reactivex.rxjava3.functions.Supplier r0 = (io.reactivex.rxjava3.functions.Supplier) r0     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x001d
            io.reactivex.rxjava3.functions.Function<? super T, ? extends java.util.stream.Stream<? extends R>> r1 = r3.mapper     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r1.apply(r0)     // Catch:{ all -> 0x0027 }
            java.lang.String r1 = "The mapper returned a null Stream"
            java.util.Objects.requireNonNull(r0, r1)     // Catch:{ all -> 0x0027 }
            r1 = r0
            java.util.stream.Stream r1 = (java.util.stream.Stream) r1     // Catch:{ all -> 0x0027 }
        L_0x001d:
            if (r1 == 0) goto L_0x0023
            io.reactivex.rxjava3.internal.jdk8.FlowableFromStream.subscribeStream(r4, r1)
            goto L_0x003a
        L_0x0023:
            io.reactivex.rxjava3.internal.subscriptions.EmptySubscription.complete(r4)
            goto L_0x003a
        L_0x0027:
            r0 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
            io.reactivex.rxjava3.internal.subscriptions.EmptySubscription.error(r0, r4)
            return
        L_0x002f:
            io.reactivex.rxjava3.functions.Function<? super T, ? extends java.util.stream.Stream<? extends R>> r1 = r3.mapper
            int r2 = r3.prefetch
            org.reactivestreams.Subscriber r4 = subscribe(r4, r1, r2)
            r0.subscribe(r4)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.FlowableFlatMapStream.subscribeActual(org.reactivestreams.Subscriber):void");
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        return new FlatMapStreamSubscriber(subscriber, function, i);
    }

    static final class FlatMapStreamSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean cancelled;
        int consumed;
        AutoCloseable currentCloseable;
        Iterator<? extends R> currentIterator;
        final Subscriber<? super R> downstream;
        long emitted;
        final AtomicThrowable error = new AtomicThrowable();
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        int sourceMode;
        Subscription upstream;
        volatile boolean upstreamDone;

        FlatMapStreamSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i) {
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.upstreamDone = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.downstream.onSubscribe(this);
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void onNext(T t) {
            if (this.sourceMode == 2 || this.queue.offer(t)) {
                drain();
                return;
            }
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        public void onError(Throwable th) {
            if (this.error.compareAndSet((Object) null, th)) {
                this.upstreamDone = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.upstreamDone = true;
            drain();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            drain();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00eb A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r17 = this;
                r1 = r17
                int r0 = r17.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super R> r2 = r1.downstream
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r3 = r1.queue
                io.reactivex.rxjava3.internal.util.AtomicThrowable r4 = r1.error
                java.util.Iterator<? extends R> r0 = r1.currentIterator
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                long r5 = r5.get()
                long r7 = r1.emitted
                int r9 = r1.prefetch
                int r10 = r9 >> 2
                int r9 = r9 - r10
                int r10 = r1.sourceMode
                r11 = 0
                r12 = 1
                if (r10 == r12) goto L_0x0026
                r10 = r12
                goto L_0x0027
            L_0x0026:
                r10 = r11
            L_0x0027:
                r13 = r7
                r8 = r12
                r6 = r5
                r5 = r0
            L_0x002b:
                boolean r0 = r1.cancelled
                if (r0 == 0) goto L_0x0037
                r3.clear()
                r17.clearCurrentSuppressCloseError()
                goto L_0x00e2
            L_0x0037:
                boolean r0 = r1.upstreamDone
                java.lang.Object r15 = r4.get()
                if (r15 == 0) goto L_0x004c
                java.lang.Object r0 = r4.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r2.onError(r0)
                r1.cancelled = r12
                goto L_0x00de
            L_0x004c:
                if (r5 != 0) goto L_0x00a5
                java.lang.Object r15 = r3.poll()     // Catch:{ all -> 0x009c }
                if (r15 != 0) goto L_0x0057
                r16 = r12
                goto L_0x0059
            L_0x0057:
                r16 = r11
            L_0x0059:
                if (r0 == 0) goto L_0x0063
                if (r16 == 0) goto L_0x0063
                r2.onComplete()
                r1.cancelled = r12
                goto L_0x00a5
            L_0x0063:
                if (r16 != 0) goto L_0x00a5
                if (r10 == 0) goto L_0x0076
                int r0 = r1.consumed
                int r0 = r0 + r12
                r1.consumed = r0
                if (r0 != r9) goto L_0x0076
                r1.consumed = r11
                org.reactivestreams.Subscription r0 = r1.upstream
                long r11 = (long) r9
                r0.request(r11)
            L_0x0076:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends java.util.stream.Stream<? extends R>> r0 = r1.mapper     // Catch:{ all -> 0x0094 }
                java.lang.Object r0 = r0.apply(r15)     // Catch:{ all -> 0x0094 }
                java.lang.String r11 = "The mapper returned a null Stream"
                java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x0094 }
                java.util.stream.Stream r0 = (java.util.stream.Stream) r0     // Catch:{ all -> 0x0094 }
                java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0094 }
                boolean r11 = r5.hasNext()     // Catch:{ all -> 0x0094 }
                if (r11 == 0) goto L_0x0092
                r1.currentIterator = r5     // Catch:{ all -> 0x0094 }
                r1.currentCloseable = r0     // Catch:{ all -> 0x0094 }
                goto L_0x00de
            L_0x0092:
                r5 = 0
                goto L_0x00de
            L_0x0094:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.trySignalError(r2, r0)
                goto L_0x00de
            L_0x009c:
                r0 = move-exception
                r11 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r11)
                r1.trySignalError(r2, r11)
                goto L_0x00de
            L_0x00a5:
                if (r5 == 0) goto L_0x00e2
                int r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x00e2
                java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x00d7 }
                java.lang.String r11 = "The Stream.Iterator returned a null value"
                java.util.Objects.requireNonNull(r0, r11)     // Catch:{ all -> 0x00d7 }
                boolean r11 = r1.cancelled
                if (r11 != 0) goto L_0x00de
                r2.onNext(r0)
                r11 = 1
                long r13 = r13 + r11
                boolean r0 = r1.cancelled
                if (r0 != 0) goto L_0x00de
                boolean r0 = r5.hasNext()     // Catch:{ all -> 0x00cf }
                if (r0 != 0) goto L_0x00de
                r17.clearCurrentRethrowCloseError()     // Catch:{ all -> 0x00cc }
                goto L_0x0092
            L_0x00cc:
                r0 = move-exception
                r5 = 0
                goto L_0x00d0
            L_0x00cf:
                r0 = move-exception
            L_0x00d0:
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.trySignalError(r2, r0)
                goto L_0x00de
            L_0x00d7:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r1.trySignalError(r2, r0)
            L_0x00de:
                r11 = 0
                r12 = 1
                goto L_0x002b
            L_0x00e2:
                r1.emitted = r13
                int r0 = -r8
                int r8 = r1.addAndGet(r0)
                if (r8 != 0) goto L_0x00ec
                return
            L_0x00ec:
                java.util.concurrent.atomic.AtomicLong r0 = r1.requested
                long r6 = r0.get()
                goto L_0x00de
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.FlowableFlatMapStream.FlatMapStreamSubscriber.drain():void");
        }

        /* access modifiers changed from: package-private */
        public void clearCurrentRethrowCloseError() throws Throwable {
            this.currentIterator = null;
            AutoCloseable autoCloseable = this.currentCloseable;
            this.currentCloseable = null;
            if (autoCloseable != null) {
                autoCloseable.close();
            }
        }

        /* access modifiers changed from: package-private */
        public void clearCurrentSuppressCloseError() {
            try {
                clearCurrentRethrowCloseError();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void trySignalError(Subscriber<?> subscriber, Throwable th) {
            if (this.error.compareAndSet((Object) null, th)) {
                this.upstream.cancel();
                this.cancelled = true;
                subscriber.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }
}
