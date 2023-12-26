package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {68, 85, 163, 166, 103, 109, 123}, m = "invokeSuspend", n = {"$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "extraLen", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "n$iv", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: EncodersJvm.kt */
final class EncodersJvmKt$inflate$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $gzip;
    final /* synthetic */ ByteReadChannel $source;
    byte B$0;
    byte B$1;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    short S$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EncodersJvmKt$inflate$1(boolean z, ByteReadChannel byteReadChannel, Continuation<? super EncodersJvmKt$inflate$1> continuation) {
        super(2, continuation);
        this.$gzip = z;
        this.$source = byteReadChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> encodersJvmKt$inflate$1 = new EncodersJvmKt$inflate$1(this.$gzip, this.$source, continuation);
        encodersJvmKt$inflate$1.L$0 = obj;
        return (Continuation) encodersJvmKt$inflate$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: io.ktor.utils.io.WriterScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v29, resolved type: java.util.zip.Inflater} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: java.nio.ByteBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v32, resolved type: java.nio.ByteBuffer} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0363, code lost:
        if ((r6 instanceof io.ktor.utils.io.ByteChannel) == false) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0365, code lost:
        r6 = r6.getClosedCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0369, code lost:
        if (r6 != null) goto L_0x036c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x036c, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x036d, code lost:
        r12.flip();
        r13 = r4;
        r18 = r3;
        r3 = r2;
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x037a, code lost:
        if (r10.finished() != false) goto L_0x03bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x037c, code lost:
        r4 = r3.element;
        r5.L$0 = r13;
        r5.L$1 = r12;
        r5.L$2 = r11;
        r5.L$3 = r10;
        r5.L$4 = r2;
        r5.L$5 = r3;
        r5.L$6 = r3;
        r5.I$0 = r4;
        r5.label = 7;
        r6 = io.ktor.util.EncodersJvmKt.inflateTo(r10, r13.getChannel(), r11, r2, (kotlin.coroutines.Continuation) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x039f, code lost:
        if (r6 != r0) goto L_0x03a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03a1, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x03a2, code lost:
        r7 = r5;
        r5 = r2;
        r2 = r4;
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03a6, code lost:
        r3.element = r2 + ((java.lang.Number) r6).intValue();
        r12.position(r12.limit() - r10.getRemaining());
        r3 = r4;
        r2 = r5;
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03c1, code lost:
        if (r5.$gzip == false) goto L_0x0452;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x03c9, code lost:
        if (r12.remaining() != 8) goto L_0x03cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03cb, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x03cd, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03ce, code lost:
        if (r8 == false) goto L_0x042e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x03d0, code lost:
        r12.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        r0 = r12.getInt(r12.position());
        r4 = r12.getInt(r12.position() + 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03ec, code lost:
        if (((int) r2.getValue()) != r0) goto L_0x03f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03ee, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x03f0, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03f1, code lost:
        if (r8 == false) goto L_0x0422;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x03f5, code lost:
        if (r3.element != r4) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03f7, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03f9, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03fa, code lost:
        if (r8 == false) goto L_0x03fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0421, code lost:
        throw new java.lang.IllegalStateException(("Gzip size invalid. Expected " + r4 + ", actual " + r3.element).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x042d, code lost:
        throw new java.lang.IllegalStateException("Gzip checksum invalid.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0451, code lost:
        throw new java.lang.IllegalStateException(("Expected 8 bytes in the trailer. Actual: " + r12.remaining() + " $").toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0458, code lost:
        if ((!r12.hasRemaining()) == false) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x045a, code lost:
        r10.end();
        io.ktor.util.cio.ByteBufferPoolKt.getKtorDefaultPool().recycle(r12);
        io.ktor.util.cio.ByteBufferPoolKt.getKtorDefaultPool().recycle(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x046d, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0479, code lost:
        throw new java.lang.IllegalStateException("Check failed.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x047a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x047b, code lost:
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0154, code lost:
        r11 = (io.ktor.utils.io.core.ByteReadPacket) r11;
        r12 = r11;
        r13 = io.ktor.utils.io.core.InputLittleEndianKt.readShortLittleEndian(r12);
        r14 = r11.readByte();
        r11 = r11.readByte();
        io.ktor.utils.io.core.InputKt.discard(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x016a, code lost:
        if ((r11 & 4) == 0) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x016c, code lost:
        r1.L$0 = r10;
        r1.L$1 = r8;
        r1.L$2 = r7;
        r1.L$3 = r6;
        r1.L$4 = r2;
        r1.S$0 = r13;
        r1.B$0 = r14;
        r1.B$1 = r11;
        r1.label = 2;
        r12 = r1.$source.readShort((kotlin.coroutines.Continuation) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0187, code lost:
        if (r12 != r0) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0189, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x018a, code lost:
        r15 = r6;
        r6 = r10;
        r10 = r2;
        r2 = r11;
        r18 = r8;
        r8 = r7;
        r7 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0193, code lost:
        r11 = (long) ((java.lang.Number) r12).shortValue();
        r1.L$0 = r6;
        r1.L$1 = r7;
        r1.L$2 = r8;
        r1.L$3 = r15;
        r1.L$4 = r10;
        r1.S$0 = r13;
        r1.B$0 = r14;
        r1.B$1 = r2;
        r1.J$0 = r11;
        r20 = r2;
        r1.label = 3;
        r2 = r1.$source.discard(r11, (kotlin.coroutines.Continuation) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01ba, code lost:
        if (r2 != r0) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01bc, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01bd, code lost:
        r5 = r20;
        r18 = r14;
        r14 = r10;
        r10 = r11;
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01cd, code lost:
        if (((java.lang.Number) r2).longValue() != r10) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01cf, code lost:
        r11 = r5;
        r2 = r14;
        r5 = r15;
        r14 = r12;
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01ec, code lost:
        throw new java.io.EOFException("Unable to discard " + r10 + " bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01ed, code lost:
        r5 = r6;
        r12 = r7;
        r7 = r8;
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01f3, code lost:
        if (r13 != -29921) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01f5, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01f7, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01f8, code lost:
        if (r8 == false) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01fc, code lost:
        if (r14 != 8) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01fe, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0200, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0201, code lost:
        if (r9 == false) goto L_0x027d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0209, code lost:
        if ((!io.ktor.util.EncodersJvmKt.has(r11, 8)) == false) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0212, code lost:
        if ((!io.ktor.util.EncodersJvmKt.has(r11, 16)) == false) goto L_0x0265;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0219, code lost:
        if (io.ktor.util.EncodersJvmKt.has(r11, 2) == false) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x021b, code lost:
        r10 = 2;
        r1.L$0 = r6;
        r1.L$1 = r7;
        r1.L$2 = r12;
        r1.L$3 = r5;
        r1.L$4 = r2;
        r1.J$0 = 2;
        r1.label = 4;
        r8 = r1.$source.discard(2, (kotlin.coroutines.Continuation) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0235, code lost:
        if (r8 != r0) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0237, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0238, code lost:
        r14 = r6;
        r13 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0242, code lost:
        if (((java.lang.Number) r8).longValue() != r10) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0244, code lost:
        r11 = r12;
        r12 = r13;
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0260, code lost:
        throw new java.io.EOFException("Unable to discard " + r10 + " bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0261, code lost:
        r10 = r6;
        r11 = r12;
        r12 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0270, code lost:
        throw new java.lang.IllegalStateException("Gzip file comment not supported".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x027c, code lost:
        throw new java.lang.IllegalStateException("Gzip file name not supported".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x029c, code lost:
        throw new java.lang.IllegalStateException(("Deflater method unsupported: " + r14 + '.').toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02b7, code lost:
        throw new java.lang.IllegalStateException(("GZIP magic invalid: " + r13).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02c0, code lost:
        r4 = r10;
        r10 = r5;
        r5 = r1;
        r3 = r2;
        r2 = new kotlin.jvm.internal.Ref.IntRef();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02ce, code lost:
        if (r5.$source.isClosedForRead() != false) goto L_0x035f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02d0, code lost:
        r5.L$0 = r4;
        r5.L$1 = r12;
        r5.L$2 = r11;
        r5.L$3 = r10;
        r5.L$4 = r3;
        r5.L$5 = r2;
        r5.L$6 = null;
        r5.label = 5;
        r6 = r5.$source.readAvailable(r12, (kotlin.coroutines.Continuation<? super java.lang.Integer>) (kotlin.coroutines.Continuation) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02eb, code lost:
        if (r6 != r0) goto L_0x02ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02ed, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02f4, code lost:
        if (((java.lang.Number) r6).intValue() <= 0) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02f6, code lost:
        r12.flip();
        r10.setInput(r12.array(), r12.position(), r12.remaining());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x030c, code lost:
        if (r10.needsInput() != false) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0312, code lost:
        if (r10.finished() != false) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0314, code lost:
        r6 = r2.element;
        r5.L$0 = r4;
        r5.L$1 = r12;
        r5.L$2 = r11;
        r5.L$3 = r10;
        r5.L$4 = r3;
        r5.L$5 = r2;
        r5.L$6 = r2;
        r5.I$0 = r6;
        r5.label = 6;
        r7 = io.ktor.util.EncodersJvmKt.inflateTo(r10, r4.getChannel(), r11, r3, (kotlin.coroutines.Continuation) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0337, code lost:
        if (r7 != r0) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0339, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x033a, code lost:
        r13 = r4;
        r4 = r2;
        r2 = r6;
        r6 = r5;
        r5 = r3;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0340, code lost:
        r3.element = r2 + ((java.lang.Number) r7).intValue();
        r12.position(r12.limit() - r10.getRemaining());
        r2 = r4;
        r3 = r5;
        r5 = r6;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x035a, code lost:
        r12.compact();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x035f, code lost:
        r6 = r5.$source;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            java.lang.String r3 = " bytes"
            java.lang.String r4 = "Unable to discard "
            r5 = 2
            r9 = 1
            switch(r2) {
                case 0: goto L_0x010e;
                case 1: goto L_0x00f4;
                case 2: goto L_0x00cc;
                case 3: goto L_0x00a8;
                case 4: goto L_0x008b;
                case 5: goto L_0x0065;
                case 6: goto L_0x003f;
                case 7: goto L_0x0019;
                default: goto L_0x0011;
            }
        L_0x0011:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0019:
            int r2 = r1.I$0
            java.lang.Object r3 = r1.L$6
            kotlin.jvm.internal.Ref$IntRef r3 = (kotlin.jvm.internal.Ref.IntRef) r3
            java.lang.Object r4 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r1.L$4
            java.util.zip.CRC32 r5 = (java.util.zip.CRC32) r5
            java.lang.Object r10 = r1.L$3
            java.util.zip.Inflater r10 = (java.util.zip.Inflater) r10
            java.lang.Object r11 = r1.L$2
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r12 = r1.L$1
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            java.lang.Object r13 = r1.L$0
            io.ktor.utils.io.WriterScope r13 = (io.ktor.utils.io.WriterScope) r13
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0088 }
            r6 = r20
            r7 = r1
            goto L_0x03a6
        L_0x003f:
            int r2 = r1.I$0
            java.lang.Object r3 = r1.L$6
            kotlin.jvm.internal.Ref$IntRef r3 = (kotlin.jvm.internal.Ref.IntRef) r3
            java.lang.Object r4 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r1.L$4
            java.util.zip.CRC32 r5 = (java.util.zip.CRC32) r5
            java.lang.Object r10 = r1.L$3
            java.util.zip.Inflater r10 = (java.util.zip.Inflater) r10
            java.lang.Object r11 = r1.L$2
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r12 = r1.L$1
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            java.lang.Object r13 = r1.L$0
            io.ktor.utils.io.WriterScope r13 = (io.ktor.utils.io.WriterScope) r13
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0088 }
            r7 = r20
            r6 = r1
            goto L_0x0340
        L_0x0065:
            java.lang.Object r2 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r3 = r1.L$4
            java.util.zip.CRC32 r3 = (java.util.zip.CRC32) r3
            java.lang.Object r4 = r1.L$3
            r10 = r4
            java.util.zip.Inflater r10 = (java.util.zip.Inflater) r10
            java.lang.Object r4 = r1.L$2
            r11 = r4
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r4 = r1.L$1
            r12 = r4
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            java.lang.Object r4 = r1.L$0
            io.ktor.utils.io.WriterScope r4 = (io.ktor.utils.io.WriterScope) r4
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0088 }
            r6 = r20
            r5 = r1
            goto L_0x02ee
        L_0x0088:
            r0 = move-exception
            goto L_0x047c
        L_0x008b:
            long r10 = r1.J$0
            java.lang.Object r2 = r1.L$4
            java.util.zip.CRC32 r2 = (java.util.zip.CRC32) r2
            java.lang.Object r5 = r1.L$3
            java.util.zip.Inflater r5 = (java.util.zip.Inflater) r5
            java.lang.Object r12 = r1.L$2
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            java.lang.Object r13 = r1.L$1
            java.nio.ByteBuffer r13 = (java.nio.ByteBuffer) r13
            java.lang.Object r14 = r1.L$0
            io.ktor.utils.io.WriterScope r14 = (io.ktor.utils.io.WriterScope) r14
            kotlin.ResultKt.throwOnFailure(r20)
            r8 = r20
            goto L_0x023a
        L_0x00a8:
            long r10 = r1.J$0
            byte r2 = r1.B$1
            byte r12 = r1.B$0
            short r13 = r1.S$0
            java.lang.Object r14 = r1.L$4
            java.util.zip.CRC32 r14 = (java.util.zip.CRC32) r14
            java.lang.Object r15 = r1.L$3
            java.util.zip.Inflater r15 = (java.util.zip.Inflater) r15
            java.lang.Object r8 = r1.L$2
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            java.lang.Object r7 = r1.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r6 = r1.L$0
            io.ktor.utils.io.WriterScope r6 = (io.ktor.utils.io.WriterScope) r6
            kotlin.ResultKt.throwOnFailure(r20)
            r5 = r2
            r2 = r20
            goto L_0x01c5
        L_0x00cc:
            byte r2 = r1.B$1
            byte r6 = r1.B$0
            short r7 = r1.S$0
            java.lang.Object r8 = r1.L$4
            java.util.zip.CRC32 r8 = (java.util.zip.CRC32) r8
            java.lang.Object r10 = r1.L$3
            java.util.zip.Inflater r10 = (java.util.zip.Inflater) r10
            java.lang.Object r11 = r1.L$2
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11
            java.lang.Object r12 = r1.L$1
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            java.lang.Object r13 = r1.L$0
            io.ktor.utils.io.WriterScope r13 = (io.ktor.utils.io.WriterScope) r13
            kotlin.ResultKt.throwOnFailure(r20)
            r14 = r6
            r15 = r10
            r6 = r13
            r13 = r7
            r10 = r8
            r8 = r11
            r7 = r12
            r12 = r20
            goto L_0x0193
        L_0x00f4:
            java.lang.Object r2 = r1.L$4
            java.util.zip.CRC32 r2 = (java.util.zip.CRC32) r2
            java.lang.Object r6 = r1.L$3
            java.util.zip.Inflater r6 = (java.util.zip.Inflater) r6
            java.lang.Object r7 = r1.L$2
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r1.L$1
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            java.lang.Object r10 = r1.L$0
            io.ktor.utils.io.WriterScope r10 = (io.ktor.utils.io.WriterScope) r10
            kotlin.ResultKt.throwOnFailure(r20)
            r11 = r20
            goto L_0x0154
        L_0x010e:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r1.L$0
            r10 = r2
            io.ktor.utils.io.WriterScope r10 = (io.ktor.utils.io.WriterScope) r10
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.util.cio.ByteBufferPoolKt.getKtorDefaultPool()
            java.lang.Object r2 = r2.borrow()
            r8 = r2
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            io.ktor.utils.io.pool.ObjectPool r2 = io.ktor.util.cio.ByteBufferPoolKt.getKtorDefaultPool()
            java.lang.Object r2 = r2.borrow()
            r7 = r2
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.util.zip.Inflater r6 = new java.util.zip.Inflater
            r6.<init>(r9)
            java.util.zip.CRC32 r2 = new java.util.zip.CRC32
            r2.<init>()
            boolean r11 = r1.$gzip
            if (r11 == 0) goto L_0x02b8
            io.ktor.utils.io.ByteReadChannel r11 = r1.$source
            r12 = 10
            r13 = r1
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r1.L$0 = r10
            r1.L$1 = r8
            r1.L$2 = r7
            r1.L$3 = r6
            r1.L$4 = r2
            r1.label = r9
            java.lang.Object r11 = r11.readPacket(r12, r13)
            if (r11 != r0) goto L_0x0154
            return r0
        L_0x0154:
            io.ktor.utils.io.core.ByteReadPacket r11 = (io.ktor.utils.io.core.ByteReadPacket) r11
            r12 = r11
            io.ktor.utils.io.core.Input r12 = (io.ktor.utils.io.core.Input) r12
            short r13 = io.ktor.utils.io.core.InputLittleEndianKt.readShortLittleEndian((io.ktor.utils.io.core.Input) r12)
            byte r14 = r11.readByte()
            byte r11 = r11.readByte()
            io.ktor.utils.io.core.InputKt.discard(r12)
            r12 = r11 & 4
            if (r12 == 0) goto L_0x01ed
            io.ktor.utils.io.ByteReadChannel r12 = r1.$source
            r15 = r1
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r1.L$0 = r10
            r1.L$1 = r8
            r1.L$2 = r7
            r1.L$3 = r6
            r1.L$4 = r2
            r1.S$0 = r13
            r1.B$0 = r14
            r1.B$1 = r11
            r1.label = r5
            java.lang.Object r12 = r12.readShort(r15)
            if (r12 != r0) goto L_0x018a
            return r0
        L_0x018a:
            r15 = r6
            r6 = r10
            r10 = r2
            r2 = r11
            r18 = r8
            r8 = r7
            r7 = r18
        L_0x0193:
            java.lang.Number r12 = (java.lang.Number) r12
            short r11 = r12.shortValue()
            long r11 = (long) r11
            io.ktor.utils.io.ByteReadChannel r5 = r1.$source
            r9 = r1
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r1.L$0 = r6
            r1.L$1 = r7
            r1.L$2 = r8
            r1.L$3 = r15
            r1.L$4 = r10
            r1.S$0 = r13
            r1.B$0 = r14
            r1.B$1 = r2
            r1.J$0 = r11
            r20 = r2
            r2 = 3
            r1.label = r2
            java.lang.Object r2 = r5.discard(r11, r9)
            if (r2 != r0) goto L_0x01bd
            return r0
        L_0x01bd:
            r5 = r20
            r18 = r14
            r14 = r10
            r10 = r11
            r12 = r18
        L_0x01c5:
            java.lang.Number r2 = (java.lang.Number) r2
            long r16 = r2.longValue()
            int r2 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x01d5
            r11 = r5
            r2 = r14
            r5 = r15
            r14 = r12
            r12 = r8
            goto L_0x01f1
        L_0x01d5:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r10)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x01ed:
            r5 = r6
            r12 = r7
            r7 = r8
            r6 = r10
        L_0x01f1:
            r8 = -29921(0xffffffffffff8b1f, float:NaN)
            if (r13 != r8) goto L_0x01f7
            r8 = 1
            goto L_0x01f8
        L_0x01f7:
            r8 = 0
        L_0x01f8:
            if (r8 == 0) goto L_0x029d
            r8 = 8
            if (r14 != r8) goto L_0x0200
            r9 = 1
            goto L_0x0201
        L_0x0200:
            r9 = 0
        L_0x0201:
            if (r9 == 0) goto L_0x027d
            boolean r9 = io.ktor.util.EncodersJvmKt.has(r11, r8)
            r8 = 1
            r9 = r9 ^ r8
            if (r9 == 0) goto L_0x0271
            r9 = 16
            boolean r9 = io.ktor.util.EncodersJvmKt.has(r11, r9)
            r9 = r9 ^ r8
            if (r9 == 0) goto L_0x0265
            r8 = 2
            boolean r8 = io.ktor.util.EncodersJvmKt.has(r11, r8)
            if (r8 == 0) goto L_0x0261
            io.ktor.utils.io.ByteReadChannel r8 = r1.$source
            r10 = 2
            r9 = r1
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r1.L$0 = r6
            r1.L$1 = r7
            r1.L$2 = r12
            r1.L$3 = r5
            r1.L$4 = r2
            r1.J$0 = r10
            r13 = 4
            r1.label = r13
            java.lang.Object r8 = r8.discard(r10, r9)
            if (r8 != r0) goto L_0x0238
            return r0
        L_0x0238:
            r14 = r6
            r13 = r7
        L_0x023a:
            java.lang.Number r8 = (java.lang.Number) r8
            long r6 = r8.longValue()
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x0249
            r11 = r12
            r12 = r13
            r10 = r14
            goto L_0x02bb
        L_0x0249:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r10)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0261:
            r10 = r6
            r11 = r12
            r12 = r7
            goto L_0x02bb
        L_0x0265:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Gzip file comment not supported"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0271:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Gzip file name not supported"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x027d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Deflater method unsupported: "
            r0.append(r2)
            r0.append(r14)
            r2 = 46
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x029d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "GZIP magic invalid: "
            r0.append(r2)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x02b8:
            r5 = r6
            r11 = r7
            r12 = r8
        L_0x02bb:
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x047a }
            r3.<init>()     // Catch:{ all -> 0x047a }
            r4 = r10
            r10 = r5
            r5 = r1
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x02c8:
            io.ktor.utils.io.ByteReadChannel r6 = r5.$source     // Catch:{ all -> 0x0088 }
            boolean r6 = r6.isClosedForRead()     // Catch:{ all -> 0x0088 }
            if (r6 != 0) goto L_0x035f
            io.ktor.utils.io.ByteReadChannel r6 = r5.$source     // Catch:{ all -> 0x0088 }
            r7 = r5
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch:{ all -> 0x0088 }
            r5.L$0 = r4     // Catch:{ all -> 0x0088 }
            r5.L$1 = r12     // Catch:{ all -> 0x0088 }
            r5.L$2 = r11     // Catch:{ all -> 0x0088 }
            r5.L$3 = r10     // Catch:{ all -> 0x0088 }
            r5.L$4 = r3     // Catch:{ all -> 0x0088 }
            r5.L$5 = r2     // Catch:{ all -> 0x0088 }
            r8 = 0
            r5.L$6 = r8     // Catch:{ all -> 0x0088 }
            r8 = 5
            r5.label = r8     // Catch:{ all -> 0x0088 }
            java.lang.Object r6 = r6.readAvailable((java.nio.ByteBuffer) r12, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r7)     // Catch:{ all -> 0x0088 }
            if (r6 != r0) goto L_0x02ee
            return r0
        L_0x02ee:
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ all -> 0x0088 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0088 }
            if (r6 <= 0) goto L_0x02c8
            r12.flip()     // Catch:{ all -> 0x0088 }
            byte[] r6 = r12.array()     // Catch:{ all -> 0x0088 }
            int r7 = r12.position()     // Catch:{ all -> 0x0088 }
            int r8 = r12.remaining()     // Catch:{ all -> 0x0088 }
            r10.setInput(r6, r7, r8)     // Catch:{ all -> 0x0088 }
        L_0x0308:
            boolean r6 = r10.needsInput()     // Catch:{ all -> 0x0088 }
            if (r6 != 0) goto L_0x035a
            boolean r6 = r10.finished()     // Catch:{ all -> 0x0088 }
            if (r6 != 0) goto L_0x035a
            int r6 = r2.element     // Catch:{ all -> 0x0088 }
            io.ktor.utils.io.ByteWriteChannel r7 = r4.getChannel()     // Catch:{ all -> 0x0088 }
            r8 = r3
            java.util.zip.Checksum r8 = (java.util.zip.Checksum) r8     // Catch:{ all -> 0x0088 }
            r9 = r5
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x0088 }
            r5.L$0 = r4     // Catch:{ all -> 0x0088 }
            r5.L$1 = r12     // Catch:{ all -> 0x0088 }
            r5.L$2 = r11     // Catch:{ all -> 0x0088 }
            r5.L$3 = r10     // Catch:{ all -> 0x0088 }
            r5.L$4 = r3     // Catch:{ all -> 0x0088 }
            r5.L$5 = r2     // Catch:{ all -> 0x0088 }
            r5.L$6 = r2     // Catch:{ all -> 0x0088 }
            r5.I$0 = r6     // Catch:{ all -> 0x0088 }
            r13 = 6
            r5.label = r13     // Catch:{ all -> 0x0088 }
            java.lang.Object r7 = io.ktor.util.EncodersJvmKt.inflateTo(r10, r7, r11, r8, r9)     // Catch:{ all -> 0x0088 }
            if (r7 != r0) goto L_0x033a
            return r0
        L_0x033a:
            r13 = r4
            r4 = r2
            r2 = r6
            r6 = r5
            r5 = r3
            r3 = r4
        L_0x0340:
            java.lang.Number r7 = (java.lang.Number) r7     // Catch:{ all -> 0x0088 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0088 }
            int r2 = r2 + r7
            r3.element = r2     // Catch:{ all -> 0x0088 }
            int r2 = r12.limit()     // Catch:{ all -> 0x0088 }
            int r3 = r10.getRemaining()     // Catch:{ all -> 0x0088 }
            int r2 = r2 - r3
            r12.position(r2)     // Catch:{ all -> 0x0088 }
            r2 = r4
            r3 = r5
            r5 = r6
            r4 = r13
            goto L_0x0308
        L_0x035a:
            r12.compact()     // Catch:{ all -> 0x0088 }
            goto L_0x02c8
        L_0x035f:
            io.ktor.utils.io.ByteReadChannel r6 = r5.$source     // Catch:{ all -> 0x0088 }
            boolean r7 = r6 instanceof io.ktor.utils.io.ByteChannel     // Catch:{ all -> 0x0088 }
            if (r7 == 0) goto L_0x036d
            java.lang.Throwable r6 = r6.getClosedCause()     // Catch:{ all -> 0x0088 }
            if (r6 != 0) goto L_0x036c
            goto L_0x036d
        L_0x036c:
            throw r6     // Catch:{ all -> 0x0088 }
        L_0x036d:
            r12.flip()     // Catch:{ all -> 0x0088 }
            r13 = r4
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x0376:
            boolean r4 = r10.finished()     // Catch:{ all -> 0x0088 }
            if (r4 != 0) goto L_0x03bf
            int r4 = r3.element     // Catch:{ all -> 0x0088 }
            io.ktor.utils.io.ByteWriteChannel r6 = r13.getChannel()     // Catch:{ all -> 0x0088 }
            r7 = r2
            java.util.zip.Checksum r7 = (java.util.zip.Checksum) r7     // Catch:{ all -> 0x0088 }
            r8 = r5
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch:{ all -> 0x0088 }
            r5.L$0 = r13     // Catch:{ all -> 0x0088 }
            r5.L$1 = r12     // Catch:{ all -> 0x0088 }
            r5.L$2 = r11     // Catch:{ all -> 0x0088 }
            r5.L$3 = r10     // Catch:{ all -> 0x0088 }
            r5.L$4 = r2     // Catch:{ all -> 0x0088 }
            r5.L$5 = r3     // Catch:{ all -> 0x0088 }
            r5.L$6 = r3     // Catch:{ all -> 0x0088 }
            r5.I$0 = r4     // Catch:{ all -> 0x0088 }
            r9 = 7
            r5.label = r9     // Catch:{ all -> 0x0088 }
            java.lang.Object r6 = io.ktor.util.EncodersJvmKt.inflateTo(r10, r6, r11, r7, r8)     // Catch:{ all -> 0x0088 }
            if (r6 != r0) goto L_0x03a2
            return r0
        L_0x03a2:
            r7 = r5
            r5 = r2
            r2 = r4
            r4 = r3
        L_0x03a6:
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ all -> 0x0088 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0088 }
            int r2 = r2 + r6
            r3.element = r2     // Catch:{ all -> 0x0088 }
            int r2 = r12.limit()     // Catch:{ all -> 0x0088 }
            int r3 = r10.getRemaining()     // Catch:{ all -> 0x0088 }
            int r2 = r2 - r3
            r12.position(r2)     // Catch:{ all -> 0x0088 }
            r3 = r4
            r2 = r5
            r5 = r7
            goto L_0x0376
        L_0x03bf:
            boolean r0 = r5.$gzip     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0452
            int r0 = r12.remaining()     // Catch:{ all -> 0x0088 }
            r4 = 8
            if (r0 != r4) goto L_0x03cd
            r8 = 1
            goto L_0x03ce
        L_0x03cd:
            r8 = 0
        L_0x03ce:
            if (r8 == 0) goto L_0x042e
            java.nio.ByteOrder r0 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x0088 }
            r12.order(r0)     // Catch:{ all -> 0x0088 }
            int r0 = r12.position()     // Catch:{ all -> 0x0088 }
            int r0 = r12.getInt(r0)     // Catch:{ all -> 0x0088 }
            int r4 = r12.position()     // Catch:{ all -> 0x0088 }
            r5 = 4
            int r4 = r4 + r5
            int r4 = r12.getInt(r4)     // Catch:{ all -> 0x0088 }
            long r5 = r2.getValue()     // Catch:{ all -> 0x0088 }
            int r2 = (int) r5     // Catch:{ all -> 0x0088 }
            if (r2 != r0) goto L_0x03f0
            r8 = 1
            goto L_0x03f1
        L_0x03f0:
            r8 = 0
        L_0x03f1:
            if (r8 == 0) goto L_0x0422
            int r0 = r3.element     // Catch:{ all -> 0x0088 }
            if (r0 != r4) goto L_0x03f9
            r8 = 1
            goto L_0x03fa
        L_0x03f9:
            r8 = 0
        L_0x03fa:
            if (r8 == 0) goto L_0x03fd
            goto L_0x045a
        L_0x03fd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r0.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "Gzip size invalid. Expected "
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            r0.append(r4)     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = ", actual "
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            int r2 = r3.element     // Catch:{ all -> 0x0088 }
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0088 }
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0088 }
            r2.<init>(r0)     // Catch:{ all -> 0x0088 }
            throw r2     // Catch:{ all -> 0x0088 }
        L_0x0422:
            java.lang.String r0 = "Gzip checksum invalid."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0088 }
            r2.<init>(r0)     // Catch:{ all -> 0x0088 }
            throw r2     // Catch:{ all -> 0x0088 }
        L_0x042e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r0.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "Expected 8 bytes in the trailer. Actual: "
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            int r2 = r12.remaining()     // Catch:{ all -> 0x0088 }
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = " $"
            r0.append(r2)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0088 }
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0088 }
            r2.<init>(r0)     // Catch:{ all -> 0x0088 }
            throw r2     // Catch:{ all -> 0x0088 }
        L_0x0452:
            boolean r0 = r12.hasRemaining()     // Catch:{ all -> 0x0088 }
            r2 = 1
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x046e
        L_0x045a:
            r10.end()
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.util.cio.ByteBufferPoolKt.getKtorDefaultPool()
            r0.recycle(r12)
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.util.cio.ByteBufferPoolKt.getKtorDefaultPool()
            r0.recycle(r11)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x046e:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0088 }
            r2.<init>(r0)     // Catch:{ all -> 0x0088 }
            throw r2     // Catch:{ all -> 0x0088 }
        L_0x047a:
            r0 = move-exception
            r10 = r5
        L_0x047c:
            throw r0     // Catch:{ all -> 0x047d }
        L_0x047d:
            r0 = move-exception
            r2 = r0
            r10.end()
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.util.cio.ByteBufferPoolKt.getKtorDefaultPool()
            r0.recycle(r12)
            io.ktor.utils.io.pool.ObjectPool r0 = io.ktor.util.cio.ByteBufferPoolKt.getKtorDefaultPool()
            r0.recycle(r11)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt$inflate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
