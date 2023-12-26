package com.tal.app.thinkacademy.business.login.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/Helper;", "", "status", "", "statusDesc", "", "extra", "Lcom/tal/app/thinkacademy/business/login/entity/Extra;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/login/entity/Extra;)V", "getExtra", "()Lcom/tal/app/thinkacademy/business/login/entity/Extra;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusDesc", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/login/entity/Extra;)Lcom/tal/app/thinkacademy/business/login/entity/Helper;", "equals", "", "other", "hashCode", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountCheckData.kt */
public final class Helper {
    private final Extra extra;
    private final Integer status;
    private final String statusDesc;

    public static /* synthetic */ Helper copy$default(Helper helper, Integer num, String str, Extra extra2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = helper.status;
        }
        if ((i & 2) != 0) {
            str = helper.statusDesc;
        }
        if ((i & 4) != 0) {
            extra2 = helper.extra;
        }
        return helper.copy(num, str, extra2);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.statusDesc;
    }

    public final Extra component3() {
        return this.extra;
    }

    public final Helper copy(Integer num, String str, Extra extra2) {
        return new Helper(num, str, extra2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Helper)) {
            return false;
        }
        Helper helper = (Helper) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) helper.status) && Intrinsics.areEqual((Object) this.statusDesc, (Object) helper.statusDesc) && Intrinsics.areEqual((Object) this.extra, (Object) helper.extra);
    }

    public int hashCode() {
        Integer num = this.status;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.statusDesc;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Extra extra2 = this.extra;
        if (extra2 != null) {
            i = extra2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Helper(status=" + this.status + ", statusDesc=" + this.statusDesc + ", extra=" + this.extra + ')';
    }

    public Helper(Integer num, String str, Extra extra2) {
        this.status = num;
        this.statusDesc = str;
        this.extra = extra2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Helper(Integer num, String str, Extra extra2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? "" : str, extra2);
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final Extra getExtra() {
        return this.extra;
    }
}
