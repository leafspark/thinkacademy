package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B_\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012H\u0010\u0007\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\f0\b¢\u0006\u0002\u0010\rJ\u0016\u0010\u001f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\u001b\u0010!\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J\u0011\u0010(\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0019\u0010*\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001e\u0010+\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001aRP\u0010\u0007\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\f0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lio/ktor/util/pipeline/SuspendFunctionGun;", "TSubject", "", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "initial", "context", "blocks", "", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;)V", "continuation", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "index", "", "lastSuspensionIndex", "subject", "getSubject", "()Ljava/lang/Object;", "setSubject", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "suspensions", "", "[Lkotlin/coroutines/Continuation;", "addContinuation", "discardLastRootContinuation", "execute", "execute$ktor_utils", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "loop", "", "direct", "proceed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWith", "resumeRootWith", "result", "Lkotlin/Result;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SuspendFunctionGun.kt */
public final class SuspendFunctionGun<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> blocks;
    private final Continuation<Unit> continuation = ((Continuation) new SuspendFunctionGun$continuation$1(this));
    private int index;
    /* access modifiers changed from: private */
    public int lastSuspensionIndex;
    private TSubject subject;
    /* access modifiers changed from: private */
    public final Continuation<TSubject>[] suspensions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendFunctionGun(TSubject tsubject, TContext tcontext, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        super(tcontext);
        Intrinsics.checkNotNullParameter(tsubject, "initial");
        Intrinsics.checkNotNullParameter(tcontext, "context");
        Intrinsics.checkNotNullParameter(list, "blocks");
        this.blocks = list;
        this.subject = tsubject;
        this.suspensions = new Continuation[list.size()];
        this.lastSuspensionIndex = -1;
    }

    public CoroutineContext getCoroutineContext() {
        return this.continuation.getContext();
    }

    public TSubject getSubject() {
        return this.subject;
    }

    public void setSubject(TSubject tsubject) {
        Intrinsics.checkNotNullParameter(tsubject, "<set-?>");
        this.subject = tsubject;
    }

    public void finish() {
        this.index = this.blocks.size();
    }

    public Object proceed(Continuation<? super TSubject> continuation2) {
        Object obj;
        if (this.index == this.blocks.size()) {
            obj = getSubject();
        } else {
            addContinuation(continuation2);
            if (loop(true)) {
                discardLastRootContinuation();
                obj = getSubject();
            } else {
                obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation2);
        }
        return obj;
    }

    public Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation2) {
        setSubject(tsubject);
        return proceed(continuation2);
    }

    public Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation2) {
        this.index = 0;
        if (this.blocks.size() == 0) {
            return tsubject;
        }
        setSubject(tsubject);
        if (this.lastSuspensionIndex < 0) {
            return proceed(continuation2);
        }
        throw new IllegalStateException("Already started");
    }

    /* access modifiers changed from: private */
    public final boolean loop(boolean z) {
        int i;
        do {
            i = this.index;
            if (i != this.blocks.size()) {
                this.index = i + 1;
                try {
                } catch (Throwable th) {
                    Result.Companion companion = Result.Companion;
                    resumeRootWith(Result.m320constructorimpl(ResultKt.createFailure(th)));
                    return false;
                }
            } else if (z) {
                return true;
            } else {
                Result.Companion companion2 = Result.Companion;
                resumeRootWith(Result.m320constructorimpl(getSubject()));
                return false;
            }
        } while (((Function3) this.blocks.get(i)).invoke(this, getSubject(), this.continuation) != IntrinsicsKt.getCOROUTINE_SUSPENDED());
        return false;
    }

    /* access modifiers changed from: private */
    public final void resumeRootWith(Object obj) {
        int i = this.lastSuspensionIndex;
        if (i >= 0) {
            Continuation<TSubject> continuation2 = this.suspensions[i];
            Intrinsics.checkNotNull(continuation2);
            Continuation<TSubject>[] continuationArr = this.suspensions;
            int i2 = this.lastSuspensionIndex;
            this.lastSuspensionIndex = i2 - 1;
            continuationArr[i2] = null;
            if (!Result.m326isFailureimpl(obj)) {
                continuation2.resumeWith(obj);
                return;
            }
            Throwable r5 = Result.m323exceptionOrNullimpl(obj);
            Intrinsics.checkNotNull(r5);
            Throwable recoverStackTraceBridge = StackTraceRecoverKt.recoverStackTraceBridge(r5, continuation2);
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m320constructorimpl(ResultKt.createFailure(recoverStackTraceBridge)));
            return;
        }
        throw new IllegalStateException("No more continuations to resume".toString());
    }

    private final void discardLastRootContinuation() {
        int i = this.lastSuspensionIndex;
        if (i >= 0) {
            Continuation<TSubject>[] continuationArr = this.suspensions;
            this.lastSuspensionIndex = i - 1;
            continuationArr[i] = null;
            return;
        }
        throw new IllegalStateException("No more continuations to resume");
    }

    private final void addContinuation(Continuation<? super TSubject> continuation2) {
        Continuation<TSubject>[] continuationArr = this.suspensions;
        int i = this.lastSuspensionIndex + 1;
        this.lastSuspensionIndex = i;
        continuationArr[i] = continuation2;
    }
}
