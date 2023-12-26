package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
        this.combiner = function;
        this.bufferSize = i;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i;
        ObservableSource<? extends T>[] observableSourceArr = this.sources;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            i = 0;
            for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                if (i == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i >> 2) + i)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i] = observableSource;
                i++;
            }
        } else {
            i = observableSourceArr.length;
        }
        int i2 = i;
        if (i2 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
            return;
        }
        new LatestCoordinator(observer, this.combiner, i2, this.bufferSize, this.delayError).subscribe(observableSourceArr);
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Observer<? super R> actual;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicThrowable errors = new AtomicThrowable();
        final T[] latest;
        final CombinerObserver<T, R>[] observers;
        final SpscLinkedArrayQueue<Object> queue;

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.actual = observer;
            this.combiner = function;
            this.delayError = z;
            this.latest = (Object[]) new Object[i];
            this.observers = new CombinerObserver[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            for (int i = 0; i < length; i++) {
                combinerObserverArr[i] = new CombinerObserver<>(this, i);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.done && !this.cancelled; i2++) {
                observableSourceArr[i2].subscribe(combinerObserverArr[i2]);
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                if (getAndIncrement() == 0) {
                    clear(this.queue);
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void cancel(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            clear(spscLinkedArrayQueue);
            cancelSources();
        }

        /* access modifiers changed from: package-private */
        public void cancelSources() {
            for (CombinerObserver<T, R> dispose : this.observers) {
                dispose.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void clear(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                Arrays.fill(this.latest, (Object) null);
            }
            spscLinkedArrayQueue.clear();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
            if (r4 != false) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
            if (r8 == null) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0055, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0056, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void combine(T r8, int r9) {
            /*
                r7 = this;
                io.reactivex.internal.operators.observable.ObservableCombineLatest$CombinerObserver<T, R>[] r0 = r7.observers
                r0 = r0[r9]
                monitor-enter(r7)
                boolean r1 = r7.cancelled     // Catch:{ all -> 0x005a }
                if (r1 == 0) goto L_0x000b
                monitor-exit(r7)     // Catch:{ all -> 0x005a }
                return
            L_0x000b:
                T[] r1 = r7.latest     // Catch:{ all -> 0x005a }
                int r2 = r1.length     // Catch:{ all -> 0x005a }
                r3 = r1[r9]     // Catch:{ all -> 0x005a }
                int r4 = r7.active     // Catch:{ all -> 0x005a }
                if (r3 != 0) goto L_0x0018
                int r4 = r4 + 1
                r7.active = r4     // Catch:{ all -> 0x005a }
            L_0x0018:
                int r5 = r7.complete     // Catch:{ all -> 0x005a }
                if (r8 != 0) goto L_0x0021
                int r5 = r5 + 1
                r7.complete = r5     // Catch:{ all -> 0x005a }
                goto L_0x0023
            L_0x0021:
                r1[r9] = r8     // Catch:{ all -> 0x005a }
            L_0x0023:
                r9 = 0
                r6 = 1
                if (r4 != r2) goto L_0x0029
                r4 = r6
                goto L_0x002a
            L_0x0029:
                r4 = r9
            L_0x002a:
                if (r5 == r2) goto L_0x0030
                if (r8 != 0) goto L_0x0031
                if (r3 != 0) goto L_0x0031
            L_0x0030:
                r9 = r6
            L_0x0031:
                if (r9 != 0) goto L_0x004e
                if (r8 == 0) goto L_0x0041
                if (r4 == 0) goto L_0x0041
                io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object> r9 = r7.queue     // Catch:{ all -> 0x005a }
                java.lang.Object r1 = r1.clone()     // Catch:{ all -> 0x005a }
                r9.offer(r0, r1)     // Catch:{ all -> 0x005a }
                goto L_0x0050
            L_0x0041:
                if (r8 != 0) goto L_0x0050
                io.reactivex.internal.util.AtomicThrowable r9 = r7.errors     // Catch:{ all -> 0x005a }
                java.lang.Object r9 = r9.get()     // Catch:{ all -> 0x005a }
                if (r9 == 0) goto L_0x0050
                r7.done = r6     // Catch:{ all -> 0x005a }
                goto L_0x0050
            L_0x004e:
                r7.done = r6     // Catch:{ all -> 0x005a }
            L_0x0050:
                monitor-exit(r7)     // Catch:{ all -> 0x005a }
                if (r4 != 0) goto L_0x0056
                if (r8 == 0) goto L_0x0056
                return
            L_0x0056:
                r7.drain()
                return
            L_0x005a:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x005a }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.combine(java.lang.Object, int):void");
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                Observer<? super R> observer = this.actual;
                boolean z = this.delayError;
                int i = 1;
                do {
                    if (!checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), observer, spscLinkedArrayQueue, z)) {
                        while (true) {
                            boolean z2 = this.done;
                            boolean z3 = ((CombinerObserver) spscLinkedArrayQueue.poll()) == null;
                            if (!checkTerminated(z2, z3, observer, spscLinkedArrayQueue, z)) {
                                if (z3) {
                                    i = addAndGet(-i);
                                } else {
                                    try {
                                        observer.onNext(ObjectHelper.requireNonNull(this.combiner.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null"));
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.cancelled = true;
                                        cancel(spscLinkedArrayQueue);
                                        observer.onError(th);
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } while (i != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue, boolean z3) {
            if (this.cancelled) {
                cancel(spscLinkedArrayQueue);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (z3) {
                    if (!z2) {
                        return false;
                    }
                    cancel(spscLinkedArrayQueue);
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        observer.onError(terminate);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                } else if (((Throwable) this.errors.get()) != null) {
                    cancel(spscLinkedArrayQueue);
                    observer.onError(this.errors.terminate());
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    clear(this.queue);
                    observer.onComplete();
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            }
        }
    }

    static final class CombinerObserver<T, R> implements Observer<T> {
        final int index;
        final LatestCoordinator<T, R> parent;
        final AtomicReference<Disposable> s = new AtomicReference<>();

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.s, disposable);
        }

        public void onNext(T t) {
            this.parent.combine(t, this.index);
        }

        public void onError(Throwable th) {
            this.parent.onError(th);
            this.parent.combine(null, this.index);
        }

        public void onComplete() {
            this.parent.combine(null, this.index);
        }

        public void dispose() {
            DisposableHelper.dispose(this.s);
        }
    }
}
