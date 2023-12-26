package com.adyen.checkout.card.data;

import com.adyen.checkout.card.api.model.Brand;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012¨\u0006\""}, d2 = {"Lcom/adyen/checkout/card/data/DetectedCardType;", "", "cardType", "Lcom/adyen/checkout/card/data/CardType;", "isReliable", "", "enableLuhnCheck", "cvcPolicy", "Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;", "expiryDatePolicy", "isSupported", "isSelected", "(Lcom/adyen/checkout/card/data/CardType;ZZLcom/adyen/checkout/card/api/model/Brand$FieldPolicy;Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;ZZ)V", "getCardType", "()Lcom/adyen/checkout/card/data/CardType;", "getCvcPolicy", "()Lcom/adyen/checkout/card/api/model/Brand$FieldPolicy;", "getEnableLuhnCheck", "()Z", "getExpiryDatePolicy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DetectedCardType.kt */
public final class DetectedCardType {
    private final CardType cardType;
    private final Brand.FieldPolicy cvcPolicy;
    private final boolean enableLuhnCheck;
    private final Brand.FieldPolicy expiryDatePolicy;
    private final boolean isReliable;
    private final boolean isSelected;
    private final boolean isSupported;

    public static /* synthetic */ DetectedCardType copy$default(DetectedCardType detectedCardType, CardType cardType2, boolean z, boolean z2, Brand.FieldPolicy fieldPolicy, Brand.FieldPolicy fieldPolicy2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            cardType2 = detectedCardType.cardType;
        }
        if ((i & 2) != 0) {
            z = detectedCardType.isReliable;
        }
        boolean z5 = z;
        if ((i & 4) != 0) {
            z2 = detectedCardType.enableLuhnCheck;
        }
        boolean z6 = z2;
        if ((i & 8) != 0) {
            fieldPolicy = detectedCardType.cvcPolicy;
        }
        Brand.FieldPolicy fieldPolicy3 = fieldPolicy;
        if ((i & 16) != 0) {
            fieldPolicy2 = detectedCardType.expiryDatePolicy;
        }
        Brand.FieldPolicy fieldPolicy4 = fieldPolicy2;
        if ((i & 32) != 0) {
            z3 = detectedCardType.isSupported;
        }
        boolean z7 = z3;
        if ((i & 64) != 0) {
            z4 = detectedCardType.isSelected;
        }
        return detectedCardType.copy(cardType2, z5, z6, fieldPolicy3, fieldPolicy4, z7, z4);
    }

    public final CardType component1() {
        return this.cardType;
    }

    public final boolean component2() {
        return this.isReliable;
    }

    public final boolean component3() {
        return this.enableLuhnCheck;
    }

    public final Brand.FieldPolicy component4() {
        return this.cvcPolicy;
    }

    public final Brand.FieldPolicy component5() {
        return this.expiryDatePolicy;
    }

    public final boolean component6() {
        return this.isSupported;
    }

    public final boolean component7() {
        return this.isSelected;
    }

    public final DetectedCardType copy(CardType cardType2, boolean z, boolean z2, Brand.FieldPolicy fieldPolicy, Brand.FieldPolicy fieldPolicy2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(cardType2, "cardType");
        Intrinsics.checkNotNullParameter(fieldPolicy, "cvcPolicy");
        Intrinsics.checkNotNullParameter(fieldPolicy2, "expiryDatePolicy");
        return new DetectedCardType(cardType2, z, z2, fieldPolicy, fieldPolicy2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DetectedCardType)) {
            return false;
        }
        DetectedCardType detectedCardType = (DetectedCardType) obj;
        return this.cardType == detectedCardType.cardType && this.isReliable == detectedCardType.isReliable && this.enableLuhnCheck == detectedCardType.enableLuhnCheck && this.cvcPolicy == detectedCardType.cvcPolicy && this.expiryDatePolicy == detectedCardType.expiryDatePolicy && this.isSupported == detectedCardType.isSupported && this.isSelected == detectedCardType.isSelected;
    }

    public int hashCode() {
        int hashCode = this.cardType.hashCode() * 31;
        boolean z = this.isReliable;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.enableLuhnCheck;
        if (z3) {
            z3 = true;
        }
        int hashCode2 = (((((i + (z3 ? 1 : 0)) * 31) + this.cvcPolicy.hashCode()) * 31) + this.expiryDatePolicy.hashCode()) * 31;
        boolean z4 = this.isSupported;
        if (z4) {
            z4 = true;
        }
        int i2 = (hashCode2 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.isSelected;
        if (!z5) {
            z2 = z5;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "DetectedCardType(cardType=" + this.cardType + ", isReliable=" + this.isReliable + ", enableLuhnCheck=" + this.enableLuhnCheck + ", cvcPolicy=" + this.cvcPolicy + ", expiryDatePolicy=" + this.expiryDatePolicy + ", isSupported=" + this.isSupported + ", isSelected=" + this.isSelected + ')';
    }

    public DetectedCardType(CardType cardType2, boolean z, boolean z2, Brand.FieldPolicy fieldPolicy, Brand.FieldPolicy fieldPolicy2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(cardType2, "cardType");
        Intrinsics.checkNotNullParameter(fieldPolicy, "cvcPolicy");
        Intrinsics.checkNotNullParameter(fieldPolicy2, "expiryDatePolicy");
        this.cardType = cardType2;
        this.isReliable = z;
        this.enableLuhnCheck = z2;
        this.cvcPolicy = fieldPolicy;
        this.expiryDatePolicy = fieldPolicy2;
        this.isSupported = z3;
        this.isSelected = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DetectedCardType(CardType cardType2, boolean z, boolean z2, Brand.FieldPolicy fieldPolicy, Brand.FieldPolicy fieldPolicy2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cardType2, z, z2, fieldPolicy, fieldPolicy2, z3, (i & 64) != 0 ? false : z4);
    }

    public final CardType getCardType() {
        return this.cardType;
    }

    public final boolean isReliable() {
        return this.isReliable;
    }

    public final boolean getEnableLuhnCheck() {
        return this.enableLuhnCheck;
    }

    public final Brand.FieldPolicy getCvcPolicy() {
        return this.cvcPolicy;
    }

    public final Brand.FieldPolicy getExpiryDatePolicy() {
        return this.expiryDatePolicy;
    }

    public final boolean isSupported() {
        return this.isSupported;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
