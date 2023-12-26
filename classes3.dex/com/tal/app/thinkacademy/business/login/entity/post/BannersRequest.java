package com.tal.app.thinkacademy.business.login.entity.post;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/BannersRequest;", "", "header", "Lcom/tal/app/thinkacademy/business/login/entity/post/BannersRequestHeader;", "data", "", "Lcom/tal/app/thinkacademy/business/login/entity/post/BannersRequestData;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/BannersRequestHeader;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getHeader", "()Lcom/tal/app/thinkacademy/business/login/entity/post/BannersRequestHeader;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannersRequest.kt */
public final class BannersRequest {
    private final List<BannersRequestData> data;
    private final BannersRequestHeader header;

    public BannersRequest() {
        this((BannersRequestHeader) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BannersRequest copy$default(BannersRequest bannersRequest, BannersRequestHeader bannersRequestHeader, List<BannersRequestData> list, int i, Object obj) {
        if ((i & 1) != 0) {
            bannersRequestHeader = bannersRequest.header;
        }
        if ((i & 2) != 0) {
            list = bannersRequest.data;
        }
        return bannersRequest.copy(bannersRequestHeader, list);
    }

    public final BannersRequestHeader component1() {
        return this.header;
    }

    public final List<BannersRequestData> component2() {
        return this.data;
    }

    public final BannersRequest copy(BannersRequestHeader bannersRequestHeader, List<BannersRequestData> list) {
        return new BannersRequest(bannersRequestHeader, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannersRequest)) {
            return false;
        }
        BannersRequest bannersRequest = (BannersRequest) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) bannersRequest.header) && Intrinsics.areEqual((Object) this.data, (Object) bannersRequest.data);
    }

    public int hashCode() {
        BannersRequestHeader bannersRequestHeader = this.header;
        int i = 0;
        int hashCode = (bannersRequestHeader == null ? 0 : bannersRequestHeader.hashCode()) * 31;
        List<BannersRequestData> list = this.data;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "BannersRequest(header=" + this.header + ", data=" + this.data + ')';
    }

    public BannersRequest(BannersRequestHeader bannersRequestHeader, List<BannersRequestData> list) {
        this.header = bannersRequestHeader;
        this.data = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannersRequest(BannersRequestHeader bannersRequestHeader, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new BannersRequestHeader((String) null, 1, (DefaultConstructorMarker) null) : bannersRequestHeader, (i & 2) != 0 ? CollectionsKt.arrayListOf(new BannersRequestData((String) null, (int[]) null, 3, (DefaultConstructorMarker) null)) : list);
    }

    public final BannersRequestHeader getHeader() {
        return this.header;
    }

    public final List<BannersRequestData> getData() {
        return this.data;
    }
}
