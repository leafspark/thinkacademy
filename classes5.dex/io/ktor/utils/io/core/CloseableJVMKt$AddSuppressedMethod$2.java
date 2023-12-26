package io.ktor.utils.io.core;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Method;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloseableJVM.kt */
final class CloseableJVMKt$AddSuppressedMethod$2 extends Lambda implements Function0<Method> {
    public static final CloseableJVMKt$AddSuppressedMethod$2 INSTANCE = new CloseableJVMKt$AddSuppressedMethod$2();

    CloseableJVMKt$AddSuppressedMethod$2() {
        super(0);
    }

    public final Method invoke() {
        try {
            return Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Throwable unused) {
            return null;
        }
    }
}
