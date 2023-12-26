package com.tal.app.thinkacademy.live.core.live.abilitypack;

import androidx.lifecycle.Lifecycle;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.AbilityData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001d\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"lifecycleData", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/AbilityData;", "Landroidx/lifecycle/Lifecycle$Event;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityPack;", "getLifecycleData", "(Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityPack;)Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/AbilityData;", "bus_livebase_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbilityViewModel.kt */
public final class AbilityViewModelKt {
    public static final AbilityData<Lifecycle.Event> getLifecycleData(AbilityPack abilityPack) {
        Intrinsics.checkNotNullParameter(abilityPack, "<this>");
        return AbilityViewModel.Companion.getVmLifecycleData();
    }
}
