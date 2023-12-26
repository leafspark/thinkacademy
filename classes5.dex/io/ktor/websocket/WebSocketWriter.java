package io.ktor.websocket;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.pool.ObjectPool;
import io.ktor.websocket.Frame;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u00010B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020#H\u0002J!\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020#2\u0006\u0010'\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010!\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lio/ktor/websocket/WebSocketWriter;", "Lkotlinx/coroutines/CoroutineScope;", "writeChannel", "Lio/ktor/utils/io/ByteWriteChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "masking", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;ZLio/ktor/utils/io/pool/ObjectPool;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getMasking", "()Z", "setMasking", "(Z)V", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "queue", "Lkotlinx/coroutines/channels/Channel;", "", "serializer", "Lio/ktor/websocket/Serializer;", "writeLoopJob", "Lkotlinx/coroutines/Job;", "getWriteLoopJob$annotations", "()V", "close", "", "drainQueueAndDiscard", "drainQueueAndSerialize", "firstMsg", "buffer", "(Lio/ktor/websocket/Frame;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "frame", "(Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLoop", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FlushRequest", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebSocketWriter.kt */
public final class WebSocketWriter implements CoroutineScope {
    private final CoroutineContext coroutineContext;
    private boolean masking;
    private final ObjectPool<ByteBuffer> pool;
    private final Channel<Object> queue;
    private final Serializer serializer;
    private final ByteWriteChannel writeChannel;
    private final Job writeLoopJob;

    private static /* synthetic */ void getWriteLoopJob$annotations() {
    }

    public WebSocketWriter(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext2, boolean z, ObjectPool<ByteBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "writeChannel");
        Intrinsics.checkNotNullParameter(coroutineContext2, "coroutineContext");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.writeChannel = byteWriteChannel;
        this.coroutineContext = coroutineContext2;
        this.masking = z;
        this.pool = objectPool;
        this.queue = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.serializer = new Serializer();
        this.writeLoopJob = BuildersKt.launch(this, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new WebSocketWriter$writeLoopJob$1(this, (Continuation<? super WebSocketWriter$writeLoopJob$1>) null));
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final boolean getMasking() {
        return this.masking;
    }

