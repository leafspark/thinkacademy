package com.tal.app.thinkacademy.business.shop.bean.request;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/TeacherDeatilsRequest;", "", "header", "Lcom/tal/app/thinkacademy/business/shop/bean/request/Header;", "data", "Lcom/tal/app/thinkacademy/business/shop/bean/request/Data;", "(Lcom/tal/app/thinkacademy/business/shop/bean/request/Header;Lcom/tal/app/thinkacademy/business/shop/bean/request/Data;)V", "getData", "()Lcom/tal/app/thinkacademy/business/shop/bean/request/Data;", "setData", "(Lcom/tal/app/thinkacademy/business/shop/bean/request/Data;)V", "getHeader", "()Lcom/tal/app/thinkacademy/business/shop/bean/request/Header;", "setHeader", "(Lcom/tal/app/thinkacademy/business/shop/bean/request/Header;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDeatilsRequest.kt */
public final class TeacherDeatilsRequest {
    private Data data;
    private Header header;

    public static /* synthetic */ TeacherDeatilsRequest copy$default(TeacherDeatilsRequest teacherDeatilsRequest, Header header2, Data data2, int i, Object obj) {
        if ((i & 1) != 0) {
            header2 = teacherDeatilsRequest.header;
        }
        if ((i & 2) != 0) {
            data2 = teacherDeatilsRequest.data;
        }
        return teacherDeatilsRequest.copy(header2, data2);
    }

    public final Header component1() {
        return this.header;
    }

    public final Data component2() {
        return this.data;
    }

    public final TeacherDeatilsRequest copy(Header header2, Data data2) {
        Intrinsics.checkNotNullParameter(header2, "header");
        Intrinsics.checkNotNullParameter(data2, DbParams.KEY_DATA);
        return new TeacherDeatilsRequest(header2, data2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeacherDeatilsRequest)) {
            return false;
        }
        TeacherDeatilsRequest teacherDeatilsRequest = (TeacherDeatilsRequest) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) teacherDeatilsRequest.header) && Intrinsics.areEqual((Object) this.data, (Object) teacherDeatilsRequest.data);
    }

    public int hashCode() {
        return (this.header.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "TeacherDeatilsRequest(header=" + this.header + ", data=" + this.data + ')';
    }

    public TeacherDeatilsRequest(Header header2, Data data2) {
        Intrinsics.checkNotNullParameter(header2, "header");
        Intrinsics.checkNotNullParameter(data2, DbParams.KEY_DATA);
        this.header = header2;
        this.data = data2;
    }

    public final Header getHeader() {
        return this.header;
    }

    public final void setHeader(Header header2) {
        Intrinsics.checkNotNullParameter(header2, "<set-?>");
        this.header = header2;
    }

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "<set-?>");
        this.data = data2;
    }
}
