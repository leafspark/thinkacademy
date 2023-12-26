package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/RecordedTeacherItem;", "", "sysName", "", "avatar", "teacherType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAvatar", "()Ljava/lang/String;", "getSysName", "getTeacherType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/shop/bean/RecordedTeacherItem;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopRecordedItemData.kt */
public final class RecordedTeacherItem {
    private final String avatar;
    private final String sysName;
    private final Integer teacherType;

    public RecordedTeacherItem() {
        this((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordedTeacherItem copy$default(RecordedTeacherItem recordedTeacherItem, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordedTeacherItem.sysName;
        }
        if ((i & 2) != 0) {
            str2 = recordedTeacherItem.avatar;
        }
        if ((i & 4) != 0) {
            num = recordedTeacherItem.teacherType;
        }
        return recordedTeacherItem.copy(str, str2, num);
    }

    public final String component1() {
        return this.sysName;
    }

    public final String component2() {
        return this.avatar;
    }

    public final Integer component3() {
        return this.teacherType;
    }

    public final RecordedTeacherItem copy(String str, String str2, Integer num) {
        return new RecordedTeacherItem(str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedTeacherItem)) {
            return false;
        }
        RecordedTeacherItem recordedTeacherItem = (RecordedTeacherItem) obj;
        return Intrinsics.areEqual((Object) this.sysName, (Object) recordedTeacherItem.sysName) && Intrinsics.areEqual((Object) this.avatar, (Object) recordedTeacherItem.avatar) && Intrinsics.areEqual((Object) this.teacherType, (Object) recordedTeacherItem.teacherType);
    }

    public int hashCode() {
        String str = this.sysName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.avatar;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.teacherType;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RecordedTeacherItem(sysName=" + this.sysName + ", avatar=" + this.avatar + ", teacherType=" + this.teacherType + ')';
    }

    public RecordedTeacherItem(String str, String str2, Integer num) {
        this.sysName = str;
        this.avatar = str2;
        this.teacherType = num;
    }

    public final String getSysName() {
        return this.sysName;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordedTeacherItem(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 1 : num);
    }

    public final Integer getTeacherType() {
        return this.teacherType;
    }
}
