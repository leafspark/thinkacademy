package io.ktor.utils.io.streams;

import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"ByteArrayPool", "Lio/ktor/utils/io/pool/DefaultPool;", "", "getByteArrayPool", "()Lio/ktor/utils/io/pool/DefaultPool;", "ByteArrayPoolBufferSize", "", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteArrays.kt */
public final class ByteArraysKt {
    private static final DefaultPool<byte[]> ByteArrayPool = new ByteArraysKt$ByteArrayPool$1();
    public static final int ByteArrayPoolBufferSize = 4096;

    public static final DefaultPool<byte[]> getByteArrayPool() {
        return ByteArrayPool;
    }
}
