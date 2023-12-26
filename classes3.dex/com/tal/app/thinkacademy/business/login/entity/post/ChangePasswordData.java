package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePasswordData;", "", "password", "", "accountName", "verificationCode", "countryCallingCode", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAccountName", "()Ljava/lang/String;", "getCountryCallingCode", "getPassword", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVerificationCode", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/login/entity/post/ChangePasswordData;", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChangePassword.kt */
public final class ChangePasswordData {
    private final String accountName;
    private final String countryCallingCode;
    private final String password;
    private final Integer type;
    private final String verificationCode;

    public static /* synthetic */ ChangePasswordData copy$default(ChangePasswordData changePasswordData, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changePasswordData.password;
        }
        if ((i & 2) != 0) {
            str2 = changePasswordData.accountName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = changePasswordData.verificationCode;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = changePasswordData.countryCallingCode;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            num = changePasswordData.type;
        }
        return changePasswordData.copy(str, str5, str6, str7, num);
    }

    public final String component1() {
        return this.password;
    }

    public final String component2() {
        return this.accountName;
    }

    public final String component3() {
        return this.verificationCode;
    }

    public final String component4() {
        return this.countryCallingCode;
    }

    public final Integer component5() {
        return this.type;
    }

    public final ChangePasswordData copy(String str, String str2, String str3, String str4, Integer num) {
        return new ChangePasswordData(str, str2, str3, str4, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangePasswordData)) {
            return false;
        }
        ChangePasswordData changePasswordData = (ChangePasswordData) obj;
        return Intrinsics.areEqual((Object) this.password, (Object) changePasswordData.password) && Intrinsics.areEqual((Object) this.accountName, (Object) changePasswordData.accountName) && Intrinsics.areEqual((Object) this.verificationCode, (Object) changePasswordData.verificationCode) && Intrinsics.areEqual((Object) this.countryCallingCode, (Object) changePasswordData.countryCallingCode) && Intrinsics.areEqual((Object) this.type, (Object) changePasswordData.type);
    }

    public int hashCode() {
        String str = this.password;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.accountName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.verificationCode;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.countryCallingCode;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.type;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ChangePasswordData(password=" + this.password + ", accountName=" + this.accountName + ", verificationCode=" + this.verificationCode + ", countryCallingCode=" + this.countryCallingCode + ", type=" + this.type + ')';
    }

    public ChangePasswordData(String str, String str2, String str3, String str4, Integer num) {
        this.password = str;
        this.accountName = str2;
        this.verificationCode = str3;
        this.countryCallingCode = str4;
        this.type = num;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getAccountName() {
        return this.accountName;
    }

    public final String getVerificationCode() {
        return this.verificationCode;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChangePasswordData(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? 1 : num);
    }

    public final Integer getType() {
        return this.type;
    }
}
