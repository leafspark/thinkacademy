package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/CanGotoBuyHelper;", "", "old", "", "status", "", "statusDesc", "", "extra", "Lcom/tal/app/thinkacademy/business/shop/bean/CanGotoBuyExtra;", "(ZILjava/lang/String;Lcom/tal/app/thinkacademy/business/shop/bean/CanGotoBuyExtra;)V", "getExtra", "()Lcom/tal/app/thinkacademy/business/shop/bean/CanGotoBuyExtra;", "getOld", "()Z", "getStatus", "()I", "getStatusDesc", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckCanGotoBuyBean.kt */
public final class CanGotoBuyHelper {
    private final CanGotoBuyExtra extra;
    private final boolean old;
    private final int status;
    private final String statusDesc;

    public CanGotoBuyHelper() {
        this(false, 0, (String) null, (CanGotoBuyExtra) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CanGotoBuyHelper copy$default(CanGotoBuyHelper canGotoBuyHelper, boolean z, int i, String str, CanGotoBuyExtra canGotoBuyExtra, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = canGotoBuyHelper.old;
        }
        if ((i2 & 2) != 0) {
            i = canGotoBuyHelper.status;
        }
        if ((i2 & 4) != 0) {
            str = canGotoBuyHelper.statusDesc;
        }
        if ((i2 & 8) != 0) {
            canGotoBuyExtra = canGotoBuyHelper.extra;
        }
        return canGotoBuyHelper.copy(z, i, str, canGotoBuyExtra);
    }

    public final boolean component1() {
        return this.old;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.statusDesc;
    }

    public final CanGotoBuyExtra component4() {
        return this.extra;
    }

    public final CanGotoBuyHelper copy(boolean z, int i, String str, CanGotoBuyExtra canGotoBuyExtra) {
        return new CanGotoBuyHelper(z, i, str, canGotoBuyExtra);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CanGotoBuyHelper)) {
            return false;
        }
        CanGotoBuyHelper canGotoBuyHelper = (CanGotoBuyHelper) obj;
        return this.old == canGotoBuyHelper.old && this.status == canGotoBuyHelper.status && Intrinsics.areEqual((Object) this.statusDesc, (Object) canGotoBuyHelper.statusDesc) && Intrinsics.areEqual((Object) this.extra, (Object) canGotoBuyHelper.extra);
    }

    public int hashCode() {
        boolean z = this.old;
        if (z) {
            z = true;
        }
        int i = (((z ? 1 : 0) * true) + this.status) * 31;
        String str = this.statusDesc;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        CanGotoBuyExtra canGotoBuyExtra = this.extra;
        if (canGotoBuyExtra != null) {
            i2 = canGotoBuyExtra.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "CanGotoBuyHelper(old=" + this.old + ", status=" + this.status + ", statusDesc=" + this.statusDesc + ", extra=" + this.extra + ')';
    }

    public CanGotoBuyHelper(boolean z, int i, String str, CanGotoBuyExtra canGotoBuyExtra) {
        this.old = z;
        this.status = i;
        this.statusDesc = str;
        this.extra = canGotoBuyExtra;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CanGotoBuyHelper(boolean z, int i, String str, CanGotoBuyExtra canGotoBuyExtra, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : canGotoBuyExtra);
    }

    public final boolean getOld() {
        return this.old;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final CanGotoBuyExtra getExtra() {
        return this.extra;
    }
}
