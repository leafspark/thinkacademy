package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0007\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/UserAccount;", "", "avatar", "", "card", "nickName", "uid", "isSeleted", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAvatar", "()Ljava/lang/String;", "getCard", "()Ljava/lang/Boolean;", "setSeleted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNickName", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/business/login/entity/UserAccount;", "equals", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountListEntity.kt */
public final class UserAccount {
    private final String avatar;
    private final String card;
    private Boolean isSeleted;
    private final String nickName;
    private final String uid;

    public static /* synthetic */ UserAccount copy$default(UserAccount userAccount, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAccount.avatar;
        }
        if ((i & 2) != 0) {
            str2 = userAccount.card;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = userAccount.nickName;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = userAccount.uid;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            bool = userAccount.isSeleted;
        }
        return userAccount.copy(str, str5, str6, str7, bool);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.card;
    }

    public final String component3() {
        return this.nickName;
    }

    public final String component4() {
        return this.uid;
    }

    public final Boolean component5() {
        return this.isSeleted;
    }

    public final UserAccount copy(String str, String str2, String str3, String str4, Boolean bool) {
        return new UserAccount(str, str2, str3, str4, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAccount)) {
            return false;
        }
        UserAccount userAccount = (UserAccount) obj;
        return Intrinsics.areEqual((Object) this.avatar, (Object) userAccount.avatar) && Intrinsics.areEqual((Object) this.card, (Object) userAccount.card) && Intrinsics.areEqual((Object) this.nickName, (Object) userAccount.nickName) && Intrinsics.areEqual((Object) this.uid, (Object) userAccount.uid) && Intrinsics.areEqual((Object) this.isSeleted, (Object) userAccount.isSeleted);
    }

    public int hashCode() {
        String str = this.avatar;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.card;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nickName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.uid;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.isSeleted;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "UserAccount(avatar=" + this.avatar + ", card=" + this.card + ", nickName=" + this.nickName + ", uid=" + this.uid + ", isSeleted=" + this.isSeleted + ')';
    }

    public UserAccount(String str, String str2, String str3, String str4, Boolean bool) {
        this.avatar = str;
        this.card = str2;
        this.nickName = str3;
        this.uid = str4;
        this.isSeleted = bool;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getCard() {
        return this.card;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getUid() {
        return this.uid;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserAccount(String str, String str2, String str3, String str4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? false : bool);
    }

    public final Boolean isSeleted() {
        return this.isSeleted;
    }

    public final void setSeleted(Boolean bool) {
        this.isSeleted = bool;
    }
}
