package com.tal.app.thinkacademy.live.core.live.abilitypack;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0007\u001a\u0002H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "isInstanceOf", "", "clz", "targetClz", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbilityPack.kt */
public final class ViewModelFactory implements ViewModelProvider.Factory {
    private final ILiveRoomProvider provider;

    public ViewModelFactory(ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
    }

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        try {
            if (!isInstanceOf(cls, AbilityViewModel.class)) {
                return (ViewModel) cls.newInstance();
            }
            return (ViewModel) cls.getConstructor(new Class[]{ILiveRoomProvider.class}).newInstance(new Object[]{this.provider});
        } catch (InstantiationException e) {
            throw new RuntimeException(Intrinsics.stringPlus("Cannot create an instance of ", cls), e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(Intrinsics.stringPlus("Cannot create an instance of ", cls), e2);
        }
    }

    private final boolean isInstanceOf(Class<?> cls, Class<?> cls2) {
        if (Intrinsics.areEqual((Object) cls.getName(), (Object) cls2.getName())) {
            return true;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null) {
            return false;
        }
        return isInstanceOf(superclass, cls2);
    }
}
