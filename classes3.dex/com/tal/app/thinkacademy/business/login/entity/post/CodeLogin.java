package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/CodeLogin;", "", "countryCallingCode", "", "verificationCode", "accountName", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAccountName", "()Ljava/lang/String;", "getCountryCallingCode", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVerificationCode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/login/entity/post/CodeLogin;", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CodeLogin.kt */
public final class CodeLogin {
    private final String accountName;
    private final String countryCallingCode;
    private final Integer type;
    private final String verificationCode;

    public static /* synthetic */ CodeLogin copy$default(CodeLogin codeLogin, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = codeLogin.countryCallingCode;
        }
        if ((i & 2) != 0) {
            str2 = codeLogin.verificationCode;
        }
        if ((i & 4) != 0) {
            str3 = codeLogin.accountName;
        }
        if ((i & 8) != 0) {
            num = codeLogin.type;
        }
        return codeLogin.copy(str, str2, str3, num);
    }

    public final String component1() {
        return this.countryCallingCode;
    }

    public final String component2() {
        return this.verificationCode;
    }

    public final String component3() {
        return this.accountName;
    }

    public final Integer component4() {
        return this.type;
    }

    public final CodeLogin copy(String str, String str2, String str3, Integer num) {
        return new CodeLogin(str, str2, str3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeLogin)) {
            return false;
        }
        CodeLogin codeLogin = (CodeLogin) obj;
        return Intrinsics.areEqual((Object) this.countryCallingCode, (Object) codeLogin.countryCallingCode) && Intrinsics.areEqual((Object) this.verificationCode, (Object) codeLogin.verificationCode) && Intrinsics.areEqual((Object) this.accountName, (Object) codeLogin.accountName) && Intrinsics.areEqual((Object) this.type, (Object) codeLogin.type);
    }

    public int hashCode() {
        String str = this.countryCallingCode;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.verificationCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.accountName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.type;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "CodeLogin(countryCallingCode=" + this.countryCallingCode + ", verificationCode=" + this.verificationCode + ", accountName=" + this.accountName + ", type=" + this.type + ')';
    }

    public CodeLogin(String str, String str2, String str3, Integer num) {
        this.countryCallingCode = str;
        this.verificationCode = str2;
        this.accountName = str3;
        this.type = num;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }

    public final String getVerificationCode() {
        return this.verificationCode;
    }

    public final String getAccountName() {
        return this.accountName;
    }

    public final Integer getType() {
        return this.type;
    }
}
