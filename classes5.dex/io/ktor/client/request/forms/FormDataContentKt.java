package io.ktor.client.request.forms;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"RN_BYTES", "", "generateBoundary", "", "copyTo", "", "Lio/ktor/utils/io/core/Input;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/core/Input;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormDataContent.kt */
public final class FormDataContentKt {
    /* access modifiers changed from: private */
    public static final byte[] RN_BYTES;

    /* access modifiers changed from: private */
    public static final String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            String num = Integer.toString(Random.Default.nextInt(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            sb.append(num);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return StringsKt.take(sb2, 70);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object copyTo(io.ktor.utils.io.core.Input r18, io.ktor.utils.io.ByteWriteChannel r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof io.ktor.client.request.forms.FormDataContentKt$copyTo$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.ktor.client.request.forms.FormDataContentKt$copyTo$1 r2 = (io.ktor.client.request.forms.FormDataContentKt$copyTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.ktor.client.request.forms.FormDataContentKt$copyTo$1 r2 = new io.ktor.client.request.forms.FormDataContentKt$copyTo$1
            r2.<init>(r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L_0x0071
            if (r4 == r8) goto L_0x006d
            if (r4 == r7) goto L_0x0056
            if (r4 == r6) goto L_0x0044
            if (r4 == r5) goto L_0x003b
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003b:
            java.lang.Object r0 = r2.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00f0
        L_0x0044:
            java.lang.Object r0 = r2.L$2
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.lang.Object r0 = r2.L$1
            io.ktor.utils.io.ByteWriteChannel r0 = (io.ktor.utils.io.ByteWriteChannel) r0
            java.lang.Object r4 = r2.L$0
            io.ktor.utils.io.core.Input r4 = (io.ktor.utils.io.core.Input) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r0 = r4
            goto L_0x008a
        L_0x0056:
            java.lang.Object r0 = r2.L$2
            io.ktor.utils.io.ByteWriteChannel r0 = (io.ktor.utils.io.ByteWriteChannel) r0
            java.lang.Object r4 = r2.L$1
            io.ktor.utils.io.ByteWriteChannel r4 = (io.ktor.utils.io.ByteWriteChannel) r4
            java.lang.Object r9 = r2.L$0
            io.ktor.utils.io.core.Input r9 = (io.ktor.utils.io.core.Input) r9
            kotlin.ResultKt.throwOnFailure(r1)
            r15 = r9
            r17 = r1
            r1 = r0
            r0 = r4
            r4 = r17
            goto L_0x00a1
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0085
        L_0x0071:
            kotlin.ResultKt.throwOnFailure(r1)
            boolean r1 = r0 instanceof io.ktor.utils.io.core.ByteReadPacket
            if (r1 == 0) goto L_0x0088
            io.ktor.utils.io.core.ByteReadPacket r0 = (io.ktor.utils.io.core.ByteReadPacket) r0
            r2.label = r8
            r1 = r19
            java.lang.Object r0 = r1.writePacket(r0, r2)
            if (r0 != r3) goto L_0x0085
            return r3
        L_0x0085:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0088:
            r1 = r19
        L_0x008a:
            boolean r4 = r0.getEndOfInput()
            if (r4 != 0) goto L_0x00f1
            r2.L$0 = r0
            r2.L$1 = r1
            r2.L$2 = r1
            r2.label = r7
            java.lang.Object r4 = io.ktor.utils.io.WriterSessionKt.requestWriteBuffer(r1, r8, r2)
            if (r4 != r3) goto L_0x009f
            return r3
        L_0x009f:
            r15 = r0
            r0 = r1
        L_0x00a1:
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4
            if (r4 != 0) goto L_0x00ab
            io.ktor.utils.io.core.Buffer$Companion r4 = io.ktor.utils.io.core.Buffer.Companion
            io.ktor.utils.io.core.Buffer r4 = r4.getEmpty()
        L_0x00ab:
            r16 = 0
            java.nio.ByteBuffer r10 = r4.m184getMemorySK3TCg8()     // Catch:{ all -> 0x00dd }
            int r9 = r4.getWritePosition()     // Catch:{ all -> 0x00dd }
            long r11 = (long) r9     // Catch:{ all -> 0x00dd }
            int r9 = r4.getLimit()     // Catch:{ all -> 0x00dd }
            long r13 = (long) r9     // Catch:{ all -> 0x00dd }
            long r13 = r13 - r11
            r9 = r15
            long r9 = io.ktor.utils.io.core.InputArraysKt.m228readAvailableUAd2zVI((io.ktor.utils.io.core.Input) r9, (java.nio.ByteBuffer) r10, (long) r11, (long) r13)     // Catch:{ all -> 0x00dd }
            int r9 = (int) r9
            r4.commitWritten(r9)     // Catch:{ all -> 0x00db }
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)     // Catch:{ all -> 0x00db }
            r2.L$0 = r15
            r2.L$1 = r0
            r2.L$2 = r10
            r2.label = r6
            java.lang.Object r1 = io.ktor.utils.io.WriterSessionKt.completeWriting(r1, r4, r9, r2)
            if (r1 != r3) goto L_0x00d8
            return r3
        L_0x00d8:
            r1 = r0
            r0 = r15
            goto L_0x008a
        L_0x00db:
            r0 = move-exception
            goto L_0x00e0
        L_0x00dd:
            r0 = move-exception
            r9 = r16
        L_0x00e0:
            r2.L$0 = r0
            r6 = 0
            r2.L$1 = r6
            r2.L$2 = r6
            r2.label = r5
            java.lang.Object r1 = io.ktor.utils.io.WriterSessionKt.completeWriting(r1, r4, r9, r2)
            if (r1 != r3) goto L_0x00f0
            return r3
        L_0x00f0:
            throw r0
        L_0x00f1:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.FormDataContentKt.copyTo(io.ktor.utils.io.core.Input, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static {
        byte[] bArr;
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            bArr = StringsKt.encodeToByteArray("\r\n");
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            bArr = CharsetJVMKt.encodeToByteArray(newEncoder, "\r\n", 0, 2);
        }
        RN_BYTES = bArr;
    }
}
