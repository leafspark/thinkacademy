package com.adyen.checkout.card;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0007"}, d2 = {"Lcom/adyen/checkout/card/DualBrandedCardUtils;", "", "()V", "sortBrands", "", "Lcom/adyen/checkout/card/data/DetectedCardType;", "cards", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DualBrandedCardUtils.kt */
public final class DualBrandedCardUtils {
    public static final DualBrandedCardUtils INSTANCE = new DualBrandedCardUtils();

    private DualBrandedCardUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
        if (kotlin.text.StringsKt.contains$default(r6, "cbcc", false, 2, (java.lang.Object) null) != false) goto L_0x00c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x004a A[EDGE_INSN: B:54:0x004a->B:19:0x004a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c6 A[EDGE_INSN: B:58:0x00c6->B:45:0x00c6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0075 A[EDGE_INSN: B:59:0x0075->B:32:0x0075 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.adyen.checkout.card.data.DetectedCardType> sortBrands(java.util.List<com.adyen.checkout.card.data.DetectedCardType> r13) {
        /*
            r12 = this;
            java.lang.String r0 = "cards"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            int r0 = r13.size()
            r1 = 1
            if (r0 > r1) goto L_0x000e
            goto L_0x00e3
        L_0x000e:
            r0 = r13
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L_0x0021
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0021
        L_0x001f:
            r4 = r3
            goto L_0x003f
        L_0x0021:
            java.util.Iterator r4 = r0.iterator()
        L_0x0025:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x001f
            java.lang.Object r5 = r4.next()
            com.adyen.checkout.card.data.DetectedCardType r5 = (com.adyen.checkout.card.data.DetectedCardType) r5
            com.adyen.checkout.card.data.CardType r5 = r5.getCardType()
            com.adyen.checkout.card.data.CardType r6 = com.adyen.checkout.card.data.CardType.CARTEBANCAIRE
            if (r5 != r6) goto L_0x003b
            r5 = r1
            goto L_0x003c
        L_0x003b:
            r5 = r3
        L_0x003c:
            if (r5 == 0) goto L_0x0025
            r4 = r1
        L_0x003f:
            if (r2 == 0) goto L_0x004c
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x004c
        L_0x004a:
            r5 = r3
            goto L_0x006a
        L_0x004c:
            java.util.Iterator r5 = r0.iterator()
        L_0x0050:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x004a
            java.lang.Object r6 = r5.next()
            com.adyen.checkout.card.data.DetectedCardType r6 = (com.adyen.checkout.card.data.DetectedCardType) r6
            com.adyen.checkout.card.data.CardType r6 = r6.getCardType()
            com.adyen.checkout.card.data.CardType r7 = com.adyen.checkout.card.data.CardType.VISA
            if (r6 != r7) goto L_0x0066
            r6 = r1
            goto L_0x0067
        L_0x0066:
            r6 = r3
        L_0x0067:
            if (r6 == 0) goto L_0x0050
            r5 = r1
        L_0x006a:
            if (r2 == 0) goto L_0x0077
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0077
        L_0x0075:
            r1 = r3
            goto L_0x00c6
        L_0x0077:
            java.util.Iterator r2 = r0.iterator()
        L_0x007b:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0075
            java.lang.Object r6 = r2.next()
            com.adyen.checkout.card.data.DetectedCardType r6 = (com.adyen.checkout.card.data.DetectedCardType) r6
            com.adyen.checkout.card.data.CardType r7 = r6.getCardType()
            com.adyen.checkout.card.data.CardType r8 = com.adyen.checkout.card.data.CardType.UNKNOWN
            if (r7 != r8) goto L_0x00c3
            com.adyen.checkout.card.data.CardType r7 = r6.getCardType()
            java.lang.String r7 = r7.getTxVariant()
            java.lang.String r8 = "it.cardType.txVariant"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r9 = "plcc"
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10 = 2
            r11 = 0
            boolean r7 = kotlin.text.StringsKt.contains$default(r7, r9, r3, r10, r11)
            if (r7 != 0) goto L_0x00c1
            com.adyen.checkout.card.data.CardType r6 = r6.getCardType()
            java.lang.String r6 = r6.getTxVariant()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r7 = "cbcc"
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r7, r3, r10, r11)
            if (r6 == 0) goto L_0x00c3
        L_0x00c1:
            r6 = r1
            goto L_0x00c4
        L_0x00c3:
            r6 = r3
        L_0x00c4:
            if (r6 == 0) goto L_0x007b
        L_0x00c6:
            if (r4 == 0) goto L_0x00d6
            if (r5 == 0) goto L_0x00d6
            com.adyen.checkout.card.DualBrandedCardUtils$sortBrands$$inlined$sortedByDescending$1 r13 = new com.adyen.checkout.card.DualBrandedCardUtils$sortBrands$$inlined$sortedByDescending$1
            r13.<init>()
            java.util.Comparator r13 = (java.util.Comparator) r13
            java.util.List r13 = kotlin.collections.CollectionsKt.sortedWith(r0, r13)
            goto L_0x00e3
        L_0x00d6:
            if (r1 == 0) goto L_0x00e3
            com.adyen.checkout.card.DualBrandedCardUtils$sortBrands$$inlined$sortedByDescending$2 r13 = new com.adyen.checkout.card.DualBrandedCardUtils$sortBrands$$inlined$sortedByDescending$2
            r13.<init>()
            java.util.Comparator r13 = (java.util.Comparator) r13
            java.util.List r13 = kotlin.collections.CollectionsKt.sortedWith(r0, r13)
        L_0x00e3:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.DualBrandedCardUtils.sortBrands(java.util.List):java.util.List");
    }
}
