package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/websocket/FrameType;", "", "controlFrame", "", "opcode", "", "(Ljava/lang/String;IZI)V", "getControlFrame", "()Z", "getOpcode", "()I", "TEXT", "BINARY", "CLOSE", "PING", "PONG", "Companion", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FrameType.kt */
public enum FrameType {
    TEXT(false, 1),
    BINARY(false, 2),
    CLOSE(true, 8),
    PING(true, 9),
    PONG(true, 10);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final FrameType[] byOpcodeArray = null;
    /* access modifiers changed from: private */
    public static final int maxOpcode = 0;
    private final boolean controlFrame;
    private final int opcode;

    private FrameType(boolean z, int i) {
        this.controlFrame = z;
        this.opcode = i;
    }

    public final boolean getControlFrame() {
        return this.controlFrame;
    }

    public final int getOpcode() {
        return this.opcode;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        r10 = null;
     */
    static {
        /*
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "TEXT"
            r2 = 0
            r3 = 1
            r0.<init>(r1, r2, r2, r3)
            TEXT = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "BINARY"
            r4 = 2
            r0.<init>(r1, r3, r2, r4)
            BINARY = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "CLOSE"
            r5 = 8
            r0.<init>(r1, r4, r3, r5)
            CLOSE = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "PING"
            r4 = 3
            r5 = 9
            r0.<init>(r1, r4, r3, r5)
            PING = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "PONG"
            r4 = 4
            r5 = 10
            r0.<init>(r1, r4, r3, r5)
            PONG = r0
            io.ktor.websocket.FrameType[] r0 = $values()
            $VALUES = r0
            io.ktor.websocket.FrameType$Companion r0 = new io.ktor.websocket.FrameType$Companion
            r1 = 0
            r0.<init>(r1)
            Companion = r0
            io.ktor.websocket.FrameType[] r0 = values()
            int r4 = r0.length
            if (r4 != 0) goto L_0x004f
            r4 = r3
            goto L_0x0050
        L_0x004f:
            r4 = r2
        L_0x0050:
            if (r4 == 0) goto L_0x0054
            r4 = r1
            goto L_0x006f
        L_0x0054:
            r4 = r0[r2]
            int r5 = kotlin.collections.ArraysKt.getLastIndex(r0)
            if (r5 != 0) goto L_0x005d
            goto L_0x006f
        L_0x005d:
            int r6 = r4.opcode
            if (r3 > r5) goto L_0x006f
            r7 = r3
        L_0x0062:
            r8 = r0[r7]
            int r9 = r8.opcode
            if (r6 >= r9) goto L_0x006a
            r4 = r8
            r6 = r9
        L_0x006a:
            if (r7 == r5) goto L_0x006f
            int r7 = r7 + 1
            goto L_0x0062
        L_0x006f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r0 = r4.opcode
            maxOpcode = r0
            int r0 = r0 + r3
            io.ktor.websocket.FrameType[] r4 = new io.ktor.websocket.FrameType[r0]
            r5 = r2
        L_0x007a:
            if (r5 >= r0) goto L_0x00a1
            io.ktor.websocket.FrameType[] r6 = values()
            int r7 = r6.length
            r10 = r1
            r8 = r2
            r9 = r8
        L_0x0084:
            if (r8 >= r7) goto L_0x0099
            r11 = r6[r8]
            int r12 = r11.opcode
            if (r12 != r5) goto L_0x008e
            r12 = r3
            goto L_0x008f
        L_0x008e:
            r12 = r2
        L_0x008f:
            if (r12 == 0) goto L_0x0096
            if (r9 == 0) goto L_0x0094
            goto L_0x009b
        L_0x0094:
            r9 = r3
            r10 = r11
        L_0x0096:
            int r8 = r8 + 1
            goto L_0x0084
        L_0x0099:
            if (r9 != 0) goto L_0x009c
        L_0x009b:
            r10 = r1
        L_0x009c:
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x007a
        L_0x00a1:
            byOpcodeArray = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.FrameType.<clinit>():void");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\bH\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/ktor/websocket/FrameType$Companion;", "", "()V", "byOpcodeArray", "", "Lio/ktor/websocket/FrameType;", "[Lio/ktor/websocket/FrameType;", "maxOpcode", "", "get", "opcode", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FrameType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FrameType get(int i) {
            boolean z = false;
            if (i >= 0 && i <= FrameType.maxOpcode) {
                z = true;
            }
            if (z) {
                return FrameType.byOpcodeArray[i];
            }
            return null;
        }
    }
}
