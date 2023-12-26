package com.tal.app.thinkacademy.live.core.live.http.response;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/http/response/KeyEntity;", "", "keys", "", "", "(Ljava/util/List;)V", "getKeys", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyEntity.kt */
public final class KeyEntity {
    private final List<String> keys;

    public static /* synthetic */ KeyEntity copy$default(KeyEntity keyEntity, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = keyEntity.keys;
        }
        return keyEntity.copy(list);
    }

    public final List<String> component1() {
        return this.keys;
    }

    public final KeyEntity copy(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "keys");
        return new KeyEntity(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KeyEntity) && Intrinsics.areEqual((Object) this.keys, (Object) ((KeyEntity) obj).keys);
    }

    public int hashCode() {
        return this.keys.hashCode();
    }

    public String toString() {
        return "KeyEntity(keys=" + this.keys + ')';
    }

    public KeyEntity(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "keys");
        this.keys = list;
    }

    public final List<String> getKeys() {
        return this.keys;
    }
}
