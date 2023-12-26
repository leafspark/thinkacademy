package io.ktor.websocket;

import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.pool.ObjectPool;
import io.ktor.websocket.Frame;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, d2 = {"readBytes", "", "Lio/ktor/websocket/Frame;", "readReason", "Lio/ktor/websocket/CloseReason;", "Lio/ktor/websocket/Frame$Close;", "readText", "", "Lio/ktor/websocket/Frame$Text;", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FrameCommon.kt */
public final class FrameCommonKt {
    public static final String readText(Frame.Text text) {
        Intrinsics.checkNotNullParameter(text, "<this>");
        if (text.getFin()) {
            CharsetDecoder newDecoder = Charsets.UTF_8.newDecoder();
            Intrinsics.checkNotNullExpressionValue(newDecoder, "UTF_8.newDecoder()");
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
            try {
                OutputKt.writeFully$default((Output) bytePacketBuilder, text.getData(), 0, 0, 6, (Object) null);
                return EncodingKt.decode$default(newDecoder, bytePacketBuilder.build(), 0, 2, (Object) null);
            } catch (Throwable th) {
                bytePacketBuilder.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Text could be only extracted from non-fragmented frame".toString());
        }
    }

    public static final byte[] readBytes(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "<this>");
        byte[] data = frame.getData();
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public static final CloseReason readReason(Frame.Close close) {
        Intrinsics.checkNotNullParameter(close, "<this>");
        if (close.getData().length < 2) {
            return null;
        }
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            OutputKt.writeFully$default((Output) bytePacketBuilder, close.getData(), 0, 0, 6, (Object) null);
            Input build = bytePacketBuilder.build();
            return new CloseReason(InputPrimitivesKt.readShort(build), Input.readText$default(build, 0, 0, 3, (Object) null));
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
