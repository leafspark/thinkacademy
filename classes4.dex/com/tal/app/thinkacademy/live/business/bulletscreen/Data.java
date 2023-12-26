package com.tal.app.thinkacademy.live.business.bulletscreen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/bulletscreen/Data;", "", "ambianceId", "", "ambianceName", "interactId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmbianceId", "()Ljava/lang/String;", "getAmbianceName", "getInteractId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BulletScreenBean.kt */
public final class Data {
    private final String ambianceId;
    private final String ambianceName;
    private final String interactId;

    public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.ambianceId;
        }
        if ((i & 2) != 0) {
            str2 = data.ambianceName;
        }
        if ((i & 4) != 0) {
            str3 = data.interactId;
        }
        return data.copy(str, str2, str3);
    }

    public final String component1() {
        return this.ambianceId;
    }

    public final String component2() {
        return this.ambianceName;
    }

    public final String component3() {
        return this.interactId;
    }

    public final Data copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "ambianceId");
        Intrinsics.checkNotNullParameter(str2, "ambianceName");
        Intrinsics.checkNotNullParameter(str3, "interactId");
        return new Data(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return Intrinsics.areEqual(this.ambianceId, data.ambianceId) && Intrinsics.areEqual(this.ambianceName, data.ambianceName) && Intrinsics.areEqual(this.interactId, data.interactId);
    }

    public int hashCode() {
        return (((this.ambianceId.hashCode() * 31) + this.ambianceName.hashCode()) * 31) + this.interactId.hashCode();
    }

    public String toString() {
        return "Data(ambianceId=" + this.ambianceId + ", ambianceName=" + this.ambianceName + ", interactId=" + this.interactId + ')';
    }

    public Data(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "ambianceId");
        Intrinsics.checkNotNullParameter(str2, "ambianceName");
        Intrinsics.checkNotNullParameter(str3, "interactId");
        this.ambianceId = str;
        this.ambianceName = str2;
        this.interactId = str3;
    }

    public final String getAmbianceId() {
        return this.ambianceId;
    }

    public final String getAmbianceName() {
        return this.ambianceName;
    }

    public final String getInteractId() {
        return this.interactId;
    }
}
