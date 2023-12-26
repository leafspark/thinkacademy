package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b\u001a\u0015\u0010\f\u001a\u00020\r*\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"CHUNK_BUFFER_SIZE", "", "copyToBoth", "", "Lio/ktor/utils/io/ByteReadChannel;", "first", "Lio/ktor/utils/io/ByteWriteChannel;", "second", "split", "Lkotlin/Pair;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "toByteArray", "", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteChannels.kt */
public final class ByteChannelsKt {
    private static final long CHUNK_BUFFER_SIZE = 4096;

    public static final Pair<ByteReadChannel, ByteReadChannel> split(ByteReadChannel byteReadChannel, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        ByteChannel ByteChannel = ByteChannelKt.ByteChannel(true);
        ByteChannel ByteChannel2 = ByteChannelKt.ByteChannel(true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ByteChannelsKt$split$1(byteReadChannel, ByteChannel, ByteChannel2, (Continuation<? super ByteChannelsKt$split$1>) null), 3, (Object) null).invokeOnCompletion(new ByteChannelsKt$split$2(ByteChannel, ByteChannel2));
        return TuplesKt.to(ByteChannel, ByteChannel2);
    }

    public static final void copyToBoth(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(byteWriteChannel, "first");
        Intrinsics.checkNotNullParameter(byteWriteChannel2, "second");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), (CoroutineStart) null, new ByteChannelsKt$copyToBoth$1(byteReadChannel, byteWriteChannel, byteWriteChannel2, (Continuation<? super ByteChannelsKt$copyToBoth$1>) null), 2, (Object) null).invokeOnCompletion(new ByteChannelsKt$copyToBoth$2(byteWriteChannel, byteWriteChannel2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object toByteArray(io.ktor.utils.io.ByteReadChannel r8, kotlin.coroutines.Continuation<? super byte[]> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.util.ByteChannelsKt$toByteArray$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = (io.ktor.util.ByteChannelsKt$toByteArray$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = new io.ktor.util.ByteChannelsKt$toByteArray$1
            r0.<init>(r9)
        L_0x0019:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r7) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0044
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = 0
            r5 = 1
            r6 = 0
            r4.label = r7
            r1 = r8
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L_0x0044
            return r0
        L_0x0044:
            io.ktor.utils.io.core.ByteReadPacket r9 = (io.ktor.utils.io.core.ByteReadPacket) r9
            r8 = 0
            r0 = 0
            byte[] r8 = io.ktor.utils.io.core.StringsKt.readBytes$default(r9, r8, r7, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.toByteArray(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
