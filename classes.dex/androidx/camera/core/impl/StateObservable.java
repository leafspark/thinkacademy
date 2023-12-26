package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class StateObservable<T> implements Observable<T> {
    private static final int INITIAL_VERSION = 0;
    private final Object mLock = new Object();
    private final CopyOnWriteArraySet<ObserverWrapper<T>> mNotifySet = new CopyOnWriteArraySet<>();
    private final AtomicReference<Object> mState;
    private boolean mUpdating = false;
    private int mVersion = 0;
    private final Map<Observable.Observer<? super T>, ObserverWrapper<T>> mWrapperMap = new HashMap();

    StateObservable(Object obj, boolean z) {
        if (z) {
            Preconditions.checkArgument(obj instanceof Throwable, "Initial errors must be Throwable");
            this.mState = new AtomicReference<>(ErrorWrapper.wrap((Throwable) obj));
            return;
        }
        this.mState = new AtomicReference<>(obj);
    }

    /* access modifiers changed from: package-private */
    public void updateState(T t) {
        updateStateInternal(t);
    }

    /* access modifiers changed from: package-private */
    public void updateStateAsError(Throwable th) {
        updateStateInternal(ErrorWrapper.wrap(th));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r1.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r1.next().update(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r1 = r3.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r3.mVersion != r4) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        r3.mUpdating = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        r4 = r3.mNotifySet.iterator();
        r0 = r3.mVersion;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        r1 = r4;
        r4 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateStateInternal(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r3.mState     // Catch:{ all -> 0x0051 }
            java.lang.Object r1 = r1.getAndSet(r4)     // Catch:{ all -> 0x0051 }
            boolean r4 = java.util.Objects.equals(r1, r4)     // Catch:{ all -> 0x0051 }
            if (r4 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x0011:
            int r4 = r3.mVersion     // Catch:{ all -> 0x0051 }
            r1 = 1
            int r4 = r4 + r1
            r3.mVersion = r4     // Catch:{ all -> 0x0051 }
            boolean r2 = r3.mUpdating     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x001d:
            r3.mUpdating = r1     // Catch:{ all -> 0x0051 }
            java.util.concurrent.CopyOnWriteArraySet<androidx.camera.core.impl.StateObservable$ObserverWrapper<T>> r1 = r3.mNotifySet     // Catch:{ all -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
        L_0x0026:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0036
            java.lang.Object r0 = r1.next()
            androidx.camera.core.impl.StateObservable$ObserverWrapper r0 = (androidx.camera.core.impl.StateObservable.ObserverWrapper) r0
            r0.update(r4)
            goto L_0x0026
        L_0x0036:
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            int r0 = r3.mVersion     // Catch:{ all -> 0x004e }
            if (r0 != r4) goto L_0x0042
            r4 = 0
            r3.mUpdating = r4     // Catch:{ all -> 0x004e }
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            return
        L_0x0042:
            java.util.concurrent.CopyOnWriteArraySet<androidx.camera.core.impl.StateObservable$ObserverWrapper<T>> r4 = r3.mNotifySet     // Catch:{ all -> 0x004e }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x004e }
            int r0 = r3.mVersion     // Catch:{ all -> 0x004e }
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            r1 = r4
            r4 = r0
            goto L_0x0026
        L_0x004e:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004e }
            throw r4
        L_0x0051:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.StateObservable.updateStateInternal(java.lang.Object):void");
    }

    public ListenableFuture<T> fetchData() {
        Object obj = this.mState.get();
        if (obj instanceof ErrorWrapper) {
            return Futures.immediateFailedFuture(((ErrorWrapper) obj).getError());
        }
        return Futures.immediateFuture(obj);
    }

    public void addObserver(Executor executor, Observable.Observer<? super T> observer) {
        ObserverWrapper observerWrapper;
        synchronized (this.mLock) {
            removeObserverLocked(observer);
            observerWrapper = new ObserverWrapper(this.mState, executor, observer);
            this.mWrapperMap.put(observer, observerWrapper);
            this.mNotifySet.add(observerWrapper);
        }
        observerWrapper.update(0);
    }

    public void removeObserver(Observable.Observer<? super T> observer) {
        synchronized (this.mLock) {
            removeObserverLocked(observer);
        }
    }

    private void removeObserverLocked(Observable.Observer<? super T> observer) {
        ObserverWrapper remove = this.mWrapperMap.remove(observer);
        if (remove != null) {
            remove.close();
            this.mNotifySet.remove(remove);
        }
    }

    private static final class ObserverWrapper<T> implements Runnable {
        private static final Object NOT_SET = new Object();
        private static final int NO_VERSION = -1;
        private final AtomicBoolean mActive = new AtomicBoolean(true);
        private final Executor mExecutor;
        private Object mLastState = NOT_SET;
        private int mLatestSignalledVersion = -1;
        private final Observable.Observer<? super T> mObserver;
        private final AtomicReference<Object> mStateRef;
        private boolean mWrapperUpdating = false;

        ObserverWrapper(AtomicReference<Object> atomicReference, Executor executor, Observable.Observer<? super T> observer) {
            this.mStateRef = atomicReference;
            this.mExecutor = executor;
            this.mObserver = observer;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
            if (java.util.Objects.equals(r4.mLastState, r0) != false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
            r4.mLastState = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
            if ((r0 instanceof androidx.camera.core.impl.StateObservable.ErrorWrapper) == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            r4.mObserver.onError(((androidx.camera.core.impl.StateObservable.ErrorWrapper) r0).getError());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
            r4.mObserver.onNewData(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            if (r2 == r4.mLatestSignalledVersion) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
            if (r4.mActive.get() != false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            r0 = r4.mStateRef.get();
            r2 = r4.mLatestSignalledVersion;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
            r4.mWrapperUpdating = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                monitor-enter(r4)
                java.util.concurrent.atomic.AtomicBoolean r0 = r4.mActive     // Catch:{ all -> 0x0055 }
                boolean r0 = r0.get()     // Catch:{ all -> 0x0055 }
                r1 = 0
                if (r0 != 0) goto L_0x000e
                r4.mWrapperUpdating = r1     // Catch:{ all -> 0x0055 }
                monitor-exit(r4)     // Catch:{ all -> 0x0055 }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r4.mStateRef     // Catch:{ all -> 0x0055 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0055 }
                int r2 = r4.mLatestSignalledVersion     // Catch:{ all -> 0x0055 }
                monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            L_0x0017:
                java.lang.Object r3 = r4.mLastState
                boolean r3 = java.util.Objects.equals(r3, r0)
                if (r3 != 0) goto L_0x0036
                r4.mLastState = r0
                boolean r3 = r0 instanceof androidx.camera.core.impl.StateObservable.ErrorWrapper
                if (r3 == 0) goto L_0x0031
                androidx.camera.core.impl.Observable$Observer<? super T> r3 = r4.mObserver
                androidx.camera.core.impl.StateObservable$ErrorWrapper r0 = (androidx.camera.core.impl.StateObservable.ErrorWrapper) r0
                java.lang.Throwable r0 = r0.getError()
                r3.onError(r0)
                goto L_0x0036
            L_0x0031:
                androidx.camera.core.impl.Observable$Observer<? super T> r3 = r4.mObserver
                r3.onNewData(r0)
            L_0x0036:
                monitor-enter(r4)
                int r0 = r4.mLatestSignalledVersion     // Catch:{ all -> 0x0052 }
                if (r2 == r0) goto L_0x004e
                java.util.concurrent.atomic.AtomicBoolean r0 = r4.mActive     // Catch:{ all -> 0x0052 }
                boolean r0 = r0.get()     // Catch:{ all -> 0x0052 }
                if (r0 != 0) goto L_0x0044
                goto L_0x004e
            L_0x0044:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r4.mStateRef     // Catch:{ all -> 0x0052 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0052 }
                int r2 = r4.mLatestSignalledVersion     // Catch:{ all -> 0x0052 }
                monitor-exit(r4)     // Catch:{ all -> 0x0052 }
                goto L_0x0017
            L_0x004e:
                r4.mWrapperUpdating = r1     // Catch:{ all -> 0x0052 }
                monitor-exit(r4)     // Catch:{ all -> 0x0052 }
                return
            L_0x0052:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0052 }
                throw r0
            L_0x0055:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0055 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.StateObservable.ObserverWrapper.run():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void update(int r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                java.util.concurrent.atomic.AtomicBoolean r0 = r1.mActive     // Catch:{ all -> 0x002c }
                boolean r0 = r0.get()     // Catch:{ all -> 0x002c }
                if (r0 != 0) goto L_0x000b
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                return
            L_0x000b:
                int r0 = r1.mLatestSignalledVersion     // Catch:{ all -> 0x002c }
                if (r2 > r0) goto L_0x0011
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                return
            L_0x0011:
                r1.mLatestSignalledVersion = r2     // Catch:{ all -> 0x002c }
                boolean r2 = r1.mWrapperUpdating     // Catch:{ all -> 0x002c }
                if (r2 == 0) goto L_0x0019
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                return
            L_0x0019:
                r2 = 1
                r1.mWrapperUpdating = r2     // Catch:{ all -> 0x002c }
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                java.util.concurrent.Executor r2 = r1.mExecutor     // Catch:{ all -> 0x0023 }
                r2.execute(r1)     // Catch:{ all -> 0x0023 }
                goto L_0x0028
            L_0x0023:
                monitor-enter(r1)
                r2 = 0
                r1.mWrapperUpdating = r2     // Catch:{ all -> 0x0029 }
                monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            L_0x0028:
                return
            L_0x0029:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0029 }
                throw r2
            L_0x002c:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.StateObservable.ObserverWrapper.update(int):void");
        }

        /* access modifiers changed from: package-private */
        public void close() {
            this.mActive.set(false);
        }
    }

    static abstract class ErrorWrapper {
        public abstract Throwable getError();

        ErrorWrapper() {
        }

        static ErrorWrapper wrap(Throwable th) {
            return new AutoValue_StateObservable_ErrorWrapper(th);
        }
    }
}
