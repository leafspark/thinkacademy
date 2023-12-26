package com.tal.app.thinkacademy.lib.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0006H\u0016J&\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0006J&\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0006J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0010H\u0014J\u0013\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u0015\u0010 \u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001aR(\u0010\u0004\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "T", "Landroidx/lifecycle/LiveData;", "()V", "mForeverObserverMap", "", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData$StickyObserver;", "mObserverMap", "mStickyData", "Ljava/lang/Object;", "mVersion", "", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "observeForever", "sticky", "", "observerSticky", "ownerDestroyed", "source", "postStickyData", "stickyData", "(Ljava/lang/Object;)V", "postValue", "value", "removeObserver", "removeObservers", "setStickyData", "setValue", "StickyObserver", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StickyLiveData.kt */
public class StickyLiveData<T> extends LiveData<T> {
    private final Map<Observer<? super T>, StickyObserver<T>> mForeverObserverMap = new LinkedHashMap();
    private final Map<Observer<? super T>, StickyObserver<T>> mObserverMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public T mStickyData;
    /* access modifiers changed from: private */
    public int mVersion;

    /* access modifiers changed from: protected */
    public void ownerDestroyed(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
    }

    public final void setStickyData(T t) {
        this.mStickyData = t;
        setValue(t);
    }

    public final void postStickyData(T t) {
        this.mStickyData = t;
        LiveDataUtils.setValue(this, t);
    }

    /* access modifiers changed from: protected */
    public void setValue(T t) {
        this.mVersion++;
        StickyLiveData.super.setValue(t);
    }

    /* access modifiers changed from: protected */
    public void postValue(T t) {
        this.mVersion++;
        StickyLiveData.super.postValue(t);
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        observerSticky(lifecycleOwner, false, observer);
    }

    public final void observerSticky(LifecycleOwner lifecycleOwner, boolean z, Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        lifecycleOwner.getLifecycle().addObserver(new StickyLiveData$$ExternalSyntheticLambda0(this));
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            XesLog.et("eventbus销毁乐乐乐", "eventbus销毁乐乐乐");
        }
        Observer stickyObserver = new StickyObserver(this, z, observer);
        this.mObserverMap.put(observer, stickyObserver);
        StickyLiveData.super.observe(lifecycleOwner, stickyObserver);
    }

    /* access modifiers changed from: private */
    /* renamed from: observerSticky$lambda-0  reason: not valid java name */
    public static final void m132observerSticky$lambda0(StickyLiveData stickyLiveData, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(stickyLiveData, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            stickyLiveData.ownerDestroyed(lifecycleOwner);
            stickyLiveData.removeObservers(lifecycleOwner);
        }
    }

    public final void observeForever(LifecycleOwner lifecycleOwner, boolean z, Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Observer stickyObserver = new StickyObserver(this, z, observer);
        this.mForeverObserverMap.put(observer, stickyObserver);
        StickyLiveData.super.observeForever(stickyObserver);
    }

    public void removeObserver(Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Observer observer2 = (StickyObserver) this.mForeverObserverMap.remove(observer);
        if (observer2 != null) {
            StickyLiveData.super.removeObserver(observer2);
            return;
        }
        Observer observer3 = (StickyObserver) this.mObserverMap.remove(observer);
        if (observer3 != null) {
            StickyLiveData.super.removeObserver(observer3);
        } else {
            StickyLiveData.super.removeObserver(observer);
        }
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.mObserverMap.clear();
        StickyLiveData.super.removeObservers(lifecycleOwner);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0002¢\u0006\u0002\u0010\bJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData$StickyObserver;", "T", "Landroidx/lifecycle/Observer;", "stickyLiveData", "Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "sticky", "", "observer", "(Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;ZLandroidx/lifecycle/Observer;)V", "lastVersion", "", "onChanged", "", "t", "(Ljava/lang/Object;)V", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StickyLiveData.kt */
    public static final class StickyObserver<T> implements Observer<T> {
        private int lastVersion;
        private final Observer<? super T> observer;
        private final boolean sticky;
        private final StickyLiveData<T> stickyLiveData;

        public StickyObserver(StickyLiveData<T> stickyLiveData2, boolean z, Observer<? super T> observer2) {
            Intrinsics.checkNotNullParameter(stickyLiveData2, "stickyLiveData");
            Intrinsics.checkNotNullParameter(observer2, "observer");
            this.stickyLiveData = stickyLiveData2;
            this.sticky = z;
            this.observer = observer2;
            this.lastVersion = stickyLiveData2.mVersion;
        }

        public void onChanged(T t) {
            if (this.lastVersion < this.stickyLiveData.mVersion) {
                this.lastVersion = this.stickyLiveData.mVersion;
                this.observer.onChanged(t);
            } else if (this.sticky && this.stickyLiveData.mStickyData != null) {
                this.observer.onChanged(this.stickyLiveData.mStickyData);
            }
        }
    }
}
