package io.ktor.util.pipeline;

import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001BU\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012?\u0010\f\u001a;\u00127\u00125\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\u000b0\u0006ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eB\u001b\u0012\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0004\b\r\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015JQ\u0010\u0017\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00160\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b#\u0010$J%\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010%2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010,J\u001d\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b0\u0010/J\u001f\u00103\u001a\u00020\"2\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u00104JS\u00106\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000429\u00105\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b6\u00107JQ\u00108\u001a;\u00127\u00125\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\u000b0\u00062\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b8\u00109JQ\u0010;\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00160\u0006H\u0000¢\u0006\u0004\b:\u0010\u0018J!\u0010<\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b<\u0010=J#\u0010>\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b>\u0010=J!\u0010?\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b?\u0010=JY\u0010A\u001a\u00020\n2H\u0010@\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00160\u0006H\u0002¢\u0006\u0004\bA\u0010BJY\u0010D\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00160\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\bC\u00109J!\u0010E\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\bE\u0010=J\u000f\u0010F\u001a\u00020\nH\u0002¢\u0006\u0004\bF\u0010\u0015J#\u0010H\u001a\u00020\n2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\bH\u0010=J#\u0010J\u001a\u00020\n2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%H\u0002¢\u0006\u0004\bJ\u0010KJQ\u0010L\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00160\u0006H\u0002¢\u0006\u0004\bL\u0010\u0018J[\u0010M\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u00042B\u00105\u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0016H\u0002¢\u0006\u0004\bM\u0010NR\u0017\u0010P\u001a\u00020O8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\"8\u0016XD¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR¬\u0001\u0010\f\u001aF\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0016\u0018\u00010\u00062J\u0010X\u001aF\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0016\u0018\u00010\u00068B@BX\u000e¢\u0006\f\u001a\u0004\bY\u0010\u0018\"\u0004\bZ\u0010BR\u0016\u0010[\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010UR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0011\u0010`\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b`\u0010WR\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068F¢\u0006\u0006\u001a\u0004\ba\u0010\u0018R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00010c8\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010e\u0002\u0004\n\u0002\b\u0019¨\u0006f"}, d2 = {"Lio/ktor/util/pipeline/Pipeline;", "", "TSubject", "TContext", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "interceptors", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;Ljava/util/List;)V", "", "phases", "([Lio/ktor/util/pipeline/PipelinePhase;)V", "addPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)V", "afterIntercepted", "()V", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "cacheInterceptors", "()Ljava/util/List;", "context", "subject", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "createContext", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/util/pipeline/PipelineContext;", "execute", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "from", "", "fastPathMerge", "(Lio/ktor/util/pipeline/Pipeline;)Z", "Lio/ktor/util/pipeline/PhaseContent;", "findPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Lio/ktor/util/pipeline/PhaseContent;", "", "findPhaseIndex", "(Lio/ktor/util/pipeline/PipelinePhase;)I", "hasPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Z", "reference", "insertPhaseAfter", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhase;)V", "insertPhaseBefore", "fromPhaseOrContent", "fromPhase", "insertRelativePhase", "(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelinePhase;)Z", "block", "intercept", "(Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)V", "interceptorsForPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Ljava/util/List;", "interceptorsForTests$ktor_utils", "interceptorsForTests", "merge", "(Lio/ktor/util/pipeline/Pipeline;)V", "mergeInterceptors", "mergePhases", "list", "notSharedInterceptorsList", "(Ljava/util/List;)V", "phaseInterceptors$ktor_utils", "phaseInterceptors", "resetFrom", "resetInterceptorsList", "pipeline", "setInterceptorsListFromAnotherPipeline", "phaseContent", "setInterceptorsListFromPhase", "(Lio/ktor/util/pipeline/PhaseContent;)V", "sharedInterceptorsList", "tryAddToPhaseFastPath", "(Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)Z", "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "developmentMode", "Z", "getDevelopmentMode", "()Z", "value", "getInterceptors", "setInterceptors", "interceptorsListShared", "interceptorsListSharedPhase", "Lio/ktor/util/pipeline/PipelinePhase;", "interceptorsQuantity", "I", "isEmpty", "getItems", "items", "", "phasesRaw", "Ljava/util/List;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Pipeline.kt */
public class Pipeline<TSubject, TContext> {
    private volatile /* synthetic */ Object _interceptors;
    private final Attributes attributes;
    private final boolean developmentMode;
    private boolean interceptorsListShared;
    private PipelinePhase interceptorsListSharedPhase;
    private int interceptorsQuantity;
    private final List<Object> phasesRaw;

