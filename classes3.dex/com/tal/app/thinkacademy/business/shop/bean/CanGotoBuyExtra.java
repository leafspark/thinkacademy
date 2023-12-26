package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/CanGotoBuyExtra;", "", "examId", "", "leftChance", "phone", "", "(IILjava/lang/String;)V", "getExamId", "()I", "getLeftChance", "getPhone", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckCanGotoBuyBean.kt */
public final class CanGotoBuyExtra {
    private final int examId;
    private final int leftChance;
    private final String phone;

    public CanGotoBuyExtra() {
        this(0, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CanGotoBuyExtra copy$default(CanGotoBuyExtra canGotoBuyExtra, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = canGotoBuyExtra.examId;
        }
        if ((i3 & 2) != 0) {
            i2 = canGotoBuyExtra.leftChance;
        }
        if ((i3 & 4) != 0) {
            str = canGotoBuyExtra.phone;
        }
        return canGotoBuyExtra.copy(i, i2, str);
    }

    public final int component1() {
        return this.examId;
    }

    public final int component2() {
        return this.leftChance;
    }

    public final String component3() {
        return this.phone;
    }

    public final CanGotoBuyExtra copy(int i, int i2, String str) {
        return new CanGotoBuyExtra(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CanGotoBuyExtra)) {
            return false;
        }
        CanGotoBuyExtra canGotoBuyExtra = (CanGotoBuyExtra) obj;
        return this.examId == canGotoBuyExtra.examId && this.leftChance == canGotoBuyExtra.leftChance && Intrinsics.areEqual((Object) this.phone, (Object) canGotoBuyExtra.phone);
    }

    public int hashCode() {
        int i = ((this.examId * 31) + this.leftChance) * 31;
        String str = this.phone;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CanGotoBuyExtra(examId=" + this.examId + ", leftChance=" + this.leftChance + ", phone=" + this.phone + ')';
    }

    public CanGotoBuyExtra(int i, int i2, String str) {
        this.examId = i;
        this.leftChance = i2;
        this.phone = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CanGotoBuyExtra(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? -1 : i2, (i3 & 4) != 0 ? null : str);
    }

    public final int getExamId() {
        return this.examId;
    }

    public final int getLeftChance() {
        return this.leftChance;
    }

    public final String getPhone() {
        return this.phone;
    }
}
