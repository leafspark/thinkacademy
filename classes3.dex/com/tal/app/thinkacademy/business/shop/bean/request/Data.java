package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/Data;", "", "teacherId", "", "teachingType", "", "(ILjava/lang/String;)V", "getTeacherId", "()I", "setTeacherId", "(I)V", "getTeachingType", "()Ljava/lang/String;", "setTeachingType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDeatilsRequest.kt */
public final class Data {
    private int teacherId;
    private String teachingType;

    public static /* synthetic */ Data copy$default(Data data, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = data.teacherId;
        }
        if ((i2 & 2) != 0) {
            str = data.teachingType;
        }
        return data.copy(i, str);
    }

    public final int component1() {
        return this.teacherId;
    }

    public final String component2() {
        return this.teachingType;
    }

    public final Data copy(int i, String str) {
        return new Data(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return this.teacherId == data.teacherId && Intrinsics.areEqual((Object) this.teachingType, (Object) data.teachingType);
    }

    public int hashCode() {
        int i = this.teacherId * 31;
        String str = this.teachingType;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Data(teacherId=" + this.teacherId + ", teachingType=" + this.teachingType + ')';
    }

    public Data(int i, String str) {
        this.teacherId = i;
        this.teachingType = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Data(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "0" : str);
    }

    public final int getTeacherId() {
        return this.teacherId;
    }

    public final void setTeacherId(int i) {
        this.teacherId = i;
    }

    public final String getTeachingType() {
        return this.teachingType;
    }

    public final void setTeachingType(String str) {
        this.teachingType = str;
    }
}
