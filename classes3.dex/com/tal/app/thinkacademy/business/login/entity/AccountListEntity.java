package com.tal.app.thinkacademy.business.login.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J'\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/AccountListEntity;", "", "associatedAccount", "", "Lcom/tal/app/thinkacademy/business/login/entity/UserAccount;", "currentAccount", "(Ljava/util/List;Lcom/tal/app/thinkacademy/business/login/entity/UserAccount;)V", "getAssociatedAccount", "()Ljava/util/List;", "getCurrentAccount", "()Lcom/tal/app/thinkacademy/business/login/entity/UserAccount;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountListEntity.kt */
public final class AccountListEntity {
    private final List<UserAccount> associatedAccount;
    private final UserAccount currentAccount;

    public static /* synthetic */ AccountListEntity copy$default(AccountListEntity accountListEntity, List<UserAccount> list, UserAccount userAccount, int i, Object obj) {
        if ((i & 1) != 0) {
            list = accountListEntity.associatedAccount;
        }
        if ((i & 2) != 0) {
            userAccount = accountListEntity.currentAccount;
        }
        return accountListEntity.copy(list, userAccount);
    }

    public final List<UserAccount> component1() {
        return this.associatedAccount;
    }

    public final UserAccount component2() {
        return this.currentAccount;
    }

    public final AccountListEntity copy(List<UserAccount> list, UserAccount userAccount) {
        return new AccountListEntity(list, userAccount);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountListEntity)) {
            return false;
        }
        AccountListEntity accountListEntity = (AccountListEntity) obj;
        return Intrinsics.areEqual((Object) this.associatedAccount, (Object) accountListEntity.associatedAccount) && Intrinsics.areEqual((Object) this.currentAccount, (Object) accountListEntity.currentAccount);
    }

    public int hashCode() {
        List<UserAccount> list = this.associatedAccount;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        UserAccount userAccount = this.currentAccount;
        if (userAccount != null) {
            i = userAccount.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AccountListEntity(associatedAccount=" + this.associatedAccount + ", currentAccount=" + this.currentAccount + ')';
    }

    public AccountListEntity(List<UserAccount> list, UserAccount userAccount) {
        this.associatedAccount = list;
        this.currentAccount = userAccount;
    }

    public final List<UserAccount> getAssociatedAccount() {
        return this.associatedAccount;
    }

    public final UserAccount getCurrentAccount() {
        return this.currentAccount;
    }
}
