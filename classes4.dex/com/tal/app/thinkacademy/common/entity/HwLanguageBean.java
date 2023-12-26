package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/HwLanguageBean;", "", "name", "", "language", "country", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getLanguage", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwLanguageBean.kt */
public final class HwLanguageBean {
    private final String country;
    private final String language;
    private final String name;

    public static /* synthetic */ HwLanguageBean copy$default(HwLanguageBean hwLanguageBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hwLanguageBean.name;
        }
        if ((i & 2) != 0) {
            str2 = hwLanguageBean.language;
        }
        if ((i & 4) != 0) {
            str3 = hwLanguageBean.country;
        }
        return hwLanguageBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.language;
    }

    public final String component3() {
        return this.country;
    }

    public final HwLanguageBean copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "language");
        Intrinsics.checkNotNullParameter(str3, "country");
        return new HwLanguageBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HwLanguageBean)) {
            return false;
        }
        HwLanguageBean hwLanguageBean = (HwLanguageBean) obj;
        return Intrinsics.areEqual(this.name, hwLanguageBean.name) && Intrinsics.areEqual(this.language, hwLanguageBean.language) && Intrinsics.areEqual(this.country, hwLanguageBean.country);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.language.hashCode()) * 31) + this.country.hashCode();
    }

    public String toString() {
        return "HwLanguageBean(name=" + this.name + ", language=" + this.language + ", country=" + this.country + ')';
    }

    public HwLanguageBean(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "language");
        Intrinsics.checkNotNullParameter(str3, "country");
        this.name = str;
        this.language = str2;
        this.country = str3;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getName() {
        return this.name;
    }
}
