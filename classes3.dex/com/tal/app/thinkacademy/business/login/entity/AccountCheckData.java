package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/AccountCheckData;", "", "continue", "", "helper", "Lcom/tal/app/thinkacademy/business/login/entity/Helper;", "(Ljava/lang/Boolean;Lcom/tal/app/thinkacademy/business/login/entity/Helper;)V", "getContinue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHelper", "()Lcom/tal/app/thinkacademy/business/login/entity/Helper;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Lcom/tal/app/thinkacademy/business/login/entity/Helper;)Lcom/tal/app/thinkacademy/business/login/entity/AccountCheckData;", "equals", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountCheckData.kt */
public final class AccountCheckData {

    /* renamed from: continue  reason: not valid java name */
    private final Boolean f2continue;
    private final Helper helper;

    public static /* synthetic */ AccountCheckData copy$default(AccountCheckData accountCheckData, Boolean bool, Helper helper2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = accountCheckData.f2continue;
        }
        if ((i & 2) != 0) {
            helper2 = accountCheckData.helper;
        }
        return accountCheckData.copy(bool, helper2);
    }

    public final Boolean component1() {
        return this.f2continue;
    }

    public final Helper component2() {
        return this.helper;
    }

    public final AccountCheckData copy(Boolean bool, Helper helper2) {
        return new AccountCheckData(bool, helper2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountCheckData)) {
            return false;
        }
        AccountCheckData accountCheckData = (AccountCheckData) obj;
        return Intrinsics.areEqual((Object) this.f2continue, (Object) accountCheckData.f2continue) && Intrinsics.areEqual((Object) this.helper, (Object) accountCheckData.helper);
    }

    public int hashCode() {
        Boolean bool = this.f2continue;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Helper helper2 = this.helper;
        if (helper2 != null) {
            i = helper2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AccountCheckData(continue=" + this.f2continue + ", helper=" + this.helper + ')';
    }

    public AccountCheckData(Boolean bool, Helper helper2) {
        this.f2continue = bool;
        this.helper = helper2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountCheckData(Boolean bool, Helper helper2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, helper2);
    }

    public final Boolean getContinue() {
        return this.f2continue;
    }

    public final Helper getHelper() {
        return this.helper;
    }
}
