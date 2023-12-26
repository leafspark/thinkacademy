package io.ktor.util.internal;

import io.ktor.http.LinkHeader;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020G:\u0004NOPQB\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u000f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\rH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u0011\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\r2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001b\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00032\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\"\f\b\u0000\u0010\u001d*\u00060\u0000j\u0002`\u00032\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00030$¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00060\u0000j\u0002`\u0003H\u0002¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0002¢\u0006\u0004\b)\u0010\u0007J\u001b\u0010*\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0002¢\u0006\u0004\b*\u0010\u0007J\u000f\u0010+\u001a\u00020\u0005H\u0001¢\u0006\u0004\b+\u0010\u0002J\r\u0010,\u001a\u00020\u0005¢\u0006\u0004\b,\u0010\u0002J/\u0010.\u001a\u00020-2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\bø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u00060\u0000j\u0002`\u0003H\u0002¢\u0006\u0004\b0\u0010(J\u000f\u00101\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u00102J\u001a\u00103\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001d\u0018\u0001H\b¢\u0006\u0004\b3\u00104J1\u00105\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001d\u0018\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\rH\bø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b7\u0010(J\u000f\u00109\u001a\u000208H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J/\u0010@\u001a\u00020?2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00032\u0006\u0010>\u001a\u00020-H\u0001¢\u0006\u0004\b@\u0010AJ'\u0010E\u001a\u00020\u00052\n\u0010B\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0000¢\u0006\u0004\bC\u0010DR\u0011\u0010F\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bF\u00102R\u0011\u0010\u0013\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u00104R\u0015\u0010J\u001a\u00060\u0000j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\bI\u0010(R\u0011\u0010B\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bK\u00104R\u0015\u0010M\u001a\u00060\u0000j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\bL\u0010(\u0002\u0007\n\u0005\b20\u0001¨\u0006R"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lio/ktor/util/internal/Node;", "node", "", "addLast", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)Z", "_prev", "Lio/ktor/util/internal/OpDescriptor;", "op", "correctPrev", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "T", "Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "Lio/ktor/util/internal/AtomicDesc;", "describeRemove", "()Lio/ktor/util/internal/AtomicDesc;", "Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "findHead", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "finishAdd", "finishRemove", "helpDelete", "helpRemove", "Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "markPrev", "remove", "()Z", "removeFirstIfIsInstanceOf", "()Ljava/lang/Object;", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "Lio/ktor/util/internal/Removed;", "removed", "()Lio/ktor/util/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$ktor_utils", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "getNextNode", "nextNode", "getPrev", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "RemoveFirstDesc", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListNode {
    static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU;
    static final /* synthetic */ AtomicReferenceFieldUpdater _prev$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _removedRef$FU;
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    static {
        Class<LockFreeLinkedListNode> cls = LockFreeLinkedListNode.class;
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        _prev$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_prev");
        _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_removedRef");
    }

    /* access modifiers changed from: private */
    public final Removed removed() {
        Removed removed = (Removed) this._removedRef;
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        _removedRef$FU.lazySet(this, removed2);
        return removed2;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "Lio/ktor/util/internal/AtomicOp;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "newNode", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "newNode");
            this.newNode = lockFreeLinkedListNode;
        }

        public void complete(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            boolean z = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode2 != null && LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.oldNext;
                Intrinsics.checkNotNull(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.finishAdd(lockFreeLinkedListNode4);
            }
        }
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "node");
        Intrinsics.checkNotNullParameter(function0, "condition");
        return new LockFreeLinkedListNode$makeCondAddOp$1(lockFreeLinkedListNode, function0);
    }

    public final boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        return LockFreeLinkedListKt.unwrap(getPrev());
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "node");
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        _next$FU.lazySet(lockFreeLinkedListNode, this);
        while (getNext() == this) {
            if (_next$FU.compareAndSet(this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    public final void addLast(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "node");
        do {
        } while (!((LockFreeLinkedListNode) getPrev()).addNext(lockFreeLinkedListNode, this));
    }

    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(T t) {
        Intrinsics.checkNotNullParameter(t, "node");
        return new AddLastDesc<>(this, t);
    }

    public final boolean addLastIfPrev(LockFreeLinkedListNode lockFreeLinkedListNode, Function1<? super LockFreeLinkedListNode, Boolean> function1) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "node");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) getPrev();
            if (!((Boolean) function1.invoke(lockFreeLinkedListNode2)).booleanValue()) {
                return false;
            }
        } while (!lockFreeLinkedListNode2.addNext(lockFreeLinkedListNode, this));
        return true;
    }

    public final boolean addNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "node");
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.finishAdd(lockFreeLinkedListNode2);
        return true;
    }

    public final int tryCondAddNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, CondAddOp condAddOp) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "node");
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
        Intrinsics.checkNotNullParameter(condAddOp, "condAdd");
        _prev$FU.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.oldNext = lockFreeLinkedListNode2;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        return condAddOp.perform(this) == null ? 1 : 2;
    }

    public boolean remove() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if ((next instanceof Removed) || next == this) {
                return false;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
        } while (!_next$FU.compareAndSet(this, next, lockFreeLinkedListNode.removed()));
        finishRemove(lockFreeLinkedListNode);
        return true;
    }

    public final void helpRemove() {
        Object next = getNext();
        Removed removed = next instanceof Removed ? (Removed) next : null;
        if (removed != null) {
            finishRemove(removed.ref);
            return;
        }
        throw new IllegalStateException("Must be invoked on a removed node".toString());
    }

    public AtomicDesc describeRemove() {
        if (isRemoved()) {
            return null;
        }
        return new LockFreeLinkedListNode$describeRemove$1(this);
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) getNext();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpDelete();
        }
    }

    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    public final /* synthetic */ <T> T removeFirstIfIsInstanceOf() {
        while (true) {
            T t = (LockFreeLinkedListNode) getNext();
            if (t == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(t instanceof Object)) {
                return null;
            }
            if (t.remove()) {
                return t;
            }
            t.helpDelete();
        }
    }

    public final /* synthetic */ <T> T removeFirstIfIsInstanceOfOrPeekIf(Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        while (true) {
            T t = (LockFreeLinkedListNode) getNext();
            if (t == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(t instanceof Object)) {
                return null;
            }
            if (((Boolean) function1.invoke(t)).booleanValue() || t.remove()) {
                return t;
            }
            t.helpDelete();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u001eB\u001b\u0012\n\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J)\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\t\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\f2\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0019\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0018\u0010\u001c\u001a\u00060\u0001j\u0002`\u00028DX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0004\u001a\u00060\u0001j\u0002`\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001a¨\u0006\u001d"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "T", "queue", "node", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "affected", "next", "", "finishOnSuccess", "", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "", "retry", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lio/ktor/util/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "updatedNext", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", "ktor-utils", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LockFreeLinkedList.kt */
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile /* synthetic */ Object _affectedNode;
        public final T node;
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(LockFreeLinkedListNode lockFreeLinkedListNode, T t) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "queue");
            Intrinsics.checkNotNullParameter(t, "node");
            this.queue = lockFreeLinkedListNode;
            this.node = t;
            if (t._next == t && t._prev == t) {
                this._affectedNode = null;
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            Intrinsics.checkNotNullParameter(opDescriptor, "op");
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) this.queue._prev;
                Object obj = lockFreeLinkedListNode._next;
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
                if (obj == lockFreeLinkedListNode2 || obj == opDescriptor) {
                    return lockFreeLinkedListNode;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(lockFreeLinkedListNode);
                } else {
                    LockFreeLinkedListNode access$correctPrev = lockFreeLinkedListNode2.correctPrev(lockFreeLinkedListNode, opDescriptor);
                    if (access$correctPrev != null) {
                        return access$correctPrev;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode getOriginalNext() {
            return this.queue;
        }

        /* access modifiers changed from: protected */
        public boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(obj, LinkHeader.Rel.Next);
            return obj != this.queue;
        }

        /* access modifiers changed from: protected */
        public Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
            _affectedNode$FU.compareAndSet(this, (Object) null, lockFreeLinkedListNode);
            return null;
        }

        /* access modifiers changed from: protected */
        public Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
            LockFreeLinkedListNode._prev$FU.compareAndSet(this.node, this.node, lockFreeLinkedListNode);
            LockFreeLinkedListNode._next$FU.compareAndSet(this.node, this.node, this.queue);
            return this.node;
        }

        /* access modifiers changed from: protected */
        public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
            this.node.finishAdd(this.queue);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020(B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\f2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003H\u0004¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003H\u0004¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00020\u00112\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0010J\u0017\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u0017\u0010&\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "queue", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "affected", "", "next", "failure", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Ljava/lang/Object;", "", "finishOnSuccess", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "", "retry", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lio/ktor/util/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "updatedNext", "node", "validatePrepared", "(Ljava/lang/Object;)Z", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "ktor-utils", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LockFreeLinkedList.kt */
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU;
        private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU;
        private volatile /* synthetic */ Object _affectedNode = null;
        private volatile /* synthetic */ Object _originalNext = null;
        public final LockFreeLinkedListNode queue;

        static {
            Class<RemoveFirstDesc> cls = RemoveFirstDesc.class;
            _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_affectedNode");
            _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_originalNext");
        }

        public static /* synthetic */ void getResult$annotations() {
        }

        /* access modifiers changed from: protected */
        public boolean validatePrepared(T t) {
            return true;
        }

        public RemoveFirstDesc(LockFreeLinkedListNode lockFreeLinkedListNode) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "queue");
            this.queue = lockFreeLinkedListNode;
        }

        public final T getResult() {
            T affectedNode = getAffectedNode();
            Intrinsics.checkNotNull(affectedNode);
            return (Object) affectedNode;
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            Intrinsics.checkNotNullParameter(opDescriptor, "op");
            return (LockFreeLinkedListNode) this.queue.getNext();
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode getOriginalNext() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        /* access modifiers changed from: protected */
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(obj, LinkHeader.Rel.Next);
            if (lockFreeLinkedListNode == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public final boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(obj, LinkHeader.Rel.Next);
            if (!(obj instanceof Removed)) {
                return false;
            }
            lockFreeLinkedListNode.helpDelete();
            return true;
        }

        /* access modifiers changed from: protected */
        public final Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
            if (!(!(lockFreeLinkedListNode instanceof LockFreeLinkedListHead))) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!validatePrepared(lockFreeLinkedListNode)) {
                return LockFreeLinkedListKt.REMOVE_PREPARED;
            } else {
                _affectedNode$FU.compareAndSet(this, (Object) null, lockFreeLinkedListNode);
                _originalNext$FU.compareAndSet(this, (Object) null, lockFreeLinkedListNode2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
            return lockFreeLinkedListNode2.removed();
        }

        /* access modifiers changed from: protected */
        public final void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
            lockFreeLinkedListNode.finishRemove(lockFreeLinkedListNode2);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J \u0010\u0012\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$J\"\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J\u0014\u0010\u0017\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u0018H\u0014J \u0010\u0019\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$R\u001a\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u001b"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lio/ktor/util/internal/AtomicDesc;", "()V", "affectedNode", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "complete", "", "op", "Lio/ktor/util/internal/AtomicOp;", "failure", "", "affected", "next", "finishOnSuccess", "onPrepare", "prepare", "retry", "", "takeAffectedNode", "Lio/ktor/util/internal/OpDescriptor;", "updatedNext", "PrepareOp", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        /* access modifiers changed from: protected */
        public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(obj, LinkHeader.Rel.Next);
            return null;
        }

        /* access modifiers changed from: protected */
        public abstract void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        public abstract LockFreeLinkedListNode getAffectedNode();

        /* access modifiers changed from: protected */
        public abstract LockFreeLinkedListNode getOriginalNext();

        /* access modifiers changed from: protected */
        public abstract Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        public boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
            Intrinsics.checkNotNullParameter(obj, LinkHeader.Rel.Next);
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        /* access modifiers changed from: protected */
        public LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor) {
            Intrinsics.checkNotNullParameter(opDescriptor, "op");
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            Intrinsics.checkNotNull(affectedNode);
            return affectedNode;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc$PrepareOp;", "Lio/ktor/util/internal/OpDescriptor;", "next", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "op", "Lio/ktor/util/internal/AtomicOp;", "desc", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/AtomicOp;Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "perform", "", "affected", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LockFreeLinkedList.kt */
        private static final class PrepareOp extends OpDescriptor {
            public final AbstractAtomicDesc desc;
            public final LockFreeLinkedListNode next;
            public final AtomicOp<LockFreeLinkedListNode> op;

            public PrepareOp(LockFreeLinkedListNode lockFreeLinkedListNode, AtomicOp<? super LockFreeLinkedListNode> atomicOp, AbstractAtomicDesc abstractAtomicDesc) {
                Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, LinkHeader.Rel.Next);
                Intrinsics.checkNotNullParameter(atomicOp, "op");
                Intrinsics.checkNotNullParameter(abstractAtomicDesc, "desc");
                this.next = lockFreeLinkedListNode;
                this.op = atomicOp;
                this.desc = abstractAtomicDesc;
            }

            public Object perform(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                Object onPrepare = this.desc.onPrepare(lockFreeLinkedListNode, this.next);
                if (onPrepare != null) {
                    if (onPrepare == LockFreeLinkedListKt.REMOVE_PREPARED) {
                        if (LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next.removed())) {
                            lockFreeLinkedListNode.helpDelete();
                        }
                    } else {
                        this.op.tryDecide(onPrepare);
                        LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next);
                    }
                    return onPrepare;
                }
                LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.op.isDecided() ? this.next : this.op);
                return null;
            }
        }

        public final Object prepare(AtomicOp<?> atomicOp) {
            Object perform;
            Intrinsics.checkNotNullParameter(atomicOp, "op");
            while (true) {
                LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(atomicOp);
                Object obj = takeAffectedNode._next;
                if (obj == atomicOp || atomicOp.isDecided()) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(takeAffectedNode);
                } else {
                    Object failure = failure(takeAffectedNode, obj);
                    if (failure != null) {
                        return failure;
                    }
                    if (!retry(takeAffectedNode, obj)) {
                        PrepareOp prepareOp = new PrepareOp((LockFreeLinkedListNode) obj, atomicOp, this);
                        if (LockFreeLinkedListNode._next$FU.compareAndSet(takeAffectedNode, obj, prepareOp) && (perform = prepareOp.perform(takeAffectedNode)) != LockFreeLinkedListKt.REMOVE_PREPARED) {
                            return perform;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        public final void complete(AtomicOp<?> atomicOp, Object obj) {
            Intrinsics.checkNotNullParameter(atomicOp, "op");
            boolean z = obj == null;
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null) {
                AbstractAtomicDesc abstractAtomicDesc = this;
                if (!(!z)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
            }
            LockFreeLinkedListNode originalNext = getOriginalNext();
            if (originalNext == null) {
                AbstractAtomicDesc abstractAtomicDesc2 = this;
                if (!(!z)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
            }
            if (LockFreeLinkedListNode._next$FU.compareAndSet(affectedNode, atomicOp, z ? updatedNext(affectedNode, originalNext) : originalNext) && z) {
                finishOnSuccess(affectedNode, originalNext);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void finishRemove(LockFreeLinkedListNode lockFreeLinkedListNode) {
        helpDelete();
        lockFreeLinkedListNode.correctPrev(LockFreeLinkedListKt.unwrap(this._prev), (OpDescriptor) null);
    }

    private final LockFreeLinkedListNode findHead() {
        boolean z;
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (!(lockFreeLinkedListNode instanceof LockFreeLinkedListHead)) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (lockFreeLinkedListNode != this) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (!z) {
                throw new IllegalStateException("Cannot loop to this while looking for list head".toString());
            }
        }
        return lockFreeLinkedListNode;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: io.ktor.util.internal.LockFreeLinkedListNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void helpDelete() {
        /*
            r7 = this;
            io.ktor.util.internal.LockFreeLinkedListNode r0 = r7.markPrev()
            java.lang.Object r1 = r7._next
            io.ktor.util.internal.Removed r1 = (io.ktor.util.internal.Removed) r1
            io.ktor.util.internal.LockFreeLinkedListNode r1 = r1.ref
            r2 = 0
        L_0x000b:
            r3 = r2
        L_0x000c:
            java.lang.Object r4 = r1.getNext()
            boolean r5 = r4 instanceof io.ktor.util.internal.Removed
            if (r5 == 0) goto L_0x001c
            r1.markPrev()
            io.ktor.util.internal.Removed r4 = (io.ktor.util.internal.Removed) r4
            io.ktor.util.internal.LockFreeLinkedListNode r1 = r4.ref
            goto L_0x000c
        L_0x001c:
            java.lang.Object r4 = r0.getNext()
            boolean r5 = r4 instanceof io.ktor.util.internal.Removed
            if (r5 == 0) goto L_0x003b
            if (r3 == 0) goto L_0x0034
            r0.markPrev()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = _next$FU
            io.ktor.util.internal.Removed r4 = (io.ktor.util.internal.Removed) r4
            io.ktor.util.internal.LockFreeLinkedListNode r4 = r4.ref
            r5.compareAndSet(r3, r0, r4)
            r0 = r3
            goto L_0x000b
        L_0x0034:
            java.lang.Object r0 = r0._prev
            io.ktor.util.internal.LockFreeLinkedListNode r0 = io.ktor.util.internal.LockFreeLinkedListKt.unwrap(r0)
            goto L_0x000c
        L_0x003b:
            if (r4 == r7) goto L_0x0047
            r3 = r4
            io.ktor.util.internal.LockFreeLinkedListNode r3 = (io.ktor.util.internal.LockFreeLinkedListNode) r3
            if (r3 != r1) goto L_0x0043
            return
        L_0x0043:
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x000c
        L_0x0047:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = _next$FU
            boolean r4 = r4.compareAndSet(r0, r7, r1)
            if (r4 == 0) goto L_0x000c
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.internal.LockFreeLinkedListNode.helpDelete():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: io.ktor.util.internal.LockFreeLinkedListNode} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.ktor.util.internal.LockFreeLinkedListNode correctPrev(io.ktor.util.internal.LockFreeLinkedListNode r7, io.ktor.util.internal.OpDescriptor r8) {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r7._next
            if (r2 != r8) goto L_0x0007
            return r7
        L_0x0007:
            boolean r3 = r2 instanceof io.ktor.util.internal.OpDescriptor
            if (r3 == 0) goto L_0x0011
            io.ktor.util.internal.OpDescriptor r2 = (io.ktor.util.internal.OpDescriptor) r2
            r2.perform(r7)
            goto L_0x0002
        L_0x0011:
            boolean r3 = r2 instanceof io.ktor.util.internal.Removed
            if (r3 == 0) goto L_0x002c
            if (r1 == 0) goto L_0x0025
            r7.markPrev()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = _next$FU
            io.ktor.util.internal.Removed r2 = (io.ktor.util.internal.Removed) r2
            io.ktor.util.internal.LockFreeLinkedListNode r2 = r2.ref
            r3.compareAndSet(r1, r7, r2)
            r7 = r1
            goto L_0x0001
        L_0x0025:
            java.lang.Object r7 = r7._prev
            io.ktor.util.internal.LockFreeLinkedListNode r7 = io.ktor.util.internal.LockFreeLinkedListKt.unwrap(r7)
            goto L_0x0002
        L_0x002c:
            java.lang.Object r3 = r6._prev
            boolean r4 = r3 instanceof io.ktor.util.internal.Removed
            if (r4 == 0) goto L_0x0033
            return r0
        L_0x0033:
            if (r2 == r6) goto L_0x003c
            r1 = r2
            io.ktor.util.internal.LockFreeLinkedListNode r1 = (io.ktor.util.internal.LockFreeLinkedListNode) r1
            r5 = r1
            r1 = r7
            r7 = r5
            goto L_0x0002
        L_0x003c:
            if (r3 != r7) goto L_0x003f
            return r0
        L_0x003f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = _prev$FU
            boolean r2 = r2.compareAndSet(r6, r3, r7)
            if (r2 == 0) goto L_0x0002
            java.lang.Object r2 = r7._prev
            boolean r2 = r2 instanceof io.ktor.util.internal.Removed
            if (r2 != 0) goto L_0x0002
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.internal.LockFreeLinkedListNode.correctPrev(io.ktor.util.internal.LockFreeLinkedListNode, io.ktor.util.internal.OpDescriptor):io.ktor.util.internal.LockFreeLinkedListNode");
    }

    public final void validateNode$ktor_utils(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "prev");
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
        boolean z = true;
        if (lockFreeLinkedListNode == this._prev) {
            if (lockFreeLinkedListNode2 != this._next) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '@' + hashCode();
    }

    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final Object getPrev() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof Removed) {
                return obj;
            }
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            if (lockFreeLinkedListNode.getNext() == this) {
                return obj;
            }
            correctPrev(lockFreeLinkedListNode, (OpDescriptor) null);
        }
    }

    public final boolean addLastIf(LockFreeLinkedListNode lockFreeLinkedListNode, Function0<Boolean> function0) {
        int tryCondAddNext;
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "node");
        Intrinsics.checkNotNullParameter(function0, "condition");
        CondAddOp lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(lockFreeLinkedListNode, function0);
        do {
            tryCondAddNext = ((LockFreeLinkedListNode) getPrev()).tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrevAndIf(LockFreeLinkedListNode lockFreeLinkedListNode, Function1<? super LockFreeLinkedListNode, Boolean> function1, Function0<Boolean> function0) {
        int tryCondAddNext;
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "node");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Intrinsics.checkNotNullParameter(function0, "condition");
        CondAddOp lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(lockFreeLinkedListNode, function0);
        do {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) getPrev();
            if (!((Boolean) function1.invoke(lockFreeLinkedListNode2)).booleanValue()) {
                return false;
            }
            tryCondAddNext = lockFreeLinkedListNode2.tryCondAddNext(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    /* access modifiers changed from: private */
    public final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Object obj;
        do {
            obj = lockFreeLinkedListNode._prev;
            if ((obj instanceof Removed) || getNext() != lockFreeLinkedListNode) {
                return;
            }
        } while (!_prev$FU.compareAndSet(lockFreeLinkedListNode, obj, this));
        if (getNext() instanceof Removed) {
            lockFreeLinkedListNode.correctPrev((LockFreeLinkedListNode) obj, (OpDescriptor) null);
        }
    }

    private final LockFreeLinkedListNode markPrev() {
        Object obj;
        do {
            obj = this._prev;
            if (obj instanceof Removed) {
                return ((Removed) obj).ref;
            }
        } while (!_prev$FU.compareAndSet(this, obj, (obj == this ? findHead() : (LockFreeLinkedListNode) obj).removed()));
        return (LockFreeLinkedListNode) obj;
    }
}
