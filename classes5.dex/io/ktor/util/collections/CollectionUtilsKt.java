package io.ktor.util.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0007\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u0006\"\u0002H\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a2\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b\"\b\b\u0001\u0010\u0002*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"sharedList", "", "V", "sharedListOf", "T", "values", "", "([Ljava/lang/Object;)Ljava/util/List;", "sharedMap", "", "K", "", "initialCapacity", "", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionUtils.kt */
public final class CollectionUtilsKt {
    @Deprecated(message = "Will be dropped with new memory model enabled by default", replaceWith = @ReplaceWith(expression = "mutableListOf(values)", imports = {}))
    public static final <T> List<T> sharedListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "values");
        return CollectionsKt.mutableListOf(Arrays.copyOf(tArr, tArr.length));
    }

    @Deprecated(message = "Will be dropped with new memory model enabled by default", replaceWith = @ReplaceWith(expression = "mutableMapOf()", imports = {}))
    public static final <K, V> Map<K, V> sharedMap(int i) {
        return new LinkedHashMap<>(i);
    }

    public static /* synthetic */ Map sharedMap$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8;
        }
        return sharedMap(i);
    }

    @Deprecated(message = "Will be dropped with new memory model enabled by default", replaceWith = @ReplaceWith(expression = "mutableListOf<V>()", imports = {}))
    public static final <V> List<V> sharedList() {
        return new ArrayList<>();
    }
}
