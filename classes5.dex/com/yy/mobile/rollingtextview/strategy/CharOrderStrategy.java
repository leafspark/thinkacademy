package com.yy.mobile.rollingtextview.strategy;

import com.yy.mobile.rollingtextview.NextProgress;
import com.yy.mobile.rollingtextview.PreviousProgress;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001e\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J0\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\b\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tj\u0002`\fH\u0016JJ\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010\b\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tj\u0002`\fH&J4\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\t2\u0006\u0010\u0018\u001a\u00020\u0011H&¨\u0006\u0019"}, d2 = {"Lcom/yy/mobile/rollingtextview/strategy/CharOrderStrategy;", "", "afterCompute", "", "beforeCompute", "sourceText", "", "targetText", "charPool", "", "", "", "Lcom/yy/mobile/rollingtextview/strategy/CharPool;", "findCharOrder", "Lkotlin/Pair;", "Lcom/yy/mobile/rollingtextview/strategy/Direction;", "index", "", "nextProgress", "Lcom/yy/mobile/rollingtextview/NextProgress;", "previousProgress", "Lcom/yy/mobile/rollingtextview/PreviousProgress;", "columnIndex", "columns", "charIndex", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CharOrderStrategy.kt */
public interface CharOrderStrategy {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CharOrderStrategy.kt */
    public static final class DefaultImpls {
        public static void afterCompute(CharOrderStrategy charOrderStrategy) {
            Intrinsics.checkNotNullParameter(charOrderStrategy, "this");
        }

        public static void beforeCompute(CharOrderStrategy charOrderStrategy, CharSequence charSequence, CharSequence charSequence2, List<? extends Collection<Character>> list) {
            Intrinsics.checkNotNullParameter(charOrderStrategy, "this");
            Intrinsics.checkNotNullParameter(charSequence, "sourceText");
            Intrinsics.checkNotNullParameter(charSequence2, "targetText");
            Intrinsics.checkNotNullParameter(list, "charPool");
        }
    }

    void afterCompute();

    void beforeCompute(CharSequence charSequence, CharSequence charSequence2, List<? extends Collection<Character>> list);

    Pair<List<Character>, Direction> findCharOrder(CharSequence charSequence, CharSequence charSequence2, int i, List<? extends Collection<Character>> list);

    NextProgress nextProgress(PreviousProgress previousProgress, int i, List<? extends List<Character>> list, int i2);
}
