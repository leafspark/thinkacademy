package com.tal.app.thinkacademy.live.core.live.abilitypack;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\tJ\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ%\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001c¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityPack;", "", "()V", "mCollector", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityCollector;", "mIsBinding", "", "mWeakLiveRoomProvider", "Ljava/lang/ref/WeakReference;", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "mWeakOwner", "Landroidx/lifecycle/LifecycleOwner;", "mWeakStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "mWeakViewModelFactory", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/ViewModelFactory;", "bind", "", "owner", "store", "liveRoomProvider", "getCollector", "getLifecycleOwner", "getLiveRoomProvider", "getViewModel", "T", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "clz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "isBind", "unBind", "Companion", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbilityPack.kt */
public final class AbilityPack {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<AbilityPack> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AbilityPack$Companion$INSTANCE$2.INSTANCE);
    public static final String TAG = "AbilityPack";
    private final AbilityCollector mCollector;
    private boolean mIsBinding;
    private WeakReference<ILiveRoomProvider> mWeakLiveRoomProvider;
    private WeakReference<LifecycleOwner> mWeakOwner;
    private WeakReference<ViewModelStoreOwner> mWeakStoreOwner;
    private ViewModelFactory mWeakViewModelFactory;

    public /* synthetic */ AbilityPack(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final AbilityPack get() {
        return Companion.get();
    }

    private AbilityPack() {
        this.mCollector = new AbilityCollector();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityPack$Companion;", "", "()V", "INSTANCE", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityPack;", "getINSTANCE", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityPack;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "get", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbilityPack.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final AbilityPack getINSTANCE() {
            return (AbilityPack) AbilityPack.INSTANCE$delegate.getValue();
        }

        @JvmStatic
        public final AbilityPack get() {
            return getINSTANCE();
        }
    }

    public final void bind(LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner, ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "store");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
        XesLog.it(TAG, new Object[]{"AbilityPack 绑定[" + lifecycleOwner.getClass() + ' ' + lifecycleOwner + ']'});
        if (this.mWeakOwner != null) {
            XesLog.it(TAG, new Object[]{"AbilityPack 重复绑定，[ " + lifecycleOwner.getClass() + ' ' + lifecycleOwner + ']'});
        }
        this.mWeakViewModelFactory = new ViewModelFactory(iLiveRoomProvider);
        this.mWeakOwner = new WeakReference<>(lifecycleOwner);
        this.mWeakStoreOwner = new WeakReference<>(viewModelStoreOwner);
        this.mWeakLiveRoomProvider = new WeakReference<>(iLiveRoomProvider);
        this.mIsBinding = true;
    }

    public final boolean isBind() {
        return this.mIsBinding;
    }

    public final void unBind() {
        XesLog.it(TAG, new Object[]{"AbilityPack 解绑"});
        this.mWeakViewModelFactory = null;
        this.mWeakOwner = null;
        this.mWeakStoreOwner = null;
        this.mWeakLiveRoomProvider = null;
        this.mIsBinding = false;
        getCollector().destroyAll();
    }

    public final LifecycleOwner getLifecycleOwner() {
        if (!isBind()) {
            return null;
        }
        WeakReference<LifecycleOwner> weakReference = this.mWeakOwner;
        if (weakReference == null) {
            return null;
        }
        return (LifecycleOwner) weakReference.get();
    }

    public final ILiveRoomProvider getLiveRoomProvider() {
        if (!isBind()) {
            return null;
        }
        WeakReference<ILiveRoomProvider> weakReference = this.mWeakLiveRoomProvider;
        if (weakReference == null) {
            return null;
        }
        return (ILiveRoomProvider) weakReference.get();
    }

    private final AbilityCollector getCollector() {
        return this.mCollector;
    }

    public final <T extends AbilityViewModel> T getViewModel(Class<T> cls) {
        ViewModelStoreOwner viewModelStoreOwner;
        T t;
        Intrinsics.checkNotNullParameter(cls, "clz");
        if (!isBind()) {
            return (AbilityViewModel) null;
        }
        WeakReference<ViewModelStoreOwner> weakReference = this.mWeakStoreOwner;
        if (weakReference == null || (viewModelStoreOwner = (ViewModelStoreOwner) weakReference.get()) == null) {
            return null;
        }
        ViewModelProvider.Factory factory = this.mWeakViewModelFactory;
        if (factory == null) {
            t = null;
        } else {
            t = (AbilityViewModel) new ViewModelProvider(viewModelStoreOwner, factory).get(cls);
        }
        if (t == null) {
            return null;
        }
        getCollector().collect(t);
        return t;
    }
}
