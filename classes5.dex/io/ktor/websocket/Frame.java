package io.ktor.websocket;

import com.tekartik.sqflite.Constant;
import io.ktor.util.NIOKt;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \"2\u00020\u0001:\u0006 !\"#$%BG\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u0006\u0010\u001d\u001a\u00020\u0000J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017\u0001\u0005&'()*¨\u0006+"}, d2 = {"Lio/ktor/websocket/Frame;", "", "fin", "", "frameType", "Lio/ktor/websocket/FrameType;", "data", "", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "rsv1", "rsv2", "rsv3", "(ZLio/ktor/websocket/FrameType;[BLkotlinx/coroutines/DisposableHandle;ZZZ)V", "buffer", "Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", "getData", "()[B", "getDisposableHandle", "()Lkotlinx/coroutines/DisposableHandle;", "getFin", "()Z", "getFrameType", "()Lio/ktor/websocket/FrameType;", "getRsv1", "getRsv2", "getRsv3", "copy", "toString", "", "Binary", "Close", "Companion", "Ping", "Pong", "Text", "Lio/ktor/websocket/Frame$Binary;", "Lio/ktor/websocket/Frame$Text;", "Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/Frame$Ping;", "Lio/ktor/websocket/Frame$Pong;", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Frame.kt */
public abstract class Frame {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final byte[] Empty = new byte[0];
    private final ByteBuffer buffer;
    private final byte[] data;
    private final DisposableHandle disposableHandle;
    private final boolean fin;
    private final FrameType frameType;
    private final boolean rsv1;
    private final boolean rsv2;
    private final boolean rsv3;

    public /* synthetic */ Frame(boolean z, FrameType frameType2, byte[] bArr, DisposableHandle disposableHandle2, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, frameType2, bArr, disposableHandle2, z2, z3, z4);
    }

    private Frame(boolean z, FrameType frameType2, byte[] bArr, DisposableHandle disposableHandle2, boolean z2, boolean z3, boolean z4) {
        this.fin = z;
        this.frameType = frameType2;
        this.data = bArr;
        this.disposableHandle = disposableHandle2;
        this.rsv1 = z2;
        this.rsv2 = z3;
        this.rsv3 = z4;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(data)");
        this.buffer = wrap;
    }

    public final boolean getFin() {
        return this.fin;
    }

    public final FrameType getFrameType() {
        return this.frameType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Frame(boolean z, FrameType frameType2, byte[] bArr, DisposableHandle disposableHandle2, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, frameType2, bArr, (i & 8) != 0 ? NonDisposableHandle.INSTANCE : disposableHandle2, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (DefaultConstructorMarker) null);
    }

    public final byte[] getData() {
        return this.data;
    }

    public final DisposableHandle getDisposableHandle() {
        return this.disposableHandle;
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

    public final ByteBuffer getBuffer() {
        return this.buffer;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/websocket/Frame$Binary;", "Lio/ktor/websocket/Frame;", "fin", "", "buffer", "Ljava/nio/ByteBuffer;", "(ZLjava/nio/ByteBuffer;)V", "data", "", "(Z[B)V", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(ZLio/ktor/utils/io/core/ByteReadPacket;)V", "rsv1", "rsv2", "rsv3", "(Z[BZZZ)V", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Frame.kt */
    public static final class Binary extends Frame {
        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Binary(boolean z, byte[] bArr, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, bArr, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, byte[] bArr, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.BINARY, bArr, NonDisposableHandle.INSTANCE, z2, z3, z4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, ByteBuffer byteBuffer) {
            this(z, NIOKt.moveToByteArray(byteBuffer));
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, byte[] bArr) {
            this(z, bArr, false, false, false);
            Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, ByteReadPacket byteReadPacket) {
            this(z, StringsKt.readBytes$default(byteReadPacket, 0, 1, (Object) null));
            Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/Frame$Text;", "Lio/ktor/websocket/Frame;", "fin", "", "data", "", "(Z[B)V", "text", "", "(Ljava/lang/String;)V", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(ZLio/ktor/utils/io/core/ByteReadPacket;)V", "buffer", "Ljava/nio/ByteBuffer;", "(ZLjava/nio/ByteBuffer;)V", "rsv1", "rsv2", "rsv3", "(Z[BZZZ)V", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Frame.kt */
    public static final class Text extends Frame {
        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Text(boolean z, byte[] bArr, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, bArr, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(boolean z, byte[] bArr, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.TEXT, bArr, NonDisposableHandle.INSTANCE, z2, z3, z4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Text(boolean z, byte[] bArr) {
            this(z, bArr, false, false, false);
            Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Text(boolean z, ByteReadPacket byteReadPacket) {
            this(z, StringsKt.readBytes$default(byteReadPacket, 0, 1, (Object) null));
            Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Text(boolean z, ByteBuffer byteBuffer) {
            this(z, NIOKt.moveToByteArray(byteBuffer));
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Text(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = "text"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
                java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r1 == 0) goto L_0x0014
                byte[] r4 = kotlin.text.StringsKt.encodeToByteArray(r4)
                goto L_0x0029
            L_0x0014:
                java.nio.charset.CharsetEncoder r0 = r0.newEncoder()
                java.lang.String r1 = "charset.newEncoder()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r1 = r4
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r2 = 0
                int r4 = r4.length()
                byte[] r4 = io.ktor.utils.io.charsets.CharsetJVMKt.encodeToByteArray(r0, r1, r2, r4)
            L_0x0029:
                r0 = 1
                r3.<init>((boolean) r0, (byte[]) r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.Frame.Text.<init>(java.lang.String):void");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/Frame;", "reason", "Lio/ktor/websocket/CloseReason;", "(Lio/ktor/websocket/CloseReason;)V", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "()V", "buffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "data", "", "([B)V", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Frame.kt */
    public static final class Close extends Frame {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Close(byte[] bArr) {
            super(true, FrameType.CLOSE, bArr, NonDisposableHandle.INSTANCE, false, false, false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Close(ByteReadPacket byteReadPacket) {
            this(StringsKt.readBytes$default(byteReadPacket, 0, 1, (Object) null));
            Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        }

        public Close() {
            this(Frame.Empty);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Close(ByteBuffer byteBuffer) {
            this(NIOKt.moveToByteArray(byteBuffer));
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Close(io.ktor.websocket.CloseReason r11) {
            /*
                r10 = this;
                java.lang.String r0 = "reason"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                io.ktor.utils.io.core.BytePacketBuilder r0 = new io.ktor.utils.io.core.BytePacketBuilder
                r1 = 0
                r2 = 1
                r0.<init>(r1, r2, r1)
                r1 = r0
                io.ktor.utils.io.core.Output r1 = (io.ktor.utils.io.core.Output) r1     // Catch:{ all -> 0x0031 }
                short r2 = r11.getCode()     // Catch:{ all -> 0x0031 }
                io.ktor.utils.io.core.OutputPrimitivesKt.writeShort(r1, r2)     // Catch:{ all -> 0x0031 }
                r3 = r0
                io.ktor.utils.io.core.Output r3 = (io.ktor.utils.io.core.Output) r3     // Catch:{ all -> 0x0031 }
                java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x0031 }
                r4 = r11
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0031 }
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 14
                r9 = 0
                io.ktor.utils.io.core.StringsKt.writeText$default((io.ktor.utils.io.core.Output) r3, (java.lang.CharSequence) r4, (int) r5, (int) r6, (java.nio.charset.Charset) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0031 }
                io.ktor.utils.io.core.ByteReadPacket r11 = r0.build()     // Catch:{ all -> 0x0031 }
                r10.<init>((io.ktor.utils.io.core.ByteReadPacket) r11)
                return
            L_0x0031:
                r11 = move-exception
                r0.release()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.Frame.Close.<init>(io.ktor.websocket.CloseReason):void");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/websocket/Frame$Pong;", "Lio/ktor/websocket/Frame;", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "buffer", "Ljava/nio/ByteBuffer;", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "(Ljava/nio/ByteBuffer;Lkotlinx/coroutines/DisposableHandle;)V", "(Ljava/nio/ByteBuffer;)V", "data", "", "([BLkotlinx/coroutines/DisposableHandle;)V", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Frame.kt */
    public static final class Pong extends Frame {
        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Pong(byte[] bArr, DisposableHandle disposableHandle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, (i & 2) != 0 ? NonDisposableHandle.INSTANCE : disposableHandle);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Pong(byte[] bArr, DisposableHandle disposableHandle) {
            super(true, FrameType.PONG, bArr, disposableHandle, false, false, false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
            Intrinsics.checkNotNullParameter(disposableHandle, "disposableHandle");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Pong(ByteReadPacket byteReadPacket) {
            this(StringsKt.readBytes$default(byteReadPacket, 0, 1, (Object) null), (DisposableHandle) NonDisposableHandle.INSTANCE);
            Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Pong(ByteBuffer byteBuffer, DisposableHandle disposableHandle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(byteBuffer, (i & 2) != 0 ? NonDisposableHandle.INSTANCE : disposableHandle);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Pong(ByteBuffer byteBuffer, DisposableHandle disposableHandle) {
            this(NIOKt.moveToByteArray(byteBuffer), disposableHandle);
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
            Intrinsics.checkNotNullParameter(disposableHandle, "disposableHandle");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Pong(ByteBuffer byteBuffer) {
            this(NIOKt.moveToByteArray(byteBuffer), (DisposableHandle) NonDisposableHandle.INSTANCE);
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/websocket/Frame$Ping;", "Lio/ktor/websocket/Frame;", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "buffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "data", "", "([B)V", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Frame.kt */
    public static final class Ping extends Frame {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ping(byte[] bArr) {
            super(true, FrameType.PING, bArr, NonDisposableHandle.INSTANCE, false, false, false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Ping(ByteReadPacket byteReadPacket) {
            this(StringsKt.readBytes$default(byteReadPacket, 0, 1, (Object) null));
            Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Ping(ByteBuffer byteBuffer) {
            this(NIOKt.moveToByteArray(byteBuffer));
            Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        }
    }

    public String toString() {
        return "Frame " + this.frameType + " (fin=" + this.fin + ", buffer len = " + this.data.length + ')';
    }

    public final Frame copy() {
        Companion companion = Companion;
        boolean z = this.fin;
        FrameType frameType2 = this.frameType;
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return companion.byType(z, frameType2, copyOf, this.rsv1, this.rsv2, this.rsv3);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/Frame$Companion;", "", "()V", "Empty", "", "byType", "Lio/ktor/websocket/Frame;", "fin", "", "frameType", "Lio/ktor/websocket/FrameType;", "data", "rsv1", "rsv2", "rsv3", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Frame.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Frame.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FrameType.values().length];
                iArr[FrameType.BINARY.ordinal()] = 1;
                iArr[FrameType.TEXT.ordinal()] = 2;
                iArr[FrameType.CLOSE.ordinal()] = 3;
                iArr[FrameType.PING.ordinal()] = 4;
                iArr[FrameType.PONG.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Frame byType(boolean z, FrameType frameType, byte[] bArr, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(frameType, "frameType");
            Intrinsics.checkNotNullParameter(bArr, Constant.PARAM_ERROR_DATA);
            int i = WhenMappings.$EnumSwitchMapping$0[frameType.ordinal()];
            if (i == 1) {
                return new Binary(z, bArr, z2, z3, z4);
            }
            if (i == 2) {
                return new Text(z, bArr, z2, z3, z4);
            }
            if (i == 3) {
                return new Close(bArr);
            }
            if (i == 4) {
                return new Ping(bArr);
            }
            if (i == 5) {
                return new Pong(bArr, (DisposableHandle) NonDisposableHandle.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
