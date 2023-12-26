package com.yy.mobile.rollingtextview.strategy;

import com.yy.mobile.rollingtextview.PreviousProgress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/StickyStrategy;", "Lcom/yy/mobile/rollingtextview/strategy/NormalAnimationStrategy;", "factor", "", "(D)V", "getFactor", "()D", "previousProgress", "Lcom/yy/mobile/rollingtextview/PreviousProgress;", "index", "", "size", "charList", "", "", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StickyStrategy.kt */
public final class StickyStrategy extends NormalAnimationStrategy {
    private final double factor;

    public StickyStrategy(double d) {
        this.factor = d;
        if (d <= 0.0d && d > 1.0d) {
            throw new IllegalStateException(Intrinsics.stringPlus("factor must be in range (0,1] but now is ", Double.valueOf(d)));
        }
    }

    public final double getFactor() {
        return this.factor;
    }

    public double getFactor(PreviousProgress previousProgress, int i, int i2, List<Character> list) {
        Intrinsics.checkNotNullParameter(previousProgress, "previousProgress");
        Intrinsics.checkNotNullParameter(list, "charList");
        return this.factor;
    }
}
