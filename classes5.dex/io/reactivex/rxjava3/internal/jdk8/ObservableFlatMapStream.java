package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public final class ObservableFlatMapStream<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final Observable<T> source;

    public ObservableFlatMapStream(Observable<T> observable, Function<? super T, ? extends Stream<? extends R>> function) {
        this.source = observable;
        this.mapper = function;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.stream.Stream} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribeActual(io.reactivex.rxjava3.core.Observer<? super R> r4) {
        /*
            r3 = this;
            io.reactivex.rxjava3.core.Observable<T> r0 = r3.source
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
            io.reactivex.rxjava3.internal.jdk8.ObservableFromStream.subscribeStream(r4, r1)
            goto L_0x0039
        L_0x0023:
            io.reactivex.rxjava3.internal.disposables.EmptyDisposable.complete((io.reactivex.rxjava3.core.Observer<?>) r4)
            goto L_0x0039
        L_0x0027:
            r0 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
            io.reactivex.rxjava3.internal.disposables.EmptyDisposable.error((java.lang.Throwable) r0, (io.reactivex.rxjava3.core.Observer<?>) r4)
            return
        L_0x002f:
            io.reactivex.rxjava3.internal.jdk8.ObservableFlatMapStream$FlatMapStreamObserver r1 = new io.reactivex.rxjava3.internal.jdk8.ObservableFlatMapStream$FlatMapStreamObserver
            io.reactivex.rxjava3.functions.Function<? super T, ? extends java.util.stream.Stream<? extends R>> r2 = r3.mapper
            r1.<init>(r4, r2)
            r0.subscribe(r1)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ObservableFlatMapStream.subscribeActual(io.reactivex.rxjava3.core.Observer):void");
    }

    static final class FlatMapStreamObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean disposed;
        boolean done;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends Stream<? extends R>> mapper;
        Disposable upstream;

        FlatMapStreamObserver(Observer<? super R> observer, Function<? super T, ? extends Stream<? extends R>> function) {
            this.downstream = observer;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
            if (r5 != null) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0052, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r5) {
            /*
                r4 = this;
                boolean r0 = r4.done
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends java.util.stream.Stream<? extends R>> r0 = r4.mapper     // Catch:{ all -> 0x0053 }
                java.lang.Object r5 = r0.apply(r5)     // Catch:{ all -> 0x0053 }
                java.lang.String r0 = "The mapper returned a null Stream"
                java.util.Objects.requireNonNull(r5, r0)     // Catch:{ all -> 0x0053 }
                java.util.stream.Stream r5 = (java.util.stream.Stream) r5     // Catch:{ all -> 0x0053 }
                java.util.Iterator r0 = r5.iterator()     // Catch:{ all -> 0x0045 }
            L_0x0016:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0045 }
                if (r1 == 0) goto L_0x003f
                boolean r1 = r4.disposed     // Catch:{ all -> 0x0045 }
                r2 = 1
                if (r1 == 0) goto L_0x0024
                r4.done = r2     // Catch:{ all -> 0x0045 }
                goto L_0x003f
            L_0x0024:
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0045 }
                java.lang.String r3 = "The Stream's Iterator.next returned a null value"
                java.util.Objects.requireNonNull(r1, r3)     // Catch:{ all -> 0x0045 }
                boolean r3 = r4.disposed     // Catch:{ all -> 0x0045 }
                if (r3 == 0) goto L_0x0034
                r4.done = r2     // Catch:{ all -> 0x0045 }
                goto L_0x003f
            L_0x0034:
                io.reactivex.rxjava3.core.Observer<? super R> r3 = r4.downstream     // Catch:{ all -> 0x0045 }
                r3.onNext(r1)     // Catch:{ all -> 0x0045 }
                boolean r1 = r4.disposed     // Catch:{ all -> 0x0045 }
                if (r1 == 0) goto L_0x0016
                r4.done = r2     // Catch:{ all -> 0x0045 }
            L_0x003f:
                if (r5 == 0) goto L_0x005f
                r5.close()     // Catch:{ all -> 0x0053 }
                goto L_0x005f
            L_0x0045:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0047 }
            L_0x0047:
                r1 = move-exception
                if (r5 == 0) goto L_0x0052
                r5.close()     // Catch:{ all -> 0x004e }
                goto L_0x0052
            L_0x004e:
                r5 = move-exception
                r0.addSuppressed(r5)     // Catch:{ all -> 0x0053 }
            L_0x0052:
                throw r1     // Catch:{ all -> 0x0053 }
            L_0x0053:
                r5 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
                io.reactivex.rxjava3.disposables.Disposable r0 = r4.upstream
                r0.dispose()
                r4.onError(r5)
            L_0x005f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ObservableFlatMapStream.FlatMapStreamObserver.onNext(java.lang.Object):void");
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
