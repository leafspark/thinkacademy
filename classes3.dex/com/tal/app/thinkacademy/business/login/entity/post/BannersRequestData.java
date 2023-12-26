package com.tal.app.thinkacademy.business.login.entity.post;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/BannersRequestData;", "", "locationKey", "", "gradeIds", "", "(Ljava/lang/String;[I)V", "getGradeIds", "()[I", "getLocationKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannersRequest.kt */
public final class BannersRequestData {
    private final int[] gradeIds;
    private final String locationKey;

    public BannersRequestData() {
        this((String) null, (int[]) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BannersRequestData copy$default(BannersRequestData bannersRequestData, String str, int[] iArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bannersRequestData.locationKey;
        }
        if ((i & 2) != 0) {
            iArr = bannersRequestData.gradeIds;
        }
        return bannersRequestData.copy(str, iArr);
    }

    public final String component1() {
        return this.locationKey;
    }

    public final int[] component2() {
        return this.gradeIds;
    }

    public final BannersRequestData copy(String str, int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "locationKey");
        Intrinsics.checkNotNullParameter(iArr, "gradeIds");
        return new BannersRequestData(str, iArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannersRequestData)) {
            return false;
        }
        BannersRequestData bannersRequestData = (BannersRequestData) obj;
        return Intrinsics.areEqual((Object) this.locationKey, (Object) bannersRequestData.locationKey) && Intrinsics.areEqual((Object) this.gradeIds, (Object) bannersRequestData.gradeIds);
    }

    public int hashCode() {
        return (this.locationKey.hashCode() * 31) + Arrays.hashCode(this.gradeIds);
    }

    public String toString() {
        return "BannersRequestData(locationKey=" + this.locationKey + ", gradeIds=" + Arrays.toString(this.gradeIds) + ')';
    }

    public BannersRequestData(String str, int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "locationKey");
        Intrinsics.checkNotNullParameter(iArr, "gradeIds");
        this.locationKey = str;
        this.gradeIds = iArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannersRequestData(String str, int[] iArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "APP-profile_adv" : str, (i & 2) != 0 ? new int[0] : iArr);
    }

    public final String getLocationKey() {
        return this.locationKey;
    }

    public final int[] getGradeIds() {
        return this.gradeIds;
    }
}
