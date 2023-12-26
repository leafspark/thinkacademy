package com.tal.app.thinkacademy.live.abilitypack.graffiti;

import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/graffiti/GraffitiViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "onVmDestroy", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiViewModel.kt */
public final class GraffitiViewModel extends AbilityViewModel {
    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraffitiViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
    }
}
