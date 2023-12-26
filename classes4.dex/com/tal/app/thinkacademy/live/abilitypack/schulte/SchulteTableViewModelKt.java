package com.tal.app.thinkacademy.live.abilitypack.schulte;

import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\b¨\u0006\u0003"}, d2 = {"getSchulteTableViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/schulte/SchulteTableViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityPack;", "bus_livebusiness_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableViewModel.kt */
public final class SchulteTableViewModelKt {
    public static final SchulteTableViewModel getSchulteTableViewModel(AbilityPack abilityPack) {
        Intrinsics.checkNotNullParameter(abilityPack, "<this>");
        return abilityPack.getViewModel(SchulteTableViewModel.class);
    }
}
