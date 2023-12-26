package io.reactivex.rxjava3.internal.operators.observable;

import io.ktor.client.plugins.HttpTimeout;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public ObservableWindowTimed(Observable<T> observable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler2, long j3, int i, boolean z) {
        super(observable);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.maxSize = j3;
        this.bufferSize = i;
        this.restartTimerOnMaxSize = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.timespan != this.timeskip) {
            this.source.subscribe(new WindowSkipObserver(observer, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
        } else if (this.maxSize == HttpTimeout.INFINITE_TIMEOUT_MS) {
            this.source.subscribe(new WindowExactUnboundedObserver(observer, this.timespan, this.unit, this.scheduler, this.bufferSize));
        } else {
            this.source.subscribe(new WindowExactBoundedObserver(observer, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
        }
    }

    static abstract class AbstractWindowObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5724293814035355511L;
        final int bufferSize;
        volatile boolean done;
        final Observer<? super Observable<T>> downstream;
        final AtomicBoolean downstreamCancelled;
        long emitted;
        Throwable error;
        final SimplePlainQueue<Object> queue = new MpscLinkedQueue();
        final long timespan;
        final TimeUnit unit;
        Disposable upstream;
        volatile boolean upstreamCancelled;
        final AtomicInteger windowCount;

        /* access modifiers changed from: package-private */
        public abstract void cleanupResources();

        /* access modifiers changed from: package-private */
        public abstract void createFirstWindow();

        /* access modifiers changed from: package-private */
        public abstract void drain();

        AbstractWindowObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, int i) {
            this.downstream = observer;
            this.timespan = j;
            this.unit = timeUnit;
            this.bufferSize = i;
            this.downstreamCancelled = new AtomicBoolean();
            this.windowCount = new AtomicInteger(1);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                createFirstWindow();
            }
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void dispose() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        public final boolean isDisposed() {
            return this.downstreamCancelled.get();
        }

        /* access modifiers changed from: package-private */
        public final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.dispose();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    static final class WindowExactUnboundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        final Scheduler scheduler;
        final SequentialDisposable timer = new SequentialDisposable();
        UnicastSubject<T> window;
        final Runnable windowRunnable = new WindowRunnable();

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler2, int i) {
            super(observer, j, timeUnit, i);
            this.scheduler = scheduler2;
        }

        /* access modifiers changed from: package-private */
        public void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.windowCount.getAndIncrement();
                this.window = UnicastSubject.create(this.bufferSize, this.windowRunnable);
                this.emitted = 1;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(this.window);
                this.downstream.onNext(observableWindowSubscribeIntercept);
                this.timer.replace(this.scheduler.schedulePeriodicallyDirect(this, this.timespan, this.timespan, this.unit));
                if (observableWindowSubscribeIntercept.tryAbandon()) {
                    this.window.onComplete();
                }
            }
        }

        public void run() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue simplePlainQueue = this.queue;
                Observer observer = this.downstream;
                UnicastSubject<T> unicastSubject = this.window;
                int i = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        simplePlainQueue.clear();
                        this.window = null;
                        unicastSubject = null;
                    } else {
                        boolean z = this.done;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                if (unicastSubject != null) {
                                    unicastSubject.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll == NEXT_WINDOW) {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                    this.window = null;
                                    unicastSubject = null;
                                }
                                if (this.downstreamCancelled.get()) {
                                    this.timer.dispose();
                                } else {
                                    this.emitted++;
                                    this.windowCount.getAndIncrement();
                                    unicastSubject = UnicastSubject.create(this.bufferSize, this.windowRunnable);
                                    this.window = unicastSubject;
                                    ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                                    observer.onNext(observableWindowSubscribeIntercept);
                                    if (observableWindowSubscribeIntercept.tryAbandon()) {
                                        unicastSubject.onComplete();
                                    }
                                }
                            } else if (unicastSubject != null) {
                                unicastSubject.onNext(poll);
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void cleanupResources() {
            this.timer.dispose();
        }

        final class WindowRunnable implements Runnable {
            WindowRunnable() {
            }

            public void run() {
                WindowExactUnboundedObserver.this.windowDone();
            }
        }
    }

    static final class WindowExactBoundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        long count;
        final long maxSize;
        final boolean restartTimerOnMaxSize;
        final Scheduler scheduler;
        final SequentialDisposable timer;
        UnicastSubject<T> window;
        final Scheduler.Worker worker;

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler2, int i, long j2, boolean z) {
            super(observer, j, timeUnit, i);
            this.scheduler = scheduler2;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler2.createWorker();
            } else {
                this.worker = null;
            }
            this.timer = new SequentialDisposable();
        }

        /* access modifiers changed from: package-private */
        public void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.emitted = 1;
                this.windowCount.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.bufferSize, this);
                this.window = create;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                this.downstream.onNext(observableWindowSubscribeIntercept);
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1);
                if (this.restartTimerOnMaxSize) {
                    this.timer.replace(this.worker.schedulePeriodically(windowBoundaryRunnable, this.timespan, this.timespan, this.unit));
                } else {
                    this.timer.replace(this.scheduler.schedulePeriodicallyDirect(windowBoundaryRunnable, this.timespan, this.timespan, this.unit));
                }
                if (observableWindowSubscribeIntercept.tryAbandon()) {
                    this.window.onComplete();
                }
            }
        }

        public void run() {
            windowDone();
        }

        /* access modifiers changed from: package-private */
        public void cleanupResources() {
            this.timer.dispose();
            Scheduler.Worker worker2 = this.worker;
            if (worker2 != null) {
                worker2.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void boundary(WindowBoundaryRunnable windowBoundaryRunnable) {
            this.queue.offer(windowBoundaryRunnable);
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue simplePlainQueue = this.queue;
                Observer observer = this.downstream;
                UnicastSubject<T> unicastSubject = this.window;
                int i = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        simplePlainQueue.clear();
                        this.window = null;
                        unicastSubject = null;
                    } else {
                        boolean z = this.done;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                if (unicastSubject != null) {
                                    unicastSubject.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll instanceof WindowBoundaryRunnable) {
                                if (((WindowBoundaryRunnable) poll).index == this.emitted || !this.restartTimerOnMaxSize) {
                                    this.count = 0;
                                    unicastSubject = createNewWindow(unicastSubject);
                                }
                            } else if (unicastSubject != null) {
                                unicastSubject.onNext(poll);
                                long j = this.count + 1;
                                if (j == this.maxSize) {
                                    this.count = 0;
                                    unicastSubject = createNewWindow(unicastSubject);
                                } else {
                                    this.count = j;
                                }
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public UnicastSubject<T> createNewWindow(UnicastSubject<T> unicastSubject) {
            if (unicastSubject != null) {
                unicastSubject.onComplete();
                unicastSubject = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long j = this.emitted + 1;
                this.emitted = j;
                this.windowCount.getAndIncrement();
                unicastSubject = UnicastSubject.create(this.bufferSize, this);
                this.window = unicastSubject;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                this.downstream.onNext(observableWindowSubscribeIntercept);
                if (this.restartTimerOnMaxSize) {
                    this.timer.update(this.worker.schedulePeriodically(new WindowBoundaryRunnable(this, j), this.timespan, this.timespan, this.unit));
                }
                if (observableWindowSubscribeIntercept.tryAbandon()) {
                    unicastSubject.onComplete();
                }
            }
            return unicastSubject;
        }

        static final class WindowBoundaryRunnable implements Runnable {
            final long index;
            final WindowExactBoundedObserver<?> parent;

            WindowBoundaryRunnable(WindowExactBoundedObserver<?> windowExactBoundedObserver, long j) {
                this.parent = windowExactBoundedObserver;
                this.index = j;
            }

            public void run() {
                this.parent.boundary(this);
            }
        }
    }

    static final class WindowSkipObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        static final Object WINDOW_CLOSE = new Object();
        static final Object WINDOW_OPEN = new Object();
        private static final long serialVersionUID = -7852870764194095894L;
        final long timeskip;
        final List<UnicastSubject<T>> windows = new LinkedList();
        final Scheduler.Worker worker;

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker2, int i) {
            super(observer, j, timeUnit, i);
            this.timeskip = j2;
            this.worker = worker2;
        }

        /* access modifiers changed from: package-private */
        public void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.emitted = 1;
                this.windowCount.getAndIncrement();
                UnicastSubject create = UnicastSubject.create(this.bufferSize, this);
                this.windows.add(create);
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                this.downstream.onNext(observableWindowSubscribeIntercept);
                this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                Scheduler.Worker worker2 = this.worker;
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
                long j = this.timeskip;
                worker2.schedulePeriodically(windowBoundaryRunnable, j, j, this.unit);
                if (observableWindowSubscribeIntercept.tryAbandon()) {
                    create.onComplete();
                    this.windows.remove(create);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void cleanupResources() {
            this.worker.dispose();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue simplePlainQueue = this.queue;
                Observer observer = this.downstream;
                List<UnicastSubject<T>> list = this.windows;
                int i = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.done;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                for (UnicastSubject<T> onError : list) {
                                    onError.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                for (UnicastSubject<T> onComplete : list) {
                                    onComplete.onComplete();
                                }
                                observer.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll == WINDOW_OPEN) {
                                if (!this.downstreamCancelled.get()) {
                                    this.emitted++;
                                    this.windowCount.getAndIncrement();
                                    UnicastSubject create = UnicastSubject.create(this.bufferSize, this);
                                    list.add(create);
                                    ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                                    observer.onNext(observableWindowSubscribeIntercept);
                                    this.worker.schedule(new WindowBoundaryRunnable(this, false), this.timespan, this.unit);
                                    if (observableWindowSubscribeIntercept.tryAbandon()) {
                                        create.onComplete();
                                    }
                                }
                            } else if (poll != WINDOW_CLOSE) {
                                for (UnicastSubject<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            } else if (!list.isEmpty()) {
                                list.remove(0).onComplete();
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public void run() {
            windowDone();
        }

        /* access modifiers changed from: package-private */
        public void boundary(boolean z) {
            this.queue.offer(z ? WINDOW_OPEN : WINDOW_CLOSE);
            drain();
        }

        static final class WindowBoundaryRunnable implements Runnable {
            final boolean isOpen;
            final WindowSkipObserver<?> parent;

            WindowBoundaryRunnable(WindowSkipObserver<?> windowSkipObserver, boolean z) {
                this.parent = windowSkipObserver;
                this.isOpen = z;
            }

            public void run() {
                this.parent.boundary(this.isOpen);
            }
        }
    }
}
