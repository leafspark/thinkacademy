package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"io/ktor/utils/io/jvm/javaio/OutputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "loop", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Blocking.kt */
public final class OutputAdapter$loop$1 extends BlockingAdapter {
    final /* synthetic */ OutputAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutputAdapter$loop$1(Job job, OutputAdapter outputAdapter) {
        super(job);
        this.this$0 = outputAdapter;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065 A[Catch:{ all -> 0x0045, all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[Catch:{ all -> 0x0045, all -> 0x00de }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0091 A[SYNTHETIC, Splitter:B:36:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object loop(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1 r0 = (io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1 r0 = new io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1$loop$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1 r2 = (io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0045 }
            goto L_0x004c
        L_0x0031:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0039:
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.jvm.javaio.BlockingAdapter r2 = (io.ktor.utils.io.jvm.javaio.BlockingAdapter) r2
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1 r2 = (io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0045 }
            goto L_0x006e
        L_0x0045:
            r10 = move-exception
            goto L_0x00d0
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r9
        L_0x004c:
            r10 = r2
            io.ktor.utils.io.jvm.javaio.BlockingAdapter r10 = (io.ktor.utils.io.jvm.javaio.BlockingAdapter) r10     // Catch:{ all -> 0x0045 }
            r5 = 0
            r10.result = r5     // Catch:{ all -> 0x0045 }
            r0.L$0 = r2     // Catch:{ all -> 0x0045 }
            r0.L$1 = r10     // Catch:{ all -> 0x0045 }
            r0.label = r4     // Catch:{ all -> 0x0045 }
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ all -> 0x0045 }
            java.lang.Object r10 = r10.rendezvousBlock(r5)     // Catch:{ all -> 0x0045 }
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0045 }
            if (r10 != r5) goto L_0x006b
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ all -> 0x0045 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5)     // Catch:{ all -> 0x0045 }
        L_0x006b:
            if (r10 != r1) goto L_0x006e
            return r1
        L_0x006e:
            java.lang.Object r5 = io.ktor.utils.io.jvm.javaio.BlockingKt.CloseToken     // Catch:{ all -> 0x0045 }
            if (r10 != r5) goto L_0x0091
            io.ktor.utils.io.jvm.javaio.OutputAdapter r10 = r2.this$0
            io.ktor.utils.io.ByteWriteChannel r10 = r10.channel
            boolean r10 = io.ktor.utils.io.ByteWriteChannelKt.close(r10)
            if (r10 != 0) goto L_0x008e
            io.ktor.utils.io.jvm.javaio.OutputAdapter r10 = r2.this$0
            io.ktor.utils.io.ByteWriteChannel r10 = r10.channel
            java.lang.Throwable r10 = r10.getClosedCause()
            if (r10 != 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            throw r10
        L_0x008e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0091:
            java.lang.Object r5 = io.ktor.utils.io.jvm.javaio.BlockingKt.FlushToken     // Catch:{ all -> 0x0045 }
            if (r10 != r5) goto L_0x00ae
            io.ktor.utils.io.jvm.javaio.OutputAdapter r10 = r2.this$0     // Catch:{ all -> 0x0045 }
            io.ktor.utils.io.ByteWriteChannel r10 = r10.channel     // Catch:{ all -> 0x0045 }
            r10.flush()     // Catch:{ all -> 0x0045 }
            io.ktor.utils.io.jvm.javaio.OutputAdapter r10 = r2.this$0     // Catch:{ all -> 0x0045 }
            io.ktor.utils.io.ByteWriteChannel r10 = r10.channel     // Catch:{ all -> 0x0045 }
            java.lang.Throwable r10 = r10.getClosedCause()     // Catch:{ all -> 0x0045 }
            if (r10 != 0) goto L_0x00ad
            goto L_0x004c
        L_0x00ad:
            throw r10     // Catch:{ all -> 0x0045 }
        L_0x00ae:
            boolean r5 = r10 instanceof byte[]     // Catch:{ all -> 0x0045 }
            if (r5 == 0) goto L_0x004c
            io.ktor.utils.io.jvm.javaio.OutputAdapter r5 = r2.this$0     // Catch:{ all -> 0x0045 }
            io.ktor.utils.io.ByteWriteChannel r5 = r5.channel     // Catch:{ all -> 0x0045 }
            byte[] r10 = (byte[]) r10     // Catch:{ all -> 0x0045 }
            int r6 = r2.getOffset()     // Catch:{ all -> 0x0045 }
            int r7 = r2.getLength()     // Catch:{ all -> 0x0045 }
            r0.L$0 = r2     // Catch:{ all -> 0x0045 }
            r8 = 0
            r0.L$1 = r8     // Catch:{ all -> 0x0045 }
            r0.label = r3     // Catch:{ all -> 0x0045 }
            java.lang.Object r10 = r5.writeFully(r10, r6, r7, r0)     // Catch:{ all -> 0x0045 }
            if (r10 != r1) goto L_0x004c
            return r1
        L_0x00d0:
            boolean r0 = r10 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x00de }
            if (r0 != 0) goto L_0x00dd
            io.ktor.utils.io.jvm.javaio.OutputAdapter r0 = r2.this$0     // Catch:{ all -> 0x00de }
            io.ktor.utils.io.ByteWriteChannel r0 = r0.channel     // Catch:{ all -> 0x00de }
            r0.close(r10)     // Catch:{ all -> 0x00de }
        L_0x00dd:
            throw r10     // Catch:{ all -> 0x00de }
        L_0x00de:
            r10 = move-exception
            io.ktor.utils.io.jvm.javaio.OutputAdapter r0 = r2.this$0
            io.ktor.utils.io.ByteWriteChannel r0 = r0.channel
            boolean r0 = io.ktor.utils.io.ByteWriteChannelKt.close(r0)
            if (r0 != 0) goto L_0x00f8
            io.ktor.utils.io.jvm.javaio.OutputAdapter r0 = r2.this$0
            io.ktor.utils.io.ByteWriteChannel r0 = r0.channel
            java.lang.Throwable r0 = r0.getClosedCause()
            if (r0 == 0) goto L_0x00f8
            throw r0
        L_0x00f8:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1.loop(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
