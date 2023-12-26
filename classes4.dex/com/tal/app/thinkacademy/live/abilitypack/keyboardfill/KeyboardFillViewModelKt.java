package com.tal.app.thinkacademy.live.abilitypack.keyboardfill;

import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"getKeyboardFillViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/keyboardfill/KeyboardFillViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityPack;", "bus_livebusiness_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardFillViewModel.kt */
public final class KeyboardFillViewModelKt {
    public static final KeyboardFillViewModel getKeyboardFillViewModel(AbilityPack abilityPack) {
        Intrinsics.checkNotNullParameter(abilityPack, "<this>");
        return abilityPack.getViewModel(KeyboardFillViewModel.class);
    }
}