    public void afterIntercepted() {
    }

    public Pipeline(PipelinePhase... pipelinePhaseArr) {
        Intrinsics.checkNotNullParameter(pipelinePhaseArr, "phases");
        this.attributes = AttributesJvmKt.Attributes(true);
        this.phasesRaw = CollectionsKt.mutableListOf(Arrays.copyOf(pipelinePhaseArr, pipelinePhaseArr.length));
        this._interceptors = null;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final List<PipelinePhase> getItems() {
        Iterable iterable = this.phasesRaw;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object next : iterable) {
            PipelinePhase pipelinePhase = null;
            PipelinePhase pipelinePhase2 = next instanceof PipelinePhase ? (PipelinePhase) next : null;
            if (pipelinePhase2 == null) {
                PhaseContent phaseContent = next instanceof PhaseContent ? (PhaseContent) next : null;
                if (phaseContent != null) {
                    pipelinePhase = phaseContent.getPhase();
                }
                Intrinsics.checkNotNull(pipelinePhase);
                pipelinePhase2 = pipelinePhase;
            }
            arrayList.add(pipelinePhase2);
        }
        return (List) arrayList;
    }

    public final boolean isEmpty() {
        return this.interceptorsQuantity == 0;
    }

    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> getInterceptors() {
        return (List) this._interceptors;
    }

    private final void setInterceptors(List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        this._interceptors = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Pipeline(PipelinePhase pipelinePhase, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        this(pipelinePhase);
        Intrinsics.checkNotNullParameter(pipelinePhase, "phase");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            intercept(pipelinePhase, (Function3) it.next());
        }
    }

    public final Object execute(TContext tcontext, TSubject tsubject, Continuation<? super TSubject> continuation) {
        return createContext(tcontext, tsubject, continuation.getContext()).execute$ktor_utils(tsubject, continuation);
    }

    public final void addPhase(PipelinePhase pipelinePhase) {
        Intrinsics.checkNotNullParameter(pipelinePhase, "phase");
        if (!hasPhase(pipelinePhase)) {
            this.phasesRaw.add(pipelinePhase);
        }
    }

