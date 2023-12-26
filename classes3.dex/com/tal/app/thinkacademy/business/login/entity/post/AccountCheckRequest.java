package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheckRequest;", "", "header", "Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheckHeader;", "data", "Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheck;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheckHeader;Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheck;)V", "getData", "()Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheck;", "getHeader", "()Lcom/tal/app/thinkacademy/business/login/entity/post/AccountCheckHeader;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountCheckRequest.kt */
public final class AccountCheckRequest {
    private final AccountCheck data;
    private final AccountCheckHeader header;

    public AccountCheckRequest() {
        this((AccountCheckHeader) null, (AccountCheck) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AccountCheckRequest copy$default(AccountCheckRequest accountCheckRequest, AccountCheckHeader accountCheckHeader, AccountCheck accountCheck, int i, Object obj) {
        if ((i & 1) != 0) {
            accountCheckHeader = accountCheckRequest.header;
        }
        if ((i & 2) != 0) {
            accountCheck = accountCheckRequest.data;
        }
        return accountCheckRequest.copy(accountCheckHeader, accountCheck);
    }

    public final AccountCheckHeader component1() {
        return this.header;
    }

    public final AccountCheck component2() {
        return this.data;
    }

    public final AccountCheckRequest copy(AccountCheckHeader accountCheckHeader, AccountCheck accountCheck) {
        return new AccountCheckRequest(accountCheckHeader, accountCheck);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountCheckRequest)) {
            return false;
        }
        AccountCheckRequest accountCheckRequest = (AccountCheckRequest) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) accountCheckRequest.header) && Intrinsics.areEqual((Object) this.data, (Object) accountCheckRequest.data);
    }

    public int hashCode() {
        AccountCheckHeader accountCheckHeader = this.header;
        int i = 0;
        int hashCode = (accountCheckHeader == null ? 0 : accountCheckHeader.hashCode()) * 31;
        AccountCheck accountCheck = this.data;
        if (accountCheck != null) {
            i = accountCheck.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AccountCheckRequest(header=" + this.header + ", data=" + this.data + ')';
    }

    public AccountCheckRequest(AccountCheckHeader accountCheckHeader, AccountCheck accountCheck) {
        this.header = accountCheckHeader;
        this.data = accountCheck;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountCheckRequest(AccountCheckHeader accountCheckHeader, AccountCheck accountCheck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AccountCheckHeader((String) null, 1, (DefaultConstructorMarker) null) : accountCheckHeader, (i & 2) != 0 ? new AccountCheck(0, 1, (DefaultConstructorMarker) null) : accountCheck);
    }

    public final AccountCheckHeader getHeader() {
        return this.header;
    }

    public final AccountCheck getData() {
        return this.data;
    }
}
