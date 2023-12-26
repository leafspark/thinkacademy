package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", i = {0, 0, 0, 1, 1, 1, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6}, l = {320, 161, 208, 166, 167, 169, 193, 208, 208, 208, 208}, m = "invokeSuspend", n = {"last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", "frame", "last", "closeFramePresented", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$4", "L$0", "L$1", "L$4", "L$0", "L$1", "L$4", "L$6", "L$0", "L$1", "L$4"})
/* compiled from: DefaultWebSocketSession.kt */
final class DefaultWebSocketSessionImpl$runIncomingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<Frame.Ping> $ponger;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultWebSocketSessionImpl$runIncomingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, SendChannel<? super Frame.Ping> sendChannel, Continuation<? super DefaultWebSocketSessionImpl$runIncomingProcessor$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
        this.$ponger = sendChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this.this$0, this.$ponger, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: kotlin.coroutines.Continuation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v35, resolved type: kotlinx.coroutines.channels.ReceiveChannel<io.ktor.websocket.Frame>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: kotlin.jvm.internal.Ref$BooleanRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02ab, code lost:
        if (r13.send(r0, r12) != r2) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02ad, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02ae, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02af, code lost:
        r7 = r0;
        r9 = r10;
        r10 = r11;
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02b7, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r11.$ponger, (java.lang.Throwable) null, 1, (java.lang.Object) null);
        r0 = (io.ktor.utils.io.core.BytePacketBuilder) r10.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02c0, code lost:
        if (r0 == null) goto L_0x02c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02c2, code lost:
        r0.release();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02c7, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r11.this$0.filtered, (java.lang.Throwable) null, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02d4, code lost:
        if (r9.element != false) goto L_0x03eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02d6, code lost:
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.L$5 = null;
        r11.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02f8, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close(r11.this$0, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), (kotlin.coroutines.Continuation<? super kotlin.Unit>) (kotlin.coroutines.Continuation) r11) != r2) goto L_0x03eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02fa, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02fb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02fc, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02fe, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02ff, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0303, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0304, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        kotlin.ResultKt.throwOnFailure(r29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0088, code lost:
        r11 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r11.L$0 = r10;
        r11.L$1 = r9;
        r11.L$2 = r0;
        r11.L$3 = r7;
        r11.L$4 = r6;
        r11.L$5 = r8;
        r11.L$6 = null;
        r11.label = 1;
        r12 = r8.hasNext(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x011f, code lost:
        if (r12 != r2) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0121, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0122, code lost:
        r27 = r8;
        r8 = r0;
        r0 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012d, code lost:
        if (((java.lang.Boolean) r12).booleanValue() == false) goto L_0x02b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012f, code lost:
        r12 = (io.ktor.websocket.Frame) r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0137, code lost:
        if ((r12 instanceof io.ktor.websocket.Frame.Close) == false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0141, code lost:
        if (r8.getOutgoing().isClosedForSend() != false) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0143, code lost:
        r0 = r8.getOutgoing();
        r8 = io.ktor.websocket.FrameCommonKt.readReason((io.ktor.websocket.Frame.Close) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x014f, code lost:
        if (r8 != null) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0151, code lost:
        r8 = io.ktor.websocket.DefaultWebSocketSessionKt.NORMAL_CLOSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0155, code lost:
        r7 = new io.ktor.websocket.Frame.Close(r8);
        r11.L$0 = r10;
        r11.L$1 = r9;
        r11.L$2 = r6;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.L$5 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x016b, code lost:
        if (r0.send(r7, r11) != r2) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x016d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x016e, code lost:
        r9.element = true;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0175, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r11.$ponger, (java.lang.Throwable) null, 1, (java.lang.Object) null);
        r6 = (io.ktor.utils.io.core.BytePacketBuilder) r10.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x017e, code lost:
        if (r6 == null) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0180, code lost:
        r6.release();
        r6 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0185, code lost:
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r11.this$0.filtered, (java.lang.Throwable) null, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0192, code lost:
        if (r9.element != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0194, code lost:
        r11.L$0 = r0;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.L$5 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b5, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close(r11.this$0, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), (kotlin.coroutines.Continuation<? super kotlin.Unit>) (kotlin.coroutines.Continuation) r11) != r2) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01b7, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01bb, code lost:
        if ((r12 instanceof io.ktor.websocket.Frame.Pong) == false) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01bd, code lost:
        r13 = (kotlinx.coroutines.channels.SendChannel) r8.pinger;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c1, code lost:
        if (r13 == null) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c3, code lost:
        r11.L$0 = r10;
        r11.L$1 = r9;
        r11.L$2 = r8;
        r11.L$3 = r7;
        r11.L$4 = r6;
        r11.L$5 = r0;
        r11.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01d6, code lost:
        if (r13.send(r12, r11) != r2) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01d8, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d9, code lost:
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01db, code lost:
        r27 = r8;
        r8 = r0;
        r0 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e4, code lost:
        if ((r12 instanceof io.ktor.websocket.Frame.Ping) == false) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01e6, code lost:
        r11.L$0 = r10;
        r11.L$1 = r9;
        r11.L$2 = r8;
        r11.L$3 = r7;
        r11.L$4 = r6;
        r11.L$5 = r0;
        r11.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01f9, code lost:
        if (r7.send(r12, r11) != r2) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01fb, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01fc, code lost:
        r11.L$0 = r10;
        r11.L$1 = r9;
        r11.L$2 = r8;
        r11.L$3 = r7;
        r11.L$4 = r6;
        r11.L$5 = r0;
        r11.L$6 = r12;
        r11.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0215, code lost:
        if (r8.checkMaxFrameSize((io.ktor.utils.io.core.BytePacketBuilder) r10.element, r12, r11) != r2) goto L_0x0218;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0217, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0218, code lost:
        r27 = r9;
        r9 = r0;
        r0 = r12;
        r12 = r11;
        r11 = r10;
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0224, code lost:
        if (r0.getFin() != false) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0228, code lost:
        if (r11.element != null) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x022a, code lost:
        r11.element = new io.ktor.utils.io.core.BytePacketBuilder((io.ktor.utils.io.pool.ObjectPool) null, 1, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0231, code lost:
        r13 = r11.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
        io.ktor.utils.io.core.OutputKt.writeFully$default((io.ktor.utils.io.core.Output) r13, r0.getData(), 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0248, code lost:
        r0 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x024f, code lost:
        r13 = (io.ktor.utils.io.core.BytePacketBuilder) r11.element;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0253, code lost:
        if (r13 == null) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0255, code lost:
        io.ktor.utils.io.core.OutputKt.writeFully$default((io.ktor.utils.io.core.Output) r13, r0.getData(), 0, 0, 6, (java.lang.Object) null);
        r13 = io.ktor.websocket.Frame.Companion.byType(true, r0.getFrameType(), io.ktor.utils.io.core.StringsKt.readBytes$default(r13.build(), 0, 1, (java.lang.Object) null), r0.getRsv1(), r0.getRsv2(), r0.getRsv3());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0288, code lost:
        if (r13 != null) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x028b, code lost:
        r0 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x028c, code lost:
        r11.element = null;
        r13 = r8.filtered;
        r0 = r8.processIncomingExtensions(r0);
        r12.L$0 = r11;
        r12.L$1 = r10;
        r12.L$2 = r8;
        r12.L$3 = r7;
        r12.L$4 = r6;
        r12.L$5 = r9;
        r12.L$6 = null;
        r12.label = 7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:56:0x0172, B:116:0x02fd] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            r28 = this;
            r1 = r28
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            java.lang.String r3 = "Connection was closed without close frame"
            r4 = 1
            r5 = 0
            switch(r0) {
                case 0: goto L_0x00eb;
                case 1: goto L_0x00c7;
                case 2: goto L_0x00b2;
                case 3: goto L_0x00a9;
                case 4: goto L_0x008b;
                case 5: goto L_0x006d;
                case 6: goto L_0x003e;
                case 7: goto L_0x0025;
                case 8: goto L_0x0020;
                case 9: goto L_0x0020;
                case 10: goto L_0x0020;
                case 11: goto L_0x0017;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0017:
            java.lang.Object r0 = r1.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r29)
            goto L_0x03a3
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r29)
            goto L_0x03eb
        L_0x0025:
            java.lang.Object r0 = r1.L$5
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$3
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$2
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            goto L_0x0085
        L_0x003e:
            java.lang.Object r0 = r1.L$6
            io.ktor.websocket.Frame r0 = (io.ktor.websocket.Frame) r0
            java.lang.Object r6 = r1.L$5
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r1.L$3
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            java.lang.Object r9 = r1.L$2
            io.ktor.websocket.DefaultWebSocketSessionImpl r9 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r9
            java.lang.Object r10 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            kotlin.ResultKt.throwOnFailure(r29)     // Catch:{ all -> 0x0067 }
            r12 = r1
            r27 = r9
            r9 = r6
            r6 = r7
            r7 = r8
            r8 = r27
            goto L_0x0220
        L_0x0067:
            r0 = move-exception
            r6 = r7
            r9 = r10
            r10 = r11
            goto L_0x00e7
        L_0x006d:
            java.lang.Object r0 = r1.L$5
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$3
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$2
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r29)     // Catch:{ all -> 0x00e6 }
            r11 = r1
            goto L_0x01db
        L_0x008b:
            java.lang.Object r0 = r1.L$5
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$3
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$2
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            kotlin.ResultKt.throwOnFailure(r29)     // Catch:{ all -> 0x00e6 }
            r11 = r1
            goto L_0x01d9
        L_0x00a9:
            java.lang.Object r0 = r1.L$0
            kotlin.Unit r0 = (kotlin.Unit) r0
            kotlin.ResultKt.throwOnFailure(r29)
            goto L_0x01b8
        L_0x00b2:
            java.lang.Object r0 = r1.L$2
            r6 = r0
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r0 = r1.L$1
            r9 = r0
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r0 = r1.L$0
            r10 = r0
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            kotlin.ResultKt.throwOnFailure(r29)     // Catch:{ all -> 0x00e6 }
            r11 = r1
            goto L_0x016e
        L_0x00c7:
            java.lang.Object r0 = r1.L$5
            kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
            java.lang.Object r6 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r1.L$3
            kotlinx.coroutines.channels.SendChannel r7 = (kotlinx.coroutines.channels.SendChannel) r7
            java.lang.Object r8 = r1.L$2
            io.ktor.websocket.DefaultWebSocketSessionImpl r8 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r8
            java.lang.Object r9 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$0
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            kotlin.ResultKt.throwOnFailure(r29)     // Catch:{ all -> 0x00e6 }
            r12 = r29
            r11 = r1
            goto L_0x0127
        L_0x00e6:
            r0 = move-exception
        L_0x00e7:
            r7 = r0
            r11 = r1
            goto L_0x02fd
        L_0x00eb:
            kotlin.ResultKt.throwOnFailure(r29)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef
            r9.<init>()
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r1.this$0     // Catch:{ ClosedSendChannelException -> 0x03a4, all -> 0x0306 }
            io.ktor.websocket.WebSocketSession r0 = r0.raw     // Catch:{ ClosedSendChannelException -> 0x03a4, all -> 0x0306 }
            kotlinx.coroutines.channels.ReceiveChannel r6 = r0.getIncoming()     // Catch:{ ClosedSendChannelException -> 0x03a4, all -> 0x0306 }
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r1.this$0     // Catch:{ ClosedSendChannelException -> 0x03a4, all -> 0x0306 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r7 = r1.$ponger     // Catch:{ ClosedSendChannelException -> 0x03a4, all -> 0x0306 }
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x00e6 }
            r11 = r1
        L_0x010b:
            r11.L$0 = r10     // Catch:{ all -> 0x02fb }
            r11.L$1 = r9     // Catch:{ all -> 0x02fb }
            r11.L$2 = r0     // Catch:{ all -> 0x02fb }
            r11.L$3 = r7     // Catch:{ all -> 0x02fb }
            r11.L$4 = r6     // Catch:{ all -> 0x02fb }
            r11.L$5 = r8     // Catch:{ all -> 0x02fb }
            r11.L$6 = r5     // Catch:{ all -> 0x02fb }
            r11.label = r4     // Catch:{ all -> 0x02fb }
            java.lang.Object r12 = r8.hasNext(r11)     // Catch:{ all -> 0x02fb }
            if (r12 != r2) goto L_0x0122
            return r2
        L_0x0122:
            r27 = r8
            r8 = r0
            r0 = r27
        L_0x0127:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x02fb }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x02fb }
            if (r12 == 0) goto L_0x02b4
            java.lang.Object r12 = r0.next()     // Catch:{ all -> 0x02fb }
            io.ktor.websocket.Frame r12 = (io.ktor.websocket.Frame) r12     // Catch:{ all -> 0x02fb }
            boolean r13 = r12 instanceof io.ktor.websocket.Frame.Close     // Catch:{ all -> 0x02fb }
            if (r13 == 0) goto L_0x01b9
            kotlinx.coroutines.channels.SendChannel r0 = r8.getOutgoing()     // Catch:{ all -> 0x02fb }
            boolean r0 = r0.isClosedForSend()     // Catch:{ all -> 0x02fb }
            if (r0 != 0) goto L_0x016e
            kotlinx.coroutines.channels.SendChannel r0 = r8.getOutgoing()     // Catch:{ all -> 0x02fb }
            io.ktor.websocket.Frame$Close r7 = new io.ktor.websocket.Frame$Close     // Catch:{ all -> 0x02fb }
            io.ktor.websocket.Frame$Close r12 = (io.ktor.websocket.Frame.Close) r12     // Catch:{ all -> 0x02fb }
            io.ktor.websocket.CloseReason r8 = io.ktor.websocket.FrameCommonKt.readReason(r12)     // Catch:{ all -> 0x02fb }
            if (r8 != 0) goto L_0x0155
            io.ktor.websocket.CloseReason r8 = io.ktor.websocket.DefaultWebSocketSessionKt.NORMAL_CLOSE     // Catch:{ all -> 0x02fb }
        L_0x0155:
            r7.<init>((io.ktor.websocket.CloseReason) r8)     // Catch:{ all -> 0x02fb }
            r11.L$0 = r10     // Catch:{ all -> 0x02fb }
            r11.L$1 = r9     // Catch:{ all -> 0x02fb }
            r11.L$2 = r6     // Catch:{ all -> 0x02fb }
            r11.L$3 = r5     // Catch:{ all -> 0x02fb }
            r11.L$4 = r5     // Catch:{ all -> 0x02fb }
            r11.L$5 = r5     // Catch:{ all -> 0x02fb }
            r8 = 2
            r11.label = r8     // Catch:{ all -> 0x02fb }
            java.lang.Object r0 = r0.send(r7, r11)     // Catch:{ all -> 0x02fb }
            if (r0 != r2) goto L_0x016e
            return r2
        L_0x016e:
            r9.element = r4     // Catch:{ all -> 0x02fb }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x02fb }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)     // Catch:{ ClosedSendChannelException -> 0x03a5, all -> 0x0304 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r6 = r11.$ponger
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r6, r5, r4, r5)
            java.lang.Object r6 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r6 = (io.ktor.utils.io.core.BytePacketBuilder) r6
            if (r6 == 0) goto L_0x0185
            r6.release()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x0185:
            io.ktor.websocket.DefaultWebSocketSessionImpl r6 = r11.this$0
            kotlinx.coroutines.channels.Channel r6 = r6.filtered
            kotlinx.coroutines.channels.SendChannel r6 = (kotlinx.coroutines.channels.SendChannel) r6
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r6, r5, r4, r5)
            boolean r4 = r9.element
            if (r4 != 0) goto L_0x01b8
            io.ktor.websocket.DefaultWebSocketSessionImpl r4 = r11.this$0
            io.ktor.websocket.WebSocketSession r4 = (io.ktor.websocket.WebSocketSession) r4
            io.ktor.websocket.CloseReason r6 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r7 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r6.<init>((io.ktor.websocket.CloseReason.Codes) r7, (java.lang.String) r3)
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r11.L$0 = r0
            r11.L$1 = r5
            r11.L$2 = r5
            r11.L$3 = r5
            r11.L$4 = r5
            r11.L$5 = r5
            r5 = 3
            r11.label = r5
            java.lang.Object r3 = io.ktor.websocket.WebSocketSessionKt.close((io.ktor.websocket.WebSocketSession) r4, (io.ktor.websocket.CloseReason) r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)
            if (r3 != r2) goto L_0x01b8
            return r2
        L_0x01b8:
            return r0
        L_0x01b9:
            boolean r13 = r12 instanceof io.ktor.websocket.Frame.Pong     // Catch:{ all -> 0x02fb }
            if (r13 == 0) goto L_0x01e2
            java.lang.Object r13 = r8.pinger     // Catch:{ all -> 0x02fb }
            kotlinx.coroutines.channels.SendChannel r13 = (kotlinx.coroutines.channels.SendChannel) r13     // Catch:{ all -> 0x02fb }
            if (r13 == 0) goto L_0x01db
            r11.L$0 = r10     // Catch:{ all -> 0x02fb }
            r11.L$1 = r9     // Catch:{ all -> 0x02fb }
            r11.L$2 = r8     // Catch:{ all -> 0x02fb }
            r11.L$3 = r7     // Catch:{ all -> 0x02fb }
            r11.L$4 = r6     // Catch:{ all -> 0x02fb }
            r11.L$5 = r0     // Catch:{ all -> 0x02fb }
            r14 = 4
            r11.label = r14     // Catch:{ all -> 0x02fb }
            java.lang.Object r12 = r13.send(r12, r11)     // Catch:{ all -> 0x02fb }
            if (r12 != r2) goto L_0x01d9
            return r2
        L_0x01d9:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x02fb }
        L_0x01db:
            r27 = r8
            r8 = r0
            r0 = r27
            goto L_0x010b
        L_0x01e2:
            boolean r13 = r12 instanceof io.ktor.websocket.Frame.Ping     // Catch:{ all -> 0x02fb }
            if (r13 == 0) goto L_0x01fc
            r11.L$0 = r10     // Catch:{ all -> 0x02fb }
            r11.L$1 = r9     // Catch:{ all -> 0x02fb }
            r11.L$2 = r8     // Catch:{ all -> 0x02fb }
            r11.L$3 = r7     // Catch:{ all -> 0x02fb }
            r11.L$4 = r6     // Catch:{ all -> 0x02fb }
            r11.L$5 = r0     // Catch:{ all -> 0x02fb }
            r13 = 5
            r11.label = r13     // Catch:{ all -> 0x02fb }
            java.lang.Object r12 = r7.send(r12, r11)     // Catch:{ all -> 0x02fb }
            if (r12 != r2) goto L_0x01db
            return r2
        L_0x01fc:
            java.lang.Object r13 = r10.element     // Catch:{ all -> 0x02fb }
            io.ktor.utils.io.core.BytePacketBuilder r13 = (io.ktor.utils.io.core.BytePacketBuilder) r13     // Catch:{ all -> 0x02fb }
            r11.L$0 = r10     // Catch:{ all -> 0x02fb }
            r11.L$1 = r9     // Catch:{ all -> 0x02fb }
            r11.L$2 = r8     // Catch:{ all -> 0x02fb }
            r11.L$3 = r7     // Catch:{ all -> 0x02fb }
            r11.L$4 = r6     // Catch:{ all -> 0x02fb }
            r11.L$5 = r0     // Catch:{ all -> 0x02fb }
            r11.L$6 = r12     // Catch:{ all -> 0x02fb }
            r14 = 6
            r11.label = r14     // Catch:{ all -> 0x02fb }
            java.lang.Object r13 = r8.checkMaxFrameSize(r13, r12, r11)     // Catch:{ all -> 0x02fb }
            if (r13 != r2) goto L_0x0218
            return r2
        L_0x0218:
            r27 = r9
            r9 = r0
            r0 = r12
            r12 = r11
            r11 = r10
            r10 = r27
        L_0x0220:
            boolean r13 = r0.getFin()     // Catch:{ all -> 0x02ae }
            if (r13 != 0) goto L_0x024f
            java.lang.Object r13 = r11.element     // Catch:{ all -> 0x02ae }
            if (r13 != 0) goto L_0x0231
            io.ktor.utils.io.core.BytePacketBuilder r13 = new io.ktor.utils.io.core.BytePacketBuilder     // Catch:{ all -> 0x02ae }
            r13.<init>(r5, r4, r5)     // Catch:{ all -> 0x02ae }
            r11.element = r13     // Catch:{ all -> 0x02ae }
        L_0x0231:
            java.lang.Object r13 = r11.element     // Catch:{ all -> 0x02ae }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ all -> 0x02ae }
            r14 = r13
            io.ktor.utils.io.core.Output r14 = (io.ktor.utils.io.core.Output) r14     // Catch:{ all -> 0x02ae }
            byte[] r15 = r0.getData()     // Catch:{ all -> 0x02ae }
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            io.ktor.utils.io.core.OutputKt.writeFully$default((io.ktor.utils.io.core.Output) r14, (byte[]) r15, (int) r16, (int) r17, (int) r18, (java.lang.Object) r19)     // Catch:{ all -> 0x02ae }
        L_0x0248:
            r0 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            goto L_0x010b
        L_0x024f:
            java.lang.Object r13 = r11.element     // Catch:{ all -> 0x02ae }
            io.ktor.utils.io.core.BytePacketBuilder r13 = (io.ktor.utils.io.core.BytePacketBuilder) r13     // Catch:{ all -> 0x02ae }
            if (r13 == 0) goto L_0x028c
            r14 = r13
            io.ktor.utils.io.core.Output r14 = (io.ktor.utils.io.core.Output) r14     // Catch:{ all -> 0x02ae }
            byte[] r15 = r0.getData()     // Catch:{ all -> 0x02ae }
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            io.ktor.utils.io.core.OutputKt.writeFully$default((io.ktor.utils.io.core.Output) r14, (byte[]) r15, (int) r16, (int) r17, (int) r18, (java.lang.Object) r19)     // Catch:{ all -> 0x02ae }
            io.ktor.websocket.Frame$Companion r20 = io.ktor.websocket.Frame.Companion     // Catch:{ all -> 0x02ae }
            r21 = 1
            io.ktor.websocket.FrameType r22 = r0.getFrameType()     // Catch:{ all -> 0x02ae }
            io.ktor.utils.io.core.ByteReadPacket r13 = r13.build()     // Catch:{ all -> 0x02ae }
            r14 = 0
            byte[] r23 = io.ktor.utils.io.core.StringsKt.readBytes$default(r13, r14, r4, r5)     // Catch:{ all -> 0x02ae }
            boolean r24 = r0.getRsv1()     // Catch:{ all -> 0x02ae }
            boolean r25 = r0.getRsv2()     // Catch:{ all -> 0x02ae }
            boolean r26 = r0.getRsv3()     // Catch:{ all -> 0x02ae }
            io.ktor.websocket.Frame r13 = r20.byType(r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x02ae }
            if (r13 != 0) goto L_0x028b
            goto L_0x028c
        L_0x028b:
            r0 = r13
        L_0x028c:
            r11.element = r5     // Catch:{ all -> 0x02ae }
            kotlinx.coroutines.channels.Channel r13 = r8.filtered     // Catch:{ all -> 0x02ae }
            io.ktor.websocket.Frame r0 = r8.processIncomingExtensions(r0)     // Catch:{ all -> 0x02ae }
            r12.L$0 = r11     // Catch:{ all -> 0x02ae }
            r12.L$1 = r10     // Catch:{ all -> 0x02ae }
            r12.L$2 = r8     // Catch:{ all -> 0x02ae }
            r12.L$3 = r7     // Catch:{ all -> 0x02ae }
            r12.L$4 = r6     // Catch:{ all -> 0x02ae }
            r12.L$5 = r9     // Catch:{ all -> 0x02ae }
            r12.L$6 = r5     // Catch:{ all -> 0x02ae }
            r14 = 7
            r12.label = r14     // Catch:{ all -> 0x02ae }
            java.lang.Object r0 = r13.send(r0, r12)     // Catch:{ all -> 0x02ae }
            if (r0 != r2) goto L_0x0248
            return r2
        L_0x02ae:
            r0 = move-exception
            r7 = r0
            r9 = r10
            r10 = r11
            r11 = r12
            goto L_0x02fd
        L_0x02b4:
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r5)     // Catch:{ ClosedSendChannelException -> 0x03a5, all -> 0x0304 }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r0 = r11.$ponger
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r5, r4, r5)
            java.lang.Object r0 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r0 = (io.ktor.utils.io.core.BytePacketBuilder) r0
            if (r0 == 0) goto L_0x02c7
            r0.release()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x02c7:
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r11.this$0
            kotlinx.coroutines.channels.Channel r0 = r0.filtered
            kotlinx.coroutines.channels.SendChannel r0 = (kotlinx.coroutines.channels.SendChannel) r0
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r5, r4, r5)
            boolean r0 = r9.element
            if (r0 != 0) goto L_0x03eb
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r11.this$0
            io.ktor.websocket.WebSocketSession r0 = (io.ktor.websocket.WebSocketSession) r0
            io.ktor.websocket.CloseReason r4 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r6 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r4.<init>((io.ktor.websocket.CloseReason.Codes) r6, (java.lang.String) r3)
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r11.L$0 = r5
            r11.L$1 = r5
            r11.L$2 = r5
            r11.L$3 = r5
            r11.L$4 = r5
            r11.L$5 = r5
            r5 = 8
            r11.label = r5
            java.lang.Object r0 = io.ktor.websocket.WebSocketSessionKt.close((io.ktor.websocket.WebSocketSession) r0, (io.ktor.websocket.CloseReason) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)
            if (r0 != r2) goto L_0x03eb
            return r2
        L_0x02fb:
            r0 = move-exception
            r7 = r0
        L_0x02fd:
            throw r7     // Catch:{ all -> 0x02fe }
        L_0x02fe:
            r0 = move-exception
            r8 = r0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r6, r7)     // Catch:{ ClosedSendChannelException -> 0x03a5, all -> 0x0304 }
            throw r8     // Catch:{ ClosedSendChannelException -> 0x03a5, all -> 0x0304 }
        L_0x0304:
            r0 = move-exception
            goto L_0x0308
        L_0x0306:
            r0 = move-exception
            r11 = r1
        L_0x0308:
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r6 = r11.$ponger     // Catch:{ all -> 0x035c }
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r6, r5, r4, r5)     // Catch:{ all -> 0x035c }
            io.ktor.websocket.DefaultWebSocketSessionImpl r6 = r11.this$0     // Catch:{ all -> 0x035c }
            kotlinx.coroutines.channels.Channel r6 = r6.filtered     // Catch:{ all -> 0x035c }
            r6.close(r0)     // Catch:{ all -> 0x035c }
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r0 = r11.$ponger
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r5, r4, r5)
            java.lang.Object r0 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r0 = (io.ktor.utils.io.core.BytePacketBuilder) r0
            if (r0 == 0) goto L_0x0326
            r0.release()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0326:
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r11.this$0
            kotlinx.coroutines.channels.Channel r0 = r0.filtered
            kotlinx.coroutines.channels.SendChannel r0 = (kotlinx.coroutines.channels.SendChannel) r0
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r5, r4, r5)
            boolean r0 = r9.element
            if (r0 != 0) goto L_0x03eb
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r11.this$0
            io.ktor.websocket.WebSocketSession r0 = (io.ktor.websocket.WebSocketSession) r0
            io.ktor.websocket.CloseReason r4 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r6 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r4.<init>((io.ktor.websocket.CloseReason.Codes) r6, (java.lang.String) r3)
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r11.L$0 = r5
            r11.L$1 = r5
            r11.L$2 = r5
            r11.L$3 = r5
            r11.L$4 = r5
            r11.L$5 = r5
            r11.L$6 = r5
            r5 = 10
            r11.label = r5
            java.lang.Object r0 = io.ktor.websocket.WebSocketSessionKt.close((io.ktor.websocket.WebSocketSession) r0, (io.ktor.websocket.CloseReason) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)
            if (r0 != r2) goto L_0x03eb
            return r2
        L_0x035c:
            r0 = move-exception
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r6 = r11.$ponger
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r6, r5, r4, r5)
            java.lang.Object r6 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r6 = (io.ktor.utils.io.core.BytePacketBuilder) r6
            if (r6 == 0) goto L_0x036d
            r6.release()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x036d:
            io.ktor.websocket.DefaultWebSocketSessionImpl r6 = r11.this$0
            kotlinx.coroutines.channels.Channel r6 = r6.filtered
            kotlinx.coroutines.channels.SendChannel r6 = (kotlinx.coroutines.channels.SendChannel) r6
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r6, r5, r4, r5)
            boolean r4 = r9.element
            if (r4 != 0) goto L_0x03a3
            io.ktor.websocket.DefaultWebSocketSessionImpl r4 = r11.this$0
            io.ktor.websocket.WebSocketSession r4 = (io.ktor.websocket.WebSocketSession) r4
            io.ktor.websocket.CloseReason r6 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r7 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r6.<init>((io.ktor.websocket.CloseReason.Codes) r7, (java.lang.String) r3)
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r11.L$0 = r0
            r11.L$1 = r5
            r11.L$2 = r5
            r11.L$3 = r5
            r11.L$4 = r5
            r11.L$5 = r5
            r11.L$6 = r5
            r5 = 11
            r11.label = r5
            java.lang.Object r3 = io.ktor.websocket.WebSocketSessionKt.close((io.ktor.websocket.WebSocketSession) r4, (io.ktor.websocket.CloseReason) r6, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)
            if (r3 != r2) goto L_0x03a3
            return r2
        L_0x03a3:
            throw r0
        L_0x03a4:
            r11 = r1
        L_0x03a5:
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Ping> r0 = r11.$ponger
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r5, r4, r5)
            java.lang.Object r0 = r10.element
            io.ktor.utils.io.core.BytePacketBuilder r0 = (io.ktor.utils.io.core.BytePacketBuilder) r0
            if (r0 == 0) goto L_0x03b5
            r0.release()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x03b5:
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r11.this$0
            kotlinx.coroutines.channels.Channel r0 = r0.filtered
            kotlinx.coroutines.channels.SendChannel r0 = (kotlinx.coroutines.channels.SendChannel) r0
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r5, r4, r5)
            boolean r0 = r9.element
            if (r0 != 0) goto L_0x03eb
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = r11.this$0
            io.ktor.websocket.WebSocketSession r0 = (io.ktor.websocket.WebSocketSession) r0
            io.ktor.websocket.CloseReason r4 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r6 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY
            r4.<init>((io.ktor.websocket.CloseReason.Codes) r6, (java.lang.String) r3)
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r11.L$0 = r5
            r11.L$1 = r5
            r11.L$2 = r5
            r11.L$3 = r5
            r11.L$4 = r5
            r11.L$5 = r5
            r11.L$6 = r5
            r5 = 9
            r11.label = r5
            java.lang.Object r0 = io.ktor.websocket.WebSocketSessionKt.close((io.ktor.websocket.WebSocketSession) r0, (io.ktor.websocket.CloseReason) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)
            if (r0 != r2) goto L_0x03eb
            return r2
        L_0x03eb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
