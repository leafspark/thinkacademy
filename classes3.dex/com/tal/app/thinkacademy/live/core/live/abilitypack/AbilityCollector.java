package com.tal.app.thinkacademy.live.core.live.abilitypack;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityCollector;", "", "()V", "mExtendMap", "", "", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "collect", "", "ability", "destroyAll", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbilityCollector.kt */
public final class AbilityCollector {
    private final Map<String, AbilityViewModel> mExtendMap = new LinkedHashMap();

    public final void collect(AbilityViewModel abilityViewModel) {
        Lifecycle lifecycle;
        Lifecycle lifecycle2;
        Intrinsics.checkNotNullParameter(abilityViewModel, "ability");
        String simpleName = abilityViewModel.getClass().getSimpleName();
        XesLog.it(AbilityPack.TAG, new Object[]{"AbilityCollector 当前VM {" + simpleName + '}'});
        if (!AbilityPackKt.getAbilityPack().isBind()) {
            return;
        }
        if (Intrinsics.areEqual((Object) this.mExtendMap.get(simpleName), (Object) abilityViewModel)) {
            XesLog.it(AbilityPack.TAG, new Object[]{"AbilityCollector 已收集"});
            return;
        }
        LifecycleObserver lifecycleObserver = (AbilityViewModel) this.mExtendMap.remove(simpleName);
        if (lifecycleObserver != null) {
            XesLog.it(AbilityPack.TAG, new Object[]{Intrinsics.stringPlus("AbilityCollector 重复收集, ", lifecycleObserver)});
            LifecycleOwner lifecycleOwner = AbilityPackKt.getAbilityPack().getLifecycleOwner();
            if (!(lifecycleOwner == null || (lifecycle2 = lifecycleOwner.getLifecycle()) == null)) {
                lifecycle2.removeObserver(lifecycleObserver);
            }
        }
        XesLog.it(AbilityPack.TAG, new Object[]{Intrinsics.stringPlus("AbilityCollector 收集成功, ", abilityViewModel)});
        Map<String, AbilityViewModel> map = this.mExtendMap;
        Intrinsics.checkNotNullExpressionValue(simpleName, "abilityName");
        map.put(simpleName, abilityViewModel);
        LifecycleOwner lifecycleOwner2 = AbilityPackKt.getAbilityPack().getLifecycleOwner();
        if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle.addObserver((LifecycleObserver) abilityViewModel);
        }
    }

    public final void destroyAll() {
        Lifecycle lifecycle;
        for (Map.Entry next : this.mExtendMap.entrySet()) {
            LifecycleOwner lifecycleOwner = AbilityPackKt.getAbilityPack().getLifecycleOwner();
            if (!(lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                lifecycle.removeObserver((LifecycleObserver) next.getValue());
            }
        }
        this.mExtendMap.clear();
    }
}
