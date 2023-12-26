package com.tal.app.thinkacademy.business.login.entity.post;

import com.tal.app.thinkacademy.common.entity.Header;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/GetGradeList;", "", "header", "Lcom/tal/app/thinkacademy/common/entity/Header;", "(Lcom/tal/app/thinkacademy/common/entity/Header;)V", "getHeader", "()Lcom/tal/app/thinkacademy/common/entity/Header;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetGradeList.kt */
public final class GetGradeList {
    private final Header header;

    public static /* synthetic */ GetGradeList copy$default(GetGradeList getGradeList, Header header2, int i, Object obj) {
        if ((i & 1) != 0) {
            header2 = getGradeList.header;
        }
        return getGradeList.copy(header2);
    }

    public final Header component1() {
        return this.header;
    }

    public final GetGradeList copy(Header header2) {
        return new GetGradeList(header2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetGradeList) && Intrinsics.areEqual((Object) this.header, (Object) ((GetGradeList) obj).header);
    }

    public int hashCode() {
        Header header2 = this.header;
        if (header2 == null) {
            return 0;
        }
        return header2.hashCode();
    }

    public String toString() {
        return "GetGradeList(header=" + this.header + ')';
    }

    public GetGradeList(Header header2) {
        this.header = header2;
    }

    public final Header getHeader() {
        return this.header;
    }
}
