package io.ktor.util;

import io.ktor.utils.io.core.Input;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"asStream", "Ljava/io/InputStream;", "Lio/ktor/utils/io/core/Input;", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputJvm.kt */
public final class InputJvmKt {
    public static final InputStream asStream(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return new InputJvmKt$asStream$1(input);
    }
}
