package io.ktor.util.pipeline;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 )*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001)B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB_\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012H\u0010\t\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\n¢\u0006\u0002\u0010\u0010JJ\u0010 \u001a\u00020\u000e2B\u0010!\u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000fJ\u001a\u0010\"\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000JP\u0010\"\u001a\u00020\u000e2H\u0010#\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nJH\u0010$\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nJ\b\u0010%\u001a\u00020\u000eH\u0002JH\u0010&\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nJ\b\u0010'\u001a\u00020(H\u0016RP\u0010\t\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lio/ktor/util/pipeline/PhaseContent;", "TSubject", "", "Call", "phase", "Lio/ktor/util/pipeline/PipelinePhase;", "relation", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhaseRelation;)V", "interceptors", "", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhaseRelation;Ljava/util/List;)V", "isEmpty", "", "()Z", "getPhase", "()Lio/ktor/util/pipeline/PipelinePhase;", "getRelation", "()Lio/ktor/util/pipeline/PipelinePhaseRelation;", "shared", "getShared", "setShared", "(Z)V", "size", "", "getSize", "()I", "addInterceptor", "interceptor", "addTo", "destination", "copiedInterceptors", "copyInterceptors", "sharedInterceptors", "toString", "", "Companion", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhaseContent.kt */
public final class PhaseContent<TSubject, Call> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<Object> SharedArrayList = new ArrayList();
    private List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> interceptors;
    private final PipelinePhase phase;
    private final PipelinePhaseRelation relation;
    private boolean shared;

    public PhaseContent(PipelinePhase pipelinePhase, PipelinePhaseRelation pipelinePhaseRelation, List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> list) {
        Intrinsics.checkNotNullParameter(pipelinePhase, "phase");
        Intrinsics.checkNotNullParameter(pipelinePhaseRelation, "relation");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        this.phase = pipelinePhase;
        this.relation = pipelinePhaseRelation;
        this.interceptors = list;
        this.shared = true;
    }

    public final PipelinePhase getPhase() {
        return this.phase;
    }

    public final PipelinePhaseRelation getRelation() {
        return this.relation;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PhaseContent(io.ktor.util.pipeline.PipelinePhase r3, io.ktor.util.pipeline.PipelinePhaseRelation r4) {
        /*
            r2 = this;
            java.lang.String r0 = "phase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "relation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List<java.lang.Object> r0 = SharedArrayList
            java.util.List r1 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r0)
            r2.<init>(r3, r4, r1)
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x001a
            return
        L_0x001a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "The shared empty array list has been modified"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.PhaseContent.<init>(io.ktor.util.pipeline.PipelinePhase, io.ktor.util.pipeline.PipelinePhaseRelation):void");
    }

    public final boolean getShared() {
        return this.shared;
    }

    public final void setShared(boolean z) {
        this.shared = z;
    }

    public final boolean isEmpty() {
        return this.interceptors.isEmpty();
    }

    public final int getSize() {
        return this.interceptors.size();
    }

    public final void addInterceptor(Function3<? super PipelineContext<TSubject, Call>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "interceptor");
        if (this.shared) {
            copyInterceptors();
        }
        this.interceptors.add(function3);
    }

    public final void addTo(List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> list) {
        Intrinsics.checkNotNullParameter(list, "destination");
        List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> list2 = this.interceptors;
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + list2.size());
        }
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            list.add(list2.get(i));
        }
    }

    public final void addTo(PhaseContent<TSubject, Call> phaseContent) {
        Intrinsics.checkNotNullParameter(phaseContent, "destination");
        if (!isEmpty()) {
            if (phaseContent.isEmpty()) {
                phaseContent.interceptors = sharedInterceptors();
                phaseContent.shared = true;
                return;
            }
            if (phaseContent.shared) {
                phaseContent.copyInterceptors();
            }
            addTo(phaseContent.interceptors);
        }
    }

    public final List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> sharedInterceptors() {
        this.shared = true;
        return this.interceptors;
    }

    public final List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> copiedInterceptors() {
        List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> arrayList = new ArrayList<>();
        arrayList.addAll(this.interceptors);
        return arrayList;
    }

    public String toString() {
        return "Phase `" + this.phase.getName() + "`, " + getSize() + " handlers";
    }

    private final void copyInterceptors() {
        this.interceptors = copiedInterceptors();
        this.shared = false;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/util/pipeline/PhaseContent$Companion;", "", "()V", "SharedArrayList", "", "getSharedArrayList$annotations", "getSharedArrayList", "()Ljava/util/List;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhaseContent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getSharedArrayList$annotations() {
        }

        private Companion() {
        }

        public final List<Object> getSharedArrayList() {
            return PhaseContent.SharedArrayList;
        }
    }
}
