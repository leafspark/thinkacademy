package com.yy.mobile.rollingtextview;

import com.tekartik.sqflite.Constant;
import com.yy.mobile.rollingtextview.strategy.CharOrderStrategy;
import com.yy.mobile.rollingtextview.strategy.Direction;
import com.yy.mobile.rollingtextview.strategy.Strategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J0\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ2\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180\u00182\u0006\u0010!\u001a\u00020\u001bR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/yy/mobile/rollingtextview/CharOrderManager;", "", "()V", "charOrderList", "", "Ljava/util/LinkedHashSet;", "", "charStrategy", "Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "getCharStrategy", "()Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "setCharStrategy", "(Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;)V", "addCharOrder", "", "orderList", "", "afterCharOrder", "beforeCharOrder", "sourceText", "", "targetText", "findCharOrder", "Lkotlin/Pair;", "", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "index", "", "getProgress", "Lcom/yy/mobile/rollingtextview/NextProgress;", "previousProgress", "Lcom/yy/mobile/rollingtextview/PreviousProgress;", "columns", "charIndex", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CharOrderManager.kt */
public final class CharOrderManager {
    private final List<LinkedHashSet<Character>> charOrderList = new ArrayList();
    private CharOrderStrategy charStrategy = Strategy.NormalAnimation();

    public final CharOrderStrategy getCharStrategy() {
        return this.charStrategy;
    }

    public final void setCharStrategy(CharOrderStrategy charOrderStrategy) {
        Intrinsics.checkNotNullParameter(charOrderStrategy, "<set-?>");
        this.charStrategy = charOrderStrategy;
    }

    public final void addCharOrder(Iterable<Character> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "orderList");
        Collection mutableListOf = CollectionsKt.mutableListOf(new Character[]{0});
        CollectionsKt.addAll(mutableListOf, iterable);
        this.charOrderList.add(new LinkedHashSet(mutableListOf));
    }

    public final Pair<List<Character>, Direction> findCharOrder(CharSequence charSequence, CharSequence charSequence2, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence2, "targetText");
        return this.charStrategy.findCharOrder(charSequence, charSequence2, i, this.charOrderList);
    }

    public final void beforeCharOrder(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence2, "targetText");
        this.charStrategy.beforeCompute(charSequence, charSequence2, this.charOrderList);
    }

    public final void afterCharOrder() {
        this.charStrategy.afterCompute();
    }

    public final NextProgress getProgress(PreviousProgress previousProgress, int i, List<? extends List<Character>> list, int i2) {
        Intrinsics.checkNotNullParameter(previousProgress, "previousProgress");
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_COLUMNS);
        return this.charStrategy.nextProgress(previousProgress, i, list, i2);
    }
}
