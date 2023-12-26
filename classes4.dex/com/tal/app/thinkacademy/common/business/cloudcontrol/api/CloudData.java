package com.tal.app.thinkacademy.common.business.cloudcontrol.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u001b\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "configs", "", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudItem;", "(Ljava/util/List;)V", "getConfigs", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloudData.kt */
public final class CloudData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final List<CloudItem> configs;

    public static /* synthetic */ CloudData copy$default(CloudData cloudData, List<CloudItem> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = cloudData.configs;
        }
        return cloudData.copy(list);
    }

    public final List<CloudItem> component1() {
        return this.configs;
    }

    public final CloudData copy(List<CloudItem> list) {
        return new CloudData(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CloudData) && Intrinsics.areEqual(this.configs, ((CloudData) obj).configs);
    }

    public int hashCode() {
        List<CloudItem> list = this.configs;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "CloudData(configs=" + this.configs + ')';
    }

    public CloudData(List<CloudItem> list) {
        this.configs = list;
    }

    public final List<CloudItem> getConfigs() {
        return this.configs;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CloudData(Parcel parcel) {
        this((List<CloudItem>) parcel.readArrayList(CloudItem.class.getClassLoader()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeList(this.configs);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudData;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CloudData.kt */
    public static final class CREATOR implements Parcelable.Creator<CloudData> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public CloudData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CloudData(parcel);
        }

        public CloudData[] newArray(int i) {
            return new CloudData[i];
        }
    }
}
