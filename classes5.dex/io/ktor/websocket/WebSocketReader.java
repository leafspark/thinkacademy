package io.ktor.websocket;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001*B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0011\u0010#\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020$2\u0006\u0010'\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lio/ktor/websocket/WebSocketReader;", "Lkotlinx/coroutines/CoroutineScope;", "byteChannel", "Lio/ktor/utils/io/ByteReadChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "maxFrameSize", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;JLio/ktor/utils/io/pool/ObjectPool;)V", "collector", "Lio/ktor/websocket/SimpleFrameCollector;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "frameParser", "Lio/ktor/websocket/FrameParser;", "incoming", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lio/ktor/websocket/Frame;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "queue", "Lkotlinx/coroutines/channels/Channel;", "readerJob", "Lkotlinx/coroutines/Job;", "getReaderJob$annotations", "()V", "state", "Lio/ktor/websocket/WebSocketReader$State;", "handleFrameIfProduced", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseLoop", "buffer", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLoop", "State", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSocketReader.kt */
public final class WebSocketReader implements CoroutineScope {
    private final ByteReadChannel byteChannel;
    private final SimpleFrameCollector collector;
    private final CoroutineContext coroutineContext;
    private final FrameParser frameParser;
    private long maxFrameSize;
    /* access modifiers changed from: private */
    public final Channel<Frame> queue;
    private final Job readerJob;
    private State state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/websocket/WebSocketReader$State;", "", "(Ljava/lang/String;I)V", "HEADER", "BODY", "CLOSED", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebSocketReader.kt */
    private enum State {
        HEADER,
        BODY,
        CLOSED
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebSocketReader.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.HEADER.ordinal()] = 1;
            iArr[State.BODY.ordinal()] = 2;
            iArr[State.CLOSED.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getReaderJob$annotations() {
    }

    public WebSocketReader(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext2, long j, ObjectPool<ByteBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "byteChannel");
        Intrinsics.checkNotNullParameter(coroutineContext2, "coroutineContext");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.byteChannel = byteReadChannel;
        this.coroutineContext = coroutineContext2;
        this.maxFrameSize = j;
        this.state = State.HEADER;
        this.frameParser = new FrameParser();
        this.collector = new SimpleFrameCollector();
        this.queue = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.readerJob = BuildersKt.launch(this, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new WebSocketReader$readerJob$1(objectPool, this, (Continuation<? super WebSocketReader$readerJob$1>) null));
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebSocketReader(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext2, long j, ObjectPool<ByteBuffer> objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, coroutineContext2, j, (i & 8) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }

    public final ReceiveChannel<Frame> getIncoming() {
        return (ReceiveChannel) this.queue;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readLoop(java.nio.ByteBuffer r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.WebSocketReader$readLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.websocket.WebSocketReader$readLoop$1 r0 = (io.ktor.websocket.WebSocketReader$readLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.WebSocketReader$readLoop$1 r0 = new io.ktor.websocket.WebSocketReader$readLoop$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r8 = r0.L$1
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.WebSocketReader r2 = (io.ktor.websocket.WebSocketReader) r2
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x0034:
            r9 = r2
            goto L_0x0087
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.L$1
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.WebSocketReader r2 = (io.ktor.websocket.WebSocketReader) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0069
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r9)
            r8.clear()
            r9 = r7
        L_0x0051:
            io.ktor.websocket.WebSocketReader$State r2 = r9.state
            io.ktor.websocket.WebSocketReader$State r5 = io.ktor.websocket.WebSocketReader.State.CLOSED
            if (r2 == r5) goto L_0x008b
            io.ktor.utils.io.ByteReadChannel r2 = r9.byteChannel
            r0.L$0 = r9
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r2.readAvailable((java.nio.ByteBuffer) r8, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r2 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r6 = r2
            r2 = r9
            r9 = r6
        L_0x0069:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            r5 = -1
            if (r9 != r5) goto L_0x0077
            io.ktor.websocket.WebSocketReader$State r8 = io.ktor.websocket.WebSocketReader.State.CLOSED
            r2.state = r8
            goto L_0x008b
        L_0x0077:
            r8.flip()
            r0.L$0 = r2
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r2.parseLoop(r8, r0)
            if (r9 != r1) goto L_0x0034
            return r1
        L_0x0087:
            r8.compact()
            goto L_0x0051
        L_0x008b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketReader.readLoop(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object parseLoop(java.nio.ByteBuffer r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.websocket.WebSocketReader$parseLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.websocket.WebSocketReader$parseLoop$1 r0 = (io.ktor.websocket.WebSocketReader$parseLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.WebSocketReader$parseLoop$1 r0 = new io.ktor.websocket.WebSocketReader$parseLoop$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0029
            if (r2 != r3) goto L_0x0035
        L_0x0029:
            java.lang.Object r10 = r0.L$1
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.WebSocketReader r2 = (io.ktor.websocket.WebSocketReader) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0041
        L_0x0035:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r11)
            r2 = r9
        L_0x0041:
            boolean r11 = r10.hasRemaining()
            if (r11 == 0) goto L_0x00c0
            io.ktor.websocket.WebSocketReader$State r11 = r2.state
            int[] r5 = io.ktor.websocket.WebSocketReader.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r11 = r5[r11]
            if (r11 == r4) goto L_0x006e
            if (r11 == r3) goto L_0x005c
            r5 = 3
            if (r11 == r5) goto L_0x0059
            goto L_0x0041
        L_0x0059:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x005c:
            io.ktor.websocket.SimpleFrameCollector r11 = r2.collector
            r11.handle(r10)
            r0.L$0 = r2
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r11 = r2.handleFrameIfProduced(r0)
            if (r11 != r1) goto L_0x0041
            return r1
        L_0x006e:
            io.ktor.websocket.FrameParser r11 = r2.frameParser
            r11.frame(r10)
            io.ktor.websocket.FrameParser r11 = r2.frameParser
            boolean r11 = r11.getBodyReady()
            if (r11 == 0) goto L_0x00bd
            io.ktor.websocket.WebSocketReader$State r11 = io.ktor.websocket.WebSocketReader.State.BODY
            r2.state = r11
            io.ktor.websocket.FrameParser r11 = r2.frameParser
            long r5 = r11.getLength()
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 > 0) goto L_0x00b1
            io.ktor.websocket.FrameParser r11 = r2.frameParser
            long r5 = r11.getLength()
            long r7 = r2.maxFrameSize
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 > 0) goto L_0x00b1
            io.ktor.websocket.SimpleFrameCollector r11 = r2.collector
            io.ktor.websocket.FrameParser r5 = r2.frameParser
            long r5 = r5.getLength()
            int r5 = (int) r5
            r11.start(r5, r10)
            r0.L$0 = r2
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = r2.handleFrameIfProduced(r0)
            if (r11 != r1) goto L_0x0041
            return r1
        L_0x00b1:
            io.ktor.websocket.FrameTooBigException r10 = new io.ktor.websocket.FrameTooBigException
            io.ktor.websocket.FrameParser r11 = r2.frameParser
            long r0 = r11.getLength()
            r10.<init>(r0)
            throw r10
        L_0x00bd:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00c0:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketReader.parseLoop(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleFrameIfProduced(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1 r0 = (io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1 r0 = new io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            io.ktor.websocket.WebSocketReader r0 = (io.ktor.websocket.WebSocketReader) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x008a
        L_0x002e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r12)
            io.ktor.websocket.SimpleFrameCollector r12 = r11.collector
            boolean r12 = r12.getHasRemaining()
            if (r12 != 0) goto L_0x008f
            io.ktor.websocket.FrameParser r12 = r11.frameParser
            io.ktor.websocket.FrameType r12 = r12.getFrameType()
            io.ktor.websocket.FrameType r2 = io.ktor.websocket.FrameType.CLOSE
            if (r12 != r2) goto L_0x004e
            io.ktor.websocket.WebSocketReader$State r12 = io.ktor.websocket.WebSocketReader.State.CLOSED
            goto L_0x0050
        L_0x004e:
            io.ktor.websocket.WebSocketReader$State r12 = io.ktor.websocket.WebSocketReader.State.HEADER
        L_0x0050:
            r11.state = r12
            io.ktor.websocket.FrameParser r12 = r11.frameParser
            io.ktor.websocket.Frame$Companion r4 = io.ktor.websocket.Frame.Companion
            boolean r5 = r12.getFin()
            io.ktor.websocket.FrameType r6 = r12.getFrameType()
            io.ktor.websocket.SimpleFrameCollector r2 = r11.collector
            java.lang.Integer r7 = r12.getMaskKey()
            java.nio.ByteBuffer r2 = r2.take(r7)
            byte[] r7 = io.ktor.util.NIOKt.moveToByteArray(r2)
            boolean r8 = r12.getRsv1()
            boolean r9 = r12.getRsv2()
            boolean r10 = r12.getRsv3()
            io.ktor.websocket.Frame r12 = r4.byType(r5, r6, r7, r8, r9, r10)
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame> r2 = r11.queue
            r0.L$0 = r11
            r0.label = r3
            java.lang.Object r12 = r2.send(r12, r0)
            if (r12 != r1) goto L_0x0089
            return r1
        L_0x0089:
            r0 = r11
        L_0x008a:
            io.ktor.websocket.FrameParser r12 = r0.frameParser
            r12.bodyComplete()
        L_0x008f:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketReader.handleFrameIfProduced(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