    public final void setMasking(boolean z) {
        this.masking = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebSocketWriter(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext2, boolean z, ObjectPool<ByteBuffer> objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteWriteChannel, coroutineContext2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }

    public final ObjectPool<ByteBuffer> getPool() {
        return this.pool;
    }

    public final SendChannel<Frame> getOutgoing() {
        return (SendChannel) this.queue;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080 A[Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d A[Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ae A[Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x00d6=Splitter:B:50:0x00d6, B:55:0x00ee=Splitter:B:55:0x00ee} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeLoop(java.nio.ByteBuffer r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof io.ktor.websocket.WebSocketWriter$writeLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.ktor.websocket.WebSocketWriter$writeLoop$1 r0 = (io.ktor.websocket.WebSocketWriter$writeLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.WebSocketWriter$writeLoop$1 r0 = new io.ktor.websocket.WebSocketWriter$writeLoop$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            java.lang.String r6 = "WebSocket closed."
            if (r2 == 0) goto L_0x0065
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r11 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r11 = (kotlinx.coroutines.channels.ChannelIterator) r11
            java.lang.Object r2 = r0.L$1
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.WebSocketWriter r7 = (io.ktor.websocket.WebSocketWriter) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r9 = r0
            r0 = r11
            r11 = r2
            r2 = r1
            r1 = r9
            goto L_0x00a6
        L_0x0042:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004a:
            java.lang.Object r11 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r11 = (kotlinx.coroutines.channels.ChannelIterator) r11
            java.lang.Object r2 = r0.L$1
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.WebSocketWriter r7 = (io.ktor.websocket.WebSocketWriter) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r9 = r0
            r0 = r11
            r11 = r2
        L_0x005c:
            r2 = r1
            r1 = r9
            goto L_0x0085
        L_0x005f:
            r11 = move-exception
            goto L_0x00d6
        L_0x0062:
            r11 = move-exception
            goto L_0x00ee
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r12)
            r11.clear()
            kotlinx.coroutines.channels.Channel<java.lang.Object> r12 = r10.queue     // Catch:{ ChannelWriteException -> 0x00ec, all -> 0x00d4 }
            kotlinx.coroutines.channels.ChannelIterator r12 = r12.iterator()     // Catch:{ ChannelWriteException -> 0x00ec, all -> 0x00d4 }
            r7 = r10
        L_0x0072:
            r0.L$0 = r7     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r0.L$1 = r11     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r0.L$2 = r12     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r0.label = r4     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            java.lang.Object r2 = r12.hasNext(r0)     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            if (r2 != r1) goto L_0x0081
            return r1
        L_0x0081:
            r9 = r0
            r0 = r12
            r12 = r2
            goto L_0x005c
        L_0x0085:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            boolean r12 = r12.booleanValue()     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            if (r12 == 0) goto L_0x00db
            java.lang.Object r12 = r0.next()     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            boolean r8 = r12 instanceof io.ktor.websocket.Frame     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            if (r8 == 0) goto L_0x00b3
            io.ktor.websocket.Frame r12 = (io.ktor.websocket.Frame) r12     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r1.L$0 = r7     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r1.L$1 = r11     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r1.L$2 = r0     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r1.label = r3     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            java.lang.Object r12 = r7.drainQueueAndSerialize(r12, r11, r1)     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            if (r12 != r2) goto L_0x00a6
            return r2
        L_0x00a6:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            boolean r12 = r12.booleanValue()     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            if (r12 == 0) goto L_0x00af
            goto L_0x00db
        L_0x00af:
            r12 = r0
            r0 = r1
            r1 = r2
            goto L_0x0072
        L_0x00b3:
            boolean r8 = r12 instanceof io.ktor.websocket.WebSocketWriter.FlushRequest     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            if (r8 == 0) goto L_0x00bd
            io.ktor.websocket.WebSocketWriter$FlushRequest r12 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r12     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r12.complete()     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            goto L_0x00af
        L_0x00bd:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r0.<init>()     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            java.lang.String r1 = "unknown message "
            r0.append(r1)     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r0.append(r12)     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            java.lang.String r12 = r0.toString()     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            r11.<init>(r12)     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
            throw r11     // Catch:{ ChannelWriteException -> 0x0062, all -> 0x005f }
        L_0x00d4:
            r11 = move-exception
            r7 = r10
        L_0x00d6:
            kotlinx.coroutines.channels.Channel<java.lang.Object> r12 = r7.queue     // Catch:{ all -> 0x0104 }
            r12.close(r11)     // Catch:{ all -> 0x0104 }
        L_0x00db:
            kotlinx.coroutines.channels.Channel<java.lang.Object> r11 = r7.queue
            java.util.concurrent.CancellationException r12 = kotlinx.coroutines.ExceptionsKt.CancellationException(r6, r5)
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            r11.close(r12)
            io.ktor.utils.io.ByteWriteChannel r11 = r7.writeChannel
            io.ktor.utils.io.ByteWriteChannelKt.close(r11)
            goto L_0x00fe
        L_0x00ec:
            r11 = move-exception
            r7 = r10
        L_0x00ee:
            kotlinx.coroutines.channels.Channel<java.lang.Object> r12 = r7.queue     // Catch:{ all -> 0x0104 }
            java.lang.String r0 = "Failed to write to WebSocket."
            java.lang.Throwable r11 = (java.lang.Throwable) r11     // Catch:{ all -> 0x0104 }
            java.util.concurrent.CancellationException r11 = kotlinx.coroutines.ExceptionsKt.CancellationException(r0, r11)     // Catch:{ all -> 0x0104 }
            java.lang.Throwable r11 = (java.lang.Throwable) r11     // Catch:{ all -> 0x0104 }
            r12.close(r11)     // Catch:{ all -> 0x0104 }
            goto L_0x00db
        L_0x00fe:
            r7.drainQueueAndDiscard()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0104:
            r11 = move-exception
            kotlinx.coroutines.channels.Channel<java.lang.Object> r12 = r7.queue
            java.util.concurrent.CancellationException r0 = kotlinx.coroutines.ExceptionsKt.CancellationException(r6, r5)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r12.close(r0)
            io.ktor.utils.io.ByteWriteChannel r12 = r7.writeChannel
            io.ktor.utils.io.ByteWriteChannelKt.close(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.writeLoop(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void drainQueueAndDiscard() {
        SendChannel.DefaultImpls.close$default(this.queue, (Throwable) null, 1, (Object) null);
        while (true) {
            try {
                Object r0 = ChannelResult.getOrNull-impl(this.queue.tryReceive-PtdJZtk());
                if (r0 != null) {
                    if (!(r0 instanceof Frame.Close)) {
                        if (r0 instanceof Frame.Ping ? true : r0 instanceof Frame.Pong) {
                            continue;
                        } else if (r0 instanceof FlushRequest) {
                            ((FlushRequest) r0).complete();
                        } else {
                            if (!(r0 instanceof Frame.Text ? true : r0 instanceof Frame.Binary)) {
                                throw new IllegalArgumentException("unknown message " + r0);
                            }
                        }
                    }
                } else {
                    return;
                }
            } catch (CancellationException unused) {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a6 A[ADDED_TO_REGION, EDGE_INSN: B:65:0x00a6->B:31:0x00a6 ?: BREAK  , SYNTHETIC] */
    public final java.lang.Object drainQueueAndSerialize(io.ktor.websocket.Frame r8, java.nio.ByteBuffer r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1 r0 = (io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1 r0 = new io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r4) goto L_0x003c
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r2 = r0.L$1
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketWriter r5 = (io.ktor.websocket.WebSocketWriter) r5
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L_0x00fc
        L_0x003c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            io.ktor.websocket.Serializer r2 = r7.serializer
            r2.enqueue(r8)
            boolean r8 = r8 instanceof io.ktor.websocket.Frame.Close
            r2 = r7
        L_0x0054:
            java.lang.Object r5 = r10.element
            if (r5 != 0) goto L_0x00a6
            if (r8 != 0) goto L_0x00a6
            io.ktor.websocket.Serializer r5 = r2.serializer
            int r5 = r5.getRemainingCapacity()
            if (r5 <= 0) goto L_0x00a6
            kotlinx.coroutines.channels.Channel<java.lang.Object> r5 = r2.queue
            java.lang.Object r5 = r5.tryReceive-PtdJZtk()
            java.lang.Object r5 = kotlinx.coroutines.channels.ChannelResult.getOrNull-impl(r5)
            if (r5 != 0) goto L_0x006f
            goto L_0x00a6
        L_0x006f:
            boolean r6 = r5 instanceof io.ktor.websocket.WebSocketWriter.FlushRequest
            if (r6 == 0) goto L_0x0076
            r10.element = r5
            goto L_0x0054
        L_0x0076:
            boolean r6 = r5 instanceof io.ktor.websocket.Frame.Close
            if (r6 == 0) goto L_0x0083
            io.ktor.websocket.Serializer r8 = r2.serializer
            io.ktor.websocket.Frame r5 = (io.ktor.websocket.Frame) r5
            r8.enqueue(r5)
            r8 = r4
            goto L_0x0054
        L_0x0083:
            boolean r6 = r5 instanceof io.ktor.websocket.Frame
            if (r6 == 0) goto L_0x008f
            io.ktor.websocket.Serializer r6 = r2.serializer
            io.ktor.websocket.Frame r5 = (io.ktor.websocket.Frame) r5
            r6.enqueue(r5)
            goto L_0x0054
        L_0x008f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "unknown message "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x00a6:
            if (r8 == 0) goto L_0x00af
            kotlinx.coroutines.channels.Channel<java.lang.Object> r5 = r2.queue
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r5, r3, r4, r3)
        L_0x00af:
            io.ktor.websocket.Serializer r5 = r2.serializer
            boolean r5 = r5.getHasOutstandingBytes()
            if (r5 != 0) goto L_0x00d9
            int r5 = r9.position()
            if (r5 == 0) goto L_0x00be
            goto L_0x00d9
        L_0x00be:
            io.ktor.utils.io.ByteWriteChannel r9 = r2.writeChannel
            r9.flush()
            java.lang.Object r9 = r10.element
            io.ktor.websocket.WebSocketWriter$FlushRequest r9 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r9
            if (r9 == 0) goto L_0x00d0
            boolean r9 = r9.complete()
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
        L_0x00d0:
            if (r8 == 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r4 = 0
        L_0x00d4:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        L_0x00d9:
            io.ktor.websocket.Serializer r5 = r2.serializer
            boolean r6 = r2.masking
            r5.setMasking(r6)
            io.ktor.websocket.Serializer r5 = r2.serializer
            r5.serialize(r9)
            r9.flip()
            r5 = r2
        L_0x00e9:
            io.ktor.utils.io.ByteWriteChannel r2 = r5.writeChannel
            r0.L$0 = r5
            r0.L$1 = r9
            r0.L$2 = r10
            r0.I$0 = r8
            r0.label = r4
            java.lang.Object r2 = r2.writeFully((java.nio.ByteBuffer) r9, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r2 != r1) goto L_0x00fc
            return r1
        L_0x00fc:
            io.ktor.websocket.Serializer r2 = r5.serializer
            boolean r2 = r2.getHasOutstandingBytes()
            if (r2 != 0) goto L_0x011a
            boolean r2 = r9.hasRemaining()
            if (r2 != 0) goto L_0x011a
            java.lang.Object r2 = r10.element
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r2
            if (r2 == 0) goto L_0x011a
            io.ktor.utils.io.ByteWriteChannel r6 = r5.writeChannel
            r6.flush()
            r2.complete()
            r10.element = r3
        L_0x011a:
            java.lang.Object r2 = r10.element
            if (r2 != 0) goto L_0x0120
            if (r8 == 0) goto L_0x0126
        L_0x0120:
            boolean r2 = r9.hasRemaining()
            if (r2 != 0) goto L_0x00e9
        L_0x0126:
            r9.compact()
            r2 = r5
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.drainQueueAndSerialize(io.ktor.websocket.Frame, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object send(Frame frame, Continuation<? super Unit> continuation) {
        Object send = this.queue.send(frame, continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
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
      PHI: (r2v4 io.ktor.websocket.WebSocketWriter$FlushRequest) = (r2v5 io.ktor.websocket.WebSocketWriter$FlushRequest), (r2v7 io.ktor.websocket.WebSocketWriter$FlushRequest), (r2v7 io.ktor.websocket.WebSocketWriter$FlushRequest) binds: [B:19:0x0068, B:16:0x004e, B:17:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:16:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object flush(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.WebSocketWriter$flush$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.websocket.WebSocketWriter$flush$1 r0 = (io.ktor.websocket.WebSocketWriter$flush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.websocket.WebSocketWriter$flush$1 r0 = new io.ktor.websocket.WebSocketWriter$flush$1
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
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0095
        L_0x0042:
            java.lang.Object r2 = r0.L$2
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r2
            java.lang.Object r5 = r0.L$1
            io.ktor.websocket.WebSocketWriter$FlushRequest r5 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r5
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.WebSocketWriter r7 = (io.ktor.websocket.WebSocketWriter) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ ClosedSendChannelException -> 0x0080, all -> 0x0079 }
            goto L_0x0096
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = new io.ktor.websocket.WebSocketWriter$FlushRequest
            kotlin.coroutines.CoroutineContext r9 = r8.getCoroutineContext()
            kotlinx.coroutines.Job$Key r7 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r7 = (kotlin.coroutines.CoroutineContext.Key) r7
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r7)
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            r2.<init>(r9)
            kotlinx.coroutines.channels.Channel<java.lang.Object> r9 = r8.queue     // Catch:{ ClosedSendChannelException -> 0x007e, all -> 0x0079 }
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
            kotlinx.coroutines.Job r9 = r7.writeLoopJob
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.flush(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Will be removed")
    public final void close() {
        SendChannel.DefaultImpls.close$default(this.queue, (Throwable) null, 1, (Object) null);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lio/ktor/websocket/WebSocketWriter$FlushRequest;", "", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "done", "Lkotlinx/coroutines/CompletableJob;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebSocketWriter.kt */
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
