package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/Headers;", "", "schoolCode", "", "studentId", "(Ljava/lang/String;Ljava/lang/String;)V", "getSchoolCode", "()Ljava/lang/String;", "setSchoolCode", "(Ljava/lang/String;)V", "getStudentId", "setStudentId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserInfoRequest.kt */
public final class Headers {
    private String schoolCode;
    private String studentId;

    public Headers() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Headers copy$default(Headers headers, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headers.schoolCode;
        }
        if ((i & 2) != 0) {
            str2 = headers.studentId;
        }
        return headers.copy(str, str2);
    }

    public final String component1() {
        return this.schoolCode;
    }

    public final String component2() {
        return this.studentId;
    }

    public final Headers copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        Intrinsics.checkNotNullParameter(str2, "studentId");
        return new Headers(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Headers)) {
            return false;
        }
        Headers headers = (Headers) obj;
        return Intrinsics.areEqual((Object) this.schoolCode, (Object) headers.schoolCode) && Intrinsics.areEqual((Object) this.studentId, (Object) headers.studentId);
    }

    public int hashCode() {
        return (this.schoolCode.hashCode() * 31) + this.studentId.hashCode();
    }

    public String toString() {
        return "Headers(schoolCode=" + this.schoolCode + ", studentId=" + this.studentId + ')';
    }

    public Headers(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        Intrinsics.checkNotNullParameter(str2, "studentId");
        this.schoolCode = str;
        this.studentId = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Headers(java.lang.String r3, java.lang.String r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r2 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L_0x0017
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r0 = "school_code"
            java.lang.String r1 = "415"
            java.lang.String r3 = r3.getString(r0, r1, r6)
            java.lang.String r6 = "getInstance()\n        .g…ager.SHAREDATA_NOT_CLEAR)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
        L_0x0017:
            r5 = r5 & 2
            if (r5 == 0) goto L_0x0032
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r4 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r4 = r4.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r4 = r4.getUserInfoEntity()
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x002b
        L_0x0029:
            r4 = r5
            goto L_0x0032
        L_0x002b:
            java.lang.String r4 = r4.getUid()
            if (r4 != 0) goto L_0x0032
            goto L_0x0029
        L_0x0032:
            r2.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.request.Headers.<init>(java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolCode = str;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final void setStudentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.studentId = str;
    }
}
