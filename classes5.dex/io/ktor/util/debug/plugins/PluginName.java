package io.ktor.util.debug.plugins;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/ktor/util/debug/plugins/PluginName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "pluginName", "", "(Ljava/lang/String;)V", "getPluginName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Key", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PluginName.kt */
public final class PluginName extends AbstractCoroutineContextElement {
    public static final Key Key = new Key((DefaultConstructorMarker) null);
    private final String pluginName;

    public static /* synthetic */ PluginName copy$default(PluginName pluginName2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pluginName2.pluginName;
        }
        return pluginName2.copy(str);
    }

    public final String component1() {
        return this.pluginName;
    }

    public final PluginName copy(String str) {
        Intrinsics.checkNotNullParameter(str, "pluginName");
        return new PluginName(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PluginName) && Intrinsics.areEqual(this.pluginName, ((PluginName) obj).pluginName);
    }

    public int hashCode() {
        return this.pluginName.hashCode();
    }

    public final String getPluginName() {
        return this.pluginName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PluginName(String str) {
        super(Key);
        Intrinsics.checkNotNullParameter(str, "pluginName");
        this.pluginName = str;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/util/debug/plugins/PluginName$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lio/ktor/util/debug/plugins/PluginName;", "()V", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PluginName.kt */
    public static final class Key implements CoroutineContext.Key<PluginName> {
        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Key() {
        }
    }

    public String toString() {
        return "PluginName(" + this.pluginName + ')';
    }
}
