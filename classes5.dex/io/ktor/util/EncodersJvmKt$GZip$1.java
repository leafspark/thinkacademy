package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"io/ktor/util/EncodersJvmKt$GZip$1", "Lio/ktor/util/Encoder;", "decode", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CoroutineScope;", "source", "encode", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EncodersJvm.kt */
public final class EncodersJvmKt$GZip$1 implements Encoder {
    EncodersJvmKt$GZip$1() {
    }

    public ByteReadChannel encode(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(byteReadChannel, "source");
        return DeflaterKt.deflated$default(byteReadChannel, true, (ObjectPool) null, coroutineScope.getCoroutineContext(), 2, (Object) null);
    }

    public ByteReadChannel decode(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(byteReadChannel, "source");
        return EncodersJvmKt.inflate$default(coroutineScope, byteReadChannel, false, 2, (Object) null);
    }
}
