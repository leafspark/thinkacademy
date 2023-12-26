package com.yanzhenjie.andserver.util.comparator;

import com.yanzhenjie.andserver.util.Assert;
import java.io.Serializable;
import java.util.Comparator;

public class InvertibleComparator<T> implements Comparator<T>, Serializable {
    private boolean ascending = true;
    private final Comparator<T> comparator;

    public InvertibleComparator(Comparator<T> comparator2) {
        Assert.notNull(comparator2, "Comparator must not be null.");
        this.comparator = comparator2;
    }

    public InvertibleComparator(Comparator<T> comparator2, boolean z) {
        Assert.notNull(comparator2, "Comparator must not be null.");
        this.comparator = comparator2;
        setAscending(z);
    }

    public void setAscending(boolean z) {
        this.ascending = z;
    }

    public boolean isAscending() {
        return this.ascending;
    }

    public void invertOrder() {
        this.ascending = !this.ascending;
    }

    public int compare(T t, T t2) {
        int compare = this.comparator.compare(t, t2);
        if (compare == 0) {
            return 0;
        }
        if (this.ascending) {
            return compare;
        }
        if (Integer.MIN_VALUE == compare) {
            return Integer.MAX_VALUE;
        }
        return compare * -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InvertibleComparator)) {
            return false;
        }
        InvertibleComparator invertibleComparator = (InvertibleComparator) obj;
        if (!this.comparator.equals(invertibleComparator.comparator) || this.ascending != invertibleComparator.ascending) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return "InvertibleComparator: [" + this.comparator + "]; ascending=" + this.ascending;
    }
}
