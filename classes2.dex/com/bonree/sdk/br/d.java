package com.bonree.sdk.br;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public final class d {
    public static <T> T a(Set<T> set, Random random) {
        int nextInt = random.nextInt(set.size());
        Iterator<T> it = set.iterator();
        for (int i = 0; i < nextInt && it.hasNext(); i++) {
            it.next();
        }
        return it.next();
    }
}
