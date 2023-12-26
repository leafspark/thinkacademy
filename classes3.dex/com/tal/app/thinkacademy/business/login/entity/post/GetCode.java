package com.tal.app.thinkacademy.business.login.entity.post;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/GetCode;", "", "header", "Lcom/tal/app/thinkacademy/business/login/entity/post/GetCodeHeader;", "data", "Lcom/tal/app/thinkacademy/business/login/entity/post/GetCodeData;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/GetCodeHeader;Lcom/tal/app/thinkacademy/business/login/entity/post/GetCodeData;)V", "getData", "()Lcom/tal/app/thinkacademy/business/login/entity/post/GetCodeData;", "getHeader", "()Lcom/tal/app/thinkacademy/business/login/entity/post/GetCodeHeader;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetCode.kt */
public final class GetCode {
    private final GetCodeData data;
    private final GetCodeHeader header;

    public static /* synthetic */ GetCode copy$default(GetCode getCode, GetCodeHeader getCodeHeader, GetCodeData getCodeData, int i, Object obj) {
        if ((i & 1) != 0) {
            getCodeHeader = getCode.header;
        }
        if ((i & 2) != 0) {
            getCodeData = getCode.data;
        }
        return getCode.copy(getCodeHeader, getCodeData);
    }

    public final GetCodeHeader component1() {
        return this.header;
    }

    public final GetCodeData component2() {
        return this.data;
    }

    public final GetCode copy(GetCodeHeader getCodeHeader, GetCodeData getCodeData) {
        return new GetCode(getCodeHeader, getCodeData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetCode)) {
            return false;
        }
        GetCode getCode = (GetCode) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) getCode.header) && Intrinsics.areEqual((Object) this.data, (Object) getCode.data);
    }

    public int hashCode() {
        GetCodeHeader getCodeHeader = this.header;
        int i = 0;
        int hashCode = (getCodeHeader == null ? 0 : getCodeHeader.hashCode()) * 31;
        GetCodeData getCodeData = this.data;
        if (getCodeData != null) {
            i = getCodeData.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GetCode(header=" + this.header + ", data=" + this.data + ')';
    }

    public GetCode(GetCodeHeader getCodeHeader, GetCodeData getCodeData) {
        this.header = getCodeHeader;
        this.data = getCodeData;
    }

    public final GetCodeHeader getHeader() {
        return this.header;
    }

    public final GetCodeData getData() {
        return this.data;
    }
}
