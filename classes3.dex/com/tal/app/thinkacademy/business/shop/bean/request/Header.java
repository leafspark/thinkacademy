package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/Header;", "", "schoolCode", "", "(Ljava/lang/String;)V", "getSchoolCode", "()Ljava/lang/String;", "setSchoolCode", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDeatilsRequest.kt */
public final class Header {
    private String schoolCode;

    public Header() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Header copy$default(Header header, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = header.schoolCode;
        }
        return header.copy(str);
    }

    public final String component1() {
        return this.schoolCode;
    }

    public final Header copy(String str) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        return new Header(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Header) && Intrinsics.areEqual((Object) this.schoolCode, (Object) ((Header) obj).schoolCode);
    }

    public int hashCode() {
        return this.schoolCode.hashCode();
    }

    public String toString() {
        return "Header(schoolCode=" + this.schoolCode + ')';
    }

    public Header(String str) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        this.schoolCode = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Header(java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r1 = this;
            r3 = r3 & 1
            if (r3 == 0) goto L_0x0017
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r4 = "school_code"
            java.lang.String r0 = "415"
            java.lang.String r2 = r2.getString(r4, r0, r3)
            java.lang.String r3 = "getInstance()\n        .g…ager.SHAREDATA_NOT_CLEAR)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0017:
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.request.Header.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolCode = str;
    }
}
