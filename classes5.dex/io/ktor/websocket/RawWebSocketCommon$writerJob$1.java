package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1}, l = {58, 60}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
/* compiled from: RawWebSocketCommon.kt */
final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$writerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007c A[Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A[Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0117 A[SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x00f3=Splitter:B:50:0x00f3, B:45:0x00cc=Splitter:B:45:0x00cc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            java.lang.String r4 = "WebSocket closed."
            r5 = 0
            if (r1 == 0) goto L_0x002e
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            java.lang.Object r1 = r11.L$0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ ChannelWriteException -> 0x002a, all -> 0x0026 }
            r12 = r11
            goto L_0x006f
        L_0x0018:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ ChannelWriteException -> 0x002a, all -> 0x0026 }
            r1 = r0
            r0 = r11
            goto L_0x004a
        L_0x0026:
            r12 = move-exception
            r0 = r11
            goto L_0x00cc
        L_0x002a:
            r12 = move-exception
            r0 = r11
            goto L_0x00f3
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
        L_0x0032:
            io.ktor.websocket.RawWebSocketCommon r1 = r12.this$0     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            kotlinx.coroutines.channels.Channel r1 = r1._outgoing     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            r6 = r12
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            r12.L$0 = r5     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            r12.label = r3     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            java.lang.Object r1 = r1.receive(r6)     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            if (r1 != r0) goto L_0x0046
            return r0
        L_0x0046:
            r10 = r0
            r0 = r12
            r12 = r1
            r1 = r10
        L_0x004a:
            boolean r6 = r12 instanceof io.ktor.websocket.Frame     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            if (r6 == 0) goto L_0x00a1
            io.ktor.websocket.RawWebSocketCommon r6 = r0.this$0     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            io.ktor.utils.io.ByteWriteChannel r6 = r6.output     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r7 = r12
            io.ktor.websocket.Frame r7 = (io.ktor.websocket.Frame) r7     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            io.ktor.websocket.RawWebSocketCommon r8 = r0.this$0     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            boolean r8 = r8.getMasking()     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r0.L$0 = r12     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r0.label = r2     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            java.lang.Object r6 = io.ktor.websocket.RawWebSocketCommonKt.writeFrame(r6, r7, r8, r9)     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            if (r6 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r10 = r1
            r1 = r12
            r12 = r0
            r0 = r10
        L_0x006f:
            io.ktor.websocket.RawWebSocketCommon r6 = r12.this$0     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            io.ktor.utils.io.ByteWriteChannel r6 = r6.output     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            r6.flush()     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            boolean r1 = r1 instanceof io.ktor.websocket.Frame.Close     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            if (r1 == 0) goto L_0x0032
            io.ktor.websocket.RawWebSocketCommon r0 = r12.this$0     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            kotlinx.coroutines.channels.Channel r0 = r0._outgoing     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            kotlinx.coroutines.channels.SendChannel r0 = (kotlinx.coroutines.channels.SendChannel) r0     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r5, r3, r5)     // Catch:{ ChannelWriteException -> 0x00ef, all -> 0x00c8 }
            io.ktor.websocket.RawWebSocketCommon r0 = r12.this$0
            kotlinx.coroutines.channels.Channel r0 = r0._outgoing
            java.util.concurrent.CancellationException r1 = kotlinx.coroutines.ExceptionsKt.CancellationException(r4, r5)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r0.close(r1)
            io.ktor.websocket.RawWebSocketCommon r0 = r12.this$0
            io.ktor.utils.io.ByteWriteChannel r0 = r0.output
            io.ktor.utils.io.ByteWriteChannelKt.close(r0)
            goto L_0x0107
        L_0x00a1:
            boolean r6 = r12 instanceof io.ktor.websocket.RawWebSocketCommon.FlushRequest     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            if (r6 == 0) goto L_0x00ad
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r12 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r12     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r12.complete()     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r12 = r0
            r0 = r1
            goto L_0x0032
        L_0x00ad:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r2.<init>()     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            java.lang.String r3 = "unknown message "
            r2.append(r3)     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r2.append(r12)     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            java.lang.String r12 = r2.toString()     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            r1.<init>(r12)     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
            throw r1     // Catch:{ ChannelWriteException -> 0x00c6, all -> 0x00c4 }
        L_0x00c4:
            r12 = move-exception
            goto L_0x00cc
        L_0x00c6:
            r12 = move-exception
            goto L_0x00f3
        L_0x00c8:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        L_0x00cc:
            io.ktor.websocket.RawWebSocketCommon r1 = r0.this$0     // Catch:{ all -> 0x0124 }
            kotlinx.coroutines.channels.Channel r1 = r1._outgoing     // Catch:{ all -> 0x0124 }
            r1.close(r12)     // Catch:{ all -> 0x0124 }
        L_0x00d5:
            io.ktor.websocket.RawWebSocketCommon r12 = r0.this$0
            kotlinx.coroutines.channels.Channel r12 = r12._outgoing
            java.util.concurrent.CancellationException r1 = kotlinx.coroutines.ExceptionsKt.CancellationException(r4, r5)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r12.close(r1)
            io.ktor.websocket.RawWebSocketCommon r12 = r0.this$0
            io.ktor.utils.io.ByteWriteChannel r12 = r12.output
            io.ktor.utils.io.ByteWriteChannelKt.close(r12)
            r12 = r0
            goto L_0x0107
        L_0x00ef:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        L_0x00f3:
            io.ktor.websocket.RawWebSocketCommon r1 = r0.this$0     // Catch:{ all -> 0x0124 }
            kotlinx.coroutines.channels.Channel r1 = r1._outgoing     // Catch:{ all -> 0x0124 }
            java.lang.String r2 = "Failed to write to WebSocket."
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch:{ all -> 0x0124 }
            java.util.concurrent.CancellationException r12 = kotlinx.coroutines.ExceptionsKt.CancellationException(r2, r12)     // Catch:{ all -> 0x0124 }
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch:{ all -> 0x0124 }
            r1.close(r12)     // Catch:{ all -> 0x0124 }
            goto L_0x00d5
        L_0x0107:
            io.ktor.websocket.RawWebSocketCommon r0 = r12.this$0
            kotlinx.coroutines.channels.Channel r0 = r0._outgoing
            java.lang.Object r0 = r0.tryReceive-PtdJZtk()
            java.lang.Object r0 = kotlinx.coroutines.channels.ChannelResult.getOrNull-impl(r0)
            if (r0 != 0) goto L_0x011a
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x011a:
            boolean r1 = r0 instanceof io.ktor.websocket.RawWebSocketCommon.FlushRequest
            if (r1 == 0) goto L_0x0107
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r0 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r0
            r0.complete()
            goto L_0x0107
        L_0x0124:
            r12 = move-exception
            io.ktor.websocket.RawWebSocketCommon r1 = r0.this$0
            kotlinx.coroutines.channels.Channel r1 = r1._outgoing
            java.util.concurrent.CancellationException r2 = kotlinx.coroutines.ExceptionsKt.CancellationException(r4, r5)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r1.close(r2)
            io.ktor.websocket.RawWebSocketCommon r0 = r0.this$0
            io.ktor.utils.io.ByteWriteChannel r0 = r0.output
            io.ktor.utils.io.ByteWriteChannelKt.close(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$writerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
