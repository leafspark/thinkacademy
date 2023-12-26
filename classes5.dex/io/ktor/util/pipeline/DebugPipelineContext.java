package io.ktor.util.pipeline;

import io.ktor.util.KtorDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004Bg\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012H\u0010\u0006\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b0\u0007\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\nH\u0016J\u0011\u0010\u001e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0011\u0010 \u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010!\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000RP\u0010\u0006\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lio/ktor/util/pipeline/DebugPipelineContext;", "TSubject", "", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "context", "interceptors", "", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "subject", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "index", "", "getSubject", "()Ljava/lang/Object;", "setSubject", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "execute", "initial", "execute$ktor_utils", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "proceed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedLoop", "proceedWith", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
@KtorDsl
/* compiled from: DebugPipelineContext.kt */
public final class DebugPipelineContext<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    private final CoroutineContext coroutineContext;
    private int index;
    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptors;
    private TSubject subject;

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebugPipelineContext(TContext tcontext, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list, TSubject tsubject, CoroutineContext coroutineContext2) {
        super(tcontext);
        Intrinsics.checkNotNullParameter(tcontext, "context");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(tsubject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext2, "coroutineContext");
        this.interceptors = list;
        this.coroutineContext = coroutineContext2;
        this.subject = tsubject;
    }

    public TSubject getSubject() {
        return this.subject;
    }

    public void setSubject(TSubject tsubject) {
        Intrinsics.checkNotNullParameter(tsubject, "<set-?>");
        this.subject = tsubject;
    }

    public void finish() {
        this.index = -1;
    }

    public Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation) {
        setSubject(tsubject);
        return proceed(continuation);
    }

    public Object proceed(Continuation<? super TSubject> continuation) {
        int i = this.index;
        if (i < 0) {
            return getSubject();
        }
        if (i < this.interceptors.size()) {
            return proceedLoop(continuation);
        }
        finish();
        return getSubject();
    }

    public Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation) {
        this.index = 0;
        setSubject(tsubject);
        return proceed(continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object proceedLoop(kotlin.coroutines.Continuation<? super TSubject> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = (io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = new io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r2 = r0.L$0
            io.ktor.util.pipeline.DebugPipelineContext r2 = (io.ktor.util.pipeline.DebugPipelineContext) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003a
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            r2 = r6
        L_0x003a:
            int r7 = r2.index
            r4 = -1
            if (r7 != r4) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            java.util.List<kotlin.jvm.functions.Function3<io.ktor.util.pipeline.PipelineContext<TSubject, TContext>, TSubject, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r4 = r2.interceptors
            int r5 = r4.size()
            if (r7 < r5) goto L_0x0050
            r2.finish()
        L_0x004b:
            java.lang.Object r7 = r2.getSubject()
            return r7
        L_0x0050:
            java.lang.Object r4 = r4.get(r7)
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            int r7 = r7 + 1
            r2.index = r7
            java.lang.Object r7 = r2.getSubject()
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r4.invoke(r2, r7, r0)
            if (r7 != r1) goto L_0x003a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.DebugPipelineContext.proceedLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
