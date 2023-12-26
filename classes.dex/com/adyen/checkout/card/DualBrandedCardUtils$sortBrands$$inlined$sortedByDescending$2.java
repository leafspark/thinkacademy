package com.adyen.checkout.card;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
/* compiled from: Comparisons.kt */
public final class DualBrandedCardUtils$sortBrands$$inlined$sortedByDescending$2<T> implements Comparator<T> {
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006c, code lost:
        if (kotlin.text.StringsKt.contains$default(r9, "cbcc", false, 2, (java.lang.Object) null) != false) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int compare(T r9, T r10) {
        /*
            r8 = this;
            com.adyen.checkout.card.data.DetectedCardType r10 = (com.adyen.checkout.card.data.DetectedCardType) r10
            com.adyen.checkout.card.data.CardType r0 = r10.getCardType()
            java.lang.String r0 = r0.getTxVariant()
            java.lang.String r1 = "it.cardType.txVariant"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "plcc"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            r5 = 2
            r6 = 0
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r3, r4, r5, r6)
            java.lang.String r3 = "cbcc"
            r7 = 1
            if (r0 != 0) goto L_0x003b
            com.adyen.checkout.card.data.CardType r10 = r10.getCardType()
            java.lang.String r10 = r10.getTxVariant()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r10 = kotlin.text.StringsKt.contains$default(r10, r0, r4, r5, r6)
            if (r10 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r10 = r4
            goto L_0x003c
        L_0x003b:
            r10 = r7
        L_0x003c:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            java.lang.Comparable r10 = (java.lang.Comparable) r10
            com.adyen.checkout.card.data.DetectedCardType r9 = (com.adyen.checkout.card.data.DetectedCardType) r9
            com.adyen.checkout.card.data.CardType r0 = r9.getCardType()
            java.lang.String r0 = r0.getTxVariant()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r2, r4, r5, r6)
            if (r0 != 0) goto L_0x006e
            com.adyen.checkout.card.data.CardType r9 = r9.getCardType()
            java.lang.String r9 = r9.getTxVariant()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r9 = kotlin.text.StringsKt.contains$default(r9, r3, r4, r5, r6)
            if (r9 == 0) goto L_0x006f
        L_0x006e:
            r4 = r7
        L_0x006f:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r4)
            java.lang.Comparable r9 = (java.lang.Comparable) r9
            int r9 = kotlin.comparisons.ComparisonsKt.compareValues(r10, r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.DualBrandedCardUtils$sortBrands$$inlined$sortedByDescending$2.compare(java.lang.Object, java.lang.Object):int");
    }
}
