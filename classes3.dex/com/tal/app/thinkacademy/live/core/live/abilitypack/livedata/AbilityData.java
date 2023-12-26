package com.tal.app.thinkacademy.live.core.live.abilitypack.livedata;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/AbilityData;", "T", "Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "()V", "observeSticky", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "sticky", "", "observer", "Landroidx/lifecycle/Observer;", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbilityData.kt */
public class AbilityData<T> extends StickyLiveData<T> {
    public final void observeSticky(LifecycleOwner lifecycleOwner, boolean z, Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        AbilityData.super.observerSticky(lifecycleOwner, z, observer);
    }
}
