package io.ktor.websocket;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00014B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\b\u00103\u001a\u000201H\u0017R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon;", "Lio/ktor/websocket/WebSocketSession;", "input", "Lio/ktor/utils/io/ByteReadChannel;", "output", "Lio/ktor/utils/io/ByteWriteChannel;", "maxFrameSize", "", "masking", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;)V", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_outgoing", "", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "extensions", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "incoming", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "lastOpcode", "", "getMasking", "()Z", "setMasking", "(Z)V", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "readerJob", "Lkotlinx/coroutines/Job;", "socketJob", "Lkotlinx/coroutines/CompletableJob;", "writerJob", "flush", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "FlushRequest", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RawWebSocketCommon.kt */
public final class RawWebSocketCommon implements WebSocketSession {
    /* access modifiers changed from: private */
    public final Channel<Frame> _incoming;
    /* access modifiers changed from: private */
    public final Channel<Object> _outgoing;
    private final CoroutineContext coroutineContext;
    /* access modifiers changed from: private */
    public final ByteReadChannel input;
    /* access modifiers changed from: private */
    public int lastOpcode;
    private boolean masking;
    private long maxFrameSize;
    /* access modifiers changed from: private */
    public final ByteWriteChannel output;
    private final Job readerJob;
    private final CompletableJob socketJob;
    private final Job writerJob;

    public RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext2) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "input");
        Intrinsics.checkNotNullParameter(byteWriteChannel, "output");
        Intrinsics.checkNotNullParameter(coroutineContext2, "coroutineContext");
        this.input = byteReadChannel;
        this.output = byteWriteChannel;
        this.maxFrameSize = j;
        this.masking = z;
        CoroutineContext Job = JobKt.Job(coroutineContext2.get(Job.Key));
        this.socketJob = Job;
        this._incoming = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this._outgoing = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.coroutineContext = coroutineContext2.plus(Job).plus(new CoroutineName("raw-ws"));
        CoroutineScope coroutineScope = this;
        this.writerJob = BuildersKt.launch(coroutineScope, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new RawWebSocketCommon$writerJob$1(this, (Continuation<? super RawWebSocketCommon$writerJob$1>) null));
        this.readerJob = BuildersKt.launch(coroutineScope, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new RawWebSocketCommon$readerJob$1(this, (Continuation<? super RawWebSocketCommon$readerJob$1>) null));
        Job.complete();
    }

    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return WebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteWriteChannel, (i & 4) != 0 ? 2147483647L : j, (i & 8) != 0 ? false : z, coroutineContext2);
    }

    public long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    public boolean getMasking() {
        return this.masking;
    }

    public void setMasking(boolean z) {
        this.masking = z;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public ReceiveChannel<Frame> getIncoming() {
        return (ReceiveChannel) this._incoming;
    }

    public SendChannel<Frame> getOutgoing() {
        return (SendChannel) this._outgoing;
    }

    public List<WebSocketExtension<?>> getExtensions() {
        return CollectionsKt.emptyList();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0079, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r2.complete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        r7 = r8;
        r5 = r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:16:0x004e, B:19:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079 A[ExcHandler: all (r9v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r2 
      PHI: (r2v4 io.ktor.websocket.RawWebSocketCommon$FlushRequest) = (r2v5 io.ktor.websocket.RawWebSocketCommon$FlushRequest), (r2v7 io.ktor.websocket.RawWebSocketCommon$FlushRequest), (r2v7 io.ktor.websocket.RawWebSocketCommon$FlushRequest) binds: [B:19:0x0068, B:16:0x004e, B:17:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:16:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object flush(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.RawWebSocketCommon$flush$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = (io.ktor.websocket.RawWebSocketCommon$flush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = new io.ktor.websocket.RawWebSocketCommon$flush$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0052
            if (r2 == r5) goto L_0x0042
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a5
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x003a:
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r2 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0095
        L_0x0042:
            java.lang.Object r2 = r0.L$2
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r2 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r2
            java.lang.Object r5 = r0.L$1
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r5 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r5
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.RawWebSocketCommon r7 = (io.ktor.websocket.RawWebSocketCommon) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ ClosedSendChannelException -> 0x0080, all -> 0x0079 }
            goto L_0x0096
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r2 = new io.ktor.websocket.RawWebSocketCommon$FlushRequest
            kotlin.coroutines.CoroutineContext r9 = r8.getCoroutineContext()
            kotlinx.coroutines.Job$Key r7 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r7 = (kotlin.coroutines.CoroutineContext.Key) r7
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r7)
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            r2.<init>(r9)
            kotlinx.coroutines.channels.Channel<java.lang.Object> r9 = r8._outgoing     // Catch:{ ClosedSendChannelException -> 0x007e, all -> 0x0079 }
            r0.L$0 = r8     // Catch:{ ClosedSendChannelException -> 0x007e, all -> 0x0079 }
            r0.L$1 = r2     // Catch:{ ClosedSendChannelException -> 0x007e, all -> 0x0079 }
            r0.L$2 = r2     // Catch:{ ClosedSendChannelException -> 0x007e, all -> 0x0079 }
            r0.label = r5     // Catch:{ ClosedSendChannelException -> 0x007e, all -> 0x0079 }
            java.lang.Object r9 = r9.send(r2, r0)     // Catch:{ ClosedSendChannelException -> 0x007e, all -> 0x0079 }
            if (r9 != r1) goto L_0x0095
            return r1
        L_0x0079:
            r9 = move-exception
            r2.complete()
            throw r9
        L_0x007e:
            r7 = r8
            r5 = r2
        L_0x0080:
            r2.complete()
            kotlinx.coroutines.Job r9 = r7.writerJob
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r9 = r9.join(r0)
            if (r9 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r2 = r5
        L_0x0095:
            r5 = r2
        L_0x0096:
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r9 = r5.await(r0)
            if (r9 != r1) goto L_0x00a5
            return r1
        L_0x00a5:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon.flush(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        SendChannel.DefaultImpls.close$default(getOutgoing(), (Throwable) null, 1, (Object) null);
        this.socketJob.complete();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon$FlushRequest;", "", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "done", "Lkotlinx/coroutines/CompletableJob;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RawWebSocketCommon.kt */
    private static final class FlushRequest {
        private final CompletableJob done;

        public FlushRequest(Job job) {
            this.done = JobKt.Job(job);
        }

        public final boolean complete() {
            return this.done.complete();
        }

        public final Object await(Continuation<? super Unit> continuation) {
            Object join = this.done.join(continuation);
            return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
        }
    }
}
