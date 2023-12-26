package io.reactivex.rxjava3.processors;

import io.ktor.client.plugins.HttpTimeout;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final AtomicReference<Subscriber<? super T>> downstream = new AtomicReference<>();
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once = new AtomicBoolean();
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested = new AtomicLong();
    final BasicIntQueueSubscription<T> wip = new UnicastQueueSubscription();

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(bufferSize(), (Runnable) null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new UnicastProcessor<>(i, (Runnable) null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(boolean z) {
        return new UnicastProcessor<>(bufferSize(), (Runnable) null, z);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i, Runnable runnable) {
        return create(i, runnable, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i, Runnable runnable, boolean z) {
        Objects.requireNonNull(runnable, "onTerminate");
        ObjectHelper.verifyPositive(i, "capacityHint");
        return new UnicastProcessor<>(i, runnable, z);
    }

    UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.queue = new SpscLinkedArrayQueue<>(i);
        this.onTerminate = new AtomicReference<>(runnable);
        this.delayError = z;
    }

    /* access modifiers changed from: package-private */
    public void doTerminate() {
        Runnable andSet = this.onTerminate.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void drainRegular(Subscriber<? super T> subscriber) {
        int i;
        long j;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean z = true;
        boolean z2 = !this.delayError;
        int i2 = 1;
        while (true) {
            long j2 = this.requested.get();
            long j3 = 0;
            while (true) {
                i = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i == 0) {
                    j = j3;
                    break;
                }
                boolean z3 = this.done;
                T poll = spscLinkedArrayQueue.poll();
                boolean z4 = poll == null ? z : false;
                T t = poll;
                j = j3;
                if (!checkTerminated(z2, z3, z4, subscriber, spscLinkedArrayQueue)) {
                    if (z4) {
                        break;
                    }
                    subscriber.onNext(t);
                    j3 = 1 + j;
                    z = true;
                } else {
                    return;
                }
            }
            Subscriber<? super T> subscriber2 = subscriber;
            if (i == 0) {
                if (checkTerminated(z2, this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
            }
            if (!(j == 0 || j2 == HttpTimeout.INFINITE_TIMEOUT_MS)) {
                this.requested.addAndGet(-j);
            }
            i2 = this.wip.addAndGet(-i2);
            if (i2 != 0) {
                z = true;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void drainFused(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int i = 1;
        boolean z = !this.delayError;
        while (!this.cancelled) {
            boolean z2 = this.done;
            if (!z || !z2 || this.error == null) {
                subscriber.onNext((Object) null);
                if (z2) {
                    this.downstream.lazySet((Object) null);
                    Throwable th = this.error;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else {
                    i = this.wip.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            } else {
                spscLinkedArrayQueue.clear();
                this.downstream.lazySet((Object) null);
                subscriber.onError(this.error);
                return;
            }
        }
        this.downstream.lazySet((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            int i = 1;
            Subscriber subscriber = (Subscriber) this.downstream.get();
            while (subscriber == null) {
                i = this.wip.addAndGet(-i);
                if (i != 0) {
                    subscriber = (Subscriber) this.downstream.get();
                } else {
                    return;
                }
            }
            if (this.enableOperatorFusion) {
                drainFused(subscriber);
            } else {
                drainRegular(subscriber);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkTerminated(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.cancelled) {
            spscLinkedArrayQueue.clear();
            this.downstream.lazySet((Object) null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.error != null) {
                spscLinkedArrayQueue.clear();
                this.downstream.lazySet((Object) null);
                subscriber.onError(this.error);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th = this.error;
                this.downstream.lazySet((Object) null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.done || this.cancelled) {
            subscription.cancel();
        } else {
            subscription.request(HttpTimeout.INFINITE_TIMEOUT_MS);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (!this.done && !this.cancelled) {
            this.queue.offer(t);
            drain();
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (this.done || this.cancelled) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.error = th;
        this.done = true;
        doTerminate();
        drain();
    }

    public void onComplete() {
        if (!this.done && !this.cancelled) {
            this.done = true;
            doTerminate();
            drain();
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.wip);
        this.downstream.set(subscriber);
        if (this.cancelled) {
            this.downstream.lazySet((Object) null);
        } else {
            drain();
        }
    }

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.enableOperatorFusion = true;
            return 2;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(UnicastProcessor.this.requested, j);
                UnicastProcessor.this.drain();
            }
        }

        public void cancel() {
            if (!UnicastProcessor.this.cancelled) {
                UnicastProcessor.this.cancelled = true;
                UnicastProcessor.this.doTerminate();
                UnicastProcessor.this.downstream.lazySet((Object) null);
                if (UnicastProcessor.this.wip.getAndIncrement() == 0) {
                    UnicastProcessor.this.downstream.lazySet((Object) null);
                    if (!UnicastProcessor.this.enableOperatorFusion) {
                        UnicastProcessor.this.queue.clear();
                    }
                }
            }
        }
    }

    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.downstream.get() != null;
    }

    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.done) {
            return this.error;
        }
        return null;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return this.done && this.error == null;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return this.done && this.error != null;
    }
}
