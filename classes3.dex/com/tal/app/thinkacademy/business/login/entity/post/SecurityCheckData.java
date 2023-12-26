package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheckData;", "", "contactInfo", "", "countryCallingCode", "scene", "", "verificationCode", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getContactInfo", "()Ljava/lang/String;", "getCountryCallingCode", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "getVerificationCode", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/login/entity/post/SecurityCheckData;", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecurityCheck.kt */
public final class SecurityCheckData {
    private final String contactInfo;
    private final String countryCallingCode;
    private final Integer scene;
    private final Integer type;
    private final String verificationCode;

    public static /* synthetic */ SecurityCheckData copy$default(SecurityCheckData securityCheckData, String str, String str2, Integer num, String str3, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = securityCheckData.contactInfo;
        }
        if ((i & 2) != 0) {
            str2 = securityCheckData.countryCallingCode;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            num = securityCheckData.scene;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            str3 = securityCheckData.verificationCode;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            num2 = securityCheckData.type;
        }
        return securityCheckData.copy(str, str4, num3, str5, num2);
    }

    public final String component1() {
        return this.contactInfo;
    }

    public final String component2() {
        return this.countryCallingCode;
    }

    public final Integer component3() {
        return this.scene;
    }

    public final String component4() {
        return this.verificationCode;
    }

    public final Integer component5() {
        return this.type;
    }

    public final SecurityCheckData copy(String str, String str2, Integer num, String str3, Integer num2) {
        return new SecurityCheckData(str, str2, num, str3, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SecurityCheckData)) {
            return false;
        }
        SecurityCheckData securityCheckData = (SecurityCheckData) obj;
        return Intrinsics.areEqual((Object) this.contactInfo, (Object) securityCheckData.contactInfo) && Intrinsics.areEqual((Object) this.countryCallingCode, (Object) securityCheckData.countryCallingCode) && Intrinsics.areEqual((Object) this.scene, (Object) securityCheckData.scene) && Intrinsics.areEqual((Object) this.verificationCode, (Object) securityCheckData.verificationCode) && Intrinsics.areEqual((Object) this.type, (Object) securityCheckData.type);
    }

    public int hashCode() {
        String str = this.contactInfo;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.countryCallingCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.scene;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.verificationCode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.type;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "SecurityCheckData(contactInfo=" + this.contactInfo + ", countryCallingCode=" + this.countryCallingCode + ", scene=" + this.scene + ", verificationCode=" + this.verificationCode + ", type=" + this.type + ')';
    }

    public SecurityCheckData(String str, String str2, Integer num, String str3, Integer num2) {
        this.contactInfo = str;
        this.countryCallingCode = str2;
        this.scene = num;
        this.verificationCode = str3;
        this.type = num2;
    }

    public final String getContactInfo() {
        return this.contactInfo;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SecurityCheckData(String str, String str2, Integer num, String str3, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 14 : num, str3, (i & 16) != 0 ? 1 : num2);
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final String getVerificationCode() {
        return this.verificationCode;
    }

    public final Integer getType() {
        return this.type;
    }
}
