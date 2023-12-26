package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"io/ktor/utils/io/jvm/javaio/InputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "loop", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Blocking.kt */
public final class InputAdapter$loop$1 extends BlockingAdapter {
    final /* synthetic */ InputAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputAdapter$loop$1(Job job, InputAdapter inputAdapter) {
        super(job);
        this.this$0 = inputAdapter;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object loop(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1 r0 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1 r0 = new io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1$loop$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1 r2 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0087
        L_0x0031:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0039:
            java.lang.Object r2 = r0.L$1
            io.ktor.utils.io.jvm.javaio.BlockingAdapter r2 = (io.ktor.utils.io.jvm.javaio.BlockingAdapter) r2
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1 r2 = (io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0069
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 0
            r2 = r9
        L_0x004a:
            r5 = r2
            io.ktor.utils.io.jvm.javaio.BlockingAdapter r5 = (io.ktor.utils.io.jvm.javaio.BlockingAdapter) r5
            r5.result = r10
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r4
            r10 = r0
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            java.lang.Object r5 = r5.rendezvousBlock(r10)
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r6) goto L_0x0065
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r10)
        L_0x0065:
            if (r5 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r10 = r5
        L_0x0069:
            byte[] r10 = (byte[]) r10
            io.ktor.utils.io.jvm.javaio.InputAdapter r5 = r2.this$0
            io.ktor.utils.io.ByteReadChannel r5 = r5.channel
            int r6 = r2.getOffset()
            int r7 = r2.getLength()
            r0.L$0 = r2
            r8 = 0
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r10 = r5.readAvailable(r10, r6, r7, r0)
            if (r10 != r1) goto L_0x0087
            return r1
        L_0x0087:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r5 = -1
            if (r10 != r5) goto L_0x004a
            io.ktor.utils.io.jvm.javaio.InputAdapter r0 = r2.this$0
            kotlinx.coroutines.CompletableJob r0 = r0.context
            r0.complete()
            r2.finish(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1.loop(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
