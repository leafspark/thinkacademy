package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.GroupedFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> mapFactory;
    final Function<? super T, ? extends V> valueSelector;

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i;
        this.delayError = z;
        this.mapFactory = function3;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map map;
        try {
            if (this.mapFactory == null) {
                concurrentLinkedQueue = null;
                map = new ConcurrentHashMap();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                map = (Map) this.mapFactory.apply(new EvictionAction(concurrentLinkedQueue));
            }
            this.source.subscribe(new GroupBySubscriber(subscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, map, concurrentLinkedQueue));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(th);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        boolean done;
        final Subscriber<? super GroupedFlowable<K, V>> downstream;
        long emittedGroups;
        final Queue<GroupedUnicast<K, V>> evictedGroups;
        final AtomicLong groupConsumed = new AtomicLong();
        final AtomicInteger groupCount = new AtomicInteger(1);
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        final int limit;
        Subscription upstream;
        final Function<? super T, ? extends V> valueSelector;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Map<Object, GroupedUnicast<K, V>> map, Queue<GroupedUnicast<K, V>> queue) {
            this.downstream = subscriber;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.limit = i - (i >> 2);
            this.delayError = z;
            this.groups = map;
            this.evictedGroups = queue;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request((long) this.bufferSize);
            }
        }

        public void onNext(T t) {
            Object obj;
            if (!this.done) {
                try {
                    Object apply = this.keySelector.apply(t);
                    boolean z = false;
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = NULL_KEY;
                    }
                    GroupedUnicast groupedUnicast = this.groups.get(obj);
                    if (groupedUnicast == null) {
                        if (!this.cancelled.get()) {
                            groupedUnicast = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                            this.groups.put(obj, groupedUnicast);
                            this.groupCount.getAndIncrement();
                            z = true;
                        } else {
                            return;
                        }
                    }
                    try {
                        groupedUnicast.onNext(ExceptionHelper.nullCheck(this.valueSelector.apply(t), "The valueSelector returned a null value."));
                        completeEvictions();
                        if (!z) {
                            return;
                        }
                        if (this.emittedGroups != get()) {
                            this.emittedGroups++;
                            this.downstream.onNext(groupedUnicast);
                            if (groupedUnicast.state.tryAbandon()) {
                                cancel(apply);
                                groupedUnicast.onComplete();
                                requestGroup(1);
                                return;
                            }
                            return;
                        }
                        this.upstream.cancel();
                        onError(new MissingBackpressureException(groupHangWarning(this.emittedGroups)));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.upstream.cancel();
                        if (z) {
                            if (this.emittedGroups != get()) {
                                this.downstream.onNext(groupedUnicast);
                            } else {
                                MissingBackpressureException missingBackpressureException = new MissingBackpressureException(groupHangWarning(this.emittedGroups));
                                missingBackpressureException.initCause(th);
                                onError(missingBackpressureException);
                                return;
                            }
                        }
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            }
        }

        static String groupHangWarning(long j) {
            return "Unable to emit a new group (#" + j + ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.";
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            for (GroupedUnicast<K, V> onError : this.groups.values()) {
                onError.onError(th);
            }
            this.groups.clear();
            completeEvictions();
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                for (GroupedUnicast<K, V> onComplete : this.groups.values()) {
                    onComplete.onComplete();
                }
                this.groups.clear();
                completeEvictions();
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                completeEvictions();
                if (this.groupCount.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        private void completeEvictions() {
            if (this.evictedGroups != null) {
                int i = 0;
                while (true) {
                    GroupedUnicast poll = this.evictedGroups.poll();
                    if (poll == null) {
                        break;
                    } else if (poll.state.tryComplete()) {
                        i++;
                    }
                }
                if (i != 0) {
                    this.groupCount.addAndGet(-i);
                }
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = NULL_KEY;
            }
            if (this.groups.remove(k) != null && this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void requestGroup(long j) {
            long j2;
            long addCap;
            AtomicLong atomicLong = this.groupConsumed;
            int i = this.limit;
            do {
                j2 = atomicLong.get();
                addCap = BackpressureHelper.addCap(j2, j);
            } while (!atomicLong.compareAndSet(j2, addCap));
            while (true) {
                long j3 = (long) i;
                if (addCap >= j3) {
                    if (atomicLong.compareAndSet(addCap, addCap - j3)) {
                        this.upstream.request(j3);
                    }
                    addCap = atomicLong.get();
                } else {
                    return;
                }
            }
        }
    }

    static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {
        final Queue<GroupedUnicast<K, V>> evictedGroups;

        EvictionAction(Queue<GroupedUnicast<K, V>> queue) {
            this.evictedGroups = queue;
        }

        public void accept(GroupedUnicast<K, V> groupedUnicast) {
            this.evictedGroups.offer(groupedUnicast);
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new GroupedUnicast<>(k, new State(i, groupBySubscriber, k, z));
        }

        protected GroupedUnicast(K k, State<T, K> state2) {
            super(k);
            this.state = state2;
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.state.subscribe(subscriber);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void onError(Throwable th) {
            this.state.onError(th);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        static final int ABANDONED = 2;
        static final int ABANDONED_HAS_SUBSCRIBER = 3;
        static final int FRESH = 0;
        static final int HAS_SUBSCRIBER = 1;
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final AtomicBoolean evictOnce = new AtomicBoolean();
        final K key;
        final AtomicInteger once = new AtomicInteger();
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();

        public int requestFusion(int i) {
            return 0;
        }

        State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                cancelParent();
                drain();
            }
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            int i;
            do {
                i = this.once.get();
                if ((i & 1) != 0) {
                    EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                    return;
                }
            } while (!this.once.compareAndSet(i, i | 1));
            subscriber.onSubscribe(this);
            this.actual.lazySet(subscriber);
            if (this.cancelled.get()) {
                this.actual.lazySet((Object) null);
            } else {
                drain();
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public boolean tryComplete() {
            boolean compareAndSet = this.evictOnce.compareAndSet(false, true);
            this.done = true;
            drain();
            return compareAndSet;
        }

        /* access modifiers changed from: package-private */
        public void cancelParent() {
            if ((this.once.get() & 2) == 0 && this.evictOnce.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean tryAbandon() {
            return this.once.get() == 0 && this.once.compareAndSet(0, 2);
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void drainFused() {
            Throwable th;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            Subscriber subscriber = (Subscriber) this.actual.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    if (!this.cancelled.get()) {
                        boolean z = this.done;
                        if (!z || this.delayError || (th = this.error) == null) {
                            subscriber.onNext((Object) null);
                            if (z) {
                                Throwable th2 = this.error;
                                if (th2 != null) {
                                    subscriber.onError(th2);
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                        } else {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                i = addAndGet(-i);
                if (i != 0) {
                    if (subscriber == null) {
                        subscriber = (Subscriber) this.actual.get();
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
            if (r18 != 0) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
            r21 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
            if (checkTerminated(r8.done, r9.isEmpty(), r13, r10, r5, false) == false) goto L_0x007c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
            r3 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
            r3 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
            if (r3 == r23) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
            io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r8.requested, r3);
            requestParent(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0012, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drainNormal() {
            /*
                r25 = this;
                r8 = r25
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<T> r9 = r8.queue
                boolean r10 = r8.delayError
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> r0 = r8.actual
                java.lang.Object r0 = r0.get()
                org.reactivestreams.Subscriber r0 = (org.reactivestreams.Subscriber) r0
                java.util.concurrent.atomic.AtomicBoolean r11 = r8.cancelled
                r13 = r0
                r14 = 1
            L_0x0012:
                boolean r0 = r11.get()
                r15 = 0
                r5 = 0
                if (r0 == 0) goto L_0x0020
                r8.cleanupQueue(r5, r15)
                goto L_0x008c
            L_0x0020:
                if (r13 == 0) goto L_0x008c
                java.util.concurrent.atomic.AtomicLong r0 = r8.requested
                long r16 = r0.get()
                r3 = r5
            L_0x0029:
                int r18 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
                if (r18 == 0) goto L_0x0063
                boolean r1 = r8.done
                java.lang.Object r7 = r9.poll()
                if (r7 != 0) goto L_0x0038
                r19 = 1
                goto L_0x003a
            L_0x0038:
                r19 = r15
            L_0x003a:
                r20 = r19 ^ 1
                r0 = r25
                r2 = r19
                r21 = r3
                r3 = r13
                r4 = r10
                r23 = r5
                r5 = r21
                r12 = r7
                r7 = r20
                boolean r0 = r0.checkTerminated(r1, r2, r3, r4, r5, r7)
                if (r0 == 0) goto L_0x0052
                goto L_0x0012
            L_0x0052:
                if (r19 == 0) goto L_0x0057
                r5 = r21
                goto L_0x0066
            L_0x0057:
                r13.onNext(r12)
                r0 = 1
                r5 = r21
                long r3 = r5 + r0
                r5 = r23
                goto L_0x0029
            L_0x0063:
                r23 = r5
                r5 = r3
            L_0x0066:
                if (r18 != 0) goto L_0x007f
                boolean r1 = r8.done
                boolean r2 = r9.isEmpty()
                r7 = 0
                r0 = r25
                r3 = r13
                r4 = r10
                r21 = r5
                boolean r0 = r0.checkTerminated(r1, r2, r3, r4, r5, r7)
                if (r0 == 0) goto L_0x007c
                goto L_0x0012
            L_0x007c:
                r3 = r21
                goto L_0x0080
            L_0x007f:
                r3 = r5
            L_0x0080:
                int r0 = (r3 > r23 ? 1 : (r3 == r23 ? 0 : -1))
                if (r0 == 0) goto L_0x008c
                java.util.concurrent.atomic.AtomicLong r0 = r8.requested
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r0, r3)
                r8.requestParent(r3)
            L_0x008c:
                int r0 = -r14
                int r14 = r8.addAndGet(r0)
                if (r14 != 0) goto L_0x0094
                return
            L_0x0094:
                if (r13 != 0) goto L_0x0012
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscriber<? super T>> r0 = r8.actual
                java.lang.Object r0 = r0.get()
                r13 = r0
                org.reactivestreams.Subscriber r13 = (org.reactivestreams.Subscriber) r13
                goto L_0x0012
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy.State.drainNormal():void");
        }

        /* access modifiers changed from: package-private */
        public void requestParent(long j) {
            if ((this.once.get() & 2) == 0) {
                this.parent.requestGroup(j);
            }
        }

        /* access modifiers changed from: package-private */
        public void cleanupQueue(long j, boolean z) {
            while (this.queue.poll() != null) {
                j++;
            }
            replenishParent(j, z);
        }

        /* access modifiers changed from: package-private */
        public void replenishParent(long j, boolean z) {
            if (z) {
                j++;
            }
            if (j != 0) {
                requestParent(j);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3, long j, boolean z4) {
            if (this.cancelled.get()) {
                cleanupQueue(j, z4);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        this.cancelled.lazySet(true);
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.cancelled.lazySet(true);
                        subscriber.onComplete();
                        replenishParent(j, z4);
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    this.cancelled.lazySet(true);
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                        replenishParent(j, z4);
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void tryReplenish() {
            int i = this.produced;
            if (i != 0) {
                this.produced = 0;
                requestParent((long) i);
            }
        }

        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            tryReplenish();
            return null;
        }

        public boolean isEmpty() {
            if (this.queue.isEmpty()) {
                tryReplenish();
                return true;
            }
            tryReplenish();
            return false;
        }

        public void clear() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            while (spscLinkedArrayQueue.poll() != null) {
                this.produced++;
            }
            tryReplenish();
        }
    }
}
