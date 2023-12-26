package com.yy.mobile.rollingtextview.strategy;

import com.tekartik.sqflite.Constant;
import com.yy.mobile.rollingtextview.NextProgress;
import com.yy.mobile.rollingtextview.PreviousProgress;
import com.yy.mobile.rollingtextview.util.CircularList;
import com.yy.mobile.rollingtextview.util.ExtraList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0016J0\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0016\u0010*\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`+H\u0016JE\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\b2\b\u00102\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u00103J0\u00104\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020/052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u00107\u001a\u00020/H\u0016J\b\u00108\u001a\u00020\u0003H\u0016JJ\u00109\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\u0003052\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u00107\u001a\u00020/2\u0016\u0010*\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`+H\u0016J4\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020/2\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00062\u0006\u0010@\u001a\u00020/H\u0016R(\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006A"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/CarryBitStrategy;", "Lcom/yy/mobile/rollingtextview/strategy/SimpleCharOrderStrategy;", "direction", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "(Lcom/yy/mobile/rollingtextview/strategy/Direction;)V", "charOrderList", "", "", "", "getCharOrderList", "()Ljava/util/List;", "setCharOrderList", "(Ljava/util/List;)V", "getDirection", "()Lcom/yy/mobile/rollingtextview/strategy/Direction;", "sourceCumulative", "", "getSourceCumulative", "()[I", "setSourceCumulative", "([I)V", "sourceIndex", "getSourceIndex", "setSourceIndex", "targetCumulative", "getTargetCumulative", "setTargetCumulative", "targetIndex", "getTargetIndex", "setTargetIndex", "toBigger", "", "getToBigger", "()Z", "setToBigger", "(Z)V", "afterCompute", "", "beforeCompute", "sourceText", "", "targetText", "charPool", "Lcom/yy/mobile/rollingtextview/strategy/CharPool;", "circularList", "rawList", "size", "", "firstIndex", "first", "last", "(Ljava/util/List;IILjava/lang/Character;Ljava/lang/Character;)Ljava/util/List;", "determineCharOrder", "Lkotlin/Pair;", "orderList", "index", "determineDirection", "findCharOrder", "nextProgress", "Lcom/yy/mobile/rollingtextview/NextProgress;", "previousProgress", "Lcom/yy/mobile/rollingtextview/PreviousProgress;", "columnIndex", "columns", "charIndex", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CarryBitStrategy.kt */
public class CarryBitStrategy extends SimpleCharOrderStrategy {
    private List<? extends Collection<Character>> charOrderList;
    private final Direction direction;
    private int[] sourceCumulative;
    private int[] sourceIndex;
    private int[] targetCumulative;
    private int[] targetIndex;
    private boolean toBigger = true;

    public CarryBitStrategy(Direction direction2) {
        Intrinsics.checkNotNullParameter(direction2, "direction");
        this.direction = direction2;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    /* access modifiers changed from: protected */
    public final int[] getSourceIndex() {
        return this.sourceIndex;
    }

    /* access modifiers changed from: protected */
    public final void setSourceIndex(int[] iArr) {
        this.sourceIndex = iArr;
    }

    /* access modifiers changed from: protected */
    public final int[] getTargetIndex() {
        return this.targetIndex;
    }

    /* access modifiers changed from: protected */
    public final void setTargetIndex(int[] iArr) {
        this.targetIndex = iArr;
    }

    /* access modifiers changed from: protected */
    public final int[] getSourceCumulative() {
        return this.sourceCumulative;
    }

    /* access modifiers changed from: protected */
    public final void setSourceCumulative(int[] iArr) {
        this.sourceCumulative = iArr;
    }

    /* access modifiers changed from: protected */
    public final int[] getTargetCumulative() {
        return this.targetCumulative;
    }

    /* access modifiers changed from: protected */
    public final void setTargetCumulative(int[] iArr) {
        this.targetCumulative = iArr;
    }

    /* access modifiers changed from: protected */
    public final List<Collection<Character>> getCharOrderList() {
        return this.charOrderList;
    }

    /* access modifiers changed from: protected */
    public final void setCharOrderList(List<? extends Collection<Character>> list) {
        this.charOrderList = list;
    }

    /* access modifiers changed from: protected */
    public final boolean getToBigger() {
        return this.toBigger;
    }

    /* access modifiers changed from: protected */
    public final void setToBigger(boolean z) {
        this.toBigger = z;
    }

    public void beforeCompute(CharSequence charSequence, CharSequence charSequence2, List<? extends Collection<Character>> list) {
        Object obj;
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        List<? extends Collection<Character>> list2 = list;
        Intrinsics.checkNotNullParameter(charSequence3, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence4, "targetText");
        Intrinsics.checkNotNullParameter(list2, "charPool");
        if (charSequence.length() >= 10 || charSequence2.length() >= 10) {
            throw new IllegalStateException("your text is too long, it may overflow the integer calculation. please use other animation strategy.");
        }
        int max = Math.max(charSequence.length(), charSequence2.length());
        int[] iArr = new int[max];
        int[] iArr2 = new int[max];
        int[] iArr3 = new int[max];
        List<? extends Collection<Character>> arrayList = new ArrayList<>();
        char c = 0;
        IntIterator it = RangesKt.until(0, max).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            int i = nextInt - max;
            int length = charSequence.length() + i;
            int length2 = i + charSequence2.length();
            char charAt = length >= 0 ? charSequence3.charAt(length) : c;
            char charAt2 = length2 >= 0 ? charSequence4.charAt(length2) : c;
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                Collection collection = (Collection) obj;
                if (collection.contains(Character.valueOf(charAt)) && collection.contains(Character.valueOf(charAt2))) {
                    break;
                }
            }
            Collection collection2 = (Collection) obj;
            if (collection2 != null) {
                arrayList.add(collection2);
                Iterable iterable = collection2;
                iArr[nextInt] = Math.max(CollectionsKt.indexOf(iterable, Character.valueOf(charAt)) - 1, -1);
                iArr2[nextInt] = Math.max(CollectionsKt.indexOf(iterable, Character.valueOf(charAt2)) - 1, -1);
                iArr3[nextInt] = collection2.size() - 1;
                c = 0;
            } else {
                throw new IllegalStateException("the char " + charAt + " or " + charAt2 + " cannot be found in the charPool,please addCharOrder() before use");
            }
        }
        int[] iArr4 = new int[max];
        int[] iArr5 = new int[max];
        IntIterator it3 = RangesKt.until(0, max).iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (it3.hasNext()) {
            int nextInt2 = it3.nextInt();
            i2 = (i2 * i4) + Math.max(iArr[nextInt2], 0);
            i3 = Math.max(iArr2[nextInt2], 0) + (i4 * i3);
            i4 = iArr3[nextInt2];
            iArr4[nextInt2] = i2;
            iArr5[nextInt2] = i3;
        }
        this.sourceIndex = iArr;
        this.targetIndex = iArr2;
        this.sourceCumulative = iArr4;
        this.targetCumulative = iArr5;
        this.charOrderList = arrayList;
        this.toBigger = i2 < i3;
    }

    public void afterCompute() {
        this.sourceCumulative = null;
        this.targetCumulative = null;
        this.charOrderList = null;
        this.sourceIndex = null;
        this.targetIndex = null;
    }

    public NextProgress nextProgress(PreviousProgress previousProgress, int i, List<? extends List<Character>> list, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(previousProgress, "previousProgress");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_COLUMNS);
        boolean z = true;
        if (i == list.size() - 1) {
            return super.nextProgress(previousProgress, i, list, i2);
        }
        int[] iArr = this.sourceIndex;
        List<? extends Collection<Character>> list2 = this.charOrderList;
        if (iArr == null || list2 == null) {
            return super.nextProgress(previousProgress, i, list, i2);
        }
        int i4 = i + 1;
        int max = Math.max(iArr[i4], 0);
        int size = ((Collection) list2.get(i4)).size() - 1;
        int currentIndex = previousProgress.getCurrentIndex();
        boolean z2 = this.toBigger;
        if (z2) {
            i3 = (currentIndex + max) / size;
        } else {
            i3 = (((currentIndex - max) - 1) + size) / size;
        }
        int i5 = i3;
        if (!z2 ? (currentIndex - max) % size != 0 : ((currentIndex + max) + 1) % size != 0) {
            z = false;
        }
        if (z) {
            return new NextProgress(i5, previousProgress.getOffsetPercentage(), previousProgress.getProgress());
        }
        return new NextProgress(i5, 0.0d, previousProgress.getProgress());
    }

    public Pair<List<Character>, Direction> findCharOrder(CharSequence charSequence, CharSequence charSequence2, int i, List<? extends Collection<Character>> list) {
        int i2 = i;
        CharSequence charSequence3 = charSequence;
        Intrinsics.checkNotNullParameter(charSequence, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence2, "targetText");
        Intrinsics.checkNotNullParameter(list, "charPool");
        int[] iArr = this.sourceIndex;
        int[] iArr2 = this.targetIndex;
        int[] iArr3 = this.sourceCumulative;
        int[] iArr4 = this.targetCumulative;
        List<? extends Collection<Character>> list2 = this.charOrderList;
        if (iArr3 == null || iArr4 == null || list2 == null || iArr == null || iArr2 == null) {
            throw new IllegalStateException("CarryBitStrategy is in a illegal state, check it's lifecycle");
        }
        Collection arrayList = new ArrayList();
        Iterator it = ((Iterable) list2.get(i2)).iterator();
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((Character) next).charValue();
            if (i3 <= 0) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
            i3 = i4;
        }
        List list3 = (List) arrayList;
        int abs = Math.abs(iArr3[i2] - iArr4[i2]) + 1;
        char c = iArr[i2] == -1 ? (char) 0 : null;
        Character ch = iArr2[i2] == -1 ? (char) 0 : null;
        Pair<List<Character>, Integer> determineCharOrder = determineCharOrder(list3, RangesKt.coerceAtLeast(iArr[i2], 0));
        return TuplesKt.to(circularList(determineCharOrder.component1(), abs, determineCharOrder.component2().intValue(), c, ch), determineDirection());
    }

    public List<Character> circularList(List<Character> list, int i, int i2, Character ch, Character ch2) {
        Intrinsics.checkNotNullParameter(list, "rawList");
        return new ExtraList<>(new CircularList(list, i, i2), ch, ch2);
    }

    public Pair<List<Character>, Integer> determineCharOrder(List<Character> list, int i) {
        Intrinsics.checkNotNullParameter(list, "orderList");
        if (this.toBigger) {
            return TuplesKt.to(list, Integer.valueOf(i));
        }
        return TuplesKt.to(CollectionsKt.asReversed(list), Integer.valueOf((list.size() - 1) - i));
    }

    public Direction determineDirection() {
        return this.direction;
    }
}
