package io.ktor.websocket;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.agora.rtc.Constants;
import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0004J \u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\f\u0010!\u001a\u00020\u0004*\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lio/ktor/websocket/Serializer;", "", "()V", "frameBody", "Ljava/nio/ByteBuffer;", "hasOutstandingBytes", "", "getHasOutstandingBytes", "()Z", "maskBuffer", "masking", "getMasking", "setMasking", "(Z)V", "messages", "Ljava/util/concurrent/ArrayBlockingQueue;", "Lio/ktor/websocket/Frame;", "remainingCapacity", "", "getRemainingCapacity", "()I", "enqueue", "", "f", "estimateFrameHeaderSize", "mask", "maskSize", "serialize", "buffer", "serializeHeader", "frame", "setMaskBuffer", "writeCurrentPayload", "maskedIfNeeded", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Serializer.kt */
public final class Serializer {
    private ByteBuffer frameBody;
    private ByteBuffer maskBuffer;
    private boolean masking;
    private final ArrayBlockingQueue<Frame> messages = new ArrayBlockingQueue<>(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);

    private final int maskSize(boolean z) {
        return z ? 4 : 0;
    }

    public final boolean getMasking() {
        return this.masking;
    }

    public final void setMasking(boolean z) {
        this.masking = z;
    }

    public final boolean getHasOutstandingBytes() {
        return (this.messages.isEmpty() ^ true) || this.frameBody != null;
    }

    public final int getRemainingCapacity() {
        return this.messages.remainingCapacity();
    }

    public final void enqueue(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "f");
        this.messages.put(frame);
    }

    public final void serialize(ByteBuffer byteBuffer) {
        Frame peek;
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        while (writeCurrentPayload(byteBuffer) && (peek = this.messages.peek()) != null) {
            boolean z = this.masking;
            setMaskBuffer(z);
            if (byteBuffer.remaining() >= estimateFrameHeaderSize(peek, z)) {
                serializeHeader(peek, byteBuffer, z);
                this.messages.remove();
                this.frameBody = maskedIfNeeded(peek.getBuffer());
            } else {
                return;
            }
        }
    }

    private final void serializeHeader(Frame frame, ByteBuffer byteBuffer, boolean z) {
        ByteBuffer duplicate;
        int remaining = frame.getBuffer().remaining();
        if (remaining >= 126) {
            remaining = remaining <= 65535 ? 126 : 127;
        }
        boolean fin = frame.getFin();
        int i = Constants.ERR_WATERMARK_ARGB;
        byteBuffer.put((byte) ((fin ? 128 : 0) | (frame.getRsv1() ? 64 : 0) | (frame.getRsv2() ? 32 : 0) | (frame.getRsv3() ? 16 : 0) | frame.getFrameType().getOpcode()));
        if (!z) {
            i = 0;
        }
        byteBuffer.put((byte) (i | remaining));
        if (remaining == 126) {
            byteBuffer.putShort((short) frame.getBuffer().remaining());
        } else if (remaining == 127) {
            byteBuffer.putLong((long) frame.getBuffer().remaining());
        }
        ByteBuffer byteBuffer2 = this.maskBuffer;
        if (byteBuffer2 != null && (duplicate = byteBuffer2.duplicate()) != null) {
            NIOKt.moveTo$default(duplicate, byteBuffer, 0, 2, (Object) null);
        }
    }

    private final int estimateFrameHeaderSize(Frame frame, boolean z) {
        int remaining = frame.getBuffer().remaining();
        return (remaining < 126 ? 2 : remaining <= 32767 ? 4 : 10) + maskSize(z);
    }

    private final boolean writeCurrentPayload(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.frameBody;
        if (byteBuffer2 == null) {
            return true;
        }
        NIOKt.moveTo$default(byteBuffer2, byteBuffer, 0, 2, (Object) null);
        if (byteBuffer2.hasRemaining()) {
            return false;
        }
        this.frameBody = null;
        return true;
    }

    private final ByteBuffer maskedIfNeeded(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.maskBuffer;
        if (byteBuffer2 == null) {
            return byteBuffer;
        }
        ByteBuffer copy$default = NIOKt.copy$default(byteBuffer, 0, 1, (Object) null);
        UtilsKt.xor(copy$default, byteBuffer2);
        return copy$default == null ? byteBuffer : copy$default;
    }

    private final void setMaskBuffer(boolean z) {
        if (z) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(Random.Default.nextInt());
            allocate.clear();
            this.maskBuffer = allocate;
            return;
        }
        this.maskBuffer = null;
    }
}
