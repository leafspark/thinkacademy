package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011JF\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSyllabu;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "isStarted", "", "name", "", "timeDesc", "local_position_num", "local_position_type", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "()I", "itemType", "getItemType", "getLocal_position_num", "setLocal_position_num", "(I)V", "getLocal_position_type", "()Ljava/lang/Integer;", "setLocal_position_type", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getTimeDesc", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSyllabu;", "equals", "", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailSyllabu implements MultiItemEntity {
    private final int isStarted;
    private int local_position_num;
    private Integer local_position_type;
    private final String name;
    private final String timeDesc;

    public ShopClassDetailSyllabu() {
        this(0, (String) null, (String) null, 0, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailSyllabu copy$default(ShopClassDetailSyllabu shopClassDetailSyllabu, int i, String str, String str2, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = shopClassDetailSyllabu.isStarted;
        }
        if ((i3 & 2) != 0) {
            str = shopClassDetailSyllabu.name;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = shopClassDetailSyllabu.timeDesc;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i2 = shopClassDetailSyllabu.local_position_num;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            num = shopClassDetailSyllabu.local_position_type;
        }
        return shopClassDetailSyllabu.copy(i, str3, str4, i4, num);
    }

    public final int component1() {
        return this.isStarted;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.timeDesc;
    }

    public final int component4() {
        return this.local_position_num;
    }

    public final Integer component5() {
        return this.local_position_type;
    }

    public final ShopClassDetailSyllabu copy(int i, String str, String str2, int i2, Integer num) {
        return new ShopClassDetailSyllabu(i, str, str2, i2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailSyllabu)) {
            return false;
        }
        ShopClassDetailSyllabu shopClassDetailSyllabu = (ShopClassDetailSyllabu) obj;
        return this.isStarted == shopClassDetailSyllabu.isStarted && Intrinsics.areEqual((Object) this.name, (Object) shopClassDetailSyllabu.name) && Intrinsics.areEqual((Object) this.timeDesc, (Object) shopClassDetailSyllabu.timeDesc) && this.local_position_num == shopClassDetailSyllabu.local_position_num && Intrinsics.areEqual((Object) this.local_position_type, (Object) shopClassDetailSyllabu.local_position_type);
    }

    public int hashCode() {
        int i = this.isStarted * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.timeDesc;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.local_position_num) * 31;
        Integer num = this.local_position_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "ShopClassDetailSyllabu(isStarted=" + this.isStarted + ", name=" + this.name + ", timeDesc=" + this.timeDesc + ", local_position_num=" + this.local_position_num + ", local_position_type=" + this.local_position_type + ')';
    }

    public ShopClassDetailSyllabu(int i, String str, String str2, int i2, Integer num) {
        this.isStarted = i;
        this.name = str;
        this.timeDesc = str2;
        this.local_position_num = i2;
        this.local_position_type = num;
    }

    public final int isStarted() {
        return this.isStarted;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTimeDesc() {
        return this.timeDesc;
    }

    public final int getLocal_position_num() {
        return this.local_position_num;
    }

    public final void setLocal_position_num(int i) {
        this.local_position_num = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopClassDetailSyllabu(int r4, java.lang.String r5, java.lang.String r6, int r7, java.lang.Integer r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0005
            r4 = 0
        L_0x0005:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto L_0x000c
            r10 = r0
            goto L_0x000d
        L_0x000c:
            r10 = r5
        L_0x000d:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r0 = r6
        L_0x0013:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0018
            r7 = 1
        L_0x0018:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0027
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Normal
            int r5 = r5.getType()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
        L_0x0027:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu.<init>(int, java.lang.String, java.lang.String, int, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getLocal_position_type() {
        return this.local_position_type;
    }

    public final void setLocal_position_type(Integer num) {
        this.local_position_type = num;
    }

    public int getItemType() {
        return ShopClassDetailItemType.ScheduleInfo.getType();
    }
}
