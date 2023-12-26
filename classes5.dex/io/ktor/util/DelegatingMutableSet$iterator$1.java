package io.ktor.util;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"io/ktor/util/DelegatingMutableSet$iterator$1", "", "delegateIterator", "getDelegateIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DelegatingMutableSet.kt */
public final class DelegatingMutableSet$iterator$1 implements Iterator<To>, KMutableIterator {
    private final Iterator<From> delegateIterator;
    final /* synthetic */ DelegatingMutableSet<From, To> this$0;

    DelegatingMutableSet$iterator$1(DelegatingMutableSet<From, To> delegatingMutableSet) {
        this.this$0 = delegatingMutableSet;
        this.delegateIterator = delegatingMutableSet.delegate.iterator();
    }

    public final Iterator<From> getDelegateIterator() {
        return this.delegateIterator;
    }

    public boolean hasNext() {
        return this.delegateIterator.hasNext();
    }

    public To next() {
        return this.this$0.convertTo.invoke(this.delegateIterator.next());
    }

    public void remove() {
        this.delegateIterator.remove();
    }
}
