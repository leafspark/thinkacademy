package com.yy.mobile.rollingtextview.strategy;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JJ\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\tj\u0002`\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/AlignAnimationStrategy;", "Lcom/yy/mobile/rollingtextview/strategy/NormalAnimationStrategy;", "alignment", "Lcom/yy/mobile/rollingtextview/strategy/AlignAnimationStrategy$TextAlignment;", "(Lcom/yy/mobile/rollingtextview/strategy/AlignAnimationStrategy$TextAlignment;)V", "getAlignment", "()Lcom/yy/mobile/rollingtextview/strategy/AlignAnimationStrategy$TextAlignment;", "findCharOrder", "Lkotlin/Pair;", "", "", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "sourceText", "", "targetText", "index", "", "charPool", "", "Lcom/yy/mobile/rollingtextview/strategy/CharPool;", "getTextRange", "Lkotlin/ranges/IntRange;", "text", "maxLen", "TextAlignment", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AlignAnimationStrategy.kt */
public class AlignAnimationStrategy extends NormalAnimationStrategy {
    private final TextAlignment alignment;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/AlignAnimationStrategy$TextAlignment;", "", "(Ljava/lang/String;I)V", "Left", "Right", "Center", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AlignAnimationStrategy.kt */
    public enum TextAlignment {
        Left,
        Right,
        Center
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AlignAnimationStrategy.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextAlignment.values().length];
            iArr[TextAlignment.Left.ordinal()] = 1;
            iArr[TextAlignment.Center.ordinal()] = 2;
            iArr[TextAlignment.Right.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AlignAnimationStrategy(TextAlignment textAlignment) {
        Intrinsics.checkNotNullParameter(textAlignment, "alignment");
        this.alignment = textAlignment;
    }

    public final TextAlignment getAlignment() {
        return this.alignment;
    }

    public Pair<List<Character>, Direction> findCharOrder(CharSequence charSequence, CharSequence charSequence2, int i, List<? extends Collection<Character>> list) {
        Intrinsics.checkNotNullParameter(charSequence, "sourceText");
        Intrinsics.checkNotNullParameter(charSequence2, "targetText");
        Intrinsics.checkNotNullParameter(list, "charPool");
        int max = Math.max(charSequence.length(), charSequence2.length());
        IntRange textRange = getTextRange(charSequence, max);
        IntRange textRange2 = getTextRange(charSequence2, max);
        boolean z = true;
        char c = 0;
        char charAt = i <= textRange.getLast() && textRange.getFirst() <= i ? charSequence.charAt(i - textRange.getFirst()) : 0;
        int first = textRange2.getFirst();
        if (i > textRange2.getLast() || first > i) {
            z = false;
        }
        if (z) {
            c = charSequence2.charAt(i - textRange2.getFirst());
        }
        return findCharOrder(charAt, c, i, list);
    }

    private final IntRange getTextRange(CharSequence charSequence, int i) {
        int i2;
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.alignment.ordinal()];
        if (i3 == 1) {
            i2 = 0;
        } else if (i3 == 2) {
            i2 = MathKt.roundToInt(((float) (i - charSequence.length())) / 2.0f);
        } else if (i3 == 3) {
            i2 = i - charSequence.length();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return RangesKt.until(i2, charSequence.length() + i2);
    }
}
