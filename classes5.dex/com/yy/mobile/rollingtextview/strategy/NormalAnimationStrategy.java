package com.yy.mobile.rollingtextview.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0016J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0005\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/NormalAnimationStrategy;", "Lcom/yy/mobile/rollingtextview/strategy/SimpleCharOrderStrategy;", "()V", "findCharOrder", "Lkotlin/Pair;", "", "", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "sourceChar", "targetChar", "index", "", "order", "", "subList", "T", "start", "end", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: NormalAnimationStrategy.kt */
public class NormalAnimationStrategy extends SimpleCharOrderStrategy {
    public Pair<List<Character>, Direction> findCharOrder(char c, char c2, int i, Iterable<Character> iterable) {
        if (c == c2) {
            return TuplesKt.to(CollectionsKt.listOf(Character.valueOf(c2)), Direction.SCROLL_DOWN);
        }
        if (iterable == null) {
            return TuplesKt.to(CollectionsKt.listOf(new Character[]{Character.valueOf(c), Character.valueOf(c2)}), Direction.SCROLL_DOWN);
        }
        int indexOf = CollectionsKt.indexOf(iterable, Character.valueOf(c));
        int indexOf2 = CollectionsKt.indexOf(iterable, Character.valueOf(c2));
        if (indexOf < indexOf2) {
            return TuplesKt.to(subList(iterable, indexOf, indexOf2), Direction.SCROLL_DOWN);
        }
        return TuplesKt.to(CollectionsKt.asReversed(subList(iterable, indexOf2, indexOf)), Direction.SCROLL_UP);
    }

    private final <T> List<T> subList(Iterable<? extends T> iterable, int i, int i2) {
        Collection arrayList = new ArrayList();
        int i3 = 0;
        for (Object next : iterable) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (i <= i3 && i3 <= i2) {
                arrayList.add(next);
            }
            i3 = i4;
        }
        return (List) arrayList;
    }
}
