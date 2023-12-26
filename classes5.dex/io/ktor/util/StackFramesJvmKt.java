package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000*\f\b\u0000\u0010\n\"\u00020\u000b2\u00020\u000b*\f\b\u0000\u0010\f\"\u00020\u00012\u00020\u0001¨\u0006\r"}, d2 = {"createStackTraceElement", "Ljava/lang/StackTraceElement;", "Lio/ktor/util/StackTraceElement;", "kClass", "Lkotlin/reflect/KClass;", "methodName", "", "fileName", "lineNumber", "", "CoroutineStackFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "StackTraceElement", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StackFramesJvm.kt */
public final class StackFramesJvmKt {
    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    public static final StackTraceElement createStackTraceElement(KClass<?> kClass, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        return new StackTraceElement(JvmClassMappingKt.getJavaClass(kClass).getName(), str, str2, i);
    }
}
