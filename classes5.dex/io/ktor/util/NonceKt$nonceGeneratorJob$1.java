package io.ktor.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {73}, m = "invokeSuspend", n = {"seedChannel", "previousRoundNonceList", "secureInstance", "weakRandom", "secureBytes", "weakBytes", "randomNonceList", "lastReseed", "index"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0"})
/* compiled from: Nonce.kt */
final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    NonceKt$nonceGeneratorJob$1(Continuation<? super NonceKt$nonceGeneratorJob$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new NonceKt$nonceGeneratorJob$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007f A[Catch:{ all -> 0x0041 }, LOOP:0: B:13:0x007d->B:14:0x007f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0094 A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a2 A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00dd A[SYNTHETIC, Splitter:B:22:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0101 A[Catch:{ all -> 0x0131 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0102 A[Catch:{ all -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x010b A[Catch:{ all -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x011a A[Catch:{ all -> 0x0131 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r4 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 != r4) goto L_0x0044
            int r2 = r1.I$1
            int r5 = r1.I$0
            long r6 = r1.J$0
            java.lang.Object r8 = r1.L$6
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.L$5
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r1.L$4
            byte[] r10 = (byte[]) r10
            java.lang.Object r11 = r1.L$3
            java.security.SecureRandom r11 = (java.security.SecureRandom) r11
            java.lang.Object r12 = r1.L$2
            java.security.SecureRandom r12 = (java.security.SecureRandom) r12
            java.lang.Object r13 = r1.L$1
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r14 = r1.L$0
            kotlinx.coroutines.channels.Channel r14 = (kotlinx.coroutines.channels.Channel) r14
            kotlin.ResultKt.throwOnFailure(r24)     // Catch:{ all -> 0x0041 }
            r3 = r1
            r1 = r4
            r15 = r14
            r14 = r9
            r9 = r13
            r13 = r10
            r10 = r8
            r7 = r6
            r21 = r12
            r12 = r11
            r11 = r21
            goto L_0x0104
        L_0x0041:
            r0 = move-exception
            goto L_0x0133
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r24)
            kotlinx.coroutines.channels.Channel r2 = io.ktor.util.NonceKt.getSeedChannel()
            r5 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.security.SecureRandom r8 = io.ktor.util.NonceKt.lookupSecureRandom()
            java.lang.String r9 = "SHA1PRNG"
            java.security.SecureRandom r9 = java.security.SecureRandom.getInstance(r9)
            r10 = 128(0x80, float:1.794E-43)
            byte[] r11 = new byte[r10]
            r12 = 512(0x200, float:7.175E-43)
            byte[] r12 = new byte[r12]
            byte[] r10 = r8.generateSeed(r10)
            r9.setSeed(r10)
            r14 = r2
            r2 = r1
        L_0x0075:
            r8.nextBytes(r11)     // Catch:{ all -> 0x0041 }
            r9.nextBytes(r12)     // Catch:{ all -> 0x0041 }
            int r10 = r11.length     // Catch:{ all -> 0x0041 }
            r13 = 0
        L_0x007d:
            if (r13 >= r10) goto L_0x0088
            int r15 = r13 * 4
            byte r16 = r11[r13]     // Catch:{ all -> 0x0041 }
            r12[r15] = r16     // Catch:{ all -> 0x0041 }
            int r13 = r13 + 1
            goto L_0x007d
        L_0x0088:
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0041 }
            long r17 = r15 - r5
            r19 = 30000(0x7530, double:1.4822E-319)
            int r10 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r10 <= 0) goto L_0x00a2
            long r5 = r5 - r15
            r9.setSeed(r5)     // Catch:{ all -> 0x0041 }
            int r5 = r11.length     // Catch:{ all -> 0x0041 }
            byte[] r5 = r8.generateSeed(r5)     // Catch:{ all -> 0x0041 }
            r9.setSeed(r5)     // Catch:{ all -> 0x0041 }
            r5 = r15
            goto L_0x00a5
        L_0x00a2:
            r9.setSeed(r11)     // Catch:{ all -> 0x0041 }
        L_0x00a5:
            java.lang.String r10 = io.ktor.util.CryptoKt.hex((byte[]) r12)     // Catch:{ all -> 0x0041 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0041 }
            r13 = 16
            java.util.List r10 = kotlin.text.StringsKt.chunked(r10, r13)     // Catch:{ all -> 0x0041 }
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ all -> 0x0041 }
            r13 = r7
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch:{ all -> 0x0041 }
            java.util.List r10 = kotlin.collections.CollectionsKt.plus(r10, r13)     // Catch:{ all -> 0x0041 }
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ all -> 0x0041 }
            java.lang.String r13 = "weakRandom"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r13)     // Catch:{ all -> 0x0041 }
            r13 = r9
            java.util.Random r13 = (java.util.Random) r13     // Catch:{ all -> 0x0041 }
            java.util.List r10 = kotlin.collections.CollectionsKt.shuffled(r10, r13)     // Catch:{ all -> 0x0041 }
            int r13 = r10.size()     // Catch:{ all -> 0x0041 }
            int r13 = r13 / 2
            r15 = r14
            r14 = r12
            r12 = r9
            r9 = r7
            r21 = r5
            r5 = r2
            r2 = r13
            r6 = 0
            r13 = r11
            r11 = r8
            r7 = r21
        L_0x00db:
            if (r6 >= r2) goto L_0x010b
            java.lang.Object r3 = r10.get(r6)     // Catch:{ all -> 0x0131 }
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ all -> 0x0131 }
            r5.L$0 = r15     // Catch:{ all -> 0x0131 }
            r5.L$1 = r9     // Catch:{ all -> 0x0131 }
            r5.L$2 = r11     // Catch:{ all -> 0x0131 }
            r5.L$3 = r12     // Catch:{ all -> 0x0131 }
            r5.L$4 = r13     // Catch:{ all -> 0x0131 }
            r5.L$5 = r14     // Catch:{ all -> 0x0131 }
            r5.L$6 = r10     // Catch:{ all -> 0x0131 }
            r5.J$0 = r7     // Catch:{ all -> 0x0131 }
            r5.I$0 = r6     // Catch:{ all -> 0x0131 }
            r5.I$1 = r2     // Catch:{ all -> 0x0131 }
            r1 = 1
            r5.label = r1     // Catch:{ all -> 0x0131 }
            java.lang.Object r3 = r15.send(r3, r4)     // Catch:{ all -> 0x0131 }
            if (r3 != r0) goto L_0x0102
            return r0
        L_0x0102:
            r3 = r5
            r5 = r6
        L_0x0104:
            int r6 = r5 + 1
            r4 = r1
            r5 = r3
            r1 = r23
            goto L_0x00db
        L_0x010b:
            r9.clear()     // Catch:{ all -> 0x0131 }
            int r1 = r10.size()     // Catch:{ all -> 0x0131 }
            int r1 = r1 / 2
            int r2 = r10.size()     // Catch:{ all -> 0x0131 }
        L_0x0118:
            if (r1 >= r2) goto L_0x0124
            java.lang.Object r3 = r10.get(r1)     // Catch:{ all -> 0x0131 }
            r9.add(r3)     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            goto L_0x0118
        L_0x0124:
            r1 = r23
            r2 = r5
            r5 = r7
            r7 = r9
            r8 = r11
            r9 = r12
            r11 = r13
            r12 = r14
            r14 = r15
            r4 = 1
            goto L_0x0075
        L_0x0131:
            r0 = move-exception
            r14 = r15
        L_0x0133:
            r1 = 0
            r14.close(r0)     // Catch:{ all -> 0x0140 }
            kotlinx.coroutines.channels.SendChannel r14 = (kotlinx.coroutines.channels.SendChannel) r14
            r2 = 1
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r14, r1, r2, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0140:
            r0 = move-exception
            r2 = 1
            r3 = r0
            kotlinx.coroutines.channels.SendChannel r14 = (kotlinx.coroutines.channels.SendChannel) r14
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r14, r1, r2, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.NonceKt$nonceGeneratorJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
