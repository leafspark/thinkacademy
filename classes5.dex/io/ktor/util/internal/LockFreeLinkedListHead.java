package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J0\u0010\b\u001a\u00020\t\"\u000e\b\u0000\u0010\n\u0018\u0001*\u00060\u0001j\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\rH\bø\u0001\u0000J\u0006\u0010\u000e\u001a\u00020\u0004J\r\u0010\u000f\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0010R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0011"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListHead;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "describeRemove", "", "forEach", "", "T", "Lio/ktor/util/internal/Node;", "block", "Lkotlin/Function1;", "remove", "validate", "validate$ktor_utils", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final boolean isEmpty() {
        return getNext() == this;
    }

    public final /* synthetic */ <T extends LockFreeLinkedListNode> void forEach(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                function1.invoke(lockFreeLinkedListNode);
            }
        }
    }

    public final boolean remove() {
        throw new UnsupportedOperationException();
    }

    public final Void describeRemove() {
        throw new UnsupportedOperationException();
    }

    public final void validate$ktor_utils() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) getNext();
        while (!Intrinsics.areEqual(lockFreeLinkedListNode2, this)) {
            LockFreeLinkedListNode nextNode = lockFreeLinkedListNode2.getNextNode();
            lockFreeLinkedListNode2.validateNode$ktor_utils(lockFreeLinkedListNode, nextNode);
            lockFreeLinkedListNode = lockFreeLinkedListNode2;
            lockFreeLinkedListNode2 = nextNode;
        }
        validateNode$ktor_utils(lockFreeLinkedListNode, (LockFreeLinkedListNode) getNext());
    }
}
