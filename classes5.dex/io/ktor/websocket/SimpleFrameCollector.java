package io.ktor.websocket;

import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u0015\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/ktor/websocket/SimpleFrameCollector;", "", "()V", "buffer", "Ljava/nio/ByteBuffer;", "hasRemaining", "", "getHasRemaining", "()Z", "maskBuffer", "kotlin.jvm.PlatformType", "remaining", "", "handle", "", "bb", "start", "length", "take", "maskKey", "(Ljava/lang/Integer;)Ljava/nio/ByteBuffer;", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleFrameCollector.kt */
public final class SimpleFrameCollector {
    private ByteBuffer buffer;
    private final ByteBuffer maskBuffer = ByteBuffer.allocate(4);
    private int remaining;

    public final boolean getHasRemaining() {
        return this.remaining > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r0.capacity() < r2) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start(int r2, java.nio.ByteBuffer r3) {
        /*
            r1 = this;
            java.lang.String r0 = "bb"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = r1.remaining
            if (r0 != 0) goto L_0x000b
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 == 0) goto L_0x002f
            r1.remaining = r2
            java.nio.ByteBuffer r0 = r1.buffer
            if (r0 == 0) goto L_0x001d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.capacity()
            if (r0 >= r2) goto L_0x0023
        L_0x001d:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)
            r1.buffer = r2
        L_0x0023:
            java.nio.ByteBuffer r2 = r1.buffer
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r2.clear()
            r1.handle(r3)
            return
        L_0x002f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "remaining should be 0"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.SimpleFrameCollector.start(int, java.nio.ByteBuffer):void");
    }

    public final void handle(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bb");
        int i = this.remaining;
        ByteBuffer byteBuffer2 = this.buffer;
        Intrinsics.checkNotNull(byteBuffer2);
        this.remaining = i - NIOKt.moveTo(byteBuffer, byteBuffer2, this.remaining);
    }

    public final ByteBuffer take(Integer num) {
        ByteBuffer byteBuffer = this.buffer;
        Intrinsics.checkNotNull(byteBuffer);
        byteBuffer.flip();
        ByteBuffer slice = byteBuffer.slice();
        if (num != null) {
            this.maskBuffer.clear();
            this.maskBuffer.asIntBuffer().put(num.intValue());
            this.maskBuffer.clear();
            Intrinsics.checkNotNullExpressionValue(slice, "view");
            ByteBuffer byteBuffer2 = this.maskBuffer;
            Intrinsics.checkNotNullExpressionValue(byteBuffer2, "maskBuffer");
            UtilsKt.xor(slice, byteBuffer2);
        }
        this.buffer = null;
        ByteBuffer asReadOnlyBuffer = slice.asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "buffer!!.run {\n        f….asReadOnlyBuffer()\n    }");
        return asReadOnlyBuffer;
    }
}
