package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoopKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\"\u0018\u00002\u00020\u0010B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0007H¤@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005HHø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001fR\u0016\u0010!\u001a\u0004\u0018\u00010 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010\u001e\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00058\u0004@BX\u000e¢\u0006\f\n\u0004\b\u001e\u0010&\u001a\u0004\b'\u0010(R$\u0010\u001d\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00058\u0004@BX\u000e¢\u0006\f\n\u0004\b\u001d\u0010&\u001a\u0004\b)\u0010(R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010*\u001a\u0004\b+\u0010,\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "rc", "", "finish", "(I)V", "loop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Thread;", "thread", "parkingLoop", "(Ljava/lang/Thread;)V", "", "rendezvous", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "ucont", "rendezvousBlock", "shutdown", "()V", "jobToken", "submitAndAwait", "(Ljava/lang/Object;)I", "", "buffer", "offset", "length", "([BII)I", "Lkotlinx/coroutines/DisposableHandle;", "disposable", "Lkotlinx/coroutines/DisposableHandle;", "end", "Lkotlin/coroutines/Continuation;", "<set-?>", "I", "getLength", "()I", "getOffset", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Blocking.kt */
abstract class BlockingAdapter {
    static final /* synthetic */ AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(BlockingAdapter.class, Object.class, "state");
    /* access modifiers changed from: private */
    public final DisposableHandle disposable;
    /* access modifiers changed from: private */
    public final Continuation<Unit> end;
    private int length;
    private int offset;
    private final Job parent;
    volatile /* synthetic */ int result;
    volatile /* synthetic */ Object state;

    public BlockingAdapter() {
        this((Job) null, 1, (DefaultConstructorMarker) null);
    }

    private static /* synthetic */ void getState$annotations() {
    }

    /* access modifiers changed from: protected */
    public abstract Object loop(Continuation<? super Unit> continuation);

    public BlockingAdapter(Job job) {
        this.parent = job;
        Continuation<Unit> continuation = (Continuation) new BlockingAdapter$end$1(this);
        this.end = continuation;
        this.state = this;
        boolean z = false;
        this.result = 0;
        this.disposable = job != null ? job.invokeOnCompletion(new BlockingAdapter$disposable$1(this)) : null;
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new BlockingAdapter$block$1(this, (Continuation<? super BlockingAdapter$block$1>) null), 1)).invoke(continuation);
        if (!(this.state != this ? true : z)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlockingAdapter(Job job, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : job);
    }

    public final Job getParent() {
        return this.parent;
    }

    /* access modifiers changed from: protected */
    public final int getOffset() {
        return this.offset;
    }

    /* access modifiers changed from: protected */
    public final int getLength() {
        return this.length;
    }

    public final void shutdown() {
        DisposableHandle disposableHandle = this.disposable;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Continuation<Unit> continuation = this.end;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m320constructorimpl(ResultKt.createFailure(new CancellationException("Stream closed"))));
    }

    public final int submitAndAwait(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.offset = i;
        this.length = i2;
        return submitAndAwait(bArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.coroutines.Continuation} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int submitAndAwait(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.String r0 = "jobToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r1 = 0
        L_0x000a:
            java.lang.Object r2 = r5.state
            boolean r3 = r2 instanceof kotlin.coroutines.Continuation
            if (r3 == 0) goto L_0x0015
            r1 = r2
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r3 = r0
            goto L_0x002f
        L_0x0015:
            boolean r3 = r2 instanceof kotlin.Unit
            if (r3 == 0) goto L_0x001c
            int r6 = r5.result
            return r6
        L_0x001c:
            boolean r3 = r2 instanceof java.lang.Throwable
            if (r3 != 0) goto L_0x006d
            boolean r3 = r2 instanceof java.lang.Thread
            if (r3 != 0) goto L_0x0065
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
            if (r3 != 0) goto L_0x005d
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
        L_0x002f:
            java.lang.String r4 = "when (value) {\n         …Exception()\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = state$FU
            boolean r2 = r4.compareAndSet(r5, r2, r3)
            if (r2 != 0) goto L_0x003d
            goto L_0x000a
        L_0x003d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.Result.m320constructorimpl(r6)
            r1.resumeWith(r6)
            java.lang.String r6 = "thread"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            r5.parkingLoop(r0)
            java.lang.Object r6 = r5.state
            boolean r0 = r6 instanceof java.lang.Throwable
            if (r0 != 0) goto L_0x005a
            int r6 = r5.result
            return r6
        L_0x005a:
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        L_0x005d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Not yet started"
            r6.<init>(r0)
            throw r6
        L_0x0065:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "There is already thread owning adapter"
            r6.<init>(r0)
            throw r6
        L_0x006d:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.BlockingAdapter.submitAndAwait(java.lang.Object):int");
    }

    private final void parkingLoop(Thread thread) {
        if (this.state == thread) {
            while (true) {
                long processNextEventInCurrentThread = EventLoopKt.processNextEventInCurrentThread();
                if (this.state != thread) {
                    return;
                }
                if (processNextEventInCurrentThread > 0) {
                    PollersKt.getParkingImpl().park(processNextEventInCurrentThread);
                }
            }
        }
    }

    private final Object rendezvous$$forInline(int i, Continuation<Object> continuation) {
        this.result = i;
        InlineMarker.mark(0);
        Object access$rendezvousBlock = rendezvousBlock(continuation);
        if (access$rendezvousBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return access$rendezvousBlock;
    }

    /* access modifiers changed from: protected */
    public final Object rendezvous(int i, Continuation<Object> continuation) {
        this.result = i;
        Object access$rendezvousBlock = rendezvousBlock(continuation);
        if (access$rendezvousBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return access$rendezvousBlock;
    }

    /* access modifiers changed from: protected */
    public final void finish(int i) {
        this.result = i;
    }

    /* access modifiers changed from: private */
    public final Object rendezvousBlock(Continuation<Object> continuation) {
        Object obj;
        Continuation continuation2;
        Object obj2 = null;
        while (true) {
            Object obj3 = this.state;
            if (obj3 instanceof Thread) {
                continuation2 = IntrinsicsKt.intercepted(continuation);
                obj = obj3;
            } else if (Intrinsics.areEqual(obj3, this)) {
                obj = obj2;
                continuation2 = IntrinsicsKt.intercepted(continuation);
            } else {
                throw new IllegalStateException("Already suspended or in finished state");
            }
            if (!state$FU.compareAndSet(this, obj3, continuation2)) {
                obj2 = obj;
            } else {
                if (obj != null) {
                    PollersKt.getParkingImpl().unpark(obj);
                }
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }
    }
}
