package com.yanzhenjie.andserver.util.comparator;

import com.yanzhenjie.andserver.util.Assert;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator<T> implements Comparator<T>, Serializable {
    private final List<InvertibleComparator> comparators;

    public CompoundComparator() {
        this.comparators = new ArrayList();
    }

    public CompoundComparator(Comparator... comparatorArr) {
        Assert.notNull(comparatorArr, "Comparators must not be null");
        this.comparators = new ArrayList(comparatorArr.length);
        for (Comparator addComparator : comparatorArr) {
            addComparator(addComparator);
        }
    }

    public void addComparator(Comparator<? extends T> comparator) {
        if (comparator instanceof InvertibleComparator) {
            this.comparators.add((InvertibleComparator) comparator);
        } else {
            this.comparators.add(new InvertibleComparator(comparator));
        }
    }

    public void addComparator(Comparator<? extends T> comparator, boolean z) {
        this.comparators.add(new InvertibleComparator(comparator, z));
    }

    public void setComparator(int i, Comparator<? extends T> comparator) {
        if (comparator instanceof InvertibleComparator) {
            this.comparators.set(i, (InvertibleComparator) comparator);
        } else {
            this.comparators.set(i, new InvertibleComparator(comparator));
        }
    }

    public void setComparator(int i, Comparator<T> comparator, boolean z) {
        this.comparators.set(i, new InvertibleComparator(comparator, z));
    }

    public void invertOrder() {
        for (InvertibleComparator invertOrder : this.comparators) {
            invertOrder.invertOrder();
        }
    }

    public void invertOrder(int i) {
        this.comparators.get(i).invertOrder();
    }

    public void setAscendingOrder(int i) {
        this.comparators.get(i).setAscending(true);
    }

    public void setDescendingOrder(int i) {
        this.comparators.get(i).setAscending(false);
    }

    public int getComparatorCount() {
        return this.comparators.size();
    }

    public int compare(T t, T t2) {
        Assert.state(this.comparators.size() > 0, "No sort definitions have been added to this CompoundComparator to compare");
        for (InvertibleComparator compare : this.comparators) {
            int compare2 = compare.compare(t, t2);
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompoundComparator)) {
            return false;
        }
        return this.comparators.equals(((CompoundComparator) obj).comparators);
    }

    public int hashCode() {
        return this.comparators.hashCode();
    }

    public String toString() {
        return "CompoundComparator: " + this.comparators;
    }
}