    public final void insertPhaseAfter(PipelinePhase pipelinePhase, PipelinePhase pipelinePhase2) {
        PipelinePhaseRelation relation;
        PipelinePhase relativeTo;
        Intrinsics.checkNotNullParameter(pipelinePhase, "reference");
        Intrinsics.checkNotNullParameter(pipelinePhase2, "phase");
        if (!hasPhase(pipelinePhase2)) {
            int findPhaseIndex = findPhaseIndex(pipelinePhase);
            if (findPhaseIndex != -1) {
                int i = findPhaseIndex + 1;
                int lastIndex = CollectionsKt.getLastIndex(this.phasesRaw);
                if (i <= lastIndex) {
                    while (true) {
                        Object obj = this.phasesRaw.get(i);
                        PipelinePhaseRelation.After after = null;
                        PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                        if (phaseContent != null && (relation = phaseContent.getRelation()) != null) {
                            if (relation instanceof PipelinePhaseRelation.After) {
                                after = (PipelinePhaseRelation.After) relation;
                            }
                            if (!(after == null || (relativeTo = after.getRelativeTo()) == null || !Intrinsics.areEqual(relativeTo, pipelinePhase))) {
                                findPhaseIndex = i;
                            }
                            if (i == lastIndex) {
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                this.phasesRaw.add(findPhaseIndex + 1, new PhaseContent(pipelinePhase2, new PipelinePhaseRelation.After(pipelinePhase)));
                return;
            }
            throw new InvalidPhaseException("Phase " + pipelinePhase + " was not registered for this pipeline");
        }
    }

    public final void insertPhaseBefore(PipelinePhase pipelinePhase, PipelinePhase pipelinePhase2) {
        Intrinsics.checkNotNullParameter(pipelinePhase, "reference");
        Intrinsics.checkNotNullParameter(pipelinePhase2, "phase");
        if (!hasPhase(pipelinePhase2)) {
            int findPhaseIndex = findPhaseIndex(pipelinePhase);
            if (findPhaseIndex != -1) {
                this.phasesRaw.add(findPhaseIndex, new PhaseContent(pipelinePhase2, new PipelinePhaseRelation.Before(pipelinePhase)));
                return;
            }
            throw new InvalidPhaseException("Phase " + pipelinePhase + " was not registered for this pipeline");
        }
    }

    public final void intercept(PipelinePhase pipelinePhase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(pipelinePhase, "phase");
        Intrinsics.checkNotNullParameter(function3, "block");
        PhaseContent findPhase = findPhase(pipelinePhase);
        if (findPhase != null) {
            Function3 function32 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3);
            if (tryAddToPhaseFastPath(pipelinePhase, function3)) {
                this.interceptorsQuantity++;
                return;
            }
            findPhase.addInterceptor(function3);
            this.interceptorsQuantity++;
            resetInterceptorsList();
            afterIntercepted();
            return;
        }
        throw new InvalidPhaseException("Phase " + pipelinePhase + " was not registered for this pipeline");
    }

    public final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptorsForPhase(PipelinePhase pipelinePhase) {
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> list;
        Object obj;
        Intrinsics.checkNotNullParameter(pipelinePhase, "phase");
        Collection arrayList = new ArrayList();
        for (Object next : this.phasesRaw) {
            if (next instanceof PhaseContent) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((PhaseContent) obj).getPhase(), pipelinePhase)) {
                break;
            }
        }
        PhaseContent phaseContent = (PhaseContent) obj;
        if (phaseContent != null) {
            list = phaseContent.sharedInterceptors();
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final void mergePhases(Pipeline<TSubject, TContext> pipeline) {
        Intrinsics.checkNotNullParameter(pipeline, "from");
        List mutableList = CollectionsKt.toMutableList(pipeline.phasesRaw);
        while (!mutableList.isEmpty()) {
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                PipelinePhase pipelinePhase = next instanceof PipelinePhase ? (PipelinePhase) next : null;
                if (pipelinePhase == null) {
                    pipelinePhase = ((PhaseContent) next).getPhase();
                }
                if (hasPhase(pipelinePhase)) {
                    it.remove();
                } else if (insertRelativePhase(next, pipelinePhase)) {
                    it.remove();
                }
            }
        }
    }

    private final void mergeInterceptors(Pipeline<TSubject, TContext> pipeline) {
        if (this.interceptorsQuantity == 0) {
            setInterceptorsListFromAnotherPipeline(pipeline);
        } else {
            resetInterceptorsList();
        }
        for (Object next : pipeline.phasesRaw) {
            PipelinePhase pipelinePhase = next instanceof PipelinePhase ? (PipelinePhase) next : null;
            if (pipelinePhase == null) {
                pipelinePhase = ((PhaseContent) next).getPhase();
            }
            if (next instanceof PhaseContent) {
                PhaseContent phaseContent = (PhaseContent) next;
                if (!phaseContent.isEmpty()) {
                    PhaseContent findPhase = findPhase(pipelinePhase);
                    Intrinsics.checkNotNull(findPhase);
                    phaseContent.addTo(findPhase);
                    this.interceptorsQuantity += phaseContent.getSize();
                }
            }
        }
    }

    public final void merge(Pipeline<TSubject, TContext> pipeline) {
        Intrinsics.checkNotNullParameter(pipeline, "from");
        if (!fastPathMerge(pipeline)) {
            mergePhases(pipeline);
            mergeInterceptors(pipeline);
        }
    }

    public final void resetFrom(Pipeline<TSubject, TContext> pipeline) {
        Intrinsics.checkNotNullParameter(pipeline, "from");
        this.phasesRaw.clear();
        if (this.interceptorsQuantity == 0) {
            fastPathMerge(pipeline);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r2 = r2.sharedInterceptors();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<kotlin.jvm.functions.Function3<io.ktor.util.pipeline.PipelineContext<TSubject, TContext>, TSubject, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> phaseInterceptors$ktor_utils(io.ktor.util.pipeline.PipelinePhase r2) {
        /*
            r1 = this;
            java.lang.String r0 = "phase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.ktor.util.pipeline.PhaseContent r2 = r1.findPhase(r2)
            if (r2 == 0) goto L_0x0011
            java.util.List r2 = r2.sharedInterceptors()
            if (r2 != 0) goto L_0x0015
        L_0x0011:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.Pipeline.phaseInterceptors$ktor_utils(io.ktor.util.pipeline.PipelinePhase):java.util.List");
    }

    public final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptorsForTests$ktor_utils() {
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptors = getInterceptors();
        return interceptors == null ? cacheInterceptors() : interceptors;
    }

    private final PipelineContext<TSubject, TContext> createContext(TContext tcontext, TSubject tsubject, CoroutineContext coroutineContext) {
        return PipelineContextKt.pipelineContextFor(tcontext, sharedInterceptorsList(), tsubject, coroutineContext, getDevelopmentMode());
    }

    private final PhaseContent<TSubject, TContext> findPhase(PipelinePhase pipelinePhase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase) {
                PhaseContent<TSubject, TContext> phaseContent = new PhaseContent<>(pipelinePhase, PipelinePhaseRelation.Last.INSTANCE);
                list.set(i, phaseContent);
                return phaseContent;
            }
            if (obj instanceof PhaseContent) {
                PhaseContent<TSubject, TContext> phaseContent2 = (PhaseContent) obj;
                if (phaseContent2.getPhase() == pipelinePhase) {
                    return phaseContent2;
                }
            }
        }
        return null;
    }

    private final int findPhaseIndex(PipelinePhase pipelinePhase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase || ((obj instanceof PhaseContent) && ((PhaseContent) obj).getPhase() == pipelinePhase)) {
                return i;
            }
        }
        return -1;
    }

    private final boolean hasPhase(PipelinePhase pipelinePhase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase) {
                return true;
            }
            if ((obj instanceof PhaseContent) && ((PhaseContent) obj).getPhase() == pipelinePhase) {
                return true;
            }
        }
        return false;
    }

    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> cacheInterceptors() {
        int lastIndex;
        int i = this.interceptorsQuantity;
        if (i == 0) {
            notSharedInterceptorsList(CollectionsKt.emptyList());
            return CollectionsKt.emptyList();
        }
        List<Object> list = this.phasesRaw;
        int i2 = 0;
        if (i == 1 && (lastIndex = CollectionsKt.getLastIndex(list)) >= 0) {
            int i3 = 0;
            while (true) {
                Object obj = list.get(i3);
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent == null || phaseContent.isEmpty()) {
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                } else {
                    List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> sharedInterceptors = phaseContent.sharedInterceptors();
                    setInterceptorsListFromPhase(phaseContent);
                    return sharedInterceptors;
                }
            }
        }
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> arrayList = new ArrayList<>();
        int lastIndex2 = CollectionsKt.getLastIndex(list);
        if (lastIndex2 >= 0) {
            while (true) {
                Object obj2 = list.get(i2);
                PhaseContent phaseContent2 = obj2 instanceof PhaseContent ? (PhaseContent) obj2 : null;
                if (phaseContent2 != null) {
                    phaseContent2.addTo(arrayList);
                }
                if (i2 == lastIndex2) {
                    break;
                }
                i2++;
            }
        }
        notSharedInterceptorsList(arrayList);
        return arrayList;
    }

    private final boolean fastPathMerge(Pipeline<TSubject, TContext> pipeline) {
        if (pipeline.phasesRaw.isEmpty()) {
            return true;
        }
        int i = 0;
        if (!this.phasesRaw.isEmpty()) {
            return false;
        }
        List<Object> list = pipeline.phasesRaw;
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (lastIndex >= 0) {
            while (true) {
                Object obj = list.get(i);
                if (obj instanceof PipelinePhase) {
                    this.phasesRaw.add(obj);
                } else if (obj instanceof PhaseContent) {
                    PhaseContent phaseContent = (PhaseContent) obj;
                    this.phasesRaw.add(new PhaseContent(phaseContent.getPhase(), phaseContent.getRelation(), phaseContent.sharedInterceptors()));
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        this.interceptorsQuantity += pipeline.interceptorsQuantity;
        setInterceptorsListFromAnotherPipeline(pipeline);
        return true;
    }

    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> sharedInterceptorsList() {
        if (getInterceptors() == null) {
            cacheInterceptors();
        }
        this.interceptorsListShared = true;
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptors = getInterceptors();
        Intrinsics.checkNotNull(interceptors);
        return interceptors;
    }

    private final void resetInterceptorsList() {
        setInterceptors((List) null);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void notSharedInterceptorsList(List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        setInterceptors(list);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void setInterceptorsListFromPhase(PhaseContent<TSubject, TContext> phaseContent) {
        setInterceptors(phaseContent.sharedInterceptors());
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = phaseContent.getPhase();
    }

    private final void setInterceptorsListFromAnotherPipeline(Pipeline<TSubject, TContext> pipeline) {
        setInterceptors(pipeline.sharedInterceptorsList());
        this.interceptorsListShared = true;
        this.interceptorsListSharedPhase = null;
    }

    private final boolean tryAddToPhaseFastPath(PipelinePhase pipelinePhase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        List interceptors = getInterceptors();
        if (this.phasesRaw.isEmpty() || interceptors == null || this.interceptorsListShared || !TypeIntrinsics.isMutableList(interceptors)) {
            return false;
        }
        if (Intrinsics.areEqual(this.interceptorsListSharedPhase, pipelinePhase)) {
            interceptors.add(function3);
            return true;
        } else if (!Intrinsics.areEqual(pipelinePhase, CollectionsKt.last(this.phasesRaw)) && findPhaseIndex(pipelinePhase) != CollectionsKt.getLastIndex(this.phasesRaw)) {
            return false;
        } else {
            PhaseContent findPhase = findPhase(pipelinePhase);
            Intrinsics.checkNotNull(findPhase);
            findPhase.addInterceptor(function3);
            interceptors.add(function3);
            return true;
        }
    }

    private final boolean insertRelativePhase(Object obj, PipelinePhase pipelinePhase) {
        PipelinePhaseRelation pipelinePhaseRelation;
        if (obj == pipelinePhase) {
            pipelinePhaseRelation = PipelinePhaseRelation.Last.INSTANCE;
        } else {
            pipelinePhaseRelation = ((PhaseContent) obj).getRelation();
        }
        if (pipelinePhaseRelation instanceof PipelinePhaseRelation.Last) {
            addPhase(pipelinePhase);
            return true;
        }
        if (pipelinePhaseRelation instanceof PipelinePhaseRelation.Before) {
            PipelinePhaseRelation.Before before = (PipelinePhaseRelation.Before) pipelinePhaseRelation;
            if (hasPhase(before.getRelativeTo())) {
                insertPhaseBefore(before.getRelativeTo(), pipelinePhase);
                return true;
            }
        }
        if (!(pipelinePhaseRelation instanceof PipelinePhaseRelation.After)) {
            return false;
        }
        insertPhaseAfter(((PipelinePhaseRelation.After) pipelinePhaseRelation).getRelativeTo(), pipelinePhase);
        return true;
    }
}
