package io.ktor.utils.io.core;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0001\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018BX\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003*\n\u0010\n\"\u00020\u000b2\u00020\u000b¨\u0006\f"}, d2 = {"AddSuppressedMethod", "Ljava/lang/reflect/Method;", "getAddSuppressedMethod", "()Ljava/lang/reflect/Method;", "AddSuppressedMethod$delegate", "Lkotlin/Lazy;", "addSuppressedInternal", "", "", "other", "Closeable", "Ljava/io/Closeable;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloseableJVM.kt */
public final class CloseableJVMKt {
    private static final Lazy AddSuppressedMethod$delegate = LazyKt.lazy(CloseableJVMKt$AddSuppressedMethod$2.INSTANCE);

    public static final void addSuppressedInternal(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(th2, "other");
        Method addSuppressedMethod = getAddSuppressedMethod();
        if (addSuppressedMethod != null) {
            addSuppressedMethod.invoke(th, new Object[]{th2});
        }
    }

    private static final Method getAddSuppressedMethod() {
        return (Method) AddSuppressedMethod$delegate.getValue();
    }
}
