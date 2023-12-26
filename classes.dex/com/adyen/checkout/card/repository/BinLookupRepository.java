package com.adyen.checkout.card.repository;

import com.adyen.checkout.card.CardConfiguration;
import com.adyen.checkout.card.api.model.BinLookupResponse;
import com.adyen.checkout.card.api.model.Brand;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.card.data.DetectedCardType;
import com.adyen.checkout.core.encryption.Sha256;
import com.adyen.checkout.core.log.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J/\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J+\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/adyen/checkout/card/repository/BinLookupRepository;", "", "()V", "cachedBinLookup", "Ljava/util/HashMap;", "", "", "Lcom/adyen/checkout/card/data/DetectedCardType;", "Lkotlin/collections/HashMap;", "contains", "", "cardNumber", "fetch", "publicKey", "cardConfiguration", "Lcom/adyen/checkout/card/CardConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Lcom/adyen/checkout/card/CardConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "hashBin", "isRequiredSize", "makeBinLookup", "Lcom/adyen/checkout/card/api/model/BinLookupResponse;", "mapResponse", "binLookupResponse", "Companion", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BinLookupRepository.kt */
public final class BinLookupRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REQUIRED_BIN_SIZE = 11;
    private final HashMap<String, List<DetectedCardType>> cachedBinLookup = new HashMap<>();

    public final boolean isRequiredSize(String str) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        return str.length() >= 11;
    }

    public final boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        if (isRequiredSize(str)) {
            return this.cachedBinLookup.containsKey(hashBin(str));
        }
        return false;
    }

    private final String hashBin(String str) {
        return Sha256.INSTANCE.hashString(StringsKt.take(str, 11));
    }

    public final List<DetectedCardType> get(String str) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        if (isRequiredSize(str)) {
            List<DetectedCardType> list = this.cachedBinLookup.get(hashBin(str));
            if (list != null) {
                return list;
            }
            throw new IllegalArgumentException("BinLookupRepository does not contain card number");
        }
        throw new IllegalArgumentException("Card number too small card number");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetch(java.lang.String r5, java.lang.String r6, com.adyen.checkout.card.CardConfiguration r7, kotlin.coroutines.Continuation<? super java.util.List<com.adyen.checkout.card.data.DetectedCardType>> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.adyen.checkout.card.repository.BinLookupRepository$fetch$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.adyen.checkout.card.repository.BinLookupRepository$fetch$1 r0 = (com.adyen.checkout.card.repository.BinLookupRepository$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.adyen.checkout.card.repository.BinLookupRepository$fetch$1 r0 = new com.adyen.checkout.card.repository.BinLookupRepository$fetch$1
            r0.<init>(r4, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.L$0
            com.adyen.checkout.card.repository.BinLookupRepository r6 = (com.adyen.checkout.card.repository.BinLookupRepository) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004b
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r4.makeBinLookup(r5, r6, r7, r0)
            if (r8 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r4
        L_0x004b:
            com.adyen.checkout.card.api.model.BinLookupResponse r8 = (com.adyen.checkout.card.api.model.BinLookupResponse) r8
            java.util.List r7 = r6.mapResponse(r8)
            java.util.HashMap<java.lang.String, java.util.List<com.adyen.checkout.card.data.DetectedCardType>> r8 = r6.cachedBinLookup
            java.util.Map r8 = (java.util.Map) r8
            java.lang.String r5 = r6.hashBin(r5)
            r8.put(r5, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.card.repository.BinLookupRepository.fetch(java.lang.String, java.lang.String, com.adyen.checkout.card.CardConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object makeBinLookup(String str, String str2, CardConfiguration cardConfiguration, Continuation<? super BinLookupResponse> continuation) {
        return CoroutineScopeKt.coroutineScope(new BinLookupRepository$makeBinLookup$2(cardConfiguration, str, str2, (Continuation<? super BinLookupRepository$makeBinLookup$2>) null), continuation);
    }

    private final List<DetectedCardType> mapResponse(BinLookupResponse binLookupResponse) {
        List<Brand> list;
        DetectedCardType detectedCardType;
        Logger.d(BinLookupRepositoryKt.TAG, "handleBinLookupResponse");
        Logger.v(BinLookupRepositoryKt.TAG, Intrinsics.stringPlus("Brands: ", binLookupResponse == null ? null : binLookupResponse.getBrands()));
        if (binLookupResponse == null) {
            list = null;
        } else {
            list = binLookupResponse.getBrands();
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Collection arrayList = new ArrayList();
        for (Brand brand : list) {
            if (brand.getBrand() == null) {
                detectedCardType = null;
            } else {
                CardType byBrandName = CardType.getByBrandName(brand.getBrand());
                if (byBrandName == null) {
                    byBrandName = CardType.UNKNOWN;
                    byBrandName.setTxVariant(brand.getBrand());
                }
                CardType cardType = byBrandName;
                Intrinsics.checkNotNullExpressionValue(cardType, "CardType.getByBrandName(brandResponse.brand) ?: CardType.UNKNOWN.apply { txVariant = brandResponse.brand }");
                boolean areEqual = Intrinsics.areEqual(brand.getEnableLuhnCheck(), true);
                Brand.FieldPolicy.Companion companion = Brand.FieldPolicy.Companion;
                String cvcPolicy = brand.getCvcPolicy();
                if (cvcPolicy == null) {
                    cvcPolicy = Brand.FieldPolicy.REQUIRED.getValue();
                }
                Brand.FieldPolicy parse = companion.parse(cvcPolicy);
                Brand.FieldPolicy.Companion companion2 = Brand.FieldPolicy.Companion;
                String expiryDatePolicy = brand.getExpiryDatePolicy();
                if (expiryDatePolicy == null) {
                    expiryDatePolicy = Brand.FieldPolicy.REQUIRED.getValue();
                }
                detectedCardType = new DetectedCardType(cardType, true, areEqual, parse, companion2.parse(expiryDatePolicy), !Intrinsics.areEqual(brand.getSupported(), false), false, 64, (DefaultConstructorMarker) null);
            }
            if (detectedCardType != null) {
                arrayList.add(detectedCardType);
            }
        }
        return (List) arrayList;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adyen/checkout/card/repository/BinLookupRepository$Companion;", "", "()V", "REQUIRED_BIN_SIZE", "", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BinLookupRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
