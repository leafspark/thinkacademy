package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lio/ktor/util/Identity;", "Lio/ktor/util/Encoder;", "()V", "decode", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CoroutineScope;", "source", "encode", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Encoders.kt */
public final class Identity implements Encoder {
    public static final Identity INSTANCE = new Identity();

    public ByteReadChannel decode(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(byteReadChannel, "source");
        return byteReadChannel;
    }

    public ByteReadChannel encode(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(byteReadChannel, "source");
        return byteReadChannel;
    }

    private Identity() {
    }
}
