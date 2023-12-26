package io.ktor.websocket.internals;

import com.tekartik.sqflite.Constant;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"endsWith", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "data", "", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BytePacketUtils.kt */
public final class BytePacketUtilsKt {
    public static final boolean endsWith(ByteReadPacket byteReadPacket, byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        ByteReadPacket copy = byteReadPacket.copy();
        copy.discard(copy.getRemaining() - ((long) bArr.length));
        return Arrays.equals(StringsKt.readBytes$default(copy, 0, 1, (Object) null), bArr);
    }
}
