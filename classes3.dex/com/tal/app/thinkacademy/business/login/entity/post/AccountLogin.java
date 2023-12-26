package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/AccountLogin;", "", "accountName", "", "password", "type", "", "countryCallingCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAccountName", "()Ljava/lang/String;", "getCountryCallingCode", "getPassword", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/login/entity/post/AccountLogin;", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountLogin.kt */
public final class AccountLogin {
    private final String accountName;
    private final String countryCallingCode;
    private final String password;
    private final Integer type;

    public static /* synthetic */ AccountLogin copy$default(AccountLogin accountLogin, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountLogin.accountName;
        }
        if ((i & 2) != 0) {
            str2 = accountLogin.password;
        }
        if ((i & 4) != 0) {
            num = accountLogin.type;
        }
        if ((i & 8) != 0) {
            str3 = accountLogin.countryCallingCode;
        }
        return accountLogin.copy(str, str2, num, str3);
    }

    public final String component1() {
        return this.accountName;
    }

    public final String component2() {
        return this.password;
    }

    public final Integer component3() {
        return this.type;
    }

    public final String component4() {
        return this.countryCallingCode;
    }

    public final AccountLogin copy(String str, String str2, Integer num, String str3) {
        return new AccountLogin(str, str2, num, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountLogin)) {
            return false;
        }
        AccountLogin accountLogin = (AccountLogin) obj;
        return Intrinsics.areEqual((Object) this.accountName, (Object) accountLogin.accountName) && Intrinsics.areEqual((Object) this.password, (Object) accountLogin.password) && Intrinsics.areEqual((Object) this.type, (Object) accountLogin.type) && Intrinsics.areEqual((Object) this.countryCallingCode, (Object) accountLogin.countryCallingCode);
    }

    public int hashCode() {
        String str = this.accountName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.password;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.countryCallingCode;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "AccountLogin(accountName=" + this.accountName + ", password=" + this.password + ", type=" + this.type + ", countryCallingCode=" + this.countryCallingCode + ')';
    }

    public AccountLogin(String str, String str2, Integer num, String str3) {
        this.accountName = str;
        this.password = str2;
        this.type = num;
        this.countryCallingCode = str3;
    }

    public final String getAccountName() {
        return this.accountName;
    }

    public final String getPassword() {
        return this.password;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getCountryCallingCode() {
        return this.countryCallingCode;
    }
}
