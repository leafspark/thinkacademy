package com.coloros.ocs.base.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class o implements Continuation<Void, Task<List<Task<?>>>> {
    private Collection a;

    o(Collection collection) {
        this.a = collection;
    }

    public final /* synthetic */ Object then(Task task) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        return Tasks.forResult(arrayList);
    }
}
