package com.bonree.sdk.br;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class h extends IOException {
    private static final long a = -5932211337552319515L;
    private static /* synthetic */ boolean c = true;
    private final List<IOException> b;

    private h(List<? extends IOException> list) {
        super(a((Collection<? extends Exception>) list));
        if (c || !list.isEmpty()) {
            this.b = Collections.unmodifiableList(list);
            return;
        }
        throw new AssertionError();
    }

    private List<IOException> a() {
        return this.b;
    }

    private static String a(Collection<? extends Exception> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends Exception> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(((Exception) it.next()).getMessage());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void a(List<? extends IOException> list) throws IOException {
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                throw ((IOException) list.get(0));
            }
            throw new h(list);
        }
    }

    public static IOException b(List<? extends IOException> list) {
        int size = list.size();
        if (size == 1) {
            return (IOException) list.get(0);
        }
        if (size > 1) {
            return new h(list);
        }
        return null;
    }
}
