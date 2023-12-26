package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lio/ktor/util/Encoder;", "", "decode", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CoroutineScope;", "source", "encode", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Encoders.kt */
public interface Encoder {
    ByteReadChannel decode(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel);

    ByteReadChannel encode(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel);
}
