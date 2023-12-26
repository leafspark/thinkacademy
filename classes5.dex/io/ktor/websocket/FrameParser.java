package io.ktor.websocket;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R$\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u001e\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010$0$0#X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lio/ktor/websocket/FrameParser;", "", "()V", "bodyReady", "", "getBodyReady", "()Z", "<set-?>", "fin", "getFin", "frameType", "Lio/ktor/websocket/FrameType;", "getFrameType", "()Lio/ktor/websocket/FrameType;", "lastOpcode", "", "", "length", "getLength", "()J", "lengthLength", "mask", "getMask", "maskKey", "getMaskKey", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "opcode", "rsv1", "getRsv1", "rsv2", "getRsv2", "rsv3", "getRsv3", "state", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/ktor/websocket/FrameParser$State;", "kotlin.jvm.PlatformType", "bodyComplete", "", "frame", "bb", "Ljava/nio/ByteBuffer;", "handleStep", "parseHeader1", "parseLength", "parseMaskKey", "State", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FrameParser.kt */
public final class FrameParser {
    private boolean fin;
    private int lastOpcode;
    private long length;
    private int lengthLength;
    private boolean mask;
    private Integer maskKey;
    private int opcode;
    private boolean rsv1;
    private boolean rsv2;
    private boolean rsv3;
    private final AtomicReference<State> state = new AtomicReference<>(State.HEADER0);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/websocket/FrameParser$State;", "", "(Ljava/lang/String;I)V", "HEADER0", "LENGTH", "MASK_KEY", "BODY", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FrameParser.kt */
    public enum State {
        HEADER0,
        LENGTH,
        MASK_KEY,
        BODY
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FrameParser.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.HEADER0.ordinal()] = 1;
            iArr[State.LENGTH.ordinal()] = 2;
            iArr[State.MASK_KEY.ordinal()] = 3;
            iArr[State.BODY.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean getFin() {
        return this.fin;
    }

    public final boolean getRsv1() {
        return this.rsv1;
    }

    public final boolean getRsv2() {
        return this.rsv2;
    }

    public final boolean getRsv3() {
        return this.rsv3;
    }

    public final boolean getMask() {
        return this.mask;
    }

    public final long getLength() {
        return this.length;
    }

    public final Integer getMaskKey() {
        return this.maskKey;
    }

    public final FrameType getFrameType() {
        FrameType frameType = FrameType.Companion.get(this.opcode);
        if (frameType != null) {
            return frameType;
        }
        throw new IllegalStateException("Unsupported opcode " + Integer.toHexString(this.opcode));
    }

    public final boolean getBodyReady() {
        return this.state.get() == State.BODY;
    }

    public final void bodyComplete() {
        if (this.state.compareAndSet(State.BODY, State.HEADER0)) {
            this.opcode = 0;
            this.length = 0;
            this.lengthLength = 0;
            this.maskKey = null;
            return;
        }
        throw new IllegalStateException("It should be state BODY but it is " + this.state.get());
    }

    public final void frame(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bb");
        if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
            do {
            } while (handleStep(byteBuffer));
            return;
        }
        throw new IllegalArgumentException(("Buffer order should be BIG_ENDIAN but it is " + byteBuffer.order()).toString());
    }

    private final boolean handleStep(ByteBuffer byteBuffer) {
        State state2 = this.state.get();
        Intrinsics.checkNotNull(state2);
        int i = WhenMappings.$EnumSwitchMapping$0[state2.ordinal()];
        if (i == 1) {
            return parseHeader1(byteBuffer);
        }
        if (i == 2) {
            return parseLength(byteBuffer);
        }
        if (i == 3) {
            return parseMaskKey(byteBuffer);
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean parseHeader1(ByteBuffer byteBuffer) {
        int i = 2;
        if (byteBuffer.remaining() < 2) {
            return false;
        }
        byte b = byteBuffer.get();
        byte b2 = byteBuffer.get();
        this.fin = (b & 128) != 0;
        this.rsv1 = (b & 64) != 0;
        this.rsv2 = (b & 32) != 0;
        this.rsv3 = (b & 16) != 0;
        int i2 = b & 15;
        if (i2 == 0) {
            i2 = this.lastOpcode;
        }
        this.opcode = i2;
        if (!getFrameType().getControlFrame()) {
            this.lastOpcode = this.opcode;
        }
        boolean z = (b2 & 128) != 0;
        this.mask = z;
        byte b3 = b2 & Byte.MAX_VALUE;
        if (b3 != 126) {
            i = b3 != Byte.MAX_VALUE ? 0 : 8;
        }
        this.lengthLength = i;
        this.length = i == 0 ? (long) b3 : 0;
        if (i > 0) {
            this.state.set(State.LENGTH);
        } else if (z) {
            this.state.set(State.MASK_KEY);
        } else {
            this.state.set(State.BODY);
        }
        return true;
    }

    private final boolean parseLength(ByteBuffer byteBuffer) {
        long j;
        int remaining = byteBuffer.remaining();
        int i = this.lengthLength;
        if (remaining < i) {
            return false;
        }
        if (i == 2) {
            j = ((long) byteBuffer.getShort()) & 65535;
        } else if (i == 8) {
            j = byteBuffer.getLong();
        } else {
            throw new IllegalStateException();
        }
        this.length = j;
        this.state.set(this.mask ? State.MASK_KEY : State.BODY);
        return true;
    }

    private final boolean parseMaskKey(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            return false;
        }
        this.maskKey = Integer.valueOf(byteBuffer.getInt());
        this.state.set(State.BODY);
        return true;
    }
}
