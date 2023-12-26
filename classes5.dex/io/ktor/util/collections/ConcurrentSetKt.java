package io.ktor.util.collections;

import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003¨\u0006\u0004"}, d2 = {"ConcurrentSet", "", "Key", "", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConcurrentSet.kt */
public final class ConcurrentSetKt {
    public static final <Key> Set<Key> ConcurrentSet() {
        return new ConcurrentSetKt$ConcurrentSet$1();
    }
}
