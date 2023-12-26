package com.yy.mobile.rollingtextview.strategy;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/yy/mobile/rollingtextview/strategy/Strategy$NoAnimation$1", "Lcom/yy/mobile/rollingtextview/strategy/SimpleCharOrderStrategy;", "findCharOrder", "Lkotlin/Pair;", "", "", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "sourceChar", "targetChar", "index", "", "order", "", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Strategy.kt */
public final class Strategy$NoAnimation$1 extends SimpleCharOrderStrategy {
    Strategy$NoAnimation$1() {
    }

    public Pair<List<Character>, Direction> findCharOrder(char c, char c2, int i, Iterable<Character> iterable) {
        return TuplesKt.to(CollectionsKt.listOf(Character.valueOf(c2)), Direction.SCROLL_DOWN);
    }
}
