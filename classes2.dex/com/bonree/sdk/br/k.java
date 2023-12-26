package com.bonree.sdk.br;

import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public final class k {
    private static List<y> a(Collection<y> collection) {
        int i;
        int i2;
        int i3;
        if (collection.size() == 1 && collection.iterator().next().c.equals(a.a)) {
            return Collections.emptyList();
        }
        TreeMap treeMap = new TreeMap();
        for (y next : collection) {
            Integer valueOf = Integer.valueOf(next.a);
            List list = (List) treeMap.get(valueOf);
            if (list == null) {
                list = new LinkedList();
                treeMap.put(valueOf, list);
            }
            list.add(next);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<y> list2 : treeMap.values()) {
            while (true) {
                int size = list2.size();
                if (size > 0) {
                    int[] iArr = new int[size];
                    Iterator it = list2.iterator();
                    while (true) {
                        i = 0;
                        if (it.hasNext()) {
                            if (((y) it.next()).b > 0) {
                                i2 = 0;
                                break;
                            }
                        } else {
                            i2 = 1;
                            break;
                        }
                    }
                    int i4 = 0;
                    for (y yVar : list2) {
                        i += yVar.b + i2;
                        iArr[i4] = i;
                        i4++;
                    }
                    if (i == 0) {
                        i3 = (int) (Math.random() * ((double) size));
                    } else {
                        i3 = a(iArr, Math.random() * ((double) i));
                    }
                    arrayList.add((y) list2.remove(i3));
                }
            }
        }
        return arrayList;
    }

    private static int a(int[] iArr, double d) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length && d >= ((double) iArr[i])) {
            i2++;
            i++;
        }
        return i2;
    }
}
