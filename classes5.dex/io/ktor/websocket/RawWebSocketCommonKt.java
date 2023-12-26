package io.ktor.websocket;

import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a%\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"mask", "Lio/ktor/utils/io/core/ByteReadPacket;", "maskKey", "", "readFrame", "Lio/ktor/websocket/Frame;", "Lio/ktor/utils/io/ByteReadChannel;", "maxFrameSize", "", "lastOpcode", "(Lio/ktor/utils/io/ByteReadChannel;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFrame", "", "Lio/ktor/utils/io/ByteWriteChannel;", "frame", "masking", "", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/websocket/Frame;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RawWebSocketCommon.kt */
public final class RawWebSocketCommonKt {
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if (r11 >= 126) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d1, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d6, code lost:
        if (r11 > 65535) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d8, code lost:
        r2 = 126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00da, code lost:
        r2 = 127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00db, code lost:
        if (r13 == false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00de, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00df, code lost:
        r0.L$0 = r10;
        r0.L$1 = r12;
        r0.Z$0 = r13;
        r0.I$0 = r11;
        r0.I$1 = r2;
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f2, code lost:
        if (r10.writeByte((byte) (r5 | r2), r0) != r1) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f5, code lost:
        r5 = r10;
        r10 = r2;
        r2 = r12;
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f9, code lost:
        if (r10 == 126) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fb, code lost:
        if (r10 == 127) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fe, code lost:
        r0.L$0 = r5;
        r0.L$1 = r2;
        r0.Z$0 = r12;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010c, code lost:
        if (r5.writeLong((long) r11, r0) != r1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010f, code lost:
        r0.L$0 = r5;
        r0.L$1 = r2;
        r0.Z$0 = r12;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011d, code lost:
        if (r5.writeShort((short) r11, r0) != r1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0120, code lost:
        r10 = r12;
        r11 = r2;
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0123, code lost:
        r2 = r11;
        r5 = r12;
        r12 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0126, code lost:
        r10 = r2.getData();
        r11 = java.nio.ByteBuffer.wrap(r10, 0, r10.length);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "wrap(array, offset, length)");
        r11 = io.ktor.utils.io.core.ByteReadPacketExtensionsKt.ByteReadPacket(r11, new io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013f, code lost:
        if (r12 != true) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0141, code lost:
        r10 = kotlin.random.Random.Default.nextInt();
        r0.L$0 = r5;
        r0.L$1 = r11;
        r0.I$0 = r10;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0154, code lost:
        if (r5.writeInt(r10, r0) != r1) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0156, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0157, code lost:
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0158, code lost:
        r11 = mask(r11, r10);
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015e, code lost:
        if (r12 != false) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0160, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016c, code lost:
        if (r5.writePacket(r11, r0) != r1) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x016e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0171, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0177, code lost:
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    @io.ktor.util.InternalAPI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object writeFrame(io.ktor.utils.io.ByteWriteChannel r10, io.ktor.websocket.Frame r11, boolean r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            boolean r0 = r13 instanceof io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1 r0 = (io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1 r0 = new io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1
            r0.<init>(r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 127(0x7f, float:1.78E-43)
            r5 = 128(0x80, float:1.794E-43)
            r6 = 126(0x7e, float:1.77E-43)
            r7 = 0
            switch(r2) {
                case 0: goto L_0x007e;
                case 1: goto L_0x006a;
                case 2: goto L_0x0057;
                case 3: goto L_0x0048;
                case 4: goto L_0x0048;
                case 5: goto L_0x0039;
                case 6: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x016f
        L_0x0039:
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            io.ktor.utils.io.core.ByteReadPacket r11 = (io.ktor.utils.io.core.ByteReadPacket) r11
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r12 = (io.ktor.utils.io.ByteWriteChannel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0158
        L_0x0048:
            boolean r10 = r0.Z$0
            java.lang.Object r11 = r0.L$1
            io.ktor.websocket.Frame r11 = (io.ktor.websocket.Frame) r11
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r12 = (io.ktor.utils.io.ByteWriteChannel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0123
        L_0x0057:
            int r10 = r0.I$1
            int r11 = r0.I$0
            boolean r12 = r0.Z$0
            java.lang.Object r2 = r0.L$1
            io.ktor.websocket.Frame r2 = (io.ktor.websocket.Frame) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00f9
        L_0x006a:
            int r10 = r0.I$0
            boolean r12 = r0.Z$0
            java.lang.Object r11 = r0.L$1
            io.ktor.websocket.Frame r11 = (io.ktor.websocket.Frame) r11
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r2
            goto L_0x00cf
        L_0x007e:
            kotlin.ResultKt.throwOnFailure(r13)
            byte[] r13 = r11.getData()
            int r13 = r13.length
            boolean r2 = r11.getFin()
            if (r2 == 0) goto L_0x008e
            r2 = r5
            goto L_0x008f
        L_0x008e:
            r2 = r7
        L_0x008f:
            boolean r8 = r11.getRsv1()
            if (r8 == 0) goto L_0x0098
            r8 = 64
            goto L_0x0099
        L_0x0098:
            r8 = r7
        L_0x0099:
            r2 = r2 | r8
            boolean r8 = r11.getRsv2()
            if (r8 == 0) goto L_0x00a3
            r8 = 32
            goto L_0x00a4
        L_0x00a3:
            r8 = r7
        L_0x00a4:
            r2 = r2 | r8
            boolean r8 = r11.getRsv3()
            if (r8 == 0) goto L_0x00ae
            r8 = 16
            goto L_0x00af
        L_0x00ae:
            r8 = r7
        L_0x00af:
            r2 = r2 | r8
            io.ktor.websocket.FrameType r8 = r11.getFrameType()
            int r8 = r8.getOpcode()
            r2 = r2 | r8
            byte r2 = (byte) r2
            r0.L$0 = r10
            r0.L$1 = r11
            r0.Z$0 = r12
            r0.I$0 = r13
            r0.label = r3
            java.lang.Object r2 = r10.writeByte(r2, r0)
            if (r2 != r1) goto L_0x00cb
            return r1
        L_0x00cb:
            r9 = r12
            r12 = r11
            r11 = r13
            r13 = r9
        L_0x00cf:
            if (r11 >= r6) goto L_0x00d3
            r2 = r11
            goto L_0x00db
        L_0x00d3:
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r11 > r2) goto L_0x00da
            r2 = r6
            goto L_0x00db
        L_0x00da:
            r2 = r4
        L_0x00db:
            if (r13 == 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r5 = r7
        L_0x00df:
            r5 = r5 | r2
            byte r5 = (byte) r5
            r0.L$0 = r10
            r0.L$1 = r12
            r0.Z$0 = r13
            r0.I$0 = r11
            r0.I$1 = r2
            r8 = 2
            r0.label = r8
            java.lang.Object r5 = r10.writeByte(r5, r0)
            if (r5 != r1) goto L_0x00f5
            return r1
        L_0x00f5:
            r5 = r10
            r10 = r2
            r2 = r12
            r12 = r13
        L_0x00f9:
            if (r10 == r6) goto L_0x010f
            if (r10 == r4) goto L_0x00fe
            goto L_0x0126
        L_0x00fe:
            long r10 = (long) r11
            r0.L$0 = r5
            r0.L$1 = r2
            r0.Z$0 = r12
            r13 = 4
            r0.label = r13
            java.lang.Object r10 = r5.writeLong(r10, r0)
            if (r10 != r1) goto L_0x0120
            return r1
        L_0x010f:
            short r10 = (short) r11
            r0.L$0 = r5
            r0.L$1 = r2
            r0.Z$0 = r12
            r11 = 3
            r0.label = r11
            java.lang.Object r10 = r5.writeShort(r10, r0)
            if (r10 != r1) goto L_0x0120
            return r1
        L_0x0120:
            r10 = r12
            r11 = r2
            r12 = r5
        L_0x0123:
            r2 = r11
            r5 = r12
            r12 = r10
        L_0x0126:
            byte[] r10 = r2.getData()
            int r11 = r10.length
            java.nio.ByteBuffer r11 = java.nio.ByteBuffer.wrap(r10, r7, r11)
            java.lang.String r13 = "wrap(array, offset, length)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1 r13 = new io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
            r13.<init>(r10)
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            io.ktor.utils.io.core.ByteReadPacket r11 = io.ktor.utils.io.core.ByteReadPacketExtensionsKt.ByteReadPacket(r11, r13)
            if (r12 != r3) goto L_0x015e
            kotlin.random.Random$Default r10 = kotlin.random.Random.Default
            int r10 = r10.nextInt()
            r0.L$0 = r5
            r0.L$1 = r11
            r0.I$0 = r10
            r12 = 5
            r0.label = r12
            java.lang.Object r12 = r5.writeInt(r10, r0)
            if (r12 != r1) goto L_0x0157
            return r1
        L_0x0157:
            r12 = r5
        L_0x0158:
            io.ktor.utils.io.core.ByteReadPacket r11 = mask(r11, r10)
            r5 = r12
            goto L_0x0160
        L_0x015e:
            if (r12 != 0) goto L_0x0172
        L_0x0160:
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r10 = 6
            r0.label = r10
            java.lang.Object r10 = r5.writePacket(r11, r0)
            if (r10 != r1) goto L_0x016f
            return r1
        L_0x016f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0172:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.writeFrame(io.ktor.utils.io.ByteWriteChannel, io.ktor.websocket.Frame, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ac, code lost:
        r4 = ((java.lang.Number) r4).byteValue();
        r2.L$0 = r0;
        r2.J$0 = r9;
        r2.I$0 = r1;
        r2.B$0 = r4;
        r2.label = 2;
        r11 = r0.readByte(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c1, code lost:
        if (r11 != r3) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c3, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c4, code lost:
        r12 = r0;
        r17 = r9;
        r9 = r1;
        r1 = r11;
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cb, code lost:
        r0 = ((java.lang.Number) r1).byteValue();
        r1 = r0 & Byte.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d5, code lost:
        if (r1 == 126) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d9, code lost:
        if (r1 == Byte.MAX_VALUE) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00db, code lost:
        r13 = (long) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00dd, code lost:
        r2.L$0 = r12;
        r2.J$0 = r10;
        r2.I$0 = r9;
        r2.B$0 = r4;
        r2.B$1 = r0;
        r2.label = 4;
        r1 = r12.readLong(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ee, code lost:
        if (r1 != r3) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f0, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f1, code lost:
        r13 = ((java.lang.Number) r1).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f8, code lost:
        r2.L$0 = r12;
        r2.J$0 = r10;
        r2.I$0 = r9;
        r2.B$0 = r4;
        r2.B$1 = r0;
        r2.label = 3;
        r1 = r12.readShort(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0109, code lost:
        if (r1 != r3) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x010b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010c, code lost:
        r13 = ((long) ((java.lang.Number) r1).shortValue()) & 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0117, code lost:
        r1 = r12;
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x011b, code lost:
        if ((r0 & 128) == 0) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x011d, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011f, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0120, code lost:
        if (r0 != true) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0122, code lost:
        r2.L$0 = r1;
        r2.J$0 = r11;
        r2.I$0 = r9;
        r2.B$0 = r4;
        r2.J$1 = r13;
        r2.label = 5;
        r0 = r1.readInt(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0133, code lost:
        if (r0 != r3) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0135, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0136, code lost:
        r17 = r1;
        r1 = r0;
        r0 = r4;
        r4 = r9;
        r9 = r13;
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x013e, code lost:
        r17 = r9;
        r9 = r0;
        r0 = ((java.lang.Number) r1).intValue();
        r1 = r13;
        r13 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x014c, code lost:
        if (r0 != false) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x014e, code lost:
        r0 = -1;
        r17 = r9;
        r9 = r4;
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0159, code lost:
        if (r13 > 2147483647L) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015d, code lost:
        if (r13 > r11) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015f, code lost:
        r2.L$0 = null;
        r2.I$0 = r4;
        r2.B$0 = r9;
        r2.I$1 = r0;
        r2.label = 6;
        r1 = r1.readPacket((int) r13, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x016f, code lost:
        if (r1 != r3) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0171, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0172, code lost:
        r2 = r4;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0174, code lost:
        r1 = (io.ktor.utils.io.core.ByteReadPacket) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0176, code lost:
        if (r0 != -1) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0179, code lost:
        r1 = mask(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x017d, code lost:
        r0 = r3 & 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x017f, code lost:
        if (r0 != 0) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0182, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0183, code lost:
        r11 = io.ktor.websocket.FrameType.Companion.get(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0189, code lost:
        if (r11 == null) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x018b, code lost:
        r9 = io.ktor.websocket.Frame.Companion;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x018f, code lost:
        if ((r3 & 128) == 0) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0191, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0193, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0194, code lost:
        r12 = io.ktor.utils.io.core.StringsKt.readBytes$default(r1, 0, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x019a, code lost:
        if ((r3 & 64) == 0) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x019c, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x019e, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01a1, code lost:
        if ((r3 & 32) == 0) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a3, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01a5, code lost:
        r14 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a8, code lost:
        if ((r3 & 16) == 0) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01aa, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ac, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b1, code lost:
        return r9.byType(r10, r11, r12, r13, r14, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c8, code lost:
        throw new java.lang.IllegalStateException("Unsupported opcode: " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ce, code lost:
        throw new io.ktor.websocket.FrameTooBigException(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d4, code lost:
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    @io.ktor.util.InternalAPI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readFrame(io.ktor.utils.io.ByteReadChannel r19, long r20, int r22, kotlin.coroutines.Continuation<? super io.ktor.websocket.Frame> r23) {
        /*
            r0 = r19
            r1 = r23
            boolean r2 = r1 instanceof io.ktor.websocket.RawWebSocketCommonKt$readFrame$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.ktor.websocket.RawWebSocketCommonKt$readFrame$1 r2 = (io.ktor.websocket.RawWebSocketCommonKt$readFrame$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.ktor.websocket.RawWebSocketCommonKt$readFrame$1 r2 = new io.ktor.websocket.RawWebSocketCommonKt$readFrame$1
            r2.<init>(r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = -1
            r7 = 0
            r8 = 1
            switch(r4) {
                case 0: goto L_0x0096;
                case 1: goto L_0x0084;
                case 2: goto L_0x0072;
                case 3: goto L_0x0061;
                case 4: goto L_0x0050;
                case 5: goto L_0x003f;
                case 6: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            int r0 = r2.I$1
            byte r3 = r2.B$0
            int r2 = r2.I$0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0174
        L_0x003f:
            long r9 = r2.J$1
            byte r0 = r2.B$0
            int r4 = r2.I$0
            long r11 = r2.J$0
            java.lang.Object r13 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x013e
        L_0x0050:
            byte r0 = r2.B$1
            byte r4 = r2.B$0
            int r9 = r2.I$0
            long r10 = r2.J$0
            java.lang.Object r12 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00f1
        L_0x0061:
            byte r0 = r2.B$1
            byte r4 = r2.B$0
            int r9 = r2.I$0
            long r10 = r2.J$0
            java.lang.Object r12 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x010c
        L_0x0072:
            byte r0 = r2.B$0
            int r4 = r2.I$0
            long r9 = r2.J$0
            java.lang.Object r11 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r11 = (io.ktor.utils.io.ByteReadChannel) r11
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r11
            r10 = r9
            r9 = r4
            r4 = r0
            goto L_0x00cb
        L_0x0084:
            int r0 = r2.I$0
            long r9 = r2.J$0
            java.lang.Object r4 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r1
            r1 = r0
            r0 = r4
            r4 = r17
            goto L_0x00ac
        L_0x0096:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.L$0 = r0
            r9 = r20
            r2.J$0 = r9
            r1 = r22
            r2.I$0 = r1
            r2.label = r8
            java.lang.Object r4 = r0.readByte(r2)
            if (r4 != r3) goto L_0x00ac
            return r3
        L_0x00ac:
            java.lang.Number r4 = (java.lang.Number) r4
            byte r4 = r4.byteValue()
            r2.L$0 = r0
            r2.J$0 = r9
            r2.I$0 = r1
            r2.B$0 = r4
            r11 = 2
            r2.label = r11
            java.lang.Object r11 = r0.readByte(r2)
            if (r11 != r3) goto L_0x00c4
            return r3
        L_0x00c4:
            r12 = r0
            r17 = r9
            r9 = r1
            r1 = r11
            r10 = r17
        L_0x00cb:
            java.lang.Number r1 = (java.lang.Number) r1
            byte r0 = r1.byteValue()
            r1 = r0 & 127(0x7f, float:1.78E-43)
            r13 = 126(0x7e, float:1.77E-43)
            if (r1 == r13) goto L_0x00f8
            r13 = 127(0x7f, float:1.78E-43)
            if (r1 == r13) goto L_0x00dd
            long r13 = (long) r1
            goto L_0x0117
        L_0x00dd:
            r2.L$0 = r12
            r2.J$0 = r10
            r2.I$0 = r9
            r2.B$0 = r4
            r2.B$1 = r0
            r1 = 4
            r2.label = r1
            java.lang.Object r1 = r12.readLong(r2)
            if (r1 != r3) goto L_0x00f1
            return r3
        L_0x00f1:
            java.lang.Number r1 = (java.lang.Number) r1
            long r13 = r1.longValue()
            goto L_0x0117
        L_0x00f8:
            r2.L$0 = r12
            r2.J$0 = r10
            r2.I$0 = r9
            r2.B$0 = r4
            r2.B$1 = r0
            r1 = 3
            r2.label = r1
            java.lang.Object r1 = r12.readShort(r2)
            if (r1 != r3) goto L_0x010c
            return r3
        L_0x010c:
            java.lang.Number r1 = (java.lang.Number) r1
            short r1 = r1.shortValue()
            long r13 = (long) r1
            r15 = 65535(0xffff, double:3.23786E-319)
            long r13 = r13 & r15
        L_0x0117:
            r1 = r12
            r11 = r10
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x011f
            r0 = r8
            goto L_0x0120
        L_0x011f:
            r0 = r7
        L_0x0120:
            if (r0 != r8) goto L_0x014c
            r2.L$0 = r1
            r2.J$0 = r11
            r2.I$0 = r9
            r2.B$0 = r4
            r2.J$1 = r13
            r0 = 5
            r2.label = r0
            java.lang.Object r0 = r1.readInt(r2)
            if (r0 != r3) goto L_0x0136
            return r3
        L_0x0136:
            r17 = r1
            r1 = r0
            r0 = r4
            r4 = r9
            r9 = r13
            r13 = r17
        L_0x013e:
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r17 = r9
            r9 = r0
            r0 = r1
            r1 = r13
            r13 = r17
            goto L_0x0154
        L_0x014c:
            if (r0 != 0) goto L_0x01cf
            r0 = r6
            r17 = r9
            r9 = r4
            r4 = r17
        L_0x0154:
            r15 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 > 0) goto L_0x01c9
            int r10 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r10 > 0) goto L_0x01c9
            int r10 = (int) r13
            r2.L$0 = r5
            r2.I$0 = r4
            r2.B$0 = r9
            r2.I$1 = r0
            r11 = 6
            r2.label = r11
            java.lang.Object r1 = r1.readPacket(r10, r2)
            if (r1 != r3) goto L_0x0172
            return r3
        L_0x0172:
            r2 = r4
            r3 = r9
        L_0x0174:
            io.ktor.utils.io.core.ByteReadPacket r1 = (io.ktor.utils.io.core.ByteReadPacket) r1
            if (r0 != r6) goto L_0x0179
            goto L_0x017d
        L_0x0179:
            io.ktor.utils.io.core.ByteReadPacket r1 = mask(r1, r0)
        L_0x017d:
            r0 = r3 & 15
            if (r0 != 0) goto L_0x0182
            goto L_0x0183
        L_0x0182:
            r2 = r0
        L_0x0183:
            io.ktor.websocket.FrameType$Companion r0 = io.ktor.websocket.FrameType.Companion
            io.ktor.websocket.FrameType r11 = r0.get(r2)
            if (r11 == 0) goto L_0x01b2
            io.ktor.websocket.Frame$Companion r9 = io.ktor.websocket.Frame.Companion
            r0 = r3 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0193
            r10 = r8
            goto L_0x0194
        L_0x0193:
            r10 = r7
        L_0x0194:
            byte[] r12 = io.ktor.utils.io.core.StringsKt.readBytes$default(r1, r7, r8, r5)
            r0 = r3 & 64
            if (r0 == 0) goto L_0x019e
            r13 = r8
            goto L_0x019f
        L_0x019e:
            r13 = r7
        L_0x019f:
            r0 = r3 & 32
            if (r0 == 0) goto L_0x01a5
            r14 = r8
            goto L_0x01a6
        L_0x01a5:
            r14 = r7
        L_0x01a6:
            r0 = r3 & 16
            if (r0 == 0) goto L_0x01ac
            r15 = r8
            goto L_0x01ad
        L_0x01ac:
            r15 = r7
        L_0x01ad:
            io.ktor.websocket.Frame r0 = r9.byType(r10, r11, r12, r13, r14, r15)
            return r0
        L_0x01b2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Unsupported opcode: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01c9:
            io.ktor.websocket.FrameTooBigException r0 = new io.ktor.websocket.FrameTooBigException
            r0.<init>(r13)
            throw r0
        L_0x01cf:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.readFrame(io.ktor.utils.io.ByteReadChannel, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final ByteReadPacket mask(ByteReadPacket byteReadPacket, int i) {
        BytePacketBuilder bytePacketBuilder;
        DefaultAllocator defaultAllocator = DefaultAllocator.INSTANCE;
        ByteBuffer r0 = defaultAllocator.m37allocgFvZug((long) 4);
        try {
            r0.putInt(0, i);
            bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
            int remaining = (int) byteReadPacket.getRemaining();
            for (int i2 = 0; i2 < remaining; i2++) {
                bytePacketBuilder.writeByte((byte) (byteReadPacket.readByte() ^ r0.get(i2 % 4)));
            }
            ByteReadPacket build = bytePacketBuilder.build();
            defaultAllocator.m38free3GNKZMM(r0);
            return build;
        } catch (Throwable th) {
            defaultAllocator.m38free3GNKZMM(r0);
            throw th;
        }
    }
}
