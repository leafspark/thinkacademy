package io.ktor.utils.io.streams;

import io.agora.rtc.Constants;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0004J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0004¨\u0006\u0007"}, d2 = {"io/ktor/utils/io/streams/ByteArraysKt$ByteArrayPool$1", "Lio/ktor/utils/io/pool/DefaultPool;", "", "produceInstance", "validateInstance", "", "instance", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteArrays.kt */
public final class ByteArraysKt$ByteArrayPool$1 extends DefaultPool<byte[]> {
    /* access modifiers changed from: protected */
    public final byte[] produceInstance() {
        return new byte[4096];
    }

    ByteArraysKt$ByteArrayPool$1() {
        super(Constants.ERR_WATERMARK_ARGB);
    }

    /* access modifiers changed from: protected */
    public final void validateInstance(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "instance");
        if (bArr.length == 4096) {
            super.validateInstance(bArr);
            return;
        }
        throw new IllegalArgumentException(("Unable to recycle buffer of wrong size: " + bArr.length + " != 4096").toString());
    }
}
