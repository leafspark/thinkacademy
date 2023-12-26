package io.ktor.util;

import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\u0003"}, d2 = {"unmodifiable", "", "T", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionsJvm.kt */
public final class CollectionsJvmKt {
    public static final <T> Set<T> unmodifiable(Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Set<T> unmodifiableSet = Collections.unmodifiableSet(set);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(this)");
        return unmodifiableSet;
    }
}
