package io.ktor.utils.io.core;

import java.nio.ByteOrder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"orderOf", "Lio/ktor/utils/io/core/ByteOrder;", "nioOrder", "Ljava/nio/ByteOrder;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteOrderJVM.kt */
public final class ByteOrderJVMKt {
    /* access modifiers changed from: private */
    public static final ByteOrder orderOf(ByteOrder byteOrder) {
        return byteOrder == ByteOrder.BIG_ENDIAN ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
    }
}
