package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/LinkedAccount;", "", "name", "", "type", "", "value", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "()I", "getValue", "setValue", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UseGetInfo.kt */
public final class LinkedAccount {
    private final String name;
    private final int type;
    private String value;

    public LinkedAccount() {
        this((String) null, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LinkedAccount copy$default(LinkedAccount linkedAccount, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = linkedAccount.name;
        }
        if ((i2 & 2) != 0) {
            i = linkedAccount.type;
        }
        if ((i2 & 4) != 0) {
            str2 = linkedAccount.value;
        }
        return linkedAccount.copy(str, i, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.value;
    }

    public final LinkedAccount copy(String str, int i, String str2) {
        return new LinkedAccount(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkedAccount)) {
            return false;
        }
        LinkedAccount linkedAccount = (LinkedAccount) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) linkedAccount.name) && this.type == linkedAccount.type && Intrinsics.areEqual((Object) this.value, (Object) linkedAccount.value);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.type) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LinkedAccount(name=" + this.name + ", type=" + this.type + ", value=" + this.value + ')';
    }

    public LinkedAccount(String str, int i, String str2) {
        this.name = str;
        this.type = i;
        this.value = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinkedAccount(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
