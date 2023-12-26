package com.yy.mobile.rollingtextview.strategy;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/Strategy;", "", "()V", "CarryBitAnimation", "Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "direction", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "NoAnimation", "NonZeroFirstAnimation", "orderStrategy", "NormalAnimation", "SameDirectionAnimation", "StickyAnimation", "factor", "", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Strategy.kt */
public final class Strategy {
    public static final Strategy INSTANCE = new Strategy();

    private Strategy() {
    }

    @JvmStatic
    public static final CharOrderStrategy NoAnimation() {
        return new Strategy$NoAnimation$1();
    }

    @JvmStatic
    public static final CharOrderStrategy NormalAnimation() {
        return new NormalAnimationStrategy();
    }

    @JvmStatic
    public static final CharOrderStrategy SameDirectionAnimation(Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new SameDirectionStrategy(direction, (CharOrderStrategy) null, 2, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final CharOrderStrategy CarryBitAnimation(Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        return NonZeroFirstAnimation(new CarryBitStrategy(direction));
    }

    public static /* synthetic */ CharOrderStrategy CarryBitAnimation$default(Direction direction, int i, Object obj) {
        if ((i & 1) != 0) {
            direction = Direction.SCROLL_DOWN;
        }
        return CarryBitAnimation(direction);
    }

    @JvmStatic
    public static final CharOrderStrategy NonZeroFirstAnimation(CharOrderStrategy charOrderStrategy) {
        Intrinsics.checkNotNullParameter(charOrderStrategy, "orderStrategy");
        return new NonZeroFirstStrategy(charOrderStrategy);
    }

    @JvmStatic
    public static final CharOrderStrategy StickyAnimation(double d) {
        return new StickyStrategy(d);
    }
}
