package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/UserinfoGetBodyHead;", "", "studentId", "", "(Ljava/lang/String;)V", "getStudentId", "()Ljava/lang/String;", "setStudentId", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserinfoGetBody.kt */
public final class UserinfoGetBodyHead {
    private String studentId;

    public UserinfoGetBodyHead() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserinfoGetBodyHead copy$default(UserinfoGetBodyHead userinfoGetBodyHead, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userinfoGetBodyHead.studentId;
        }
        return userinfoGetBodyHead.copy(str);
    }

    public final String component1() {
        return this.studentId;
    }

    public final UserinfoGetBodyHead copy(String str) {
        Intrinsics.checkNotNullParameter(str, "studentId");
        return new UserinfoGetBodyHead(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserinfoGetBodyHead) && Intrinsics.areEqual((Object) this.studentId, (Object) ((UserinfoGetBodyHead) obj).studentId);
    }

    public int hashCode() {
        return this.studentId.hashCode();
    }

    public String toString() {
        return "UserinfoGetBodyHead(studentId=" + this.studentId + ')';
    }

    public UserinfoGetBodyHead(String str) {
        Intrinsics.checkNotNullParameter(str, "studentId");
        this.studentId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserinfoGetBodyHead(java.lang.String r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x001b
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r1 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r1 = r1.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r1 = r1.getUserInfoEntity()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0014
        L_0x0012:
            r1 = r2
            goto L_0x001b
        L_0x0014:
            java.lang.String r1 = r1.getUid()
            if (r1 != 0) goto L_0x001b
            goto L_0x0012
        L_0x001b:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.entity.post.UserinfoGetBodyHead.<init>(java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final void setStudentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.studentId = str;
    }
}
