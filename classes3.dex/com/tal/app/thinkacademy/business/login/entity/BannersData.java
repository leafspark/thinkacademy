package com.tal.app.thinkacademy.business.login.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/BannersData;", "", "locationKey", "", "gradeId", "", "resources", "", "Lcom/tal/app/thinkacademy/business/login/entity/Resource;", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "getGradeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLocationKey", "()Ljava/lang/String;", "getResources", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/login/entity/BannersData;", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannersData.kt */
public final class BannersData {
    private final Long gradeId;
    private final String locationKey;
    private final List<Resource> resources;

    public static /* synthetic */ BannersData copy$default(BannersData bannersData, String str, Long l, List<Resource> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bannersData.locationKey;
        }
        if ((i & 2) != 0) {
            l = bannersData.gradeId;
        }
        if ((i & 4) != 0) {
            list = bannersData.resources;
        }
        return bannersData.copy(str, l, list);
    }

    public final String component1() {
        return this.locationKey;
    }

    public final Long component2() {
        return this.gradeId;
    }

    public final List<Resource> component3() {
        return this.resources;
    }

    public final BannersData copy(String str, Long l, List<Resource> list) {
        return new BannersData(str, l, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannersData)) {
            return false;
        }
        BannersData bannersData = (BannersData) obj;
        return Intrinsics.areEqual((Object) this.locationKey, (Object) bannersData.locationKey) && Intrinsics.areEqual((Object) this.gradeId, (Object) bannersData.gradeId) && Intrinsics.areEqual((Object) this.resources, (Object) bannersData.resources);
    }

    public int hashCode() {
        String str = this.locationKey;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.gradeId;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        List<Resource> list = this.resources;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BannersData(locationKey=" + this.locationKey + ", gradeId=" + this.gradeId + ", resources=" + this.resources + ')';
    }

    public BannersData(String str, Long l, List<Resource> list) {
        this.locationKey = str;
        this.gradeId = l;
        this.resources = list;
    }

    public final String getLocationKey() {
        return this.locationKey;
    }

    public final Long getGradeId() {
        return this.gradeId;
    }

    public final List<Resource> getResources() {
        return this.resources;
    }
}
