package com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.AbilityData;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J7\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007RB\u0010\u0005\u001a6\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b0\u0006j\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "T", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/AbilityData;", "()V", "mObserveMap", "Ljava/util/HashMap;", "", "", "Landroidx/lifecycle/Observer;", "Lkotlin/collections/HashMap;", "observeListener", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "sticky", "", "target", "listenerBody", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ownerDestroyed", "removeListener", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListenerData.kt */
public class ListenerData<T extends ListenerBody<T>> extends AbilityData<T> {
    private final HashMap<String, List<Observer<T>>> mObserveMap = new HashMap<>();

    public final void observeListener(LifecycleOwner lifecycleOwner, boolean z, String str, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(str, "target");
        Intrinsics.checkNotNullParameter(function1, "listenerBody");
        ListenerData$$ExternalSyntheticLambda0 listenerData$$ExternalSyntheticLambda0 = new ListenerData$$ExternalSyntheticLambda0(function1);
        observeSticky(lifecycleOwner, z, listenerData$$ExternalSyntheticLambda0);
        if (this.mObserveMap.get(str) == null) {
            ListenerData listenerData = this;
            this.mObserveMap.put(str, new ArrayList());
        }
        List list = this.mObserveMap.get(str);
        if (list != null) {
            list.add(listenerData$$ExternalSyntheticLambda0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeListener$lambda-0  reason: not valid java name */
    public static final void m512observeListener$lambda0(Function1 function1, ListenerBody listenerBody) {
        Intrinsics.checkNotNullParameter(function1, "$listenerBody");
        function1.invoke(listenerBody);
        Intrinsics.checkNotNullExpressionValue(listenerBody, "it.also(listenerBody)");
        listenerBody.dispatch(listenerBody);
    }

    public final void removeListener(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        List<Observer> remove = this.mObserveMap.remove(str);
        if (remove != null) {
            for (Observer removeObserver : remove) {
                removeObserver(removeObserver);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void ownerDestroyed(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.mObserveMap.clear();
    }
}
