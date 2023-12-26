package io.ktor.utils.io.concurrent;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a,\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\tH\u0007\u001a-\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"shared", "Lkotlin/properties/ReadWriteProperty;", "", "T", "value", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "sharedLazy", "Lkotlin/properties/ReadOnlyProperty;", "function", "Lkotlin/Function0;", "threadLocal", "(Ljava/lang/Object;)Lkotlin/properties/ReadOnlyProperty;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Shared.kt */
public final class SharedKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Is obsolete in new memory model.")
    public static final <T> ReadWriteProperty<Object, T> shared(T t) {
        throw new IllegalStateException("Obsolete in new memory model".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Is obsolete in new memory model.")
    public static final <T> ReadOnlyProperty<Object, T> threadLocal(T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        throw new IllegalStateException("Obsolete in new memory model".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Is obsolete in new memory model.")
    public static final <T> ReadOnlyProperty<Object, T> sharedLazy(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "function");
        throw new IllegalStateException("Obsolete in new memory model".toString());
    }
}
