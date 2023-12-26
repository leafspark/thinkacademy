package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/UserInfoRequest;", "", "header", "Lcom/tal/app/thinkacademy/business/shop/bean/request/Headers;", "(Lcom/tal/app/thinkacademy/business/shop/bean/request/Headers;)V", "getHeader", "()Lcom/tal/app/thinkacademy/business/shop/bean/request/Headers;", "setHeader", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserInfoRequest.kt */
public final class UserInfoRequest {
    private Headers header;

    public static /* synthetic */ UserInfoRequest copy$default(UserInfoRequest userInfoRequest, Headers headers, int i, Object obj) {
        if ((i & 1) != 0) {
            headers = userInfoRequest.header;
        }
        return userInfoRequest.copy(headers);
    }

    public final Headers component1() {
        return this.header;
    }

    public final UserInfoRequest copy(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "header");
        return new UserInfoRequest(headers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserInfoRequest) && Intrinsics.areEqual((Object) this.header, (Object) ((UserInfoRequest) obj).header);
    }

    public int hashCode() {
        return this.header.hashCode();
    }

    public String toString() {
        return "UserInfoRequest(header=" + this.header + ')';
    }

    public UserInfoRequest(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "header");
        this.header = headers;
    }

    public final Headers getHeader() {
        return this.header;
    }

    public final void setHeader(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<set-?>");
        this.header = headers;
    }
}
