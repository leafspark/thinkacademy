package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteOrder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004HHø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004HHø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\n\u001a\u00020\t*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004HHø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\r\u001a\u00020\f*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004HHø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0010\u001a\u00020\u000f*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004HHø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0013\u001a\u00020\u0012*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a<\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u0002H\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\bø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a<\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u00020\u00022\u0006\u0010\u001b\u001a\u0002H\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\bø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a9\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u00020\u001d2\u0006\u0010\u001b\u001a\u0002H\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\b¢\u0006\u0002\u0010\u001e\u001a%\u0010\u001f\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u001d\u0010&\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a%\u0010,\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a%\u00100\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u001d\u00102\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u00103\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u00064"}, d2 = {"readDouble", "", "Lio/ktor/utils/io/ByteReadChannel;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDoubleLittleEndian", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFloat", "", "readFloatLittleEndian", "readInt", "", "readIntLittleEndian", "readLong", "", "readLongLittleEndian", "readShort", "", "readShortLittleEndian", "reverseIfNeeded", "T", "reverseBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toLittleEndian", "value", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeDouble", "", "(Lio/ktor/utils/io/ByteWriteChannel;DLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeDoubleLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloat", "(Lio/ktor/utils/io/ByteWriteChannel;FLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloatLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeInt", "(Lio/ktor/utils/io/ByteWriteChannel;ILio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeIntLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLong", "(Lio/ktor/utils/io/ByteWriteChannel;JLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLongLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "(Lio/ktor/utils/io/ByteWriteChannel;SLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShortLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelLittleEndian.kt */
public final class ChannelLittleEndianKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
    /* compiled from: ChannelLittleEndian.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ByteOrder.values().length];
            iArr[ByteOrder.BIG_ENDIAN.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: io.ktor.utils.io.core.ByteOrder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readShort(io.ktor.utils.io.ByteReadChannel r4, io.ktor.utils.io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Short> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readShort$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readShort$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readShort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readShort$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readShort$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readShort(r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 != r3) goto L_0x0050
            goto L_0x005f
        L_0x0050:
            java.lang.Number r6 = (java.lang.Number) r6
            short r4 = r6.shortValue()
            short r4 = (short) r4
            short r4 = java.lang.Short.reverseBytes(r4)
            java.lang.Short r6 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r4)
        L_0x005f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readShort(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readShort$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Short> continuation) {
        InlineMarker.mark(0);
        Object readShort = byteReadChannel.readShort(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readShort : Short.valueOf(Short.reverseBytes(((Number) readShort).shortValue()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: io.ktor.utils.io.core.ByteOrder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readInt(io.ktor.utils.io.ByteReadChannel r4, io.ktor.utils.io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readInt$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readInt$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readInt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readInt$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readInt$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readInt(r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 != r3) goto L_0x0050
            goto L_0x005e
        L_0x0050:
            java.lang.Number r6 = (java.lang.Number) r6
            int r4 = r6.intValue()
            int r4 = java.lang.Integer.reverseBytes(r4)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
        L_0x005e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readInt(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readInt$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object readInt = byteReadChannel.readInt(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readInt : Integer.valueOf(Integer.reverseBytes(((Number) readInt).intValue()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: io.ktor.utils.io.core.ByteOrder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readLong(io.ktor.utils.io.ByteReadChannel r4, io.ktor.utils.io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Long> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readLong$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readLong$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readLong$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readLong$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readLong$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readLong(r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 != r3) goto L_0x0050
            goto L_0x005e
        L_0x0050:
            java.lang.Number r6 = (java.lang.Number) r6
            long r4 = r6.longValue()
            long r4 = java.lang.Long.reverseBytes(r4)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
        L_0x005e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readLong(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readLong$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Long> continuation) {
        InlineMarker.mark(0);
        Object readLong = byteReadChannel.readLong(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readLong : Long.valueOf(Long.reverseBytes(((Number) readLong).longValue()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: io.ktor.utils.io.core.ByteOrder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readFloat(io.ktor.utils.io.ByteReadChannel r4, io.ktor.utils.io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Float> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readFloat(r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 != r3) goto L_0x0050
            goto L_0x0066
        L_0x0050:
            java.lang.Number r6 = (java.lang.Number) r6
            float r4 = r6.floatValue()
            int r4 = java.lang.Float.floatToRawIntBits(r4)
            int r4 = java.lang.Integer.reverseBytes(r4)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
        L_0x0066:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readFloat(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readFloat$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Float> continuation) {
        InlineMarker.mark(0);
        Object readFloat = byteReadChannel.readFloat(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readFloat : Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) readFloat).floatValue()))));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: io.ktor.utils.io.core.ByteOrder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readDouble(io.ktor.utils.io.ByteReadChannel r4, io.ktor.utils.io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Double> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readDouble(r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            if (r4 != r3) goto L_0x0050
            goto L_0x0066
        L_0x0050:
            java.lang.Number r6 = (java.lang.Number) r6
            double r4 = r6.doubleValue()
            long r4 = java.lang.Double.doubleToRawLongBits(r4)
            long r4 = java.lang.Long.reverseBytes(r4)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            java.lang.Double r6 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4)
        L_0x0066:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readDouble(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readDouble$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Double> continuation) {
        InlineMarker.mark(0);
        Object readDouble = byteReadChannel.readDouble(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readDouble : Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) readDouble).doubleValue()))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readShortLittleEndian(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Short> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.readShort(r0)
            if (r5 != r1) goto L_0x003e
            return r1
        L_0x003e:
            java.lang.Number r5 = (java.lang.Number) r5
            short r4 = r5.shortValue()
            short r4 = (short) r4
            short r4 = java.lang.Short.reverseBytes(r4)
            java.lang.Short r4 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readShortLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readShortLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Short> continuation) {
        InlineMarker.mark(0);
        Object readShort = byteReadChannel.readShort(continuation);
        InlineMarker.mark(1);
        return Short.valueOf(Short.reverseBytes(((Number) readShort).shortValue()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readIntLittleEndian(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Integer> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.readInt(r0)
            if (r5 != r1) goto L_0x003e
            return r1
        L_0x003e:
            java.lang.Number r5 = (java.lang.Number) r5
            int r4 = r5.intValue()
            int r4 = java.lang.Integer.reverseBytes(r4)
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readIntLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readIntLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object readInt = byteReadChannel.readInt(continuation);
        InlineMarker.mark(1);
        return Integer.valueOf(Integer.reverseBytes(((Number) readInt).intValue()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readLongLittleEndian(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Long> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.readLong(r0)
            if (r5 != r1) goto L_0x003e
            return r1
        L_0x003e:
            java.lang.Number r5 = (java.lang.Number) r5
            long r4 = r5.longValue()
            long r4 = java.lang.Long.reverseBytes(r4)
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readLongLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readLongLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        InlineMarker.mark(0);
        Object readLong = byteReadChannel.readLong(continuation);
        InlineMarker.mark(1);
        return Long.valueOf(Long.reverseBytes(((Number) readLong).longValue()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readFloatLittleEndian(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Float> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.readFloat(r0)
            if (r5 != r1) goto L_0x003e
            return r1
        L_0x003e:
            java.lang.Number r5 = (java.lang.Number) r5
            float r4 = r5.floatValue()
            int r4 = java.lang.Float.floatToRawIntBits(r4)
            int r4 = java.lang.Integer.reverseBytes(r4)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readFloatLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readFloatLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Float> continuation) {
        InlineMarker.mark(0);
        Object readFloat = byteReadChannel.readFloat(continuation);
        InlineMarker.mark(1);
        return Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) readFloat).floatValue()))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readDoubleLittleEndian(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Double> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1 r0 = (io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.readDouble(r0)
            if (r5 != r1) goto L_0x003e
            return r1
        L_0x003e:
            java.lang.Number r5 = (java.lang.Number) r5
            double r4 = r5.doubleValue()
            long r4 = java.lang.Double.doubleToRawLongBits(r4)
            long r4 = java.lang.Long.reverseBytes(r4)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            java.lang.Double r4 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ChannelLittleEndianKt.readDoubleLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readDoubleLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Double> continuation) {
        InlineMarker.mark(0);
        Object readDouble = byteReadChannel.readDouble(continuation);
        InlineMarker.mark(1);
        return Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) readDouble).doubleValue()))));
    }

    public static final <T> T toLittleEndian(ByteReadChannel byteReadChannel, T t, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(function1, "reverseBlock");
        return function1.invoke(t);
    }

    private static final <T> T toLittleEndian(ByteWriteChannel byteWriteChannel, T t, Function1<? super T, ? extends T> function1) {
        return function1.invoke(t);
    }

    public static final <T> T reverseIfNeeded(T t, ByteOrder byteOrder, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        Intrinsics.checkNotNullParameter(function1, "reverseBlock");
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? t : function1.invoke(t);
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, short s, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            s = Short.reverseBytes(s);
        }
        Object writeShort = byteWriteChannel.writeShort(s, continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, int i, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            i = Integer.reverseBytes(i);
        }
        Object writeInt = byteWriteChannel.writeInt(i, continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    public static final Object writeLong(ByteWriteChannel byteWriteChannel, long j, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            j = Long.reverseBytes(j);
        }
        Object writeLong = byteWriteChannel.writeLong(j, continuation);
        return writeLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeLong : Unit.INSTANCE;
    }

    public static final Object writeFloat(ByteWriteChannel byteWriteChannel, float f, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            f = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
        }
        Object writeFloat = byteWriteChannel.writeFloat(f, continuation);
        return writeFloat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFloat : Unit.INSTANCE;
    }

    public static final Object writeDouble(ByteWriteChannel byteWriteChannel, double d, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            d = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
        }
        Object writeDouble = byteWriteChannel.writeDouble(d, continuation);
        return writeDouble == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeDouble : Unit.INSTANCE;
    }

    public static final Object writeShortLittleEndian(ByteWriteChannel byteWriteChannel, short s, Continuation<? super Unit> continuation) {
        Object writeShort = byteWriteChannel.writeShort(Short.reverseBytes(s), continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    public static final Object writeIntLittleEndian(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object writeInt = byteWriteChannel.writeInt(Integer.reverseBytes(i), continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    public static final Object writeLongLittleEndian(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        Object writeLong = byteWriteChannel.writeLong(Long.reverseBytes(j), continuation);
        return writeLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeLong : Unit.INSTANCE;
    }

    public static final Object writeFloatLittleEndian(ByteWriteChannel byteWriteChannel, float f, Continuation<? super Unit> continuation) {
        Object writeFloat = byteWriteChannel.writeFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f))), continuation);
        return writeFloat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFloat : Unit.INSTANCE;
    }

    public static final Object writeDoubleLittleEndian(ByteWriteChannel byteWriteChannel, double d, Continuation<? super Unit> continuation) {
        Object writeDouble = byteWriteChannel.writeDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d))), continuation);
        return writeDouble == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeDouble : Unit.INSTANCE;
    }
}
