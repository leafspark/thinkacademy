package io.ktor.util.internal;

import io.ktor.http.LinkHeader;
import io.ktor.util.internal.LockFreeLinkedListNode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0016J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\u00020\r2\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"io/ktor/util/internal/LockFreeLinkedListNode$describeRemove$1", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "affected", "", "next", "failure", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Ljava/lang/Object;", "", "finishOnSuccess", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lio/ktor/util/internal/Removed;", "updatedNext", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Lio/ktor/util/internal/Removed;", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "ktor-utils", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LockFreeLinkedList.kt */
public final class LockFreeLinkedListNode$describeRemove$1 extends LockFreeLinkedListNode.AbstractAtomicDesc {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode$describeRemove$1.class, Object.class, "_originalNext");
    private volatile /* synthetic */ Object _originalNext = null;
    final /* synthetic */ LockFreeLinkedListNode this$0;

    LockFreeLinkedListNode$describeRemove$1(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.this$0 = lockFreeLinkedListNode;
    }

    /* access modifiers changed from: protected */
    public LockFreeLinkedListNode getAffectedNode() {
        return this.this$0;
    }

    /* access modifiers changed from: protected */
    public LockFreeLinkedListNode getOriginalNext() {
        return (LockFreeLinkedListNode) this._originalNext;
    }

    /* access modifiers changed from: protected */
    public Object failure(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
        Intrinsics.checkNotNullParameter(obj, LinkHeader.Rel.Next);
        if (obj instanceof Removed) {
            return LockFreeLinkedListKt.getALREADY_REMOVED();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
        _originalNext$FU.compareAndSet(this, (Object) null, lockFreeLinkedListNode2);
        return null;
    }

    /* access modifiers changed from: protected */
    public Removed updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
        return lockFreeLinkedListNode2.removed();
    }

    /* access modifiers changed from: protected */
    public void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode, "affected");
        Intrinsics.checkNotNullParameter(lockFreeLinkedListNode2, LinkHeader.Rel.Next);
        this.this$0.finishRemove(lockFreeLinkedListNode2);
    }
}
