package com.yy.mobile.rollingtextview.strategy;

import com.tekartik.sqflite.Constant;
import com.yy.mobile.rollingtextview.NextProgress;
import com.yy.mobile.rollingtextview.PreviousProgress;
import com.yy.mobile.rollingtextview.util.CircularList;
import com.yy.mobile.rollingtextview.util.ReplaceList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0007\u001a\u00020\bH\u0001J0\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\r\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u0002`\u0011H\u0016JJ\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0016\u0010\r\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u0002`\u0011H\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J5\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00162\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000e0\u000e2\u0006\u0010 \u001a\u00020\u0016H\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/NonZeroFirstStrategy;", "Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "strategy", "(Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;)V", "sourceZeroFirst", "", "targetZeroFirst", "afterCompute", "", "beforeCompute", "sourceText", "", "targetText", "charPool", "", "", "", "Lcom/yy/mobile/rollingtextview/strategy/CharPool;", "findCharOrder", "Lkotlin/Pair;", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "index", "", "firstZeroAfterEmpty", "list", "lastZeroBeforeEmpty", "nextProgress", "Lcom/yy/mobile/rollingtextview/NextProgress;", "previousProgress", "Lcom/yy/mobile/rollingtextview/PreviousProgress;", "columnIndex", "columns", "charIndex", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: NonZeroFirstStrategy.kt */
public class NonZeroFirstStrategy implements CharOrderStrategy {
    private boolean sourceZeroFirst = true;
    private final CharOrderStrategy strategy;
    private boolean targetZeroFirst = true;

    public void afterCompute() {
        this.strategy.afterCompute();
    }

    public NextProgress nextProgress(PreviousProgress previousProgress, int i, List<? extends List<Character>> list, int i2) {
        Intrinsics.checkNotNullParameter(previousProgress, "previousProgress");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_COLUMNS);
        return this.strategy.nextProgress(previousProgress, i, list, i2);
    }

    public NonZeroFirstStrategy(CharOrderStrategy charOrderStrategy) {
        Intrinsics.checkNotNullParameter(charOrderStrategy, "strategy");
        this.strategy = charOrderStrategy;
    }

    public void beforeCompute(CharSequence charSequence, CharSequence charSequence2, List<? extends Collection<Character>> list) {
        Intrinsics.checkNotNullParameter(charSequence, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence2, "targetText");
        Intrinsics.checkNotNullParameter(list, "charPool");
        this.strategy.beforeCompute(charSequence, charSequence2, list);
        this.sourceZeroFirst = true;
        this.targetZeroFirst = true;
    }

    public Pair<List<Character>, Direction> findCharOrder(CharSequence charSequence, CharSequence charSequence2, int i, List<? extends Collection<Character>> list) {
        boolean z;
        boolean z2;
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        int i2 = i;
        List<? extends Collection<Character>> list2 = list;
        Intrinsics.checkNotNullParameter(charSequence3, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence4, "targetText");
        Intrinsics.checkNotNullParameter(list2, "charPool");
        Pair<List<Character>, Direction> findCharOrder = this.strategy.findCharOrder(charSequence3, charSequence4, i2, list2);
        List component1 = findCharOrder.component1();
        Direction component2 = findCharOrder.component2();
        int max = Math.max(charSequence.length(), charSequence2.length());
        int firstZeroAfterEmpty = firstZeroAfterEmpty(component1);
        int lastZeroBeforeEmpty = lastZeroBeforeEmpty(component1);
        if (!this.sourceZeroFirst || firstZeroAfterEmpty == -1 || i2 == max - 1) {
            this.sourceZeroFirst = false;
            z = false;
        } else {
            z = true;
        }
        if (!this.targetZeroFirst || lastZeroBeforeEmpty == -1 || i2 == max - 1) {
            this.targetZeroFirst = false;
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && z2) {
            component1 = new ReplaceList(component1, null, null, new NonZeroFirstStrategy$findCharOrder$replaceList$1(firstZeroAfterEmpty), new NonZeroFirstStrategy$findCharOrder$replaceList$2(lastZeroBeforeEmpty));
        } else if (z) {
            component1 = new ReplaceList(component1, (Object) null, (Object) null, new NonZeroFirstStrategy$findCharOrder$replaceList$3(firstZeroAfterEmpty), new NonZeroFirstStrategy$findCharOrder$replaceList$4(lastZeroBeforeEmpty), 4, (DefaultConstructorMarker) null);
        } else if (z2) {
            component1 = new ReplaceList(component1, (Object) null, (Object) null, new NonZeroFirstStrategy$findCharOrder$replaceList$5(firstZeroAfterEmpty), new NonZeroFirstStrategy$findCharOrder$replaceList$6(lastZeroBeforeEmpty), 2, (DefaultConstructorMarker) null);
        }
        List list3 = component1;
        if (z && z2) {
            list3 = new CircularList(list3, (lastZeroBeforeEmpty - firstZeroAfterEmpty) + 1, firstZeroAfterEmpty);
        } else if (z) {
            list3 = new CircularList(list3, list3.size() - firstZeroAfterEmpty, firstZeroAfterEmpty);
        } else if (z2) {
            list3 = new CircularList(list3, lastZeroBeforeEmpty + 1, 0, 4, (DefaultConstructorMarker) null);
        }
        return TuplesKt.to(list3, component2);
    }

    private final int firstZeroAfterEmpty(List<Character> list) {
        int i = 0;
        for (Character charValue : list) {
            int i2 = i + 1;
            char charValue2 = charValue.charValue();
            if (charValue2 == '0') {
                return i;
            }
            if (charValue2 != 0) {
                return -1;
            }
            i = i2;
        }
        return -1;
    }

    private final int lastZeroBeforeEmpty(List<Character> list) {
        ListIterator<Character> listIterator = list.listIterator(list.size());
        int size = list.size();
        while (listIterator.hasPrevious()) {
            char charValue = listIterator.previous().charValue();
            size--;
            if (charValue != '0') {
                if (charValue != 0) {
                    break;
                }
            } else {
                return size;
            }
        }
        return -1;
    }
}
