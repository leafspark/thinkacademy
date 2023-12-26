package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0007\u001a\u0004\b\u0000\u0010\b\"\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\f\u0012\u0004\b\n\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u001e\u0010\t\u001a\u00020\u0001*\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"isEmpty", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "isEmpty$annotations", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "(Lio/ktor/utils/io/core/ByteReadPacket;)Z", "Lio/ktor/utils/io/core/Input;", "(Lio/ktor/utils/io/core/Input;)V", "(Lio/ktor/utils/io/core/Input;)Z", "isNotEmpty", "isNotEmpty$annotations", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Packet.kt */
public final class PacketKt {
    public static /* synthetic */ void isEmpty$annotations(ByteReadPacket byteReadPacket) {
    }

    @Deprecated(message = "Use endOfInput property instead", replaceWith = @ReplaceWith(expression = "endOfInput", imports = {}))
    public static /* synthetic */ void isEmpty$annotations(Input input) {
    }

    public static /* synthetic */ void isNotEmpty$annotations(ByteReadPacket byteReadPacket) {
    }

    @Deprecated(message = "This makes no sense for streaming inputs. Some use-cases are covered by endOfInput property", replaceWith = @ReplaceWith(expression = "!endOfInput", imports = {}))
    public static /* synthetic */ void isNotEmpty$annotations(Input input) {
    }

    public static final boolean isEmpty(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input.getEndOfInput();
    }

    public static final boolean isNotEmpty(Input input) {
        ChunkBuffer prepareReadFirstHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getEndOfInput() || (prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1)) == null) {
            return false;
        }
        UnsafeKt.completeReadHead(input, prepareReadFirstHead);
        return true;
    }

    public static final boolean isEmpty(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        return byteReadPacket.getEndOfInput();
    }

    public static final boolean isNotEmpty(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        return !byteReadPacket.getEndOfInput();
    }
}
