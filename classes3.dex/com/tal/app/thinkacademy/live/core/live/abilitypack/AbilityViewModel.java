package com.tal.app.thinkacademy.live.core.live.abilitypack;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.AbilityData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0004J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u000e\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\nH\u0007J\b\u0010\u0010\u001a\u00020\nH\u0007J\b\u0010\u0011\u001a\u00020\nH$R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "getMLiveRoomProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "setMLiveRoomProvider", "onCleared", "", "onLifecycleCreate", "onLifecycleDestroy", "onLifecyclePause", "onLifecycleResume", "onLifecycleStart", "onLifecycleStop", "onVmDestroy", "Companion", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbilityViewModel.kt */
public abstract class AbilityViewModel extends ViewModel implements LifecycleObserver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static AbilityData<Lifecycle.Event> vmLifecycleData = new AbilityData<>();
    private ILiveRoomProvider mLiveRoomProvider;

    public static final AbilityData<Lifecycle.Event> getVmLifecycleData() {
        return Companion.getVmLifecycleData();
    }

    public static final void setVmLifecycleData(AbilityData<Lifecycle.Event> abilityData) {
        Companion.setVmLifecycleData(abilityData);
    }

    /* access modifiers changed from: protected */
    public abstract void onVmDestroy();

    public final ILiveRoomProvider getMLiveRoomProvider() {
        return this.mLiveRoomProvider;
    }

    public final void setMLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "<set-?>");
        this.mLiveRoomProvider = iLiveRoomProvider;
    }

    public AbilityViewModel(ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "mLiveRoomProvider");
        this.mLiveRoomProvider = iLiveRoomProvider;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel$Companion;", "", "()V", "vmLifecycleData", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/AbilityData;", "Landroidx/lifecycle/Lifecycle$Event;", "getVmLifecycleData$annotations", "getVmLifecycleData", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/AbilityData;", "setVmLifecycleData", "(Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/AbilityData;)V", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbilityViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getVmLifecycleData$annotations() {
        }

        private Companion() {
        }

        public final AbilityData<Lifecycle.Event> getVmLifecycleData() {
            return AbilityViewModel.vmLifecycleData;
        }

        public final void setVmLifecycleData(AbilityData<Lifecycle.Event> abilityData) {
            AbilityViewModel.vmLifecycleData = abilityData;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onLifecycleCreate() {
        AbilityData<Lifecycle.Event> abilityData = vmLifecycleData;
        if (abilityData != null) {
            abilityData.setStickyData(Lifecycle.Event.ON_CREATE);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onLifecycleStart() {
        AbilityData<Lifecycle.Event> abilityData = vmLifecycleData;
        if (abilityData != null) {
            abilityData.setStickyData(Lifecycle.Event.ON_START);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onLifecycleResume() {
        AbilityData<Lifecycle.Event> abilityData = vmLifecycleData;
        if (abilityData != null) {
            abilityData.setStickyData(Lifecycle.Event.ON_RESUME);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onLifecyclePause() {
        AbilityData<Lifecycle.Event> abilityData = vmLifecycleData;
        if (abilityData != null) {
            abilityData.setStickyData(Lifecycle.Event.ON_PAUSE);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onLifecycleStop() {
        AbilityData<Lifecycle.Event> abilityData = vmLifecycleData;
        if (abilityData != null) {
            abilityData.setStickyData(Lifecycle.Event.ON_STOP);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onLifecycleDestroy() {
        AbilityData<Lifecycle.Event> abilityData = vmLifecycleData;
        if (abilityData != null) {
            abilityData.setStickyData(Lifecycle.Event.ON_DESTROY);
        }
        vmLifecycleData = null;
    }

    /* access modifiers changed from: protected */
    public final void onCleared() {
        onVmDestroy();
    }
}
