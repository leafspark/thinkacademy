package com.yy.mobile.rollingtextview.strategy;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JJ\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00110\tj\u0002`\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/SameDirectionStrategy;", "Lcom/yy/mobile/rollingtextview/strategy/SimpleCharOrderStrategy;", "direction", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "otherStrategy", "Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "(Lcom/yy/mobile/rollingtextview/strategy/Direction;Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;)V", "findCharOrder", "Lkotlin/Pair;", "", "", "sourceText", "", "targetText", "index", "", "charPool", "", "Lcom/yy/mobile/rollingtextview/strategy/CharPool;", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SameDirectionStrategy.kt */
public final class SameDirectionStrategy extends SimpleCharOrderStrategy {
    private final Direction direction;
    private final CharOrderStrategy otherStrategy;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SameDirectionStrategy(Direction direction2, CharOrderStrategy charOrderStrategy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(direction2, (i & 2) != 0 ? Strategy.NormalAnimation() : charOrderStrategy);
    }

    public SameDirectionStrategy(Direction direction2, CharOrderStrategy charOrderStrategy) {
        Intrinsics.checkNotNullParameter(direction2, "direction");
        Intrinsics.checkNotNullParameter(charOrderStrategy, "otherStrategy");
        this.direction = direction2;
        this.otherStrategy = charOrderStrategy;
    }

    public Pair<List<Character>, Direction> findCharOrder(CharSequence charSequence, CharSequence charSequence2, int i, List<? extends Collection<Character>> list) {
        Intrinsics.checkNotNullParameter(charSequence, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence2, "targetText");
        Intrinsics.checkNotNullParameter(list, "charPool");
        return TuplesKt.to(this.otherStrategy.findCharOrder(charSequence, charSequence2, i, list).getFirst(), this.direction);
    }
}
