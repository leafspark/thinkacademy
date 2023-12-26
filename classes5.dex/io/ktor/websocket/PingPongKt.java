package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"PingerCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "PongerCoroutineName", "pinger", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Pong;", "Lkotlinx/coroutines/CoroutineScope;", "outgoing", "Lio/ktor/websocket/Frame;", "periodMillis", "", "timeoutMillis", "ponger", "Lio/ktor/websocket/Frame$Ping;", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PingPong.kt */
public final class PingPongKt {
    private static final CoroutineName PingerCoroutineName = new CoroutineName("ws-pinger");
    private static final CoroutineName PongerCoroutineName = new CoroutineName("ws-ponger");

    public static final SendChannel<Frame.Ping> ponger(CoroutineScope coroutineScope, SendChannel<? super Frame.Pong> sendChannel) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(sendChannel, "outgoing");
        SendChannel<Frame.Ping> Channel$default = ChannelKt.Channel$default(5, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, PongerCoroutineName, (CoroutineStart) null, new PingPongKt$ponger$1(Channel$default, sendChannel, (Continuation<? super PingPongKt$ponger$1>) null), 2, (Object) null);
        return (SendChannel) Channel$default;
    }

    public static final SendChannel<Frame.Pong> pinger(CoroutineScope coroutineScope, SendChannel<? super Frame> sendChannel, long j, long j2) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(sendChannel, "outgoing");
        CompletableJob Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
        SendChannel<Frame.Pong> Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Job$default.plus(PingerCoroutineName), (CoroutineStart) null, new PingPongKt$pinger$1(j, j2, sendChannel, Channel$default, (Continuation<? super PingPongKt$pinger$1>) null), 2, (Object) null);
        Job job = coroutineScope.getCoroutineContext().get(Job.Key);
        Intrinsics.checkNotNull(job);
        job.invokeOnCompletion(new PingPongKt$pinger$2(Job$default));
        return (SendChannel) Channel$default;
    }
}
