package com.coloros.ocs.base.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class p<TResult> implements Continuation<Void, List<TResult>> {
    private Collection<? extends Task<?>> a;

    public p(Collection<? extends Task<?>> collection) {
        this.a = collection;
    }

    public final /* synthetic */ Object then(Task task) {
        ArrayList arrayList = new ArrayList();
        for (Task result : this.a) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
