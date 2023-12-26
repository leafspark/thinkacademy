package com.adyen.checkout.components.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/adyen/checkout/components/util/CountryInfo;", "", "isoCode", "", "callingCode", "emoji", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCallingCode", "()Ljava/lang/String;", "getEmoji", "getIsoCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CountryUtils.kt */
public final class CountryInfo {
    private final String callingCode;
    private final String emoji;
    private final String isoCode;

    public static /* synthetic */ CountryInfo copy$default(CountryInfo countryInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countryInfo.isoCode;
        }
        if ((i & 2) != 0) {
            str2 = countryInfo.callingCode;
        }
        if ((i & 4) != 0) {
            str3 = countryInfo.emoji;
        }
        return countryInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.isoCode;
    }

    public final String component2() {
        return this.callingCode;
    }

    public final String component3() {
        return this.emoji;
    }

    public final CountryInfo copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "isoCode");
        Intrinsics.checkNotNullParameter(str2, "callingCode");
        Intrinsics.checkNotNullParameter(str3, "emoji");
        return new CountryInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountryInfo)) {
            return false;
        }
        CountryInfo countryInfo = (CountryInfo) obj;
        return Intrinsics.areEqual(this.isoCode, countryInfo.isoCode) && Intrinsics.areEqual(this.callingCode, countryInfo.callingCode) && Intrinsics.areEqual(this.emoji, countryInfo.emoji);
    }

    public int hashCode() {
        return (((this.isoCode.hashCode() * 31) + this.callingCode.hashCode()) * 31) + this.emoji.hashCode();
    }

    public String toString() {
        return "CountryInfo(isoCode=" + this.isoCode + ", callingCode=" + this.callingCode + ", emoji=" + this.emoji + ')';
    }

    public CountryInfo(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "isoCode");
        Intrinsics.checkNotNullParameter(str2, "callingCode");
        Intrinsics.checkNotNullParameter(str3, "emoji");
        this.isoCode = str;
        this.callingCode = str2;
        this.emoji = str3;
    }

    public final String getIsoCode() {
        return this.isoCode;
    }

    public final String getCallingCode() {
        return this.callingCode;
    }

    public final String getEmoji() {
        return this.emoji;
    }
}
