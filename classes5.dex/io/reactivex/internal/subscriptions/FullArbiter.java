package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FullArbiter<T> extends FullArbiterPad2 implements Subscription {
    static final Subscription INITIAL = new InitialSubscription();
    static final Object REQUEST = new Object();
    final Subscriber<? super T> actual;
    volatile boolean cancelled;
    final SpscLinkedArrayQueue<Object> queue;
    long requested;
    Disposable resource;
    volatile Subscription s = INITIAL;

    public FullArbiter(Subscriber<? super T> subscriber, Disposable disposable, int i) {
        this.actual = subscriber;
        this.resource = disposable;
        this.queue = new SpscLinkedArrayQueue<>(i);
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.missedRequested, j);
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Object obj = REQUEST;
            spscLinkedArrayQueue.offer(obj, obj);
            drain();
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            dispose();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispose() {
        Disposable disposable = this.resource;
        this.resource = null;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public boolean setSubscription(Subscription subscription) {
        if (!this.cancelled) {
            ObjectHelper.requireNonNull(subscription, "s is null");
            this.queue.offer(this.s, NotificationLite.subscription(subscription));
            drain();
            return true;
        } else if (subscription == null) {
            return false;
        } else {
            subscription.cancel();
            return false;
        }
    }

    public boolean onNext(T t, Subscription subscription) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(subscription, NotificationLite.next(t));
        drain();
        return true;
    }

    public void onError(Throwable th, Subscription subscription) {
        if (this.cancelled) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.queue.offer(subscription, NotificationLite.error(th));
        drain();
    }

    public void onComplete(Subscription subscription) {
        this.queue.offer(subscription, NotificationLite.complete());
        drain();
    }

    /* access modifiers changed from: package-private */
    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Subscriber<? super T> subscriber = this.actual;
            int i = 1;
            while (true) {
                Object poll = spscLinkedArrayQueue.poll();
                if (poll == null) {
                    i = this.wip.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    Object poll2 = spscLinkedArrayQueue.poll();
                    if (poll == REQUEST) {
                        long andSet = this.missedRequested.getAndSet(0);
                        if (andSet != 0) {
                            this.requested = BackpressureHelper.addCap(this.requested, andSet);
                            this.s.request(andSet);
                        }
                    } else if (poll == this.s) {
                        if (NotificationLite.isSubscription(poll2)) {
                            Subscription subscription = NotificationLite.getSubscription(poll2);
                            if (!this.cancelled) {
                                this.s = subscription;
                                long j = this.requested;
                                if (j != 0) {
                                    subscription.request(j);
                                }
                            } else {
                                subscription.cancel();
                            }
                        } else if (NotificationLite.isError(poll2)) {
                            spscLinkedArrayQueue.clear();
                            dispose();
                            Throwable error = NotificationLite.getError(poll2);
                            if (!this.cancelled) {
                                this.cancelled = true;
                                subscriber.onError(error);
                            } else {
                                RxJavaPlugins.onError(error);
                            }
                        } else if (NotificationLite.isComplete(poll2)) {
                            spscLinkedArrayQueue.clear();
                            dispose();
                            if (!this.cancelled) {
                                this.cancelled = true;
                                subscriber.onComplete();
                            }
                        } else {
                            long j2 = this.requested;
                            if (j2 != 0) {
                                subscriber.onNext(NotificationLite.getValue(poll2));
                                this.requested = j2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    static final class InitialSubscription implements Subscription {
        public void cancel() {
        }

        public void request(long j) {
        }

        InitialSubscription() {
        }
    }
}
