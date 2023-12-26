package io.ktor.util.debug.plugins;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lio/ktor/util/debug/plugins/PluginsTrace;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "eventOrder", "", "Lio/ktor/util/debug/plugins/PluginTraceElement;", "(Ljava/util/List;)V", "getEventOrder", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Key", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PluginsTrace.kt */
public final class PluginsTrace extends AbstractCoroutineContextElement {
    public static final Key Key = new Key((DefaultConstructorMarker) null);
    private final List<PluginTraceElement> eventOrder;

    public PluginsTrace() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PluginsTrace copy$default(PluginsTrace pluginsTrace, List<PluginTraceElement> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pluginsTrace.eventOrder;
        }
        return pluginsTrace.copy(list);
    }

    public final List<PluginTraceElement> component1() {
        return this.eventOrder;
    }

    public final PluginsTrace copy(List<PluginTraceElement> list) {
        Intrinsics.checkNotNullParameter(list, "eventOrder");
        return new PluginsTrace(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PluginsTrace) && Intrinsics.areEqual(this.eventOrder, ((PluginsTrace) obj).eventOrder);
    }

    public int hashCode() {
        return this.eventOrder.hashCode();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PluginsTrace(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public final List<PluginTraceElement> getEventOrder() {
        return this.eventOrder;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PluginsTrace(List<PluginTraceElement> list) {
        super(Key);
        Intrinsics.checkNotNullParameter(list, "eventOrder");
        this.eventOrder = list;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/util/debug/plugins/PluginsTrace$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lio/ktor/util/debug/plugins/PluginsTrace;", "()V", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PluginsTrace.kt */
    public static final class Key implements CoroutineContext.Key<PluginsTrace> {
        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Key() {
        }
    }

    public String toString() {
        return "PluginsTrace(" + CollectionsKt.joinToString$default(this.eventOrder, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ')';
    }
}
