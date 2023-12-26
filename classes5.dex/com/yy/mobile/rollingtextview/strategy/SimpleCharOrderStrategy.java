package com.yy.mobile.rollingtextview.strategy;

import com.tekartik.sqflite.Constant;
import com.yy.mobile.rollingtextview.NextProgress;
import com.yy.mobile.rollingtextview.PreviousProgress;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\t\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u0002`\rH\u0016JJ\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0016\u0010\t\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u0002`\rH\u0016JB\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0016H\u0016JJ\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0016\u0010\t\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u0002`\rH\u0016J.\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0016J4\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00142\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n0\n2\u0006\u0010!\u001a\u00020\u0014H\u0016¨\u0006\""}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/SimpleCharOrderStrategy;", "Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "()V", "afterCompute", "", "beforeCompute", "sourceText", "", "targetText", "charPool", "", "", "", "Lcom/yy/mobile/rollingtextview/strategy/CharPool;", "findCharOrder", "Lkotlin/Pair;", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "sourceChar", "targetChar", "index", "", "order", "", "getFactor", "", "previousProgress", "Lcom/yy/mobile/rollingtextview/PreviousProgress;", "size", "charList", "nextProgress", "Lcom/yy/mobile/rollingtextview/NextProgress;", "columnIndex", "columns", "charIndex", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CharOrderStrategy.kt */
public abstract class SimpleCharOrderStrategy implements CharOrderStrategy {
    public void afterCompute() {
    }

    public void beforeCompute(CharSequence charSequence, CharSequence charSequence2, List<? extends Collection<Character>> list) {
        Intrinsics.checkNotNullParameter(charSequence, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence2, "targetText");
        Intrinsics.checkNotNullParameter(list, "charPool");
    }

    public double getFactor(PreviousProgress previousProgress, int i, int i2, List<Character> list) {
        Intrinsics.checkNotNullParameter(previousProgress, "previousProgress");
        Intrinsics.checkNotNullParameter(list, "charList");
        return 1.0d;
    }

    public NextProgress nextProgress(PreviousProgress previousProgress, int i, List<? extends List<Character>> list, int i2) {
        Intrinsics.checkNotNullParameter(previousProgress, "previousProgress");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_COLUMNS);
        int size = list.size();
        List list2 = (List) list.get(i);
        double factor = getFactor(previousProgress, i, size, list2);
        double size2 = ((double) (list2.size() - 1)) * previousProgress.getProgress();
        int i3 = (int) size2;
        double d = 1.0d / factor;
        double d2 = 1.0d - factor;
        double d3 = size2 - ((double) i3);
        return new NextProgress(i3, d3 >= d2 ? (d3 * d) - (d2 * d) : 0.0d, previousProgress.getProgress());
    }

    public Pair<List<Character>, Direction> findCharOrder(CharSequence charSequence, CharSequence charSequence2, int i, List<? extends Collection<Character>> list) {
        Intrinsics.checkNotNullParameter(charSequence, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence2, "targetText");
        Intrinsics.checkNotNullParameter(list, "charPool");
        int max = Math.max(charSequence.length(), charSequence2.length());
        int length = max - charSequence.length();
        int length2 = max - charSequence2.length();
        char c = 0;
        char charAt = i >= length ? charSequence.charAt(i - length) : 0;
        if (i >= length2) {
            c = charSequence2.charAt(i - length2);
        }
        return findCharOrder(charAt, c, i, list);
    }

    public Pair<List<Character>, Direction> findCharOrder(char c, char c2, int i, List<? extends Collection<Character>> list) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(list, "charPool");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Collection collection = (Collection) obj;
            if (!collection.contains(Character.valueOf(c)) || !collection.contains(Character.valueOf(c2))) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        return findCharOrder(c, c2, i, (Iterable<Character>) (Collection) obj);
    }

    public Pair<List<Character>, Direction> findCharOrder(char c, char c2, int i, Iterable<Character> iterable) {
        return TuplesKt.to(CollectionsKt.listOf(new Character[]{Character.valueOf(c), Character.valueOf(c2)}), Direction.SCROLL_DOWN);
    }
}
