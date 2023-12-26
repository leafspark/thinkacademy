package com.adyen.checkout.card;

import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.card.data.DetectedCardType;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
/* compiled from: Comparisons.kt */
public final class DualBrandedCardUtils$sortBrands$$inlined$sortedByDescending$1<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        boolean z = true;
        Comparable valueOf = Boolean.valueOf(((DetectedCardType) t2).getCardType() == CardType.VISA);
        if (((DetectedCardType) t).getCardType() != CardType.VISA) {
            z = false;
        }
        return ComparisonsKt.compareValues(valueOf, Boolean.valueOf(z));
    }
}
