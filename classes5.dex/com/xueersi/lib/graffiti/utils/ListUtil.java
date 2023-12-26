package com.xueersi.lib.graffiti.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListUtil {
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return !isEmpty(collection);
    }

    public static <T> int size(Collection<T> collection) {
        if (isEmpty(collection)) {
            return 0;
        }
        return collection.size();
    }

    public static <T> List<T> filterNullItem(List<T> list) {
        if (isEmpty(list)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
